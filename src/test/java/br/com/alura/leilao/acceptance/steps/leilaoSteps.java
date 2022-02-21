package br.com.alura.leilao.acceptance.steps;

import org.junit.Assert;

import br.com.alura.leilao.e2e.pages.AlterarLeilaoPage;
import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class leilaoSteps {
		
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;
	private NovoLeilaoPage novoLeilaoPage;
	private Browser browser;
	private AlterarLeilaoPage alterarLeilaoPage;
	
	@Dado("o user logado")
	public void o_user_logado() {
		this.browser = new Browser(); 
	    browser.seed();
	    loginPage = browser.getLoginPage();
	    leiloesPage = loginPage.realizaLoginComoFulano();
	}

	@Quando("acessa a pagina de novo leilao")
	public void acessa_a_pagina_de_novo_leilao() {
	    novoLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
	}
	
	@Quando("preenche o formulario com dados validos")
	public void preenche_o_formulario_com_dados_validos() {
	   this.leiloesPage = this.novoLeilaoPage.preencheForm("PC Novo", "1500", "01/11/2020");
	}
	
	@Então("volta para a pagina de leiloes")
	public void volta_para_a_pagina_de_leiloes() {
	    Assert.assertTrue(this.loginPage.estaNaPaginaDeLeiloes());
	}
	
	@Então("o novo leilao aparece na tabela")
	public void o_novo_leilao_aparece_na_tabela() {
	    this.leiloesPage.existe("PC Novo", "1500", "01/11/2020", "fulano");
	    this.browser.clean();
	}
	
	
	@Quando("clicar para editar um leilao")
	public void clicar_para_editar_um_leilao() {
		alterarLeilaoPage = this.leiloesPage.visitaPaginaParaAltearLeilao();
	}


	@Quando("edita o formulario")
	public void edita_o_formulario() {
	   this.alterarLeilaoPage.preencheForm("Teste", "2000", "21/02/2022");
	}
	
	@Então("o leilao alterado aparece na tela")
	public void o_leilao_alterado_aparece_na_tela() {
		this.leiloesPage.existe("Teste", "2000", "21/02/2022", "fulano");
	    this.browser.clean();
	}

}
