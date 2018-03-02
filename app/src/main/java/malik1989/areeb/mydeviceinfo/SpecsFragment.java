package malik1989.areeb.mydeviceinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import malik1989.areeb.mydeviceinfo.adapters.DevicePropertiesAdapter;
import malik1989.areeb.mydeviceinfo.appObjects.SpecsManager;
import malik1989.areeb.mydeviceinfo.dto.DeviceProperty;
import malik1989.areeb.mydeviceinfo.dto.Specs;

public class SpecsFragment extends Fragment {

    private View myview;
    private RecyclerView recyclerView;
    private DevicePropertiesAdapter devicePropertiesAdapter;
    private boolean running=true;
    private Specs specs;
    private SpecsManager specsManager;
    private List<DeviceProperty> devicePropertyList;

    /**
     * To fulfill the requirement of default constructor
     */
    public SpecsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_specs, container, false);
        recyclerView = myview.findViewById(R.id.specs_recyclerview);
        specsManager = new SpecsManager(getContext(), getActivity());
        devicePropertyList = new ArrayList<>();
        devicePropertiesAdapter = new DevicePropertiesAdapter(devicePropertyList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(devicePropertiesAdapter);


        setup();

        return myview;
    }

    @Override
    public void onDetach(){
        super.onDetach();
        running=false;
    }

    /**
     * Function to setup the UI of specs fragment
     * @return boolean
     */
    private boolean setup() {

        specs = specsManager.getStaticSpecs();

        devicePropertyList.add(new DeviceProperty(getString(R.string.model_number), specs.getModelNumber()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.product_name), specs.getProductName()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.os_version), specs.getOsVersion()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.product_name), specs.getProductName()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.processor_core), specs.getProcessorCore()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.back_camera), specs.getBackCamera()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.front_camera), specs.getFrontCamera()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.ram), specs.getRam()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.rom), specs.getRom()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.screen_resolution), specs.getScreenResolution()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.serial_number), specs.getSerialNumber()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.imei1), specs.getImei1()));
        devicePropertyList.add(new DeviceProperty(getString(R.string.imei2), specs.getImei2()));

        devicePropertiesAdapter.notifyDataSetChanged();

        return true;
    }
}