package util;

import driver.Driver;
import io.appium.java_client.TouchAction;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.time.ZonedDateTime;

public class SwipePage {

    static Duration duration = Duration.ofSeconds(1);
    static int width = Driver.getDriver().manage().window().getSize().width;
    static int height = Driver.getDriver().manage().window().getSize().height;
    public static void downSwipe(){
        TouchAction action2 = new TouchAction(Driver.getDriver());
        action2.press(PointOption.point(width / 2, height / 2));
        action2.waitAction(WaitOptions.waitOptions(duration));
        action2.moveTo(PointOption.point(width / 2, height * 3 / 4));
        action2.release();
        action2.perform();
    }
}
