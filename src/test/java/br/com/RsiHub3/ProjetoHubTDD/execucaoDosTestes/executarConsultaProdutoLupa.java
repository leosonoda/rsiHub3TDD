package br.com.RsiHub3.ProjetoHubTDD.execucaoDosTestes;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoHubTDD.comum.navegador;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaBusca;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaInicial;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginasProdutos;


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
		
		
			paginaInicial novaConsulta = new paginaInicial(driver);
			
			novaConsulta.pesquisaProdutoLupa(palavraBuscaP);
	
			paginaBusca novaBusca = new paginaBusca(driver);
			
			novaBusca.clicarProdutoPaginaBusca(produtoP);
			
			//Validação
			
			paginasProdutos novaValid = new paginasProdutos(driver);
			
			novaValid.validarTituloProduto(produtoP);
	
	}
	
		@Test
		
		public void consultarProdutoLupaInexistente(){
			
				//Exemplos: teclado, playstation, Laptop
				String palavraBuscaN = "monitor";
			
				paginaInicial novaConsulta = new paginaInicial(driver);
				
				novaConsulta.pesquisaProdutoLupa(palavraBuscaN);
				
				//Validacao
								
				paginaBusca novaValid = new paginaBusca(driver);
				
				novaValid.validarBuscarProdutoInexistente();
		

	}
	
	
	@AfterMethod
	
		public void fim() {
		
		navegador.fecharChrome(driver);
		
		
	}	
	
}
