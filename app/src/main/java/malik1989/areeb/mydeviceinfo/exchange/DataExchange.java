package malik1989.areeb.mydeviceinfo.exchange;

import malik1989.areeb.mydeviceinfo.observable.ObservableApk;
import malik1989.areeb.mydeviceinfo.observable.ObservableBasic;
import malik1989.areeb.mydeviceinfo.observable.ObservableBattery;
import malik1989.areeb.mydeviceinfo.observable.ObservableNetwork;
import malik1989.areeb.mydeviceinfo.observable.ObservableWifi;

/**
 * Created by areeb on 23/7/18.
 */

public interface DataExchange {

    ObservableApk apk = new ObservableApk();
    ObservableBasic basic = new ObservableBasic();
    ObservableBattery battery = new ObservableBattery();
    ObservableNetwork network = new ObservableNetwork();
    ObservableWifi wifi = new ObservableWifi();

}
