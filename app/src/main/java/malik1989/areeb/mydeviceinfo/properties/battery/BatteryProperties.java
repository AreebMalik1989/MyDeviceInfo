package malik1989.areeb.mydeviceinfo.properties.battery;

import java.util.HashMap;
import java.util.Map;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.properties.DeviceProperties;
import malik1989.areeb.mydeviceinfo.properties.DevicePropertyConstants;

/**
 * Created by areeb on 21/7/18.
 */

public class BatteryProperties implements DeviceProperties {

    private static Map<String, String> batteryProperties = new HashMap<>();

    public BatteryProperties() {

        batteryProperties.put(DevicePropertyConstants.BatteryFields.IS_PRESENT, "");
        batteryProperties.put(DevicePropertyConstants.BatteryFields.TECHNOLOGY, "");
        batteryProperties.put(DevicePropertyConstants.BatteryFields.PLUGGED, "");
        batteryProperties.put(DevicePropertyConstants.BatteryFields.HEALTH, "");
        batteryProperties.put(DevicePropertyConstants.BatteryFields.STATUS, "");
        batteryProperties.put(DevicePropertyConstants.BatteryFields.VOLTAGE, "");
        batteryProperties.put(DevicePropertyConstants.BatteryFields.TEMPERATURE, "");
        batteryProperties.put(DevicePropertyConstants.BatteryFields.LEVEL, "");

    }

    @Override
    public Map<String, String> getProperties() {
        return this.batteryProperties;
    }

    public void setBatteryProperties(Battery battery) {

        batteryProperties.put(DevicePropertyConstants.BatteryFields.IS_PRESENT, String.valueOf(battery.isPresent()));
        batteryProperties.put(DevicePropertyConstants.BatteryFields.TECHNOLOGY, battery.getTechnology());
        batteryProperties.put(DevicePropertyConstants.BatteryFields.PLUGGED, String.valueOf(battery.getPlugged()));
        batteryProperties.put(DevicePropertyConstants.BatteryFields.HEALTH, String.valueOf(battery.getHealth()));
        batteryProperties.put(DevicePropertyConstants.BatteryFields.STATUS, String.valueOf(battery.getStatus()));
        batteryProperties.put(DevicePropertyConstants.BatteryFields.VOLTAGE, String.valueOf(battery.getVoltage()));
        batteryProperties.put(DevicePropertyConstants.BatteryFields.TEMPERATURE, String.valueOf(battery.getTemperature()));
        batteryProperties.put(DevicePropertyConstants.BatteryFields.LEVEL, String.valueOf(battery.getLevel()));

    }
}
