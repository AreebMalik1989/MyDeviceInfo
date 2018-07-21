package malik1989.areeb.mydeviceinfo.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.dto.DeviceProperty;

/**
 * Created by areeb on 27/2/18.
 */

public class DevicePropertiesAdapter1 extends RecyclerView.Adapter<DevicePropertiesAdapter1.MyViewHolder> {

    private List<DeviceProperty> devicePropertyList;

    public DevicePropertiesAdapter1(List<DeviceProperty> devicePropertyList){
        this.devicePropertyList = devicePropertyList;
    }

    @Override
    public DevicePropertiesAdapter1.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.property_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DevicePropertiesAdapter1.MyViewHolder holder, int position) {
        DeviceProperty deviceProperty = devicePropertyList.get(position);
        holder.property.setText(deviceProperty.getProperty());
        holder.value.setText(deviceProperty.getValue());
    }

    @Override
    public int getItemCount() {
        return devicePropertyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView property, value;

        public MyViewHolder(View itemView) {
            super(itemView);

            property = itemView.findViewById(R.id.property);
            value = itemView.findViewById(R.id.value);
        }
    }
}
