package pages;

import Projects.ActionsBot;
import Projects.PageBase;
import Projects.testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class HomePage extends testBase {

    public  By loginNav = By.xpath("//*[@text='Login']");


//    public HomePage(WebDriver driver, ActionsBot bot, Wait<WebDriver> wait) {
//        super(driver, bot, wait);
//    }
//    public static WebDriver driver;

    public  void clickLogin(){
        driver.findElement(loginNav).click();
    }


}
