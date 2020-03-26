package br.com.RsiHub3.ProjetoHubTDD.execucaoDosTestes;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoHubTDD.comum.navegador;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.menuLogin;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaInicial;


public class executarLogarConta {
	
	private WebDriver driver;
	
	@BeforeMethod
	
	public void execut() {
		
		driver = navegador.abrirChrome();
	}

	@Test
	
	public void logarComSucesso() {
		
		paginaInicial acesso = new paginaInicial(driver);
		
		acesso.acessarMenuLogin();
		
		menuLogin loginConta = new menuLogin(driver);
		
		loginConta.novoLogin("jorge_jorge", "123456Senha");
		
		//Validação
		menuLogin novaValid = new menuLogin(driver);
		
		novaValid.validarLoginSucesso();
		
	}
	
		@Test
		
		public void loginIncorreto(){
			
			paginaInicial acesso = new paginaInicial(driver);
			
			acesso.acessarMenuLogin();
			
			menuLogin loginConta = new menuLogin(driver);
			
			loginConta.novoLogin("jorge_50", "123456Senha");
			

			//Validação
			
			menuLogin novaValid = new menuLogin(driver);
			
			novaValid.validarLoginSemSucesso();
			
	}
		
	
	@AfterMethod
	
		public void fim() {
		
		navegador.fecharChrome(driver);
		
	}	
	
}


