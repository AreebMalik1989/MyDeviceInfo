package malik1989.areeb.mydeviceinfo.observable;

import java.util.ArrayList;

import malik1989.areeb.mydeviceinfo.model.SIM;
import malik1989.areeb.mydeviceinfo.observer.SimObserver;

public class ObservableSim extends SIM {

    private ArrayList<SimObserver> observers = new ArrayList<>();

    public void addObserver(SimObserver simObserver){
        observers.add(simObserver);
    }

    public void removeObserver(SimObserver simObserver){
        observers.remove(simObserver);
    }

    public void updateSimInfo(SIM sim){

        setCountry(sim.getCountry());
        setSimNetworkLocked(sim.isSimNetworkLocked());
        setCarrier(sim.getCarrier());
        setImsi(sim.getImsi());
        setSimSerial(sim.getSimSerial());
        setMultiSim(sim.isMultiSim());
        setNumberOfActiveSim(sim.getNumberOfActiveSim());
        setActiveMultiSimInfo(sim.getActiveMultiSimInfo());

        notifyChange();
    }

    private void notifyChange() {
        for(SimObserver observer : observers) {
            observer.update(this);
        }
    }
}
