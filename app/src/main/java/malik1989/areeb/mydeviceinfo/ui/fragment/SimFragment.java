package malik1989.areeb.mydeviceinfo.ui.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SubscriptionInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.app.MainApp;
import malik1989.areeb.mydeviceinfo.collector.SimInfoCollector;
import malik1989.areeb.mydeviceinfo.exchange.DataExchange;
import malik1989.areeb.mydeviceinfo.model.SIM;
import malik1989.areeb.mydeviceinfo.observer.SimObserver;
import malik1989.areeb.mydeviceinfo.ui.adapter.SimSubscriptionAdapter;

public class SimFragment extends Fragment implements SimObserver {

    protected View myview;
    protected RecyclerView recyclerView;
    protected SimSubscriptionAdapter simSubscriptionAdapter;
    protected boolean running = true;
    protected List<SubscriptionInfo> subscriptionInfoList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_specs, container, false);
        recyclerView = myview.findViewById(R.id.specs_recyclerview);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(simSubscriptionAdapter);

        return myview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        running = true;

        // Array list for fixing ConcurrentException
        subscriptionInfoList = new CopyOnWriteArrayList<>();
        simSubscriptionAdapter = new SimSubscriptionAdapter(subscriptionInfoList);

        DataExchange.sim.addObserver(this);

        DataExchange.sim.updateSimInfo(SimInfoCollector.collect(getActivity()));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        running = false;

        DataExchange.sim.removeObserver(this);
    }

    @Override
    public void update(SIM sim) {

        subscriptionInfoList.removeAll(subscriptionInfoList.subList(0, subscriptionInfoList.size()));

        subscriptionInfoList.addAll(sim.getActiveMultiSimInfo());

        simSubscriptionAdapter.notifyDataSetChanged();
    }
}
