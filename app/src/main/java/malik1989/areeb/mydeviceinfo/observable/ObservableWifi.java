package malik1989.areeb.mydeviceinfo.observable;

import java.util.ArrayList;

import malik1989.areeb.mydeviceinfo.model.Wifi;
import malik1989.areeb.mydeviceinfo.observer.WifiObserver;

/**
 * Created by areeb on 27/7/18.
 */

public class ObservableWifi extends Wifi {

    private static ArrayList<WifiObserver> observers = new ArrayList<>();

    public void addObserver(WifiObserver wifiObserver){
        observers.add(wifiObserver);
    }

    public void removeObserver(WifiObserver wifiObserver){
        observers.remove(wifiObserver);
    }

    public void updateWifiInfo(Wifi wifi){
        setState(wifi.getState());
        setBssid(wifi.getBssid());
        setSsid(wifi.getSsid());
        setIpAddress(wifi.getIpAddress());
        setMacAddress(wifi.getMacAddress());
        setNetworkId(wifi.getNetworkId());
        setLinkSpeed(wifi.getLinkSpeed());
        setRssi(wifi.getRssi());

        notifyChange();
    }

    private void notifyChange() {
        for(WifiObserver observer : observers) {
            observer.update(this);
        }
    }
}
