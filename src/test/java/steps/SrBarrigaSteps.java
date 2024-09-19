package steps;

import config.baseclass.BaseSteps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.LoginPage;
import pages.NotificationMessagePage;

public class SrBarrigaSteps extends BaseSteps {
    NotificationMessagePage notfy = new NotificationMessagePage();
    LoginPage pLogin = new LoginPage();

    @Dado("que estou no site do SrBarriga")
    public void que_estou_no_site_do_sr_barriga() {
        pLogin.abrir();
        baterRetrato();
    }

    @Quando("preencher email {string} e senha {string}")
    public void preencher_email_e_senha(String login, String senha) {
        pLogin.preencherEmail(login);
        pLogin.preencherSenha(senha);
        baterRetrato();
    }

    @E("clicar em Entrar")
    public void clicar_em_entrar() {
        pLogin.clickEntrar();
    }

    @Entao("o sistema mostra a notificacao de sucesso {string}")
    public void o_sistema_mostra_a_notificacao(String resultadoEsperado) throws InterruptedException {
        String notificacao = notfy.getMsgSuccess();
        Assert.assertEquals(resultadoEsperado, notificacao);
        baterRetrato();
    }

    @Entao("o sistema mostra a primeira notificacao de erro {string}")
    public void o_sistema_mostra_a_primeira_notificacao_de_erro(String resultadoEsperado) throws InterruptedException {
        String notificacao = notfy.getMsgErro1();
        Assert.assertEquals(resultadoEsperado, notificacao);
        baterRetrato();
    }

    @E("o sistema mostra a segunda notificacao de erro {string}")
    public void o_sistema_mostra_a_segunda_notificacao_de_erro(String resultadoEsperado) throws InterruptedException {
        String notificacao = notfy.getMsgErro2();
        Assert.assertEquals(resultadoEsperado, notificacao);
    }
}
