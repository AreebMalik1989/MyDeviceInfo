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

    @Override
    public void setPackageName(String packageName) {
        this.packageName = packageName;
        notifyPackageNameChange();
    }

    public void notifyPackageNameChange() {
        for(ApkObserver observer : observers) {
            observer.updatePackageName(getPackageName());
        }
    }

    @Override
    public void setVersionName(String versionName) {
        this.versionName = versionName;
        notifyVersionNameChange();
    }

    public void notifyVersionNameChange() {
        for(ApkObserver observer : observers) {
            observer.updateVersionName(getVersionName());
        }
    }

    @Override
    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
        notifyVersionCodeChange();
    }

    public void notifyVersionCodeChange() {
        for(ApkObserver observer : observers) {
            observer.updateVersionCode(getVersionCode());
        }
    }

    @Override
    public void setFirstInstallTime(long firstInstallTime) {
        this.firstInstallTime = firstInstallTime;
        notifyFirstInstallTimeChange();
    }

    public void notifyFirstInstallTimeChange() {
        for(ApkObserver observer : observers) {
            observer.updateFirstInstallTime(getFirstInstallTime());
        }
    }

    @Override
    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        notifyLastUpdateTimeChange();
    }

    public void notifyLastUpdateTimeChange() {
        for(ApkObserver observer : observers) {
            observer.updateLastUpdateTime(getLastUpdateTime());
        }
    }

    @Override
    public void setSharedUserLabel(int sharedUserLabel) {
        this.sharedUserLabel = sharedUserLabel;
        notifySharedUserLabelChange();
    }

    public void notifySharedUserLabelChange() {
        for(ApkObserver observer : observers) {
            observer.updateSharedUserLabel(getSharedUserLabel());
        }
    }

    @Override
    public void setSharedUserId(String sharedUserId) {
        this.sharedUserId = sharedUserId;
        notifySharedUserIdChange();
    }

    public void notifySharedUserIdChange() {
        for(ApkObserver observer : observers) {
            observer.updateSharedUserId(getSharedUserId());
        }
    }

    public void notifyChange() {
        for(ApkObserver observer : observers) {
            observer.update(this);
        }
    }
}
