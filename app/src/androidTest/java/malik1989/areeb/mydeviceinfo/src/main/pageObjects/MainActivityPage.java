package malik1989.areeb.mydeviceinfo.src.main.pageObjects;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

/**
 * Created by areeb on 19/2/18.
 */

public class MainActivityPage {

    private static BySelector byOpenToggleButton = By.desc("Open");
    private static BySelector byCloseToggleButton = By.desc("Close");
    private static BySelector byInfoButton = By.res("malik1989.areeb.mydeviceinfo:id/info");

    private MainActivityPage(){}

    public static void pressOpenToggleButton(UiDevice uiDevice) {

        UiObject2 openToggleButton = uiDevice.findObject(byOpenToggleButton);
        UiObject2 closeToggleButton = uiDevice.findObject(byCloseToggleButton);

        if(openToggleButton != null && openToggleButton.isClickable()){
            openToggleButton.click();
        } else if(closeToggleButton != null && closeToggleButton.isClickable()){

        } else {
            throw new UnsupportedOperationException("Unexpected state!");
        }
    }

    public static void pressCloseToggleButton(UiDevice uiDevice) {

        UiObject2 openToggleButton = uiDevice.findObject(byOpenToggleButton);
        UiObject2 closeToggleButton = uiDevice.findObject(byCloseToggleButton);

        if(closeToggleButton != null && closeToggleButton.isClickable()){
            closeToggleButton.click();
        } else if(openToggleButton != null && openToggleButton.isClickable()){

        } else {
            throw new UnsupportedOperationException("Unexpected state!");
        }
    }

    public static boolean areAllFragmentsSetInDrawer(UiDevice uiDevice, String[] list) throws UiObjectNotFoundException {

        UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true));

        for(String text:list){
            scrollable.scrollTextIntoView(text);
            if(uiDevice.findObject(By.text(text)) == null){
                return false;
            }
        }

        return true;
    }

    public static void openAllFragments(UiDevice uiDevice, String[] list) throws UiObjectNotFoundException, InterruptedException {

        for(String text:list){

            Thread.sleep(1000);
            pressOpenToggleButton(uiDevice);

            Thread.sleep(1000);
            /*UiScrollable scrollable = new UiScrollable(new UiSelector().scrollable(true));
            scrollable.scrollTextIntoView(text);*/

            UiObject2 fragment = uiDevice.findObject(By.text(text));
            if(fragment != null){
                fragment.click();
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            pressCloseToggleButton(uiDevice);
        }
    }

    public static void pressInfoButton(UiDevice uiDevice){
        UiObject2 infoButton = uiDevice.findObject(byInfoButton);
        infoButton.click();
    }
}
