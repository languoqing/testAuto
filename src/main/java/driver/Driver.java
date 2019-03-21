package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    static AndroidDriver<AndroidElement> driver = null;
    public static void setDirver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "ANDROID");
        desiredCapabilities.setCapability("platformVersion", "8.1.0");
        desiredCapabilities.setCapability("deviceName", "vivo Y85A");
        desiredCapabilities.setCapability("app", "com.pingan.gamehall");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("udid", "7bff6865");
        desiredCapabilities.setCapability("appActivity", "com.pingan.gamehall.MainActivity");
        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
        }catch (MalformedURLException a){
            System.out.println(a);
        }
        try{
            driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println("页面未加载完成");
        }

    }

    public static AndroidDriver<AndroidElement> getDriver(){
        return driver;
    }
}
