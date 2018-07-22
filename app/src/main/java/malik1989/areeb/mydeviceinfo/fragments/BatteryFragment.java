package malik1989.areeb.mydeviceinfo.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.adapters.DevicePropertiesAdapter;
import malik1989.areeb.mydeviceinfo.adapters.DevicePropertiesAdapter1;
import malik1989.areeb.mydeviceinfo.dto.DeviceProperty;
import malik1989.areeb.mydeviceinfo.properties.DeviceProperties;
import malik1989.areeb.mydeviceinfo.properties.DevicePropertyConstants;
import malik1989.areeb.mydeviceinfo.properties.battery.BatteryProperties;

/**
 * Created by areeb on 21/7/18.
 */

public class BatteryFragment extends Fragment {

    private View myview;
    private RecyclerView recyclerView;
    private DevicePropertiesAdapter1 devicePropertiesAdapter;
    private boolean running=true;
    private DeviceProperties deviceProperties;
    private Map<String, String> devicePropertyMap;
    private List<DeviceProperty> devicePropertyList;


    public BatteryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_specs, container, false);
        recyclerView = myview.findViewById(R.id.specs_recyclerview);
        deviceProperties = new BatteryProperties();
        devicePropertyMap = deviceProperties.getProperties();
        devicePropertyList = new ArrayList<>();
        devicePropertiesAdapter = new DevicePropertiesAdapter1(devicePropertyList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(devicePropertiesAdapter);

        setup();

        return myview;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        running = true;
        registerBatteryLevelReceiver();
    }

    @Override
    public void onDetach(){
        super.onDetach();
        running=false;
        unregisterBatteryLevelReceiver();
    }

    private void setup(){

    }

    private void registerBatteryLevelReceiver() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        getActivity().registerReceiver(batteryReceiver, filter);
    }

    private void unregisterBatteryLevelReceiver(){
        getActivity().unregisterReceiver(batteryReceiver);
    }

    private String getPlugTypeString(int plugged) {
        String plugType = "Unknown";

        switch (plugged) {
            case BatteryManager.BATTERY_PLUGGED_AC:
                plugType = "AC";
                break;
            case BatteryManager.BATTERY_PLUGGED_USB:
                plugType = "USB";
                break;
        }

        return plugType;
    }

    private String getHealthString(int health) {
        String healthString = "Unknown";

        switch (health) {
            case BatteryManager.BATTERY_HEALTH_DEAD:
                healthString = "Dead";
                break;
            case BatteryManager.BATTERY_HEALTH_GOOD:
                healthString = "Good";
                break;
            case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                healthString = "Over Voltage";
                break;
            case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                healthString = "Over Heat";
                break;
            case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                healthString = "Failure";
                break;
        }

        return healthString;
    }

    private String getStatusString(int status) {
        String statusString = "Unknown";

        switch (status) {
            case BatteryManager.BATTERY_STATUS_CHARGING:
                statusString = "Charging";
                break;
            case BatteryManager.BATTERY_STATUS_DISCHARGING:
                statusString = "Discharging";
                break;
            case BatteryManager.BATTERY_STATUS_FULL:
                statusString = "Full";
                break;
            case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                statusString = "Not Charging";
                break;
        }

        return statusString;
    }

    private void setUpList(String [] key, String [] value) {

        devicePropertyList.clear();

        for(int i=0; i<key.length; i++){
            devicePropertyList.add(new DeviceProperty(key[i], value[i]));
        }

        devicePropertiesAdapter.notifyDataSetChanged();
    }

    BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            boolean isPresent = intent.getBooleanExtra("present", false);
            String technology = intent.getStringExtra("technology");
            int plugged = intent.getIntExtra("plugged", -1);
            int scale = intent.getIntExtra("scale", -1);
            int health = intent.getIntExtra("health", 0);
            int status = intent.getIntExtra("status", 0);
            int rawlevel = intent.getIntExtra("level", -1);
            int voltage = intent.getIntExtra("voltage", 0);
            int temperature = intent.getIntExtra("temperature", 0);
            int level = 0;
            Bundle bundle = intent.getExtras();

            String key [];
            String values [];

            if (isPresent) {
                if (rawlevel >= 0 && scale > 0) {
                    level = (rawlevel * 100) / scale;
                }
                key = new String[]{
                        DevicePropertyConstants.BatteryFields.IS_PRESENT,
                        DevicePropertyConstants.BatteryFields.LEVEL,
                        DevicePropertyConstants.BatteryFields.TECHNOLOGY,
                        DevicePropertyConstants.BatteryFields.PLUGGED,
                        DevicePropertyConstants.BatteryFields.HEALTH,
                        DevicePropertyConstants.BatteryFields.STATUS,
                        DevicePropertyConstants.BatteryFields.VOLTAGE,
                        DevicePropertyConstants.BatteryFields.TEMPERATURE};
                values = new String[]{"Present", String.valueOf(level), technology, getPlugTypeString(plugged), getHealthString(health),getStatusString(status), String.valueOf(voltage), String.valueOf(temperature)};

            } else {
                key = new String[]{DevicePropertyConstants.BatteryFields.IS_PRESENT};
                values = new String[]{"Not Present"};

            }

            setUpList(key, values);
        }
    };
}
