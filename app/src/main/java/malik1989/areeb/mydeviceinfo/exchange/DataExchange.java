package malik1989.areeb.mydeviceinfo.exchange;

import malik1989.areeb.mydeviceinfo.observable.ObservableDevice;
import malik1989.areeb.mydeviceinfo.observable.ObservableBattery;
import malik1989.areeb.mydeviceinfo.observable.ObservableNetwork;
import malik1989.areeb.mydeviceinfo.observable.ObservableSensor;
import malik1989.areeb.mydeviceinfo.observable.ObservableSim;
import malik1989.areeb.mydeviceinfo.observable.ObservableWifi;

/**
 * Created by areeb on 23/7/18.
 */

public interface DataExchange {

    ObservableDevice device = new ObservableDevice();
    ObservableBattery battery = new ObservableBattery();
    ObservableNetwork network = new ObservableNetwork();
    ObservableWifi wifi = new ObservableWifi();
    ObservableSim sim = new ObservableSim();
    ObservableSensor sensor = new ObservableSensor();
}
