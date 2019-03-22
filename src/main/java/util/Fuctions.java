package util;

import driver.Driver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Fuctions {

    /**
     * 等待元素显示，统一5ssec
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
}
