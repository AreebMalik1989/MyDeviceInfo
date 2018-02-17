package malik1989.areeb.mydeviceinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SpecsFragment extends Fragment {

    View myview;
    boolean running=true;

    /**
     * To fulfill the requirement of default constructor
     */
    public SpecsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myview = inflater.inflate(R.layout.fragment_specs, container, false);

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
        return true;
    }
}