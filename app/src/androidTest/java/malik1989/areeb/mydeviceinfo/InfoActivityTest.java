package malik1989.areeb.mydeviceinfo;

import android.test.ActivityInstrumentationTestCase2;

import malik1989.areeb.mydeviceinfo.ui.activity.InfoActivity;

/**
 * Created by areeb on 17/2/18.
 */

public class InfoActivityTest extends ActivityInstrumentationTestCase2<InfoActivity> {

    private InfoActivity infoActivity;

    public InfoActivityTest(){
        super(InfoActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        infoActivity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testInfoActivityIsNotNull(){
        assertNotNull("InfoActivity is null", infoActivity);
    }
}
