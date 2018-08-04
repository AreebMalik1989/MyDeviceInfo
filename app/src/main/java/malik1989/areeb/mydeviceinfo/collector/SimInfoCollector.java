package malik1989.areeb.mydeviceinfo.collector;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;

import github.nisrulz.easydeviceinfo.base.EasySimMod;
import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.app.MainApp;
import malik1989.areeb.mydeviceinfo.model.SIM;

public class SimInfoCollector {

    /**
     * Collects SIM information
     *
     * @return : SIM instance with updated information
     */
    @SuppressLint("MissingPermission")
    public static SIM collect(){
        Context context = MainApp.getApp();
        return collect(context);
    }

    /**
     * Collects SIM information
     *
     * @return : SIM instance with updated information
     */
    @SuppressLint("MissingPermission")
    public static SIM collect(Context context) {

        SIM sim = new SIM();
        EasySimMod easySimMod = new EasySimMod(context);

        sim.setCountry(easySimMod.getCountry());
        sim.setSimNetworkLocked(easySimMod.isSimNetworkLocked());
        sim.setCarrier(easySimMod.getCarrier());

        // Calls requiring READ_PHONE_STATE permission
        sim.setImsi(easySimMod.getIMSI());
        sim.setSimSerial(easySimMod.getSIMSerial());
        sim.setMultiSim(easySimMod.isMultiSim());
        sim.setNumberOfActiveSim(easySimMod.getNumberOfActiveSim());
        sim.setActiveMultiSimInfo(easySimMod.getActiveMultiSimInfo());

        return sim;
    }

    /**
     * Collects SIM information which doesn't require READ_PHONE_STATE permission
     *
     * @return : SIM instance with updated information not requiring any permission
     */
    public static SIM collectSecure(){
        Context context = MainApp.getApp();
        return collectSecure(context);
    }

    /**
     * Collects SIM information which doesn't require READ_PHONE_STATE permission
     *
     * @return : SIM instance with updated information not requiring any permission
     */
    public static SIM collectSecure(Context context){

        SIM sim = new SIM();
        EasySimMod easySimMod = new EasySimMod(context);

        sim.setCountry(easySimMod.getCountry());
        sim.setSimNetworkLocked(easySimMod.isSimNetworkLocked());
        sim.setCarrier(easySimMod.getCarrier());

        return sim;
    }
}
