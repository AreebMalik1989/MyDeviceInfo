package malik1989.areeb.mydeviceinfo.model;

/**
 * Created by areeb on 22/7/18.
 */

public class Wifi {

    public int state;

    public String bssid;

    public String ssid;

    public int ipAddress;

    public String macAddress;

    public int networkId;

    public int linkSpeed;

    public int rssi;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public int getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(int ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }

    public int getLinkSpeed() {
        return linkSpeed;
    }

    public void setLinkSpeed(int linkSpeed) {
        this.linkSpeed = linkSpeed;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    @Override
    public String toString() {
        return "WifiInfo{" +
                "state=" + state +
                ", bssid='" + bssid + '\'' +
                ", ssid='" + ssid + '\'' +
                ", ipAddress=" + ipAddress +
                ", macAddress='" + macAddress + '\'' +
                ", networkId=" + networkId +
                ", linkSpeed=" + linkSpeed +
                ", rssi=" + rssi +
                '}';
    }
}
