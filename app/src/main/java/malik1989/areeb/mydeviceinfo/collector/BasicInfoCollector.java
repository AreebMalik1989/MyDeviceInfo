package malik1989.areeb.mydeviceinfo.collector;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import malik1989.areeb.mydeviceinfo.app.MainApp;
import malik1989.areeb.mydeviceinfo.model.Basic;

/**
 * Created by areeb on 24/7/18.
 */

public class BasicInfoCollector {

    public static Basic collect() {

        Basic basic = new Basic();

        basic.setImei(getIMEI(MainApp.getApp()));
        basic.setImsi(getIMSI(MainApp.getApp()));
        basic.setRoot(isRoot());
        basic.setModel(Build.MODEL);
        basic.setManufacturer(Build.MANUFACTURER);
        basic.setBoard(Build.BOARD);
        basic.setFingerprint(Build.FINGERPRINT);
        basic.setBootloader(Build.BOOTLOADER);
        basic.setBrand(Build.BRAND);
        basic.setDevice(Build.DEVICE);
        basic.setDisplay(Build.DISPLAY);
        basic.setHardware(Build.HARDWARE);
        basic.setHost(Build.HOST);
        basic.setId(Build.ID);
        basic.setProduct(Build.PRODUCT);
        basic.setTags(Build.TAGS);
        basic.setType(Build.TYPE);
        basic.setUser(Build.USER);
        basic.setTime(Build.TIME);
        basic.setVersionSdkInt(Build.VERSION.SDK_INT);
        basic.setVersionCodename(Build.VERSION.CODENAME);
        basic.setVersionRelease(Build.VERSION.RELEASE);
        basic.setVersionIncremental(Build.VERSION.INCREMENTAL);

        return basic;
    }

    private static String getIMEI(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                return "Read phone state permisssion not granted!";
            }
            String imei = tm.getDeviceId();
            if (imei == null || imei.equals("")) {
                return "";
            }
            return imei;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getIMSI(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                return "Read phone state permisssion not granted!";
            }
            String imsi = tm.getSubscriberId();

            if (imsi == null || imsi.equals("")) {
                return "";
            }
            return imsi;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static boolean isRoot() {
        String binPath = "/system/bin/su";
        String xBinPath = "/system/xbin/su";
        if (new File(binPath).exists() && isExecutable(binPath)) {
            return true;
        }
        if (new File(xBinPath).exists() && isExecutable(xBinPath)) {
            return true;
        }
        return false;
    }

    private static boolean isExecutable(String filePath) {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("ls -l " + filePath);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String str = in.readLine();
            if (str != null && str.length() >= 4) {
                char flag = str.charAt(3);
                if (flag == 's' || flag == 'x') {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (p != null) {
                p.destroy();
            }
        }
        return false;
    }
}
