package malik1989.areeb.mydeviceinfo.util;

import android.os.BatteryManager;

/**
 * Created by areeb on 28/7/18.
 */

public class BatteryUtil {

    public static String plugged(int i){
        switch (i){
            case BatteryManager.BATTERY_PLUGGED_AC:
                return "AC Charging";
            case BatteryManager.BATTERY_PLUGGED_USB:
                return "USB Charging";
            case BatteryManager.BATTERY_PLUGGED_WIRELESS:
                return "Wireless Charging";
        }
        return "Unplugged";
    }

    public static String health(int i){
        switch (i){
            case BatteryManager.BATTERY_HEALTH_COLD:
                return "Cold";
            case BatteryManager.BATTERY_HEALTH_DEAD:
                return "Dead";
            case BatteryManager.BATTERY_HEALTH_GOOD:
                return "Good";
            case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                return "Over Voltage";
            case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                return "Overheat";
            case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                return "Unknown";
            case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                return "Unspecified Failure";
        }
        return "Unknown";
    }

    public static String status(int i){
        switch (i){
            case BatteryManager.BATTERY_STATUS_CHARGING:
                return "Charging";
            case BatteryManager.BATTERY_STATUS_DISCHARGING:
                return "Discharging";
            case BatteryManager.BATTERY_STATUS_FULL:
                return "Charging Full";
            case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                return "Not Charging";
            case BatteryManager.BATTERY_STATUS_UNKNOWN:
                return "Unknown";
        }
        return "Unknown";
    }

    public static String voltage(int volt){
        return String.valueOf(volt/1000.0);
    }

    public static String temperature(int temp){
        return String.valueOf(temp/10.0);
    }


}
