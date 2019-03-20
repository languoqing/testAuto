package pages;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class CommnPage {

    /**
     * 游戏过渡页
     */

    static By goGamePage = By.xpath(".//*[@class='immediately']/a");
    public static void outTranPage(){
        AndroidElement show = Driver.getDriver().findElement(goGamePage);
        Driver.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        show.click();
    }

}
