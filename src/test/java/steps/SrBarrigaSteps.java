package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.NotificationMessagePage;

public class SrBarrigaSteps {

    WebDriver driver;
    ChromeOptions options;
    NotificationMessagePage notfy;
    LoginPage pLogin;

    @Before
    public void antesDeCenario() {
        options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-crash-reporter");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-in-process-stack-traces");
        options.addArguments("--disable-logging");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--log-level=3");
        options.addArguments("--output=/dev/null");
        driver = new ChromeDriver(options);
        notfy = new NotificationMessagePage(driver);
        pLogin = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @After
    public void depoisDeCenario() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
        driver = null;
    }

    @Dado("que estou no site do SrBarriga")
    public void que_estou_no_site_do_sr_barriga() {
        pLogin.abrir();
    }

    @Quando("preencher email {string} e senha {string}")
    public void preencher_email_e_senha(String login, String senha) {
        pLogin.preencherEmail(login);
        pLogin.preencherSenha(senha);

    }

    @E("clicar em Entrar")
    public void clicar_em_entrar() {
        pLogin.clickEntrar();
    }

    @Entao("o sistema mostra a notificacao de sucesso {string}")
    public void o_sistema_mostra_a_notificacao(String resultadoEsperado) throws InterruptedException {
        String notificacao = notfy.getMsgSuccess();
        Assert.assertEquals(resultadoEsperado, notificacao);
        Thread.sleep(2000);
    }

    @Entao("o sistema mostra a primeira notificacao de erro {string}")
    public void o_sistema_mostra_a_primeira_notificacao_de_erro(String resultadoEsperado) throws InterruptedException {
        String notificacao = notfy.getMsgErro1();
        Assert.assertEquals(resultadoEsperado, notificacao);
        Thread.sleep(2000);
    }

    @E("o sistema mostra a segunda notificacao de erro {string}")
    public void o_sistema_mostra_a_segunda_notificacao_de_erro(String resultadoEsperado) throws InterruptedException {
        String notificacao = notfy.getMsgErro2();
        Assert.assertEquals(resultadoEsperado, notificacao);
        Thread.sleep(2000);
    }
}
