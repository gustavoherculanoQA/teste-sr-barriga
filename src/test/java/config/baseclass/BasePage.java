package config.baseclass;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = BaseSteps.navegador;
    }
}
