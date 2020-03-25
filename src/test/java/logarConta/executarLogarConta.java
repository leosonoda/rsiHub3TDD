package logarConta;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Comum.navegador;


public class executarLogarConta {
	
	private WebDriver driver;
	
	@BeforeMethod
	
	public void execut() {
		
		driver = navegador.abrirChrome();
	}

	@Test
	
	public void logarComSucesso() {
		
		inclusaoDadosLogin acessoTeste = new inclusaoDadosLogin(driver);
		
		acessoTeste.novoLogin("jorge_jorge", "123456Senha");
		
		//Validação
		validacaoLogarConta novaValid = new validacaoLogarConta(driver);
		
		novaValid.validarPositivo();
		
		
		
	}
	
		@Test
		
		public void loginIncorreto(){
			
			
			inclusaoDadosLogin acessoTeste = new inclusaoDadosLogin(driver);
			
			acessoTeste.novoLogin("jorge_20", "123456Senha");
			

			//Validação
			
			validacaoLogarConta novaValid = new validacaoLogarConta(driver);
			
			novaValid.validarNegativo();
			
			
	}
		
	
	@AfterMethod
	
		public void fim() {
		
		navegador.fecharChrome(driver);
		
	}	
	
}


