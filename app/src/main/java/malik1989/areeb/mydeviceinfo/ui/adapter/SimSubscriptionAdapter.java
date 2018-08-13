package malik1989.areeb.mydeviceinfo.ui.adapter;

import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.telephony.SubscriptionInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.app.MainApp;

public class SimSubscriptionAdapter extends RecyclerView.Adapter<SimSubscriptionAdapter.MyViewHolder> {

    private List<SubscriptionInfo> simSubscriptionList;

    public SimSubscriptionAdapter(List<SubscriptionInfo> simSubscriptionList){
        this.simSubscriptionList = simSubscriptionList;
    }

    @Override
    public SimSubscriptionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sim_list_row, parent, false);

        return new SimSubscriptionAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        SubscriptionInfo subscriptionInfo = simSubscriptionList.get(position);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            holder.simIcon.setImageBitmap(subscriptionInfo.createIconBitmap(MainApp.getApp()));
            holder.displayName.setText(String.valueOf(subscriptionInfo.getDisplayName()));
            holder.slot.setText(String.valueOf(subscriptionInfo.getSimSlotIndex() + 1));
            holder.carrierName.setText(String.valueOf(subscriptionInfo.getCarrierName()));
            holder.roaming.setText(String.valueOf(subscriptionInfo.getDataRoaming()));
            holder.subscriptionId.setText(String.valueOf(subscriptionInfo.getSubscriptionId()));
            holder.iccId.setText(String.valueOf(subscriptionInfo.getIccId()));
            holder.countryIso.setText(String.valueOf(subscriptionInfo.getCountryIso()));
            holder.mcc.setText(String.valueOf(subscriptionInfo.getMcc()));
            holder.mnc.setText(String.valueOf(subscriptionInfo.getMnc()));
        } else {
            holder.displayName.setText(R.string.lollipop_required);
            holder.slot.setText(R.string.lollipop_required);
            holder.carrierName.setText(R.string.lollipop_required);
            holder.roaming.setText(R.string.lollipop_required);
            holder.subscriptionId.setText(R.string.lollipop_required);
            holder.iccId.setText(R.string.lollipop_required);
            holder.countryIso.setText(R.string.lollipop_required);
            holder.mcc.setText(R.string.lollipop_required);
            holder.mnc.setText(R.string.lollipop_required);
        }
    }

    @Override
    public int getItemCount() {
        return simSubscriptionList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private ImageView simIcon;
        private TextView displayName, slot, carrierName, roaming, subscriptionId,
                            iccId, countryIso, mcc, mnc;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.sim_card_view);
            simIcon = itemView.findViewById(R.id.sim_icon);
            displayName = itemView.findViewById(R.id.sim_display_name);
            slot = itemView.findViewById(R.id.sim_slot);
            carrierName = itemView.findViewById(R.id.sim_carrier_name);
            roaming = itemView.findViewById(R.id.sim_roaming);
            subscriptionId = itemView.findViewById(R.id.subscription_id);
            iccId = itemView.findViewById(R.id.sim_icc_id);
            countryIso = itemView.findViewById(R.id.sim_country_iso);
            mcc = itemView.findViewById(R.id.sim_mcc);
            mnc = itemView.findViewById(R.id.sim_mnc);
        }
    }
}
