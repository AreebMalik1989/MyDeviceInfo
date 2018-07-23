package malik1989.areeb.mydeviceinfo.collector;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import malik1989.areeb.mydeviceinfo.model.Apk;

/**
 * Created by areeb on 23/7/18.
 */

public class ApkInfoCollector{

    public Apk collect(Context context){

        Apk apk = new Apk();

        PackageInfo packageInfo = getPackageInfo(context.getApplicationContext().getPackageManager(),
                context.getApplicationContext().getPackageName());

        apk.setPackageName(packageInfo.packageName);
        apk.setVersionName(packageInfo.versionName);
        apk.setVersionCode(packageInfo.versionCode);
        apk.setFirstInstallTime(packageInfo.firstInstallTime);
        apk.setLastUpdateTime(packageInfo.lastUpdateTime);
        apk.setSharedUserLabel(packageInfo.sharedUserLabel);
        apk.setSharedUserId(packageInfo.sharedUserId);

        return apk;
    }

    private static PackageInfo getPackageInfo(PackageManager pm, String packageName) {
        PackageInfo packageInfo = getPackageInfo(pm, packageName, PackageManager.GET_ACTIVITIES |
                PackageManager.GET_GIDS |
                PackageManager.GET_CONFIGURATIONS |
                PackageManager.GET_INSTRUMENTATION |
                PackageManager.GET_PERMISSIONS |
                PackageManager.GET_PROVIDERS |
                PackageManager.GET_RECEIVERS |
                PackageManager.GET_SERVICES |
                PackageManager.GET_SIGNATURES |
                PackageManager.GET_UNINSTALLED_PACKAGES |
                PackageManager.GET_URI_PERMISSION_PATTERNS |
                PackageManager.GET_SHARED_LIBRARY_FILES);
        return packageInfo;
    }

    private static PackageInfo getPackageInfo(PackageManager pm, String packageName, int flags) {
        try {
            PackageInfo packageInfo = pm.getPackageInfo(packageName, flags);
            return packageInfo;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
