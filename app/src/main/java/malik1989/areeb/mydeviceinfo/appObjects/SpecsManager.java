package malik1989.areeb.mydeviceinfo.appObjects;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Size;
import android.view.Display;

import java.io.File;
import java.text.DecimalFormat;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.dto.Specs;

/**
 * Created by areeb on 2/3/18.
 */

public class SpecsManager {

    private Specs currentSpecs;
    private Context context;
    private Activity activity;

    public SpecsManager(Context context, Activity activity){
        this.context = context;
        this.activity = activity;
        currentSpecs = new Specs();
    }

    public Specs getStaticSpecs(){

        currentSpecs.setModelNumber(getModelNumber());
        currentSpecs.setProductName(getProductName());
        currentSpecs.setOsVersion(getOsVersion());
        currentSpecs.setProcessorName(getProcessorName());
        currentSpecs.setProcessorCore(getProcessorCore());
        currentSpecs.setBackCamera(getBackCamera());
        currentSpecs.setFrontCamera(getFrontCamera());
        currentSpecs.setRam(getRam());
        currentSpecs.setRom(getRom());
        currentSpecs.setScreenResolution(getScreenResolution());
        currentSpecs.setSerialNumber(getSerialNumber());
        currentSpecs.setImei1(getImei1());
        currentSpecs.setImei2(getImei2());

        return currentSpecs;
    }

    private String getModelNumber(){
        return Build.MODEL;
    }

    private String getProductName(){
        return Build.PRODUCT;
    }

    private String getOsVersion(){
        return Build.VERSION.RELEASE;
    }

    private String getProcessorName(){
        return Build.HARDWARE;
    }

    private String getProcessorCore(){
        return String.valueOf(Runtime.getRuntime().availableProcessors());
    }

    private String getBackCamera(){
        return getCameraResolution(0);
    }

    private String getFrontCamera(){
        return getCameraResolution(1);
    }

    private String getRam(){
        String[] strings = new String[4];
        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);

        long availableMegs = mi.availMem / 1048576L;
        int percentAvail = (int)((mi.availMem /(float) mi.totalMem)*100);

        strings[0]=String.valueOf(availableMegs);
        strings[1]=String.valueOf(percentAvail);
        strings[2]=String.valueOf(mi.totalMem/1048576L);
        strings[3]=String.valueOf(mi.lowMemory);

        return strings[2] + "MB";
    }

    private String getRom(){
        if (isExternalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSizeLong();
            long totalBlocks = stat.getBlockCountLong();
            return formatSize(totalBlocks * blockSize);
        } else {
            return "NOT FOUND";
        }
    }

    private boolean isExternalMemoryAvailable(){
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    private String formatSize(long size){

        String suffix = null;

        if (size >= 1024) {
            suffix = "KB";
            size /= 1024;
            if (size >= 1024) {
                suffix = "MB";
                size /= 1024;
            }
        }

        StringBuilder resultBuffer = new StringBuilder(Long.toString(size));

        int commaOffset = resultBuffer.length() - 3;
        while (commaOffset > 0) {
            resultBuffer.insert(commaOffset, ',');
            commaOffset -= 3;
        }

        if (suffix != null) resultBuffer.append(suffix);
        return resultBuffer.toString();

    }

    private String getCameraResolution(int i) {

        String s;

        CameraManager cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                String[] id = cameraManager.getCameraIdList();

                CameraCharacteristics props = cameraManager.getCameraCharacteristics(id[i]);
                Size size = props.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);

                int x = size.getWidth();
                int y = size.getHeight();

                DecimalFormat df = new DecimalFormat("##.#");
                s = String.valueOf(df.format((x * y) / 1000000.0)) + " Mp";

                return s;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "API 21+ required.";
    }

    private String getScreenResolution(){

        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        String s = width + "x" + height;
        return s;
    }

    private String getSerialNumber(){
        return Build.SERIAL;
    }

    private String getImei1(){
        return getIMEI(0);
    }

    private String getImei2(){
        return getIMEI(1);
    }

    private String getIMEI(int i){

        TelephonyManager telephonyManager = (TelephonyManager)activity.getSystemService(Context.TELEPHONY_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                return telephonyManager.getDeviceId(i);
            } else {
                return context.getString(R.string.permission_denied);
            }
        }else {
            if(i==0){
                return telephonyManager.getDeviceId();
            }else {
                return "API 23+ required.";
            }
        }
    }
}
