package malik1989.areeb.mydeviceinfo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import malik1989.areeb.mydeviceinfo.exchange.DataExchange;
import malik1989.areeb.mydeviceinfo.model.Battery;

/**
 * Created by areeb on 26/7/18.
 */

public class BatteryReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean isPresent = intent.getBooleanExtra("present", false);
        int scale = intent.getIntExtra("scale", -1);
        int rawLevel = intent.getIntExtra("level", -1);
        int level = 0;

        if (isPresent) {
            if (rawLevel >= 0 && scale > 0) {
                level = (rawLevel * 100) / scale;
            }
        }

        Battery battery = new Battery();

        battery.setTechnology(intent.getStringExtra("technology"));
        battery.setPlugged(intent.getIntExtra("plugged", -1));
        battery.setHealth(intent.getIntExtra("health", 0));
        battery.setStatus(intent.getIntExtra("status", 0));
        battery.setVoltage(intent.getIntExtra("voltage", 0));
        battery.setTemperature(intent.getIntExtra("temperature", 0));
        battery.setLevel(level);

        DataExchange.battery.updateBatteryInfo(battery);
    }
}
