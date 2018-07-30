package malik1989.areeb.mydeviceinfo.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import malik1989.areeb.mydeviceinfo.exchange.DataExchange;
import malik1989.areeb.mydeviceinfo.model.Battery;
import malik1989.areeb.mydeviceinfo.model.DeviceProperty;
import malik1989.areeb.mydeviceinfo.observer.BatteryObserver;
import malik1989.areeb.mydeviceinfo.receiver.BatteryReceiver;
import malik1989.areeb.mydeviceinfo.util.BatteryUtil;

import static malik1989.areeb.mydeviceinfo.exchange.DataExchange.wifi;

/**
 * Created by areeb on 28/7/18.
 */

public class BatteryFragment extends BaseFragment implements BatteryObserver {

    BatteryReceiver batteryReceiver;

    /**
     * To fulfill the requirement of default constructor
     */
    public BatteryFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        update(DataExchange.battery);

        DataExchange.battery.addObserver(this);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void update(Battery battery) {

        devicePropertyList.removeAll(devicePropertyList.subList(0, devicePropertyList.size()));

        devicePropertyList.add(new DeviceProperty("Technology", String.valueOf(battery.getTechnology())));
        devicePropertyList.add(new DeviceProperty("Plugged", BatteryUtil.plugged(battery.getPlugged())));
        devicePropertyList.add(new DeviceProperty("Health", BatteryUtil.health(battery.getHealth())));
        devicePropertyList.add(new DeviceProperty("Status", BatteryUtil.status(battery.getStatus())));
        devicePropertyList.add(new DeviceProperty("Voltage", BatteryUtil.voltage(battery.getVoltage())));
        devicePropertyList.add(new DeviceProperty("Temperature", String.valueOf(battery.getTemperature())));
        devicePropertyList.add(new DeviceProperty("Level", String.valueOf(battery.getLevel())));

        devicePropertiesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        DataExchange.battery.addObserver(this);

        registerBatteryReceiver();
    }

    @Override
    public void onDetach(){
        super.onDetach();

        DataExchange.battery.removeObserver(this);

        unregisterBatteryReceiver();
    }

    private void registerBatteryReceiver() {
        batteryReceiver = new BatteryReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        getActivity().registerReceiver(batteryReceiver, filter);
    }

    private void unregisterBatteryReceiver(){
        if(batteryReceiver != null) {
            getActivity().unregisterReceiver(batteryReceiver);
        }
    }
}
