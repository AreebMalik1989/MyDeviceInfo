package malik1989.areeb.mydeviceinfo.ui.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import malik1989.areeb.mydeviceinfo.ui.fragment.BatteryFragment;
import malik1989.areeb.mydeviceinfo.ui.fragment.DeviceFragment;
import malik1989.areeb.mydeviceinfo.ui.fragment.NetworkFragment;
import malik1989.areeb.mydeviceinfo.ui.fragment.SensorFragment;
import malik1989.areeb.mydeviceinfo.ui.fragment.SimFragment;
import malik1989.areeb.mydeviceinfo.ui.fragment.WifiFragment;

/**
 * Created by areeb on 27/7/18.
 */

public class MyFragmentManager {

    private FragmentManager fragmentManager;
    private int contentFrameId;

    public Fragment wifiFragment;
    public Fragment batteryFragment;
    public Fragment deviceFragment;
    public Fragment networkFragment;
    public Fragment simFragment;
    public Fragment sensorFragment;

    public MyFragmentManager(AppCompatActivity activity, int contentFrameId){
        this.fragmentManager = activity.getSupportFragmentManager();
        this.contentFrameId = contentFrameId;

        this.wifiFragment = new WifiFragment();
        this.batteryFragment = new BatteryFragment();
        this.deviceFragment = new DeviceFragment();
        this.networkFragment = new NetworkFragment();
        this.simFragment = new SimFragment();
        this.sensorFragment = new SensorFragment();
    }

    public void updateFragment(Fragment fragment){
        fragmentManager.beginTransaction().replace(contentFrameId, fragment).commit();
    }

    public void switchFragments(String s){

        switch (s){

            case "Wifi":
                this.updateFragment(wifiFragment);
                break;

            case "Battery":
                this.updateFragment(batteryFragment);
                break;

            case "Device":
                this.updateFragment(deviceFragment);
                break;

            case "Network":
                this.updateFragment(networkFragment);
                break;

            case "SIM":
                this.updateFragment(simFragment);
                break;

            case "Sensor":
                this.updateFragment(sensorFragment);
                break;
        }
    }
}
