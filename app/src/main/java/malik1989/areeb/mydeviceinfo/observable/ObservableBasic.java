package malik1989.areeb.mydeviceinfo.observable;

import java.util.ArrayList;

import malik1989.areeb.mydeviceinfo.model.Basic;
import malik1989.areeb.mydeviceinfo.observer.BasicObserver;

/**
 * Created by areeb on 24/7/18.
 */

public class ObservableBasic extends Basic {

    private ArrayList<BasicObserver> observers = new ArrayList<>();

    public void addObserver(BasicObserver basicObserver){
        observers.add(basicObserver);
    }

    public void removeObserver(BasicObserver basicObserver){
        observers.remove(basicObserver);
    }

    public void updateBasicInfo(Basic basic){
        setImei(basic.getImei());
        setImsi(basic.getImsi());
        setRoot(basic.isRoot());
        setModel(basic.getModel());
        setManufacturer(basic.getManufacturer());
        setBoard(basic.getBoard());
        setFingerprint(basic.getFingerprint());
        setBootloader(basic.getBootloader());
        setBrand(basic.getBrand());
        setDevice(basic.getDevice());
        setDisplay(basic.getDisplay());
        setHardware(basic.getHardware());
        setHost(basic.getHost());
        setId(basic.getId());
        setProduct(basic.getProduct());
        setTags(basic.getTags());
        setType(basic.getType());
        setUser(basic.getUser());
        setTime(basic.getTime());
        setVersionSdkInt(basic.getVersionSdkInt());
        setVersionCodename(basic.getVersionCodename());
        setVersionRelease(basic.getVersionRelease());
        setVersionIncremental(basic.getVersionIncremental());

        notifyChange();
    }

    private void notifyChange() {
        for(BasicObserver observer : observers) {
            observer.update(this);
        }
    }
}
