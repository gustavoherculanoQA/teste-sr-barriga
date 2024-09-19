package pages;

import config.baseclass.BasePage;
import org.openqa.selenium.By;

public class NotificationMessagePage extends BasePage {
    private By msgSuccess = By.cssSelector("div.alert.alert-success");
    private By msgErro1 = By.cssSelector("div.alert.alert-danger:nth-child(2)");
    private By msgErro2 = By.cssSelector("div.alert.alert-danger:nth-child(3)");
    private By msgErro3 = By.cssSelector("div.alert.alert-success");

    public String getMsgSuccess() {
        return driver.findElement(msgSuccess).getText();
    }

    public String getMsgErro1() {
        return driver.findElement(msgErro1).getText();
    }

    public String getMsgErro2() {
        return driver.findElement(msgErro2).getText();
    }
}
