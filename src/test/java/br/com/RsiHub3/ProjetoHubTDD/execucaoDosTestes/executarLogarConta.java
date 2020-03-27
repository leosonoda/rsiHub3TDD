package br.com.RsiHub3.ProjetoHubTDD.execucaoDosTestes;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoHubTDD.comum.navegador;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.menuLogin;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaInicial;


public class executarLogarConta {
	
	private WebDriver driver;
	
	//Funcionando Não Mexer
	
	@BeforeMethod
	
	public void execut() {
		
		driver = navegador.abrirChrome();
	}

	@Test
	
	public void logarComSucesso() {
		
		paginaInicial novoAcesso = new paginaInicial(driver);
		
		novoAcesso.acessarMenuLogin();
		
		menuLogin novoMenuLogin = new menuLogin(driver);
		
		novoMenuLogin.preencherUsername("jorge_jorge");
		
		novoMenuLogin.preencherPassword("123456Senha");
		
		novoMenuLogin.clicarBotaoLogar();
		
		
		
		Assert.assertEquals(novoAcesso.obterUserLogado(), "jorge_jorge");
		
	}
	
		@Test
		
		public void loginIncorreto(){
			
			paginaInicial novoAcesso = new paginaInicial(driver);

			novoAcesso.acessarMenuLogin();
			
			menuLogin novoMenuLogin = new menuLogin(driver);
			
			novoMenuLogin.preencherUsername("jorge_errado");
			
			novoMenuLogin.preencherPassword("123456Senha");
			
			novoMenuLogin.clicarBotaoLogar();
			
			//Validação
	
			novoMenuLogin.obterMensagemErro();

			Assert.assertEquals("Incorrect user name or password.", novoMenuLogin.obterMensagemErro());
			
			
	}
		
	
	@AfterMethod
	
		public void fim() {
		
		navegador.fecharChrome(driver);
		
	}	
	
}


