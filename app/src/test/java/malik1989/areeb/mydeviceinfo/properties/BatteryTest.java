package malik1989.areeb.mydeviceinfo.properties;

import junit.framework.Assert;

import org.junit.Test;
import org.hamcrest.core.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import malik1989.areeb.mydeviceinfo.properties.battery.Battery;
import malik1989.areeb.mydeviceinfo.properties.battery.BatteryProperties;

/**
 * Created by areeb on 21/7/18.
 */

public class BatteryTest {

    BatteryProperties batteryProperties;

    @Test
    public void testBatteryPropertiesDefaultKeyValues(){

        Set<String> keySet = new HashSet<>();
        keySet.add(DevicePropertyConstants.BatteryFields.IS_PRESENT);
        keySet.add(DevicePropertyConstants.BatteryFields.TEMPERATURE);
        keySet.add(DevicePropertyConstants.BatteryFields.VOLTAGE);
        keySet.add(DevicePropertyConstants.BatteryFields.STATUS);
        keySet.add(DevicePropertyConstants.BatteryFields.HEALTH);
        keySet.add(DevicePropertyConstants.BatteryFields.PLUGGED);
        keySet.add(DevicePropertyConstants.BatteryFields.TECHNOLOGY);
        keySet.add(DevicePropertyConstants.BatteryFields.LEVEL);

        batteryProperties = new BatteryProperties();
        Map<String, String> batteryPropertyMap = batteryProperties.getProperties();
        Set<String> mapKeys = batteryPropertyMap.keySet();

        Assert.assertTrue("Missing key values", mapKeys.containsAll(keySet));

        for(String value : batteryPropertyMap.values()){
            Assert.assertTrue("Incorrect value", value.equals(""));
        }
    }

    @Test
    public void testBatteryPropertiesKeyValues(){

        Battery battery = new Battery(true, "Latest", 100, 101, 102, 103, 104, 99);
        batteryProperties = new BatteryProperties();
        batteryProperties.setBatteryProperties(battery);

        Map<String, String> batteryPropertiesMap = batteryProperties.getProperties();

        Assert.assertTrue("Incorrect value of isPresent",
                batteryPropertiesMap.get(DevicePropertyConstants.BatteryFields.IS_PRESENT).equals(String.valueOf(battery.isPresent())));
        Assert.assertTrue("Incorrect value of isPresent",
                batteryPropertiesMap.get(DevicePropertyConstants.BatteryFields.TEMPERATURE).equals(String.valueOf(battery.getTemperature())));
        Assert.assertTrue("Incorrect value of isPresent",
                batteryPropertiesMap.get(DevicePropertyConstants.BatteryFields.VOLTAGE).equals(String.valueOf(battery.getVoltage())));
        Assert.assertTrue("Incorrect value of isPresent",
                batteryPropertiesMap.get(DevicePropertyConstants.BatteryFields.STATUS).equals(String.valueOf(battery.getStatus())));
        Assert.assertTrue("Incorrect value of isPresent",
                batteryPropertiesMap.get(DevicePropertyConstants.BatteryFields.HEALTH).equals(String.valueOf(battery.getHealth())));
        Assert.assertTrue("Incorrect value of isPresent",
                batteryPropertiesMap.get(DevicePropertyConstants.BatteryFields.PLUGGED).equals(String.valueOf(battery.getPlugged())));
        Assert.assertTrue("Incorrect value of isPresent",
                batteryPropertiesMap.get(DevicePropertyConstants.BatteryFields.TECHNOLOGY).equals(battery.getTechnology()));
        Assert.assertTrue("Incorrect value of isPresent",
                batteryPropertiesMap.get(DevicePropertyConstants.BatteryFields.LEVEL).equals(String.valueOf(battery.getLevel())));
    }
}
