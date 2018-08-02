package malik1989.areeb.mydeviceinfo.util;

import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;

import java.util.List;

/**
 * Created by areeb on 28/7/18.
 */

public class NetworkUtil {

    public static String phoneType(int phoneType){
        switch (phoneType){
            case TelephonyManager.PHONE_TYPE_CDMA:
                return "CDMA";
            case TelephonyManager.PHONE_TYPE_GSM:
                return "GSM";
            case TelephonyManager.PHONE_TYPE_NONE:
                return "None";
            case TelephonyManager.PHONE_TYPE_SIP:
                return "SIP";
            default:
                return "Unknown";
        }
    }

    public static String networkType(int networkType){
        switch (networkType){
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                return "1xRTT";
            case TelephonyManager.NETWORK_TYPE_CDMA:
                return "CDMA";
            case TelephonyManager.NETWORK_TYPE_EDGE:
                return "EDGE";
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                return "EHRPD";
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                return "EVDO 0";
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                return "EVDO A";
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                return "EVDO B";
            case TelephonyManager.NETWORK_TYPE_GPRS:
                return "GPRS";
            case TelephonyManager.NETWORK_TYPE_GSM:
                return "GSM";
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                return "HSDPA";
            case TelephonyManager.NETWORK_TYPE_HSPA:
                return "HSPA";
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return "HSPAP";
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                return "HSUPA";
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return "IDEN";
            case TelephonyManager.NETWORK_TYPE_IWLAN:
                return "IWLAN";
            case TelephonyManager.NETWORK_TYPE_LTE:
                return "LTE";
            case TelephonyManager.NETWORK_TYPE_TD_SCDMA:
                return "SCDMA";
            case TelephonyManager.NETWORK_TYPE_UMTS:
                return "UMTS";
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                return "Unknown";
            default:
                return "Unknown";
        }
    }

    public static String simState(int simState){
        switch (simState){
            case TelephonyManager.SIM_STATE_ABSENT:
                return "Absent";
            case TelephonyManager.SIM_STATE_CARD_IO_ERROR:
                return "Card I/O Error";
            case TelephonyManager.SIM_STATE_CARD_RESTRICTED:
                return "Restricted";
            case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                return "Network Locked";
            case TelephonyManager.SIM_STATE_NOT_READY:
                return "Not Ready";
            case TelephonyManager.SIM_STATE_PERM_DISABLED:
                return "Disabled Permanently";
            case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                return "PIN Required";
            case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                return "PUK Required";
            case TelephonyManager.SIM_STATE_READY:
                return "Ready";
            case TelephonyManager.SIM_STATE_UNKNOWN:
                return "Unknown";
            default:
                return "Unknown";
        }
    }

    public static String callState(int callState){
        switch (callState){
            case TelephonyManager.CALL_STATE_IDLE:
                return "IDLE";
            case TelephonyManager.CALL_STATE_OFFHOOK:
                return "Off Hook";
            case TelephonyManager.CALL_STATE_RINGING:
                return "Ringing";
            default:
                return "Unknown";
        }
    }

    public static String dataActivity(int dataActivity){
        switch (dataActivity){
            case TelephonyManager.DATA_ACTIVITY_DORMANT:
                return "Dormant";
            case TelephonyManager.DATA_ACTIVITY_IN:
                return "Donwloading";
            case TelephonyManager.DATA_ACTIVITY_INOUT:
                return "Downloading and Uploading";
            case TelephonyManager.DATA_ACTIVITY_NONE:
                return "None";
            case TelephonyManager.DATA_ACTIVITY_OUT:
                return "Uploading";
            default:
                return "Unknown";
        }
    }

    public static String dataState(int dataState){
        switch (dataState){
            case TelephonyManager.DATA_SUSPENDED:
                return "Suspended";
            case TelephonyManager.DATA_CONNECTED:
                return "Connected";
            case TelephonyManager.DATA_CONNECTING:
                return "Connecting";
            case TelephonyManager.DATA_DISCONNECTED:
                return "Disconnected";
            default:
                return "Unknown";
        }
    }

    public static String neighbouringCellInfo(List<NeighboringCellInfo> neighboringCellInfos){

        String result = "";

        for(NeighboringCellInfo info : neighboringCellInfos){

            result = result + info.toString() + "\n\n";
        }

        return result.trim();
    }

    public static String allCellInfo(List<CellInfo> cellInfos){

        String result = "";

        for(CellInfo info : cellInfos){

            result = result + info.toString() + "\n\n";
        }

        return result.trim();
    }
}
