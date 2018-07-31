package malik1989.areeb.mydeviceinfo.ui.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.collector.WifiInfoCollector;
import malik1989.areeb.mydeviceinfo.exchange.DataExchange;
import malik1989.areeb.mydeviceinfo.util.PermissionsProvider;

public class EntryActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        runtimePermissions();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        View currentView = getCurrentFocus();
        if(currentView != null){
            currentView.clearFocus();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {

            case PermissionsProvider.REQUEST_CODE:

                if(grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                    Log.d(TAG, "Permission Was Granted");

                } else {

                    Log.d(TAG, "Permission Denied");

                }

        }

    }

    private void runtimePermissions(){

        PermissionsProvider permissionsProvider = new PermissionsProvider(this, this);

        if(permissionsProvider.isMarshmallowOrAbove()) {

            if(!permissionsProvider.havePermissions()) {

                permissionsProvider.requestPermissions();

            }

        }

    }
}
