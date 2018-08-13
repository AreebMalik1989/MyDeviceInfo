package malik1989.areeb.mydeviceinfo.ui.fragment;

import android.content.Context;
import android.hardware.Sensor;
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

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.collector.SensorInfoCollector;
import malik1989.areeb.mydeviceinfo.collector.SimInfoCollector;
import malik1989.areeb.mydeviceinfo.exchange.DataExchange;
import malik1989.areeb.mydeviceinfo.model.MySensor;
import malik1989.areeb.mydeviceinfo.observer.SensorObserver;
import malik1989.areeb.mydeviceinfo.ui.adapter.SensorPropertiesAdapter;

public class SensorFragment extends Fragment implements SensorObserver {

    protected View myview;
    protected RecyclerView recyclerView;
    protected SensorPropertiesAdapter sensorPropertiesAdapter;
    protected boolean running = true;
    protected List<Sensor> sensorList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_specs, container, false);
        recyclerView = myview.findViewById(R.id.specs_recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(sensorPropertiesAdapter);

        return myview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        running = true;

        // Array list for fixing ConcurrentException
        sensorList = new CopyOnWriteArrayList<>();
        sensorPropertiesAdapter = new SensorPropertiesAdapter(sensorList);

        DataExchange.sensor.addObserver(this);
        DataExchange.sensor.updateSensorInfo(SensorInfoCollector.collect());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        running = false;

        DataExchange.sensor.removeObserver(this);
    }

    @Override
    public void update(MySensor sensor) {

        sensorList.removeAll(sensorList.subList(0, sensorList.size()));

        sensorList.addAll(sensor.getSensorsList());

        sensorPropertiesAdapter.notifyDataSetChanged();
    }
}
