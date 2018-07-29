package malik1989.areeb.mydeviceinfo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import malik1989.areeb.mydeviceinfo.collector.WifiInfoCollector;
import malik1989.areeb.mydeviceinfo.exchange.DataExchange;
import malik1989.areeb.mydeviceinfo.model.DeviceProperty;
import malik1989.areeb.mydeviceinfo.model.Wifi;
import malik1989.areeb.mydeviceinfo.observer.WifiObserver;
import malik1989.areeb.mydeviceinfo.util.WifiUtil;

/**
 * Created by areeb on 27/7/18.
 */

public class WifiFragment extends BaseFragment implements WifiObserver{

    /**
     * To fulfill the requirement of default constructor
     */
    public WifiFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        update(DataExchange.wifi);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void update(Wifi wifi) {

        devicePropertyList.removeAll(devicePropertyList.subList(0, devicePropertyList.size()));

        devicePropertyList.add(new DeviceProperty("State", WifiUtil.state(wifi.getState())));
        devicePropertyList.add(new DeviceProperty("IP Address", String.valueOf(wifi.getIpAddress())));
        devicePropertyList.add(new DeviceProperty("MAC Address", String.valueOf(wifi.getMacAddress())));
        devicePropertyList.add(new DeviceProperty("Network ID", String.valueOf(wifi.getNetworkId())));
        devicePropertyList.add(new DeviceProperty("Link Speed", WifiUtil.linkSpeed(wifi.getLinkSpeed())));
        devicePropertyList.add(new DeviceProperty("BSSID", String.valueOf(wifi.getBssid())));
        devicePropertyList.add(new DeviceProperty("SSID", String.valueOf(wifi.getSsid())));
        devicePropertyList.add(new DeviceProperty("RSSI", String.valueOf(wifi.getRssi())));

        devicePropertiesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        DataExchange.wifi.addObserver(this);
        DataExchange.wifi.updateWifiInfo(WifiInfoCollector.collect());
    }

    @Override
    public void onDetach(){
        super.onDetach();

        DataExchange.wifi.removeObserver(this);
    }
}
