package malik1989.areeb.mydeviceinfo.pageObjects;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by areeb on 19/2/18.
 */

public class MainActivityObject {

    private UiDevice uiDevice;

    private BySelector openToggleButton = By.desc("Open");
    private BySelector closeToggleButton = By.desc("Close");

    public MainActivityObject(UiDevice uiDevice){
        this.uiDevice = uiDevice;
    }

    public void pressOpenToggleButton() throws UiObjectNotFoundException {
        uiDevice.findObject(openToggleButton).click();
    }

    public void pressCloseToggleButton() throws UiObjectNotFoundException {
        uiDevice.findObject(closeToggleButton).click();
    }

    public boolean areAllFragmentsSetInDrawer(String[] list) throws UiObjectNotFoundException {

        UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true));

        for(String text:list){
            scrollable.scrollTextIntoView(text);
            if(uiDevice.findObject(By.text(text)) == null){
                return false;
            }
        }

        return true;
    }
}
