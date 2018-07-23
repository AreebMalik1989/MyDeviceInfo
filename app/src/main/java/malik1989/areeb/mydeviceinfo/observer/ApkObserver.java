package malik1989.areeb.mydeviceinfo.observer;

import malik1989.areeb.mydeviceinfo.observable.ObservableApk;

/**
 * Created by areeb on 23/7/18.
 */

public interface ApkObserver {

    void updatePackageName(String packageName);
    void updateVersionName(String versionName);
    void updateVersionCode(int versionCode);
    void updateFirstInstallTime(long firstInstallTime);
    void updateLastUpdateTime(long lastUpdatedTime);
    void updateSharedUserLabel(int sharedUserLabel);
    void updateSharedUserId(String sharedUserId);
    void update(ObservableApk observableApk);
}
