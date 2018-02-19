package malik1989.areeb.mydeviceinfo.pageObjects;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by areeb on 19/2/18.
 */

public class MainActivityObject {

    public UiObject openToggleButton = new UiObject(new UiSelector().description("Open"));
    public UiObject closeToggleButton = new UiObject(new UiSelector().description("Close"));

    public void pressOpenToggleButton() throws UiObjectNotFoundException {
        openToggleButton.clickAndWaitForNewWindow();
    }

    public void pressCloseToggleButton() throws UiObjectNotFoundException {
        closeToggleButton.clickAndWaitForNewWindow();
    }
}
