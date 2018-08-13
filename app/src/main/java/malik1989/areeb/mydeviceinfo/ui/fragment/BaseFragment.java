package malik1989.areeb.mydeviceinfo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import java.util.concurrent.CopyOnWriteArrayList;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.model.DeviceProperty;
import malik1989.areeb.mydeviceinfo.ui.adapter.DevicePropertiesAdapter;

/**
 * Created by areeb on 28/7/18.
 */

public abstract class BaseFragment extends Fragment {

    protected View myview;
    protected RecyclerView recyclerView;
    protected DevicePropertiesAdapter devicePropertiesAdapter;
    protected boolean running=true;
    protected List<DeviceProperty> devicePropertyList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_specs, container, false);
        recyclerView = myview.findViewById(R.id.specs_recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(devicePropertiesAdapter);

        return myview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        running = true;

        // Array list for fixing ConcurrentException
        devicePropertyList = new CopyOnWriteArrayList<>();
        devicePropertiesAdapter = new DevicePropertiesAdapter(devicePropertyList);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        running = false;
    }
}
