package malik1989.areeb.mydeviceinfo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import github.nisrulz.easydeviceinfo.base.EasyAppMod;
import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.exchange.DataExchange;

/**
 * Created by areeb on 27/7/18.
 */

public class InfoActivity extends AppCompatActivity {

    TextView version, versionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        EasyAppMod appMod = new EasyAppMod(this);

        version = findViewById(R.id.info_version);
        versionCode = findViewById(R.id.info_version_code);

        version.setText(appMod.getAppVersion());
        versionCode.setText(String.valueOf(appMod.getAppVersionCode()));
    }
}