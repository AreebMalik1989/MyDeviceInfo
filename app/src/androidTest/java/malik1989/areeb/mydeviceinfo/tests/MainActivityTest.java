package malik1989.areeb.mydeviceinfo.tests;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.test.ActivityInstrumentationTestCase2;

import junit.framework.Assert;

import malik1989.areeb.mydeviceinfo.MainActivity;
import malik1989.areeb.mydeviceinfo.R;
import malik1989.areeb.mydeviceinfo.pageObjects.MainActivityObject;

/**
 * Created by areeb on 24/2/18.
 */

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private MainActivityObject mainActivityObject;
    private UiDevice uiDevice;

    public MainActivityTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();

        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mainActivity = getActivity();
        mainActivityObject = new MainActivityObject(uiDevice);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testFragementListInAppDrawer() throws UiObjectNotFoundException {
        mainActivityObject.pressOpenToggleButton();
        Assert.assertTrue(mainActivityObject.areAllFragmentsSetInDrawer(mainActivity.getApplicationContext().getResources().getStringArray(R.array.fragments)));
        mainActivityObject.pressCloseToggleButton();
    }
}
