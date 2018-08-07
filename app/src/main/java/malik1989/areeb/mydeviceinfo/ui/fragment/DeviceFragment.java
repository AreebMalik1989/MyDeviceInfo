package malik1989.areeb.mydeviceinfo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import malik1989.areeb.mydeviceinfo.collector.DeviceInfoCollector;
import malik1989.areeb.mydeviceinfo.exchange.DataExchange;
import malik1989.areeb.mydeviceinfo.model.Device;
import malik1989.areeb.mydeviceinfo.model.DeviceProperty;
import malik1989.areeb.mydeviceinfo.observer.DeviceObserver;

/**
 * Created by areeb on 28/7/18.
 */

public class DeviceFragment extends BaseFragment implements DeviceObserver {

    /**
     * To fulfill the requirement of default constructor
     */
    public DeviceFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        update(DataExchange.device);

        DataExchange.device.addObserver(this);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void update(Device device) {

        devicePropertyList.removeAll(devicePropertyList.subList(0, devicePropertyList.size()));

        devicePropertyList.add(new DeviceProperty("IMEI", String.valueOf(device.getImei())));
        devicePropertyList.add(new DeviceProperty("IMSI", String.valueOf(device.getImsi())));
        devicePropertyList.add(new DeviceProperty("Rooted", String.valueOf(device.isRoot())));
        devicePropertyList.add(new DeviceProperty("Model", String.valueOf(device.getModel())));
        devicePropertyList.add(new DeviceProperty("Manufacturer", String.valueOf(device.getManufacturer())));
        devicePropertyList.add(new DeviceProperty("Board", String.valueOf(device.getBoard())));
        devicePropertyList.add(new DeviceProperty("Fingerprint", String.valueOf(device.getFingerprint())));
        devicePropertyList.add(new DeviceProperty("Bootloader", String.valueOf(device.getBootloader())));
        devicePropertyList.add(new DeviceProperty("Brand", String.valueOf(device.getBrand())));
        devicePropertyList.add(new DeviceProperty("Device", String.valueOf(device.getDevice())));
        devicePropertyList.add(new DeviceProperty("Display", String.valueOf(device.getDisplay())));
        devicePropertyList.add(new DeviceProperty("Hardware", String.valueOf(device.getHardware())));
        devicePropertyList.add(new DeviceProperty("Host", String.valueOf(device.getHost())));
        devicePropertyList.add(new DeviceProperty("ID", String.valueOf(device.getId())));
        devicePropertyList.add(new DeviceProperty("Product", String.valueOf(device.getProduct())));
        devicePropertyList.add(new DeviceProperty("Tags", String.valueOf(device.getTags())));
        devicePropertyList.add(new DeviceProperty("Type", String.valueOf(device.getType())));
        devicePropertyList.add(new DeviceProperty("User", String.valueOf(device.getUser())));
        devicePropertyList.add(new DeviceProperty("Time", String.valueOf(device.getTime())));
        devicePropertyList.add(new DeviceProperty("Version SDK Int", String.valueOf(device.getVersionSdkInt())));
        devicePropertyList.add(new DeviceProperty("Version Codename", String.valueOf(device.getVersionCodename())));
        devicePropertyList.add(new DeviceProperty("Version Release", String.valueOf(device.getVersionRelease())));
        devicePropertyList.add(new DeviceProperty("Version Incremental", String.valueOf(device.getVersionIncremental())));

        devicePropertiesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        DataExchange.device.addObserver(this);
        DataExchange.device.updateBasicInfo(DeviceInfoCollector.collect());
    }

    @Override
    public void onDetach(){
        super.onDetach();

        DataExchange.device.removeObserver(this);
    }
}
