package malik1989.areeb.mydeviceinfo.model;

/**
 * Created by areeb on 22/7/18.
 */

public class Apk {
    
    private List<ApkObserver> observers = new ArrayList<>();

    private String packageName;

    private String versionName;

    private int versionCode;

    private long firstInstallTime;

    private long lastUpdateTime;

    private int sharedUserLabel;

    private String sharedUserId;
    
    public void addObserver(ApkObserver apkObserver){
        observers.add(apkObserver);
    }
    
    public void removeObserver(ApkObserver apkObserver){
        observers.remove(apkObserver);
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
        notifyPackageNameChange();
    }
    
    public void notifyPackageNameChange() {
        for(ApkObserver observer : observers) {
            observer.updatePackageName(getPackageName());
        }
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
        notifyVersionNameChange();
    }
    
    public void notifyVersionNameChange() {
        for(ApkObserver observer : observers) {
            observer.updateVersionName(getVersionName());
        }
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
        notifyVersionCodeChange();
    }
    
    public void notifyVersionCodeChange() {
        for(ApkObserver observer : observers) {
            observer.updateVersionCode(getVersionCode());
        }
    }

    public long getFirstInstallTime() {
        return firstInstallTime;
    }

    public void setFirstInstallTime(long firstInstallTime) {
        this.firstInstallTime = firstInstallTime;
        notifyFirstInstallTimeChange();
    }
    
    public void notifyFirstInstallTimeChange() {
        for(ApkObserver observer : observers) {
            observer.updateFirstInstallTime(getFirstInstallTime());
        }
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        notifyLastUpdateTimeChange();
    }
    
    public void notifyLastUpdateTimeChange() {
        for(ApkObserver observer : observers) {
            observer.updateLastUpdateTime(getLastUpdateTime());
        }
    }

    public int getSharedUserLabel() {
        return sharedUserLabel;
    }

    public void setSharedUserLabel(int sharedUserLabel) {
        this.sharedUserLabel = sharedUserLabel;
        notifySharedUserLabelChange();
    }
    
    public void notifySharedUserLabelChange() {
        for(ApkObserver observer : observers) {
            observer.updateSharedUserLabel(getSharedUserLabel());
        }
    }

    public String getSharedUserId() {
        return sharedUserId;
    }

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

    @Override
    public String toString() {
        return "ApkInfo{" +
                "packageName='" + packageName + '\'' +
                ", versionName='" + versionName + '\'' +
                ", versionCode=" + versionCode +
                ", firstInstallTime=" + firstInstallTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", sharedUserLabel=" + sharedUserLabel +
                ", sharedUserId='" + sharedUserId + '\'' +
                '}';
    }
}
