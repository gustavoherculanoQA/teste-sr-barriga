package config.baseclass;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseSteps {
    public static WebDriver navegador;
    public static Scenario cenario;

    public static void abrirNavegador() {
        navegador = Navegador.getChrome();
        navegador.manage().window().maximize();
    }

    public static void fecharNavegador() {
        navegador.quit();
        navegador = null;
    }

    public static void baterRetrato() {
        try {
            String dataHora = (new SimpleDateFormat("yyyy-MM-dd_-_HH-mm-ss-SSS")).format(new Date());
            byte[] screenshot = ((TakesScreenshot) BaseSteps.navegador).getScreenshotAs(OutputType.BYTES);
            cenario.attach(screenshot, "image/png", dataHora + "_screenshot.png");
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }
}
