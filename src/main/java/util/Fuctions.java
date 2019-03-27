package util;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.By;

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

        public static void clearText(By loc) {

            AndroidElement element = Driver.getDriver().findElement(loc);
            element.click();
            //光标定位到文末
            waitShowElement(3);
            Driver.getDriver().pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);

            for (int i=0;i<=element.getText().length();i++){
                System.out.println(i+"-----"+element.getText().charAt(i));
            Driver.getDriver().pressKeyCode(AndroidKeyCode.DEL);
            }
            //执行回车
            //Driver.getDriver().pressKeyCode(AndroidKeyCode.BACKSPACE);
        }


}
