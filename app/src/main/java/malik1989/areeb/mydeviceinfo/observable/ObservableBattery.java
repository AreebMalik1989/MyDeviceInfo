package malik1989.areeb.mydeviceinfo.observable;

import java.util.ArrayList;

import malik1989.areeb.mydeviceinfo.model.Battery;
import malik1989.areeb.mydeviceinfo.observer.BatteryObserver;

/**
 * Created by areeb on 26/7/18.
 */

public class ObservableBattery extends Battery {

    private ArrayList<BatteryObserver> observers = new ArrayList<>();

    public void addObserver(BatteryObserver batteryObserver){
        observers.add(batteryObserver);
    }

    public void removeObserver(BatteryObserver batteryObserver){
        observers.remove(batteryObserver);
    }

    public void updateBatteryInfo(Battery battery){

        setTechnology(battery.getTechnology());
        setPlugged(battery.getPlugged());
        setHealth(battery.getHealth());
        setStatus(battery.getStatus());
        setVoltage(battery.getVoltage());
        setTemperature(battery.getTemperature());
        setLevel(battery.getLevel());

        notifyChange();
    }

    private void notifyChange() {
        for(BatteryObserver observer : observers) {
            observer.update(this);
        }
    }
}