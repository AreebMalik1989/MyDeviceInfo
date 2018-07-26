package malik1989.areeb.mydeviceinfo.exchange;

import malik1989.areeb.mydeviceinfo.model.Apk;
import malik1989.areeb.mydeviceinfo.model.Basic;
import malik1989.areeb.mydeviceinfo.model.Battery;
import malik1989.areeb.mydeviceinfo.model.Processor;
import malik1989.areeb.mydeviceinfo.model.Telephony;
import malik1989.areeb.mydeviceinfo.model.Wifi;
import malik1989.areeb.mydeviceinfo.observable.ObservableApk;
import malik1989.areeb.mydeviceinfo.observable.ObservableBasic;
import malik1989.areeb.mydeviceinfo.observable.ObservableBattery;

/**
 * Created by areeb on 23/7/18.
 */

public interface DataExchange {

    ObservableApk apk = new ObservableApk();
    ObservableBasic basic = new ObservableBasic();
    ObservableBattery battery = new ObservableBattery();

}
