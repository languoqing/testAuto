package pages;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import util.Fuctions;

public class CommnPage {

    /**
     * 游戏过渡页
     */
    public static By goGamePage = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.view.View[2]/android.view.View[2]");
    public static void outTranPage(){
        AndroidElement show = Driver.getDriver().findElement(goGamePage);
        Fuctions.waitShowElement(2);
        show.click();
    }

}
