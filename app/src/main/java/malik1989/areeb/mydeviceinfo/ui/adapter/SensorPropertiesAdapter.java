package malik1989.areeb.mydeviceinfo.ui.adapter;

import android.hardware.Sensor;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.app.MainApp;

public class SensorPropertiesAdapter extends RecyclerView.Adapter<SensorPropertiesAdapter.MyViewHolder> {

    private List<Sensor> sensorList;

    public SensorPropertiesAdapter(List<Sensor> sensorList){
        this.sensorList = sensorList;
    }

    @Override
    public SensorPropertiesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sensor_list_row, parent, false);

        return new SensorPropertiesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Sensor sensor = sensorList.get(position);

        holder.name.setText(String.valueOf(sensor.getName()));
        holder.type.setText(String.valueOf(sensor.getStringType()));
        holder.version.setText(String.valueOf(sensor.getVersion()));
        holder.vendor.setText(String.valueOf(sensor.getVendor()));
        holder.maxDelay.setText(String.valueOf(sensor.getMaxDelay()));
        holder.minDelay.setText(String.valueOf(sensor.getMinDelay()));
        holder.maxRange.setText(String.valueOf(sensor.getMaximumRange()));
        holder.power.setText(String.valueOf(sensor.getPower()));
        holder.resolution.setText(String.valueOf(sensor.getResolution()));
    }

    @Override
    public int getItemCount() {
        return sensorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView name, type, version, vendor, maxDelay, minDelay, maxRange, power, resolution;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.sensor_card_view);
            name = itemView.findViewById(R.id.sensor_name);
            type = itemView.findViewById(R.id.sensorType);
            version = itemView.findViewById(R.id.sensor_version);
            vendor = itemView.findViewById(R.id.sensor_vendor);
            maxDelay = itemView.findViewById(R.id.sensor_max_delay);
            minDelay = itemView.findViewById(R.id.sensor_min_delay);
            maxRange = itemView.findViewById(R.id.sensor_max_range);
            power = itemView.findViewById(R.id.sensor_power);
            resolution = itemView.findViewById(R.id.sensor_resolution);
        }
    }
}
