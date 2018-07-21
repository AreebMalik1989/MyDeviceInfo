package malik1989.areeb.mydeviceinfo.appObjects;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import malik1989.areeb.mydeviceinfo.SettingsFragment;
import malik1989.areeb.mydeviceinfo.SpecsFragment;

/**
 * Created by areeb on 17/2/18.
 */

public class MyFragmentManager {

    private FragmentManager fragmentManager;
    private int contentFrameId;

    public Fragment specFragment;
    public Fragment settingsFragment;
    public Fragment batteryFragment;

    public MyFragmentManager(AppCompatActivity activity, int contentFrameId){
        this.fragmentManager = activity.getSupportFragmentManager();
        this.contentFrameId = contentFrameId;
        this.specFragment = new SpecsFragment();
        this.settingsFragment = new SettingsFragment();
    }

    public void updateFragment(Fragment fragment){
        fragmentManager.beginTransaction().replace(contentFrameId, fragment).commit();
    }

    public void switchFragments(String s, FragmentManager supportFragmentManager){

        Fragment fragment;
        FragmentManager fragmentManager;

        switch (s){
            case "Home":
                this.updateFragment(specFragment);
                break;

            case "Settings":
                this.updateFragment(settingsFragment);
                break;

            case "Battery":
                this.updateFragment(batteryFragment);
                break;
        }
    }
}
