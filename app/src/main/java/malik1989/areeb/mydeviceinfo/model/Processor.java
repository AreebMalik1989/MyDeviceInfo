package malik1989.areeb.mydeviceinfo.model;

/**
 * Created by areeb on 22/7/18.
 */

public class Processor {

    protected String processor;
    protected String features;
    protected String cpu_implementer;
    protected String cpu_architecture;
    protected String cpu_variant;
    protected String cpu_part;
    protected String cpu_revision;
    protected String hardware;
    protected String revision;
    protected String serial;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getCpu_implementer() {
        return cpu_implementer;
    }

    public void setCpu_implementer(String cpu_implementer) {
        this.cpu_implementer = cpu_implementer;
    }

    public String getCpu_architecture() {
        return cpu_architecture;
    }

    public void setCpu_architecture(String cpu_architecture) {
        this.cpu_architecture = cpu_architecture;
    }

    public String getCpu_variant() {
        return cpu_variant;
    }

    public void setCpu_variant(String cpu_variant) {
        this.cpu_variant = cpu_variant;
    }

    public String getCpu_part() {
        return cpu_part;
    }

    public void setCpu_part(String cpu_part) {
        this.cpu_part = cpu_part;
    }

    public String getCpu_revision() {
        return cpu_revision;
    }

    public void setCpu_revision(String cpu_revision) {
        this.cpu_revision = cpu_revision;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "CpuInfo{" +
                "processor='" + processor + '\'' +
                ", features='" + features + '\'' +
                ", cpu_implementer='" + cpu_implementer + '\'' +
                ", cpu_architecture='" + cpu_architecture + '\'' +
                ", cpu_variant='" + cpu_variant + '\'' +
                ", cpu_part='" + cpu_part + '\'' +
                ", cpu_revision='" + cpu_revision + '\'' +
                ", hardware='" + hardware + '\'' +
                ", revision='" + revision + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
