package malik1989.areeb.mydeviceinfo.collector;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import malik1989.areeb.mydeviceinfo.app.MainApp;
import malik1989.areeb.mydeviceinfo.model.Network;

/**
 * Created by areeb on 27/7/18.
 */

public class NetworkInfoCollector {

    public static Network collect(){

        TelephonyManager tm = (TelephonyManager) MainApp.getApp()
                .getSystemService(Context.TELEPHONY_SERVICE);

        Network network = new Network();

        if (ActivityCompat.checkSelfPermission(MainApp.getApp(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainApp.getApp(),"Access coarse location permisssion not granted!", Toast.LENGTH_SHORT).show();
            return network;
        }

        network.setAllCellInfo(tm.getAllCellInfo());
        network.setCallState(tm.getCallState());
        network.setCellLocation(tm.getCellLocation());
        network.setDataActivity(tm.getDataActivity());
        network.setDataState(tm.getDataState());
        network.setDeviceId(tm.getDeviceId());
        network.setDeviceSoftwareVersion(tm.getDeviceSoftwareVersion());
        network.setGroupIdLevel1(tm.getGroupIdLevel1());
        network.setHasIccCard(tm.hasIccCard());
        network.setNetworkRoaming(tm.isNetworkRoaming());
        network.setLine1Number(tm.getLine1Number());
        network.setMmsUAProfUrl(tm.getMmsUAProfUrl());
        network.setMmsUserAgent(tm.getMmsUserAgent());
        network.setNeighboringCellInfo(tm.getNeighboringCellInfo());
        network.setNetworkCountryIso(tm.getNetworkCountryIso());
        network.setNetworkOperator(tm.getNetworkOperator());
        network.setNetworkOperatorName(tm.getNetworkOperatorName());
        network.setNetworkType(tm.getNetworkType());
        network.setPhoneType(tm.getPhoneType());
        network.setSimCountryIso(tm.getSimCountryIso());
        network.setSimOperatorName(tm.getSimOperatorName());
        network.setSimSerialNumber(tm.getSimSerialNumber());
        network.setSimState(tm.getSimState());
        network.setSimOperator(tm.getSimOperator());
        network.setSubscriberId(tm.getSubscriberId());
        network.setVoiceMailAlphaTag(tm.getVoiceMailAlphaTag());
        network.setVoiceMailNumber(tm.getVoiceMailNumber());

        return network;
    }
}
