package malik1989.areeb.mydeviceinfo.model;

/**
 * Created by areeb on 22/7/18.
 */

public class Basic {

    public String uuid;

    public String imei;

    public String imsi;

    public String kernel_version;

    public boolean root;

    public String model;

    public String manufacturer;

    public String board;

    public String fingerprint;

    public String bootloader;

    public String brand;

    public String cpu_abi;

    public String cpu_abi2;

    public String device;

    public String display;

    public String hardware;

    public String host;

    public String id;

    public String product;

    public String serial;

    public String tags;

    public String type;

    public String user;

    public long time;

    public int version_sdk_int;

    public String version_codename;

    public String version_release;

    public String version_incremental;

    public String net_hostname;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public String getKernel_version() {
        return kernel_version;
    }

    public void setKernel_version(String kernel_version) {
        this.kernel_version = kernel_version;
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

    public String getCpu_abi() {
        return cpu_abi;
    }

    public void setCpu_abi(String cpu_abi) {
        this.cpu_abi = cpu_abi;
    }

    public String getCpu_abi2() {
        return cpu_abi2;
    }

    public void setCpu_abi2(String cpu_abi2) {
        this.cpu_abi2 = cpu_abi2;
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

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
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

    public int getVersion_sdk_int() {
        return version_sdk_int;
    }

    public void setVersion_sdk_int(int version_sdk_int) {
        this.version_sdk_int = version_sdk_int;
    }

    public String getVersion_codename() {
        return version_codename;
    }

    public void setVersion_codename(String version_codename) {
        this.version_codename = version_codename;
    }

    public String getVersion_release() {
        return version_release;
    }

    public void setVersion_release(String version_release) {
        this.version_release = version_release;
    }

    public String getVersion_incremental() {
        return version_incremental;
    }

    public void setVersion_incremental(String version_incremental) {
        this.version_incremental = version_incremental;
    }

    public String getNet_hostname() {
        return net_hostname;
    }

    public void setNet_hostname(String net_hostname) {
        this.net_hostname = net_hostname;
    }

    @Override
    public String toString() {
        return "BasicInfo{" +
                "uuid='" + uuid + '\'' +
                ", imei='" + imei + '\'' +
                ", imsi='" + imsi + '\'' +
                ", kernel_version='" + kernel_version + '\'' +
                ", root=" + root +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", board='" + board + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                ", bootloader='" + bootloader + '\'' +
                ", brand='" + brand + '\'' +
                ", cpu_abi='" + cpu_abi + '\'' +
                ", cpu_abi2='" + cpu_abi2 + '\'' +
                ", device='" + device + '\'' +
                ", display='" + display + '\'' +
                ", hardware='" + hardware + '\'' +
                ", host='" + host + '\'' +
                ", id='" + id + '\'' +
                ", product='" + product + '\'' +
                ", serial='" + serial + '\'' +
                ", tags='" + tags + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", time=" + time +
                ", version_sdk_int=" + version_sdk_int +
                ", version_codename='" + version_codename + '\'' +
                ", version_release='" + version_release + '\'' +
                ", version_incremental='" + version_incremental + '\'' +
                ", net_hostname='" + net_hostname + '\'' +
                '}';
    }
}
