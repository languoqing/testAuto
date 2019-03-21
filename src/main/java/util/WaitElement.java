package util;

import driver.Driver;

import java.util.concurrent.TimeUnit;

public class WaitElement {

    /**
     * 等待元素显示，统一5s
     */
    public static void waitShowElement(){
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
