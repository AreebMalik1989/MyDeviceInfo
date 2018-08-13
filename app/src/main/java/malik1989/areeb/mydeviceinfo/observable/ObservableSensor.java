package malik1989.areeb.mydeviceinfo.observable;

import java.util.ArrayList;

import malik1989.areeb.mydeviceinfo.model.MySensor;
import malik1989.areeb.mydeviceinfo.observer.SensorObserver;

public class ObservableSensor extends MySensor {

    private ArrayList<SensorObserver> observers = new ArrayList<>();

    public void addObserver(SensorObserver sensorObserver){
        observers.add(sensorObserver);
    }

    public void removeObserver(SensorObserver sensorObserver){
        observers.remove(sensorObserver);
    }

    public void updateSensorInfo(MySensor sensor){

        setSensorsList(sensor.getSensorsList());

        notifyChange();
    }

    private void notifyChange() {
        for(SensorObserver observer : observers) {
            observer.update(this);
        }
    }
}
