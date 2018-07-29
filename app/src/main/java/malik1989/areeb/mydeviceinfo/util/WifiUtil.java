package malik1989.areeb.mydeviceinfo.util;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * Created by areeb on 28/7/18.
 */

public class WifiUtil {

    public static String state(int state){
        switch (state){
            case WifiManager.WIFI_STATE_DISABLED:
                return "Disabled";
            case WifiManager.WIFI_STATE_DISABLING:
                return "Disabling";
            case WifiManager.WIFI_STATE_ENABLED:
                return "Enabled";
            case WifiManager.WIFI_STATE_ENABLING:
                return "Enabling";
            case WifiManager.WIFI_STATE_UNKNOWN:
                return "Unknown";
            default:
                return "Unknown";
        }
    }

    public static String linkSpeed(int linkSpeed){
        return linkSpeed + WifiInfo.LINK_SPEED_UNITS;
    }
}
