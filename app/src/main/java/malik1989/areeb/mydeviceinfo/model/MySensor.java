package malik1989.areeb.mydeviceinfo.model;

import android.hardware.Sensor;

import java.util.List;

public class MySensor {

    List<Sensor> sensorsList;

    public List<Sensor> getSensorsList() {
        return sensorsList;
    }

    public void setSensorsList(List<Sensor> sensorsList) {
        this.sensorsList = sensorsList;
    }
}
