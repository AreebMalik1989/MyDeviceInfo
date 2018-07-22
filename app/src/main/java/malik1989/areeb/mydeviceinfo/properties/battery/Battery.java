package malik1989.areeb.mydeviceinfo.properties.battery;

/**
 * Created by areeb on 21/7/18.
 */

public class Battery {

    private boolean isPresent;
    private String technology;
    private int plugged;
    private int health;
    private int status;
    private int voltage;
    private int temperature;
    private int level;

    public Battery(){

    }

    public Battery(boolean isPresent, String technology, int plugged, int health, int status, int voltage, int temperature, int level) {
        this.isPresent = isPresent;
        this.technology = technology;
        this.plugged = plugged;
        this.health = health;
        this.status = status;
        this.voltage = voltage;
        this.temperature = temperature;
        this.level = level;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getPlugged() {
        return plugged;
    }

    public void setPlugged(int plugged) {
        this.plugged = plugged;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
