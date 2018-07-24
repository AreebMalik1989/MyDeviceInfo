package malik1989.areeb.mydeviceinfo.app;

import android.app.Application;

import malik1989.areeb.mydeviceinfo.collector.ApkInfoCollector;
import malik1989.areeb.mydeviceinfo.collector.BasicInfoCollector;
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
        setupInfo.run();
    }

    public static MainApp getApp(){
        return mainApp;
    }

    Thread setupInfo = new Thread(new Runnable() {
        @Override
        public void run() {
            DataExchange.apk.updateApkInfo(ApkInfoCollector.collect());
            DataExchange.basic.updateBasicInfo(BasicInfoCollector.collect());
        }
    });
}
