package malik1989.areeb.mydeviceinfo.app;

import android.app.Application;

import malik1989.areeb.mydeviceinfo.collector.ApkInfoCollector;
import malik1989.areeb.mydeviceinfo.collector.BasicInfoCollector;
import malik1989.areeb.mydeviceinfo.collector.NetworkInfoCollector;
import malik1989.areeb.mydeviceinfo.exchange.DataExchange;

/**
 * Created by areeb on 24/7/18.
 */

public class MainApp extends Application {

    private static MainApp mainApp;

    @Override
    public void onCreate(){
        super.onCreate();
        mainApp = this;

        DataExchange.apk.updateApkInfo(ApkInfoCollector.collect());
        DataExchange.basic.updateBasicInfo(BasicInfoCollector.collect());
        DataExchange.network.updateNetworkInfo(NetworkInfoCollector.collect());
    }

    public static MainApp getApp(){
        return mainApp;
    }
}
