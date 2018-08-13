package malik1989.areeb.mydeviceinfo.model;

import android.telephony.SubscriptionInfo;
import android.util.Log;

import java.io.Serializable;
import java.util.List;

public class SIM implements Serializable, Cloneable{

    private String country;
    private boolean isSimNetworkLocked;
    private String carrier;
    private String imsi;
    private String simSerial;
    private boolean isMultiSim;
    private int numberOfActiveSim;
    private List<SubscriptionInfo> activeMultiSimInfo;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isSimNetworkLocked() {
        return isSimNetworkLocked;
    }

    public void setSimNetworkLocked(boolean simNetworkLocked) {
        isSimNetworkLocked = simNetworkLocked;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getSimSerial() {
        return simSerial;
    }

    public void setSimSerial(String simSerial) {
        this.simSerial = simSerial;
    }

    public boolean isMultiSim() {
        return isMultiSim;
    }

    public void setMultiSim(boolean multiSim) {
        isMultiSim = multiSim;
    }

    public int getNumberOfActiveSim() {
        return numberOfActiveSim;
    }

    public void setNumberOfActiveSim(int numberOfActiveSim) {
        this.numberOfActiveSim = numberOfActiveSim;
    }

    public List<SubscriptionInfo> getActiveMultiSimInfo() {
        return activeMultiSimInfo;
    }

    public void setActiveMultiSimInfo(List<SubscriptionInfo> activeMultiSimInfo) {
        this.activeMultiSimInfo = activeMultiSimInfo;
    }
}
