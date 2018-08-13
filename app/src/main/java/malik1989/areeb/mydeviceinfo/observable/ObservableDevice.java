package malik1989.areeb.mydeviceinfo.observable;

import java.util.ArrayList;

import malik1989.areeb.mydeviceinfo.model.Device;
import malik1989.areeb.mydeviceinfo.observer.DeviceObserver;

/**
 * Created by areeb on 24/7/18.
 */

public class ObservableDevice extends Device {

    private ArrayList<DeviceObserver> observers = new ArrayList<>();

    public void addObserver(DeviceObserver deviceObserver){
        observers.add(deviceObserver);
    }

    public void removeObserver(DeviceObserver deviceObserver){
        observers.remove(deviceObserver);
    }

    public void updateBasicInfo(Device device){
        setImei(device.getImei());
        setImsi(device.getImsi());
        setRoot(device.isRoot());
        setModel(device.getModel());
        setManufacturer(device.getManufacturer());
        setBoard(device.getBoard());
        setFingerprint(device.getFingerprint());
        setBootloader(device.getBootloader());
        setBrand(device.getBrand());
        setDevice(device.getDevice());
        setDisplay(device.getDisplay());
        setHardware(device.getHardware());
        setHost(device.getHost());
        setId(device.getId());
        setProduct(device.getProduct());
        setTags(device.getTags());
        setType(device.getType());
        setUser(device.getUser());
        setTime(device.getTime());
        setVersionSdkInt(device.getVersionSdkInt());
        setVersionCodename(device.getVersionCodename());
        setVersionRelease(device.getVersionRelease());
        setVersionIncremental(device.getVersionIncremental());

        notifyChange();
    }

    private void notifyChange() {
        for(DeviceObserver observer : observers) {
            observer.update(this);
        }
    }
}
