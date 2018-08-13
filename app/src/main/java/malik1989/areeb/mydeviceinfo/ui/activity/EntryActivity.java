package malik1989.areeb.mydeviceinfo.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import malik1989.areeb.mydeviceinfo.R;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class EntryActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private final String TAG = this.getClass().getSimpleName();
    private static final String[] REQUIRED_PERMISSIONS = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.READ_PHONE_STATE
    };

    private static final int REQUIRED_PERMISSIONS_ID = 1989;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        requestPermissions();
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

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);

    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        openMainActivity();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this,R.string.permission_denied, Toast.LENGTH_SHORT).show();
        openMainActivity();
    }

    @AfterPermissionGranted(REQUIRED_PERMISSIONS_ID)
    private void requestPermissions(){

        if(EasyPermissions.hasPermissions(this, REQUIRED_PERMISSIONS)){

            openMainActivity();

        } else {

            EasyPermissions.requestPermissions(
                    this,
                    getString(R.string.request_permission),
                    REQUIRED_PERMISSIONS_ID,
                    REQUIRED_PERMISSIONS
            );
        }
    }

    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
