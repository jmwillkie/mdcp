package net.posick.mdcdeviceviewer;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.xbill.DNS.Name;
import org.xbill.mDNS.ServiceInstance;
import org.xbill.mDNS.ServiceName;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class DeviceExpandableListAdapter extends BaseExpandableListAdapter
{
    private static final String PREFIX_DEVICE_PTR = "_org.smpte.st2071:device_v1.0.";
    
    private static final String PREFIX_SERVICE_PTR = "_org.smpte.st2071:service_v1.0.";
    
    private Context context;
    
    private LinkedHashMap<ServiceName, ServiceInstance> data = new LinkedHashMap<ServiceName, ServiceInstance>();
    
    private List<ServiceName> groupIndex = new ArrayList<ServiceName>();
    
    
    public DeviceExpandableListAdapter(Context context, List<ServiceInstance> services)
    {
        this.context = context;
        
        if (services != null)
        {
            for (ServiceInstance service : services)
            {
                addService(service);
            }
        }
    }
    
    
    public void addService(ServiceInstance service)
    {
        if (service != null)
        {
            boolean deviceAssigned = false;
            boolean serviceAssigned = false;
            
            Name[] pointers = service.getPointers();
            if (pointers != null && pointers.length > 0)
            {
                for (Name pointer : pointers)
                {
                    String ptr = pointer.toString();
                    if (!deviceAssigned && ptr.startsWith(PREFIX_DEVICE_PTR))
                    {
                        _addDevice(service);
                        deviceAssigned = true;
                    }
                    
                    if (!serviceAssigned && ptr.startsWith(PREFIX_SERVICE_PTR))
                    {
                        _addService(service);
                        serviceAssigned = true;
                    }
                }
            }
            
            if (!deviceAssigned && !serviceAssigned)
            {
                _addDevice(service);
            }
        }
    }
    
    
    private void _addDevice(ServiceInstance service)
    {
        synchronized (data)
        {
            ServiceName name = service.getName();
            if (data.put(name, service) == null)
            {
                groupIndex.add(name);
            }
        }
    }
    
    
    private void _addService(ServiceInstance service)
    {
        synchronized (data)
        {
            ServiceName name = service.getName();
            data.put(name, service);
            if (data.put(name, service) == null)
            {
                groupIndex.add(name);
            }
        }
    }
    
    
    public ServiceInstance removeService(ServiceInstance service)
    {
        ServiceName name = service.getName();
        
        for (int index = 0; index < groupIndex.size(); index++)
        {
            if (name.equals(groupIndex.get(index)))
            {
                groupIndex.remove(index);
                return data.remove(name);
            }
        }
        
        return null;
    }
    
    
    public Set<ServiceInstance> getServices()
    {
        Set<ServiceInstance> services = new LinkedHashSet<ServiceInstance>();
        for (ServiceName name : groupIndex)
        {
            services.add(data.get(name));
        }
        return services;
    }
    
    
    @Override
    public int getGroupCount()
    {
        return groupIndex.size();
    }
    
    
    @Override
    public int getChildrenCount(int groupPosition)
    {
        /*
         * Service Name Resource Name URL PTRs
         */
        ServiceName group = groupIndex.get(groupPosition);
        ServiceInstance service = data.get(group);
        return service == null ? 0 : 1;
    }
    
    
    @Override
    public Object getGroup(int groupPosition)
    {
        return data.get(groupIndex.get(groupPosition));
    }
    
    
    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        ServiceName group = groupIndex.get(groupPosition);
        if (childPosition == 0)
        {
            return data.get(group);
        }
        return null;
    }
    
    
    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }
    
    
    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }
    
    
    @Override
    public boolean hasStableIds()
    {
        return false;
    }
    
    
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        ServiceInstance service = (ServiceInstance) getGroup(groupPosition);
        String headerTitle = service.getName().toString();
        if (convertView == null)
        {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
        
        TextView groupListItem = (TextView) convertView.findViewById(R.id.groupListItem);
        groupListItem.setText(headerTitle);
        
        return convertView;
    }
    
    
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        ServiceInstance service = (ServiceInstance) getChild(groupPosition, childPosition);
        if (convertView == null)
        {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }
        
        if (service != null)
        {
            ServiceName serviceName = service.getName();
            String rn = (String) service.getTextAttributes().get("rn");
            Name hostname = service.getHost();
            InetAddress[] addresses = service.getAddresses();
            List<String> urls = toURLs(service);
            
            TextView listItemType = (TextView) convertView.findViewById(R.id.listItemType);
            listItemType.setText(rn != null ? rn.startsWith("urn:smpte:udn:") ? "Device" : rn.startsWith("urn:smpte:udn:") ? "Service" : "Unknown" : "Unknown");
            
            TextView listItemServiceName = (TextView) convertView.findViewById(R.id.listItemServiceName);
            listItemServiceName.setText(serviceName.toString());
            
            TextView listItemHostName = (TextView) convertView.findViewById(R.id.listItemHostName);
            listItemHostName.setText(hostname.toString());
            
            TextView listItemResourceName = (TextView) convertView.findViewById(R.id.listItemResourceName);
            listItemResourceName.setText(rn);
            
            TextView listItemURLs = (TextView) convertView.findViewById(R.id.listItemURLs);
            StringBuilder builder = new StringBuilder();
            for (String url : urls)
            {
                builder.append(url + "\n");
            }
            listItemURLs.setText(builder.toString());
            
            builder.setLength(0);
            TextView listItemAddresses = (TextView) convertView.findViewById(R.id.listItemAddresses);
            for (InetAddress address : addresses)
            {
                builder.append(address.getHostAddress() + "\n");
            }
            listItemAddresses.setText(builder.toString());
        }
        
        return convertView;
    }
    
    
    private List<String> toURLs(ServiceInstance service)
    {
        List<String> urls = new ArrayList<String>();
        
        int port = service.getPort();
        InetAddress[] addresses = service.getAddresses();
        Name hostname = service.getHost();
        String path = (String) service.getTextAttributes().get("path");
        String protocol = (String) service.getTextAttributes().get("proto");
        String portString = (port > 0 && port != 80 ? ":" + port : "");
        
        urls.add(protocol + "//" + hostname + portString + "/" + path);
        if (addresses != null && addresses.length > 0)
        {
            for (InetAddress address : addresses)
            {
                urls.add(protocol + "//" + address.getHostAddress() + portString + "/" + path);
            }
        }
        
        return urls;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        Object o = getChild(groupPosition, childPosition);
        return o != null;
    }
}
