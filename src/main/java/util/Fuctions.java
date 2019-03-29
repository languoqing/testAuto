package util;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Fuctions {

    /**
     * 等待元素显示，统一5sec
     */
    public static void waitShowElement(int sec){
        Driver.getDriver().manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static boolean isElementExist(By element){
        try{
            Driver.getDriver().findElement(element);
            return true;
        }catch (Exception e){
            //e.printStackTrace();
            return false;
        }
    }

    /**
     * clear() 方法并不能删除
     * @param loc
     */
    public static void clearText(By loc) {
        //选中长按
        AndroidElement element = Driver.getDriver().findElement(loc);
        TouchAction action = new TouchAction(Driver.getDriver());
        action.longPress(ElementOption.element(element)).perform();
        Driver.getDriver().pressKeyCode(AndroidKeyCode.DEL);
        //光标定位到文末
        }
}
