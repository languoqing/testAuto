package pages;

import driver.Driver;
import org.openqa.selenium.By;

/*
 启动app主页：1768
 */
public class MainPage {

    //搜索按钮
    By searchBtn = By.className("//*[@class='soso']");
    public static MainPage startApp(){
        Driver.setDirver();
        return new MainPage();
    }

    public SearchGamePage goSearchGamePage(){
        Driver.getDriver().findElement(searchBtn).click();
        return new SearchGamePage();
    }
}
