package malik1989.areeb.mydeviceinfo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.adapters.DevicePropertiesAdapter;
import malik1989.areeb.mydeviceinfo.properties.DeviceProperties;
import malik1989.areeb.mydeviceinfo.properties.battery.BatteryProperties;

/**
 * Created by areeb on 21/7/18.
 */

public class BatteryFragment extends Fragment {

    private View myview;
    private RecyclerView recyclerView;
    private DevicePropertiesAdapter devicePropertiesAdapter;
    private boolean running=true;
    private DeviceProperties deviceProperties;
    private Map<String, String> devicePropertyMap;


    public BatteryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_specs, container, false);
        recyclerView = myview.findViewById(R.id.specs_recyclerview);
        deviceProperties = new BatteryProperties();
        devicePropertyMap = deviceProperties.getProperties();
        devicePropertiesAdapter = new DevicePropertiesAdapter(devicePropertyMap);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(devicePropertiesAdapter);

        setup();

        return myview;
    }

    private void setup(){

    }
}
