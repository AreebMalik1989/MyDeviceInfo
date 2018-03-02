package malik1989.areeb.mydeviceinfo.appObjects;

/**
 * Created by areeb on 2/3/18.
 */

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

public class PermissionsProvider {

    public final static int REQUEST_CODE = 3552;

    private Context context;
    private Activity activity;

    private int osVersion;

    public PermissionsProvider(Context context, Activity activity){

        this.context = context;
        this.activity = activity;

        osVersion = Build.VERSION.SDK_INT;

    }

    //--------------------------  Method to check OS version  ------------------------------------\\

    public boolean isMarshmallowOrAbove(){

        if(osVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {

            return true;

        } else {

            return false;

        }

    }

    //----------------------------  Method to check if already have permissions  -----------------\\

    public boolean havePermissions(){

        int result = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(result == PackageManager.PERMISSION_GRANTED ){

            return true;

        } else {

            return false;

        }

    }

    //-----------------------------  Method to request permission  -------------------------------\\

    public void requestPermissions(){

        ActivityCompat.requestPermissions(

                activity,

                new String[]{

                        Manifest.permission.READ_PHONE_STATE,

                },

                REQUEST_CODE);

    }

}
