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
import malik1989.areeb.mydeviceinfo.model.Device;

/**
 * Created by areeb on 24/7/18.
 */

public class DeviceInfoCollector {

    public static Device collect() {

        Device device = new Device();

        device.setImei(getIMEI(MainApp.getApp()));
        device.setImsi(getIMSI(MainApp.getApp()));
        device.setRoot(isRoot());
        device.setModel(Build.MODEL);
        device.setManufacturer(Build.MANUFACTURER);
        device.setBoard(Build.BOARD);
        device.setFingerprint(Build.FINGERPRINT);
        device.setBootloader(Build.BOOTLOADER);
        device.setBrand(Build.BRAND);
        device.setDevice(Build.DEVICE);
        device.setDisplay(Build.DISPLAY);
        device.setHardware(Build.HARDWARE);
        device.setHost(Build.HOST);
        device.setId(Build.ID);
        device.setProduct(Build.PRODUCT);
        device.setTags(Build.TAGS);
        device.setType(Build.TYPE);
        device.setUser(Build.USER);
        device.setTime(Build.TIME);
        device.setVersionSdkInt(Build.VERSION.SDK_INT);
        device.setVersionCodename(Build.VERSION.CODENAME);
        device.setVersionRelease(Build.VERSION.RELEASE);
        device.setVersionIncremental(Build.VERSION.INCREMENTAL);

        return device;
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
