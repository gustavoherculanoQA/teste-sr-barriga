package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    String url = "https://seubarriga.wcaquino.me/login";
    By campoEmail = By.id("email");
    By campoSenha = By.id("senha");
    By btnEntrar = By.cssSelector("button.btn.btn-primary");

    public LoginPage(WebDriver navegador) {
        this.driver = navegador;
    }

    public void abrir() {
        driver.get(url);
    }

    public void preencherEmail(String email) {
        driver.findElement(campoEmail).sendKeys(email);
    }

    public void preencherSenha(String senha) {
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clickEntrar() {
        driver.findElement(btnEntrar).click();
    }
}
