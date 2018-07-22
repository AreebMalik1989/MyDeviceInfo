package malik1989.areeb.mydeviceinfo.exchange;

import malik1989.areeb.mydeviceinfo.model.Apk;
import malik1989.areeb.mydeviceinfo.model.Basic;
import malik1989.areeb.mydeviceinfo.model.Battery;
import malik1989.areeb.mydeviceinfo.model.Processor;
import malik1989.areeb.mydeviceinfo.model.Telephony;
import malik1989.areeb.mydeviceinfo.model.Wifi;

/**
 * Created by areeb on 23/7/18.
 */

public interface DataExchange {

    Apk apk = new Apk();
    Basic basic = new Basic();
    Battery battery = new Battery();
    Processor processor = new Processor();
    Telephony telephony = new Telephony();
    Wifi wifi = new Wifi();

}
