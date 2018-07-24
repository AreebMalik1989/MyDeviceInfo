package malik1989.areeb.mydeviceinfo.model;

/**
 * Created by areeb on 22/7/18.
 */

public class Basic {

    protected String imei;
    protected String imsi;
    protected boolean root;
    protected String model;
    protected String manufacturer;
    protected String board;
    protected String fingerprint;
    protected String bootloader;
    protected String brand;
    protected String device;
    protected String display;
    protected String hardware;
    protected String host;
    protected String id;
    protected String product;
    protected String tags;
    protected String type;
    protected String user;
    protected long time;
    protected int versionSdkInt;
    protected String versionCodename;
    protected String versionRelease;
    protected String versionIncremental;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getBootloader() {
        return bootloader;
    }

    public void setBootloader(String bootloader) {
        this.bootloader = bootloader;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getVersionSdkInt() {
        return versionSdkInt;
    }

    public void setVersionSdkInt(int versionSdkInt) {
        this.versionSdkInt = versionSdkInt;
    }

    public String getVersionCodename() {
        return versionCodename;
    }

    public void setVersionCodename(String versionCodename) {
        this.versionCodename = versionCodename;
    }

    public String getVersionRelease() {
        return versionRelease;
    }

    public void setVersionRelease(String versionRelease) {
        this.versionRelease = versionRelease;
    }

    public String getVersionIncremental() {
        return versionIncremental;
    }

    public void setVersionIncremental(String versionIncremental) {
        this.versionIncremental = versionIncremental;
    }

    @Override
    public String toString() {
        return "BasicInfo{" +
                "imei='" + imei + '\'' +
                ", imsi='" + imsi + '\'' +
                ", root=" + root +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", board='" + board + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                ", bootloader='" + bootloader + '\'' +
                ", brand='" + brand + '\'' +
                ", device='" + device + '\'' +
                ", display='" + display + '\'' +
                ", hardware='" + hardware + '\'' +
                ", host='" + host + '\'' +
                ", id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", tags='" + tags + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", time=" + time +
                ", versionSdkInt=" + versionSdkInt +
                ", versionCodename='" + versionCodename + '\'' +
                ", versionRelease='" + versionRelease + '\'' +
                ", versionIncremental='" + versionIncremental + '\'' +
                '}';
    }
}
