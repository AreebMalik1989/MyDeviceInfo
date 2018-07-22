package malik1989.areeb.mydeviceinfo.model;

/**
 * Created by areeb on 22/7/18.
 */

public class Apk {

    public String packageName;

    public String versionName;

    public int versionCode;

    public long firstInstallTime;

    public long lastUpdateTime;

    public int sharedUserLabel;

    public String sharedUserId;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public long getFirstInstallTime() {
        return firstInstallTime;
    }

    public void setFirstInstallTime(long firstInstallTime) {
        this.firstInstallTime = firstInstallTime;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getSharedUserLabel() {
        return sharedUserLabel;
    }

    public void setSharedUserLabel(int sharedUserLabel) {
        this.sharedUserLabel = sharedUserLabel;
    }

    public String getSharedUserId() {
        return sharedUserId;
    }

    public void setSharedUserId(String sharedUserId) {
        this.sharedUserId = sharedUserId;
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
