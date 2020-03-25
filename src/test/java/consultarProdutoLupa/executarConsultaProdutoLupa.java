package consultarProdutoLupa;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Comum.navegador;


public class executarConsultaProdutoLupa {
	
	private WebDriver driver;
		
	@BeforeMethod
	
	public void execut() {
		
		driver = navegador.abrirChrome();
	}

	@Test
	
	public void consultarProdutoLupa() {
		
			//Exemplos: Mouse, Headphone, Laptop
			String palavraBuscaP = "mouse";
	
			//Exemplos: HP Z4000 Wireless Mouse, 
			String produtoP = "HP Z4000 Wireless Mouse";
		
		
			pesquisarProduto novaConsulta = new pesquisarProduto(driver);
			
			novaConsulta.pesquisa(palavraBuscaP);
	
			clicarNoProduto novaBusca = new clicarNoProduto(driver);
			
			novaBusca.buscar(produtoP);
			
			//Validação
			
			validacaoConsultarProdutoLupa novaValid = new validacaoConsultarProdutoLupa(driver);
			
			novaValid.validarPositivo(produtoP);
	
	}
	
		@Test
		
		public void consultarProdutoLupaInexistente() {
			
				//Exemplos: teclado, playstation, Laptop
				String palavraBuscaN = "monitor";
			
				pesquisarProduto novaConsulta = new pesquisarProduto(driver);
				
				novaConsulta.pesquisa(palavraBuscaN);
				
				//Validacao
				
				validacaoConsultarProdutoLupa novaValid = new validacaoConsultarProdutoLupa(driver);
				
				novaValid.validarNegativo();
		

	}
	
	
	@AfterMethod
	
		public void fim() {
		
		navegador.fecharChrome(driver);
		
		
	}	
	
}
