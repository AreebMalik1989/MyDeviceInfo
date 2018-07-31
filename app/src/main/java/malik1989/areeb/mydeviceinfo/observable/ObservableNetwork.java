package malik1989.areeb.mydeviceinfo.observable;

import java.util.ArrayList;

import malik1989.areeb.mydeviceinfo.model.Network;
import malik1989.areeb.mydeviceinfo.observer.NetworkObserver;

/**
 * Created by areeb on 27/7/18.
 */

public class ObservableNetwork extends Network {

    private ArrayList<NetworkObserver> observers = new ArrayList<>();

    public void addObserver(NetworkObserver networkObserver){
        observers.add(networkObserver);
    }

    public void removeObserver(NetworkObserver networkObserver){
        observers.remove(networkObserver);
    }

    public void updateNetworkInfo(Network network){
        setDeviceSoftwareVersion(network.getDeviceSoftwareVersion());
        setDeviceId(network.getDeviceId());
        setNeighboringCellInfo(network.getNeighboringCellInfo());
        setCellLocation(network.getCellLocation());
        setPhoneType(network.getPhoneType());
        setNetworkOperatorName(network.getNetworkOperatorName());
        setNetworkOperator(network.getNetworkOperator());
        setNetworkRoaming(network.isNetworkRoaming());
        setNetworkCountryIso(network.getNetworkCountryIso());
        setNetworkType(network.getNetworkType());
        setHasIccCard(network.isHasIccCard());
        setSimState(network.getSimState());
        setSimOperator(network.getSimOperator());
        setSimOperatorName(network.getSimOperatorName());
        setSimCountryIso(network.getSimCountryIso());
        setSimSerialNumber(network.getSimSerialNumber());
        setSubscriberId(network.getSubscriberId());
        setGroupIdLevel1(network.getGroupIdLevel1());
        setLine1Number(network.getLine1Number());
        setVoiceMailNumber(network.getVoiceMailNumber());
        setVoiceMailAlphaTag(network.getVoiceMailAlphaTag());
        setCallState(network.getCallState());
        setDataActivity(network.getDataActivity());
        setDataState(network.getDataState());
        setAllCellInfo(network.getAllCellInfo());
        setMmsUserAgent(network.getMmsUserAgent());
        setMmsUAProfUrl(network.getMmsUAProfUrl());

        notifyChange();
    }

    private void notifyChange() {
        for(NetworkObserver observer : observers) {
            observer.update(this);
        }
    }
}
