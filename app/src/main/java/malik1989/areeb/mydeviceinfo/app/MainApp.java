package malik1989.areeb.mydeviceinfo.app;

import android.app.Application;

/**
 * Created by areeb on 24/7/18.
 */

public class MainApp extends Application {

    private static MainApp mainApp;

    @Override
    public void onCreate(){
        super.onCreate();
        mainApp = this;
    }

    public static MainApp getApp(){
        return mainApp;
    }
}
