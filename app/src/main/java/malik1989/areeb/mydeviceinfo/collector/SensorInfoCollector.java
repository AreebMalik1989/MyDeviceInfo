package malik1989.areeb.mydeviceinfo.collector;

import android.hardware.Sensor;

import java.util.ArrayList;
import java.util.List;

import github.nisrulz.easydeviceinfo.base.EasySensorMod;
import malik1989.areeb.mydeviceinfo.app.MainApp;
import malik1989.areeb.mydeviceinfo.model.MySensor;

public class SensorInfoCollector {

    public static MySensor collect(){

        MySensor sensor = new MySensor();
        EasySensorMod easySensorMod = new EasySensorMod(MainApp.getApp());
        List<Sensor> sensorList = new ArrayList<>();

        for(Sensor s : easySensorMod.getAllSensors()){
            sensorList.add(s);
        }

        sensor.setSensorsList(sensorList);

        return sensor;
    }
}
