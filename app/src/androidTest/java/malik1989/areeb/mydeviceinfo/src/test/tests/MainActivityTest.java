package malik1989.areeb.mydeviceinfo.src.test.tests;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.test.ActivityInstrumentationTestCase2;

import junit.framework.Assert;

import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.src.main.pageObjects.MainActivityPage;
import malik1989.areeb.mydeviceinfo.ui.activity.MainActivity;

/**
 * Created by areeb on 24/2/18.
 */

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private UiDevice uiDevice;
    private String[] fragmentArray;

    public MainActivityTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();

        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mainActivity = getActivity();
        fragmentArray = mainActivity.getApplicationContext().getResources().getStringArray(R.array.fragments);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testFragementListInAppDrawer() throws UiObjectNotFoundException {
        MainActivityPage.pressOpenToggleButton(uiDevice);
        Assert.assertTrue(MainActivityPage.areAllFragmentsSetInDrawer(uiDevice, fragmentArray));
        MainActivityPage.pressCloseToggleButton(uiDevice);
    }

    public void testOpenAllFragments() throws UiObjectNotFoundException, InterruptedException {
        MainActivityPage.openAllFragments(uiDevice, fragmentArray);
    }
}
