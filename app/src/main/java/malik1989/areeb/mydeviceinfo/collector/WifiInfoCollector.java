package malik1989.areeb.mydeviceinfo.collector;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import malik1989.areeb.mydeviceinfo.app.MainApp;
import malik1989.areeb.mydeviceinfo.model.Wifi;

/**
 * Created by areeb on 27/7/18.
 */

public class WifiInfoCollector {

    public static Wifi collect(){

        WifiManager wifiService = (WifiManager) MainApp.getApp().getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);

        WifiInfo wifiInfo = wifiService.getConnectionInfo();

        Wifi wifi = new Wifi();

        wifi.setState(wifiService.getWifiState());
        wifi.setBssid(wifiInfo.getBSSID());
        wifi.setSsid(wifiInfo.getSSID());
        wifi.setIpAddress(wifiInfo.getIpAddress());
        wifi.setMacAddress(wifiInfo.getMacAddress());
        wifi.setNetworkId(wifiInfo.getNetworkId());
        wifi.setLinkSpeed(wifiInfo.getLinkSpeed());
        wifi.setRssi(wifiInfo.getRssi());

        return wifi;
    }
}
