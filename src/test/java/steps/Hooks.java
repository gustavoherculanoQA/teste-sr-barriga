package steps;

import config.baseclass.BaseSteps;
import io.cucumber.java.AfterAll;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends BaseSteps {

    @BeforeAll
    public static void antesDeTudo() {
        abrirNavegador();
    }

    @AfterAll
    public static void depoisDeTudo() {
        fecharNavegador();
    }

    @Before
    public void antesDoTeste(Scenario _scenario) {
        cenario = _scenario;
    }

    @After
    public void depoisDoTeste() {
        if (cenario.isFailed())
            baterRetrato();
    }
}
