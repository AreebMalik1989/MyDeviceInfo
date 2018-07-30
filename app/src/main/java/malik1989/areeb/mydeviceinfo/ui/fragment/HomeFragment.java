package malik1989.areeb.mydeviceinfo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import malik1989.areeb.mydeviceinfo.collector.BasicInfoCollector;
import malik1989.areeb.mydeviceinfo.exchange.DataExchange;
import malik1989.areeb.mydeviceinfo.model.Basic;
import malik1989.areeb.mydeviceinfo.model.DeviceProperty;
import malik1989.areeb.mydeviceinfo.observer.BasicObserver;

/**
 * Created by areeb on 28/7/18.
 */

public class HomeFragment extends BaseFragment implements BasicObserver{

    /**
     * To fulfill the requirement of default constructor
     */
    public HomeFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        update(DataExchange.basic);

        DataExchange.basic.addObserver(this);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void update(Basic basic) {

        devicePropertyList.removeAll(devicePropertyList.subList(0, devicePropertyList.size()));

        devicePropertyList.add(new DeviceProperty("IMEI", String.valueOf(basic.getImei())));
        devicePropertyList.add(new DeviceProperty("IMSI", String.valueOf(basic.getImsi())));
        devicePropertyList.add(new DeviceProperty("Rooted", String.valueOf(basic.isRoot())));
        devicePropertyList.add(new DeviceProperty("Model", String.valueOf(basic.getModel())));
        devicePropertyList.add(new DeviceProperty("Manufacturer", String.valueOf(basic.getManufacturer())));
        devicePropertyList.add(new DeviceProperty("Board", String.valueOf(basic.getBoard())));
        devicePropertyList.add(new DeviceProperty("Fingerprint", String.valueOf(basic.getFingerprint())));
        devicePropertyList.add(new DeviceProperty("Bootloader", String.valueOf(basic.getBootloader())));
        devicePropertyList.add(new DeviceProperty("Brand", String.valueOf(basic.getBrand())));
        devicePropertyList.add(new DeviceProperty("Device", String.valueOf(basic.getDevice())));
        devicePropertyList.add(new DeviceProperty("Display", String.valueOf(basic.getDisplay())));
        devicePropertyList.add(new DeviceProperty("Hardware", String.valueOf(basic.getHardware())));
        devicePropertyList.add(new DeviceProperty("Host", String.valueOf(basic.getHost())));
        devicePropertyList.add(new DeviceProperty("ID", String.valueOf(basic.getId())));
        devicePropertyList.add(new DeviceProperty("Product", String.valueOf(basic.getProduct())));
        devicePropertyList.add(new DeviceProperty("Tags", String.valueOf(basic.getTags())));
        devicePropertyList.add(new DeviceProperty("Type", String.valueOf(basic.getType())));
        devicePropertyList.add(new DeviceProperty("User", String.valueOf(basic.getUser())));
        devicePropertyList.add(new DeviceProperty("Time", String.valueOf(basic.getTime())));
        devicePropertyList.add(new DeviceProperty("Version SDK Int", String.valueOf(basic.getVersionSdkInt())));
        devicePropertyList.add(new DeviceProperty("Version Codename", String.valueOf(basic.getVersionCodename())));
        devicePropertyList.add(new DeviceProperty("Version Release", String.valueOf(basic.getVersionRelease())));
        devicePropertyList.add(new DeviceProperty("Version Incremental", String.valueOf(basic.getVersionIncremental())));

        devicePropertiesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        DataExchange.basic.addObserver(this);
        DataExchange.basic.updateBasicInfo(BasicInfoCollector.collect());
    }

    @Override
    public void onDetach(){
        super.onDetach();

        DataExchange.basic.removeObserver(this);
    }
}
