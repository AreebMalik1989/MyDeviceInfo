package malik1989.areeb.mydeviceinfo.observable;

import java.util.ArrayList;

import malik1989.areeb.mydeviceinfo.observer.ApkObserver;
import malik1989.areeb.mydeviceinfo.model.Apk;

/**
 * Created by areeb on 23/7/18.
 */

public class ObservableApk extends Apk {

    private ArrayList<ApkObserver> observers = new ArrayList<>();

    public void addObserver(ApkObserver apkObserver){
        observers.add(apkObserver);
    }

    public void removeObserver(ApkObserver apkObserver){
        observers.remove(apkObserver);
    }

    public void updateApkInfo(Apk apk){

        setPackageName(apk.getPackageName());
        setVersionName(apk.getVersionName());
        setVersionCode(apk.getVersionCode());
        setFirstInstallTime(apk.getFirstInstallTime());
        setLastUpdateTime(apk.getLastUpdateTime());
        setSharedUserLabel(apk.getSharedUserLabel());
        setSharedUserId(apk.getSharedUserId());

        notifyChange();
    }

    private void notifyChange() {
        for(ApkObserver observer : observers) {
            observer.update(this);
        }
    }
}
