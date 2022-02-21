package br.com.alura.leilao.acceptance.steps;

import org.junit.Assert;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginSteps {

	private Browser browser;
	private LoginPage loginPage;
	private LeiloesPage LeiloesPage;

	@Dado("o user válido")
	public void o_user_válido() {
	    browser = new Browser(); 
	    browser.seed();
	    loginPage = browser.getLoginPage();
	}

	@Quando("realizar login")
	public void realizar_login() {
	    LeiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
	}

	@Então("é redirecionado para a página de login")
	public void é_redirecionado_para_a_página_de_login() {
	   Assert.assertTrue(this.loginPage.estaNaPaginaDeLeiloes());
	   browser.clean();
	}

	@Dado("o user inválido")
	public void o_user_inválido() {
		browser = new Browser(); 
	    browser.seed();
	    loginPage = browser.getLoginPage();
	}

	@Quando("tenta se logar")
	public void tenta_se_logar() {
		LeiloesPage = this.loginPage.realizaLoginComo("fulano", "123");
	}

	@Então("continua na página de login")
	public void continua_na_página_de_login() {
		Assert.assertTrue(this.loginPage.estaNaPaginaDeLoginComErro());
		browser.clean();
	}
}
