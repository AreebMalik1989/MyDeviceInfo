package malik1989.areeb.mydeviceinfo.model;

/**
 * Created by areeb on 27/7/18.
 */

public class DeviceProperty {

    String property, value;

    public DeviceProperty(){
    }

    public DeviceProperty(String property, String value){
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
