package malik1989.areeb.mydeviceinfo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import malik1989.areeb.mydeviceinfo.collector.ApkInfoCollector;
import malik1989.areeb.mydeviceinfo.collector.NetworkInfoCollector;
import malik1989.areeb.mydeviceinfo.exchange.DataExchange;
import malik1989.areeb.mydeviceinfo.model.Apk;
import malik1989.areeb.mydeviceinfo.model.DeviceProperty;
import malik1989.areeb.mydeviceinfo.observer.ApkObserver;

/**
 * Created by areeb on 28/7/18.
 */

public class ApkFragment extends BaseFragment implements ApkObserver{

    /**
     * To fulfill the requirement of default constructor
     */
    public ApkFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        update(DataExchange.apk);

        DataExchange.apk.addObserver(this);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void update(Apk apk) {

        devicePropertyList.removeAll(devicePropertyList.subList(0, devicePropertyList.size()));

        devicePropertyList.add(new DeviceProperty("Package Name", apk.getPackageName()));
        devicePropertyList.add(new DeviceProperty("Version Name", apk.getVersionName()));
        devicePropertyList.add(new DeviceProperty("Version Code", String.valueOf(apk.getVersionCode())));
        devicePropertyList.add(new DeviceProperty("First Install Time", String.valueOf(apk.getFirstInstallTime())));
        devicePropertyList.add(new DeviceProperty("Last Update Time", String.valueOf(apk.getLastUpdateTime())));


        devicePropertiesAdapter.notifyDataSetChanged();

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        DataExchange.apk.addObserver(this);
        DataExchange.apk.updateApkInfo(ApkInfoCollector.collect());
    }

    @Override
    public void onDetach(){
        super.onDetach();

        DataExchange.apk.removeObserver(this);
    }
}
