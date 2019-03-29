package pages;


import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import util.Fuctions;
import util.YamlConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 充值页面
 */
public class RechargePage {

    //支付方式信息
    By tCoin = By.id("gameScore");
    By diamond = By.id("account_sel");
    By caijin = By.id("caijin");
    By aliPay = By.id("alipay_sel");
    By weixinPay = By.id("weixin_sel");
    By weixinPublic = By.id("weixin_public");//微信公众号
    By yinlianPay = By.id("yibao_sel");
    By jingdongPay = By.id("jingdong");
    By wltPay = By.id("wlt_sel");
    By qqPay = By.id("qpay");
    By yqbPay = By.id("yqb_sel");
    By mobilePay = By.id("sms_sel");//话费
    By ydjf = By.id("yidongscore_sel"); //移动积分
    By hys = By.id("jiankangjin");//平安好医生
    By zzb = By.id("zzb_sel"); //增值包
    By sft = By.id("payment_point");//盛付通

    By cofirm = By.id("doConfirm");
    By payStatu = By.xpath("//*[@text='支付成功！']");
    By aliPage = By.id("com.ali.user.mobile.security.ui:id/titleWholeLayout");//支付宝页面
    By statusConfirm = By.xpath("//*[@text='确 认']"); //支付成功确认按钮

    //订单信息
    public ArrayList getOrderInfo(){
        String userInfo = Driver.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.widget.ListView[1]/android.view.View[1]")).getText();
        String prdInfo = Driver.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.widget.ListView[1]/android.view.View[2]")).getText();
        String amountInfo = Driver.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.widget.ListView[1]/android.view.View[3]")).getText();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(userInfo);
        arrayList.add(prdInfo);
        arrayList.add(amountInfo);
        return arrayList;
    }

    /**
     * 支付方式校验，欢乐值抵扣，钻石支付，彩金，支付宝，微信必校验显示
     */
    public boolean isTrueRechargeOptions(){
        System.out.println("1:"+Fuctions.isElementExist(tCoin));
        System.out.println("2:"+Fuctions.isElementExist(diamond));
        System.out.println("3:"+Fuctions.isElementExist(caijin));
        System.out.println("4:"+Fuctions.isElementExist(aliPay));
        System.out.println("5:"+Fuctions.isElementExist(weixinPay));
        System.out.println("6:"+Fuctions.isElementExist(yinlianPay));
        System.out.println("7:"+Fuctions.isElementExist(wltPay));
        System.out.println("8:"+Fuctions.isElementExist(qqPay));
        System.out.println("9:"+Fuctions.isElementExist(yqbPay));
        System.out.println("10:"+Fuctions.isElementExist(mobilePay));
        System.out.println("11:"+Fuctions.isElementExist(yqbPay));
        System.out.println("12:"+Fuctions.isElementExist(ydjf));
        System.out.println("13:"+Fuctions.isElementExist(hys));
        System.out.println("14:"+Fuctions.isElementExist(zzb));
        System.out.println("15:"+Fuctions.isElementExist(sft));
        if(Fuctions.isElementExist(tCoin) &&
            Fuctions.isElementExist(diamond) &&
            Fuctions.isElementExist(caijin) &&
            Fuctions.isElementExist(aliPay) &&
            Fuctions.isElementExist(weixinPay) &&
            Fuctions.isElementExist(weixinPublic) &&
            Fuctions.isElementExist(yinlianPay) &&
            Fuctions.isElementExist(jingdongPay) &&
            Fuctions.isElementExist(wltPay) &&
            Fuctions.isElementExist(qqPay) &&
            Fuctions.isElementExist(yqbPay) &&
            Fuctions.isElementExist(mobilePay) &&
            Fuctions.isElementExist(ydjf) &&
            Fuctions.isElementExist(hys) &&
            Fuctions.isElementExist(zzb) &&
            Fuctions.isElementExist(sft)){
            return true;
        }else {return false;}

    }

    /**
     * 去充值 校验欢乐值，钻石，彩金，支付宝，微信
     * @param pay :tDian ; diamond;caiji;alipay;weixin
     */
    public boolean goRecharge(String pay){
        switch (pay){
            case "tDian":
                Driver.getDriver().findElement(tCoin).click();
                Driver.getDriver().findElement(cofirm).click();
                Fuctions.waitShowElement(2);
                return Fuctions.isElementExist(payStatu);
            case "diamond":
                Driver.getDriver().findElement(diamond).click();
                Driver.getDriver().findElement(cofirm).click();
                Fuctions.waitShowElement(2);
                return Fuctions.isElementExist(payStatu);
            case "caiji":
                Driver.getDriver().findElement(caijin).click();
                Driver.getDriver().findElement(cofirm).click();
                Fuctions.waitShowElement(2);
                return Fuctions.isElementExist(payStatu);
            case "alipay": //页面没有支付按钮说明已跳转
                Driver.getDriver().findElement(aliPay).click();
                Driver.getDriver().findElement(cofirm).click();
                Fuctions.waitShowElement(2);
                return Fuctions.isElementExist(cofirm);
            case "weixin"://页面没有支付按钮说明已跳转
                Driver.getDriver().findElement(weixinPay).click();
                Driver.getDriver().findElement(cofirm).click();
                Fuctions.waitShowElement(2);
                return Fuctions.isElementExist(cofirm);
        }
        System.out.println("是用什么支付方式");
        return false;
    }

    public void goBackGamePage(){

        Driver.getDriver().findElement(statusConfirm).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
