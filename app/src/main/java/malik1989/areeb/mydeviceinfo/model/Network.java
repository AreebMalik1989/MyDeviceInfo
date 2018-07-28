package malik1989.areeb.mydeviceinfo.model;

import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;

import java.util.List;

/**
 * Created by areeb on 22/7/18.
 */

public class Network {

    protected String deviceSoftwareVersion;
    protected String deviceId;
    protected List<NeighboringCellInfo> neighboringCellInfo;
    protected CellLocation cellLocation;
    protected int phoneType;
    protected String networkOperatorName;
    protected String networkOperator;
    protected boolean isNetworkRoaming;
    protected String networkCountryIso;
    protected int networkType;
    protected boolean hasIccCard;
    protected int simState;
    protected String simOperator;
    protected String simOperatorName;
    protected String simCountryIso;
    protected String simSerialNumber;
    protected String subscriberId;
    protected String groupIdLevel1;
    protected String line1Number;
    protected String voiceMailNumber;
    protected String voiceMailAlphaTag;
    protected int callState;
    protected int dataActivity;
    protected int dataState;
    protected List<CellInfo> allCellInfo;
    protected String mmsUserAgent;
    protected String mmsUAProfUrl;

    public String getDeviceSoftwareVersion() {
        return deviceSoftwareVersion;
    }

    public void setDeviceSoftwareVersion(String deviceSoftwareVersion) {
        this.deviceSoftwareVersion = deviceSoftwareVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<NeighboringCellInfo> getNeighboringCellInfo() {
        return neighboringCellInfo;
    }

    public void setNeighboringCellInfo(List<NeighboringCellInfo> neighboringCellInfo) {
        this.neighboringCellInfo = neighboringCellInfo;
    }

    public CellLocation getCellLocation() {
        return cellLocation;
    }

    public void setCellLocation(CellLocation cellLocation) {
        this.cellLocation = cellLocation;
    }

    public int getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(int phoneType) {
        this.phoneType = phoneType;
    }

    public String getNetworkOperatorName() {
        return networkOperatorName;
    }

    public void setNetworkOperatorName(String networkOperatorName) {
        this.networkOperatorName = networkOperatorName;
    }

    public String getNetworkOperator() {
        return networkOperator;
    }

    public void setNetworkOperator(String networkOperator) {
        this.networkOperator = networkOperator;
    }

    public boolean isNetworkRoaming() {
        return isNetworkRoaming;
    }

    public void setNetworkRoaming(boolean networkRoaming) {
        isNetworkRoaming = networkRoaming;
    }

    public String getNetworkCountryIso() {
        return networkCountryIso;
    }

    public void setNetworkCountryIso(String networkCountryIso) {
        this.networkCountryIso = networkCountryIso;
    }

    public int getNetworkType() {
        return networkType;
    }

    public void setNetworkType(int networkType) {
        this.networkType = networkType;
    }

    public boolean isHasIccCard() {
        return hasIccCard;
    }

    public void setHasIccCard(boolean hasIccCard) {
        this.hasIccCard = hasIccCard;
    }

    public int getSimState() {
        return simState;
    }

    public void setSimState(int simState) {
        this.simState = simState;
    }

    public String getSimOperator() {
        return simOperator;
    }

    public void setSimOperator(String simOperator) {
        this.simOperator = simOperator;
    }

    public String getSimOperatorName() {
        return simOperatorName;
    }

    public void setSimOperatorName(String simOperatorName) {
        this.simOperatorName = simOperatorName;
    }

    public String getSimCountryIso() {
        return simCountryIso;
    }

    public void setSimCountryIso(String simCountryIso) {
        this.simCountryIso = simCountryIso;
    }

    public String getSimSerialNumber() {
        return simSerialNumber;
    }

    public void setSimSerialNumber(String simSerialNumber) {
        this.simSerialNumber = simSerialNumber;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getGroupIdLevel1() {
        return groupIdLevel1;
    }

    public void setGroupIdLevel1(String groupIdLevel1) {
        this.groupIdLevel1 = groupIdLevel1;
    }

    public String getLine1Number() {
        return line1Number;
    }

    public void setLine1Number(String line1Number) {
        this.line1Number = line1Number;
    }

    public String getVoiceMailNumber() {
        return voiceMailNumber;
    }

    public void setVoiceMailNumber(String voiceMailNumber) {
        this.voiceMailNumber = voiceMailNumber;
    }

    public String getVoiceMailAlphaTag() {
        return voiceMailAlphaTag;
    }

    public void setVoiceMailAlphaTag(String voiceMailAlphaTag) {
        this.voiceMailAlphaTag = voiceMailAlphaTag;
    }

    public int getCallState() {
        return callState;
    }

    public void setCallState(int callState) {
        this.callState = callState;
    }

    public int getDataActivity() {
        return dataActivity;
    }

    public void setDataActivity(int dataActivity) {
        this.dataActivity = dataActivity;
    }

    public int getDataState() {
        return dataState;
    }

    public void setDataState(int dataState) {
        this.dataState = dataState;
    }

    public List<CellInfo> getAllCellInfo() {
        return allCellInfo;
    }

    public void setAllCellInfo(List<CellInfo> allCellInfo) {
        this.allCellInfo = allCellInfo;
    }

    public String getMmsUserAgent() {
        return mmsUserAgent;
    }

    public void setMmsUserAgent(String mmsUserAgent) {
        this.mmsUserAgent = mmsUserAgent;
    }

    public String getMmsUAProfUrl() {
        return mmsUAProfUrl;
    }

    public void setMmsUAProfUrl(String mmsUAProfUrl) {
        this.mmsUAProfUrl = mmsUAProfUrl;
    }
}
