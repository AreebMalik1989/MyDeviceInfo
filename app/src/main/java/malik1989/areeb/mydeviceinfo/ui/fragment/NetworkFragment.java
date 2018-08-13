package malik1989.areeb.mydeviceinfo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import malik1989.areeb.mydeviceinfo.collector.NetworkInfoCollector;
import malik1989.areeb.mydeviceinfo.exchange.DataExchange;
import malik1989.areeb.mydeviceinfo.model.DeviceProperty;
import malik1989.areeb.mydeviceinfo.model.Network;
import malik1989.areeb.mydeviceinfo.observer.NetworkObserver;
import malik1989.areeb.mydeviceinfo.util.NetworkUtil;

/**
 * Created by areeb on 28/7/18.
 */

public class NetworkFragment extends BaseFragment implements NetworkObserver {

    /**
     * To fulfill the requirement of default constructor
     */
    public NetworkFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        update(DataExchange.network);

        DataExchange.network.addObserver(this);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void update(Network network) {

        devicePropertyList.removeAll(devicePropertyList.subList(0, devicePropertyList.size()));

        devicePropertyList.add(new DeviceProperty("Phone Type", NetworkUtil.phoneType(network.getPhoneType())));
        devicePropertyList.add(new DeviceProperty("SIM State", NetworkUtil.simState(network.getSimState())));
        devicePropertyList.add(new DeviceProperty("Roaming", String.valueOf(network.isNetworkRoaming())));
        devicePropertyList.add(new DeviceProperty("Data State", NetworkUtil.dataState(network.getDataState())));
        devicePropertyList.add(new DeviceProperty("Data Activity", NetworkUtil.dataActivity(network.getDataActivity())));
        devicePropertyList.add(new DeviceProperty("Network Type", NetworkUtil.networkType(network.getNetworkType())));
        devicePropertyList.add(new DeviceProperty("SIM Operator Name", String.valueOf(network.getSimOperatorName())));
        devicePropertyList.add(new DeviceProperty("SIM Operator", String.valueOf(network.getSimOperator())));
        devicePropertyList.add(new DeviceProperty("Network Operator Name", String.valueOf(network.getNetworkOperatorName())));
        devicePropertyList.add(new DeviceProperty("Network Operator", String.valueOf(network.getNetworkOperator())));
        devicePropertyList.add(new DeviceProperty("Cell Location", String.valueOf(network.getCellLocation())));
        devicePropertyList.add(new DeviceProperty("Call State", NetworkUtil.callState(network.getCallState())));
        devicePropertyList.add(new DeviceProperty("SIM Country ISO", String.valueOf(network.getSimCountryIso())));
        devicePropertyList.add(new DeviceProperty("SIM Serial Number", String.valueOf(network.getSimSerialNumber())));
        devicePropertyList.add(new DeviceProperty("Network Country ISO", String.valueOf(network.getNetworkCountryIso())));
        devicePropertyList.add(new DeviceProperty("Voice Mail Number", String.valueOf(network.getVoiceMailNumber())));
        devicePropertyList.add(new DeviceProperty("Voice Mail Alpha Tag", String.valueOf(network.getVoiceMailAlphaTag())));
        devicePropertyList.add(new DeviceProperty("Line Number", String.valueOf(network.getLine1Number())));
        devicePropertyList.add(new DeviceProperty("Has ICC Card", String.valueOf(network.isHasIccCard())));
        devicePropertyList.add(new DeviceProperty("Subscriber ID", String.valueOf(network.getSubscriberId())));
        devicePropertyList.add(new DeviceProperty("Group ID Level 1", String.valueOf(network.getGroupIdLevel1())));
        devicePropertyList.add(new DeviceProperty("MMS User Agent", String.valueOf(network.getMmsUserAgent())));
        devicePropertyList.add(new DeviceProperty("MMS UA Profile URL", String.valueOf(network.getMmsUAProfUrl())));
        devicePropertyList.add(new DeviceProperty("Device Software Version", String.valueOf(network.getDeviceSoftwareVersion())));
        devicePropertyList.add(new DeviceProperty("Device ID", String.valueOf(network.getDeviceId())));
        devicePropertyList.add(new DeviceProperty("Neighbouring Cell Info", NetworkUtil.neighbouringCellInfo(network.getNeighboringCellInfo())));
        devicePropertyList.add(new DeviceProperty("All Cell Info", NetworkUtil.allCellInfo(network.getAllCellInfo())));

        devicePropertiesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        DataExchange.network.addObserver(this);
        DataExchange.network.updateNetworkInfo(NetworkInfoCollector.collect());
    }

    @Override
    public void onDetach(){
        super.onDetach();

        DataExchange.network.removeObserver(this);
    }
}
