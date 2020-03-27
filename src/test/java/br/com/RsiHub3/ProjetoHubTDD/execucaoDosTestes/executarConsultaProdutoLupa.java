package br.com.RsiHub3.ProjetoHubTDD.execucaoDosTestes;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoHubTDD.comum.navegador;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaBusca;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaInicial;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginasProdutos;


public class executarConsultaProdutoLupa {
	
	private WebDriver driver;
	
	//Teste funcionando, não mexer
		
	@BeforeMethod
	
	public void execut() {
		
		driver = navegador.abrirChrome();
	}

	@Test
	
	public void consultarProdutoLupa() {
		
			String palavraBuscaP = "mouse";
	 
			String produto = "HP Z4000 Wireless Mouse";
		
	
			paginaInicial novaConsulta = new paginaInicial(driver);	
						
			novaConsulta.acessarLupa();
			
			novaConsulta.pesquisarLupa(palavraBuscaP);
			
			paginaBusca novaBusca = new paginaBusca(driver);
			
			novaBusca.clicarProdutoPaginaBusca(produto);
				
			//Validação
			paginasProdutos novoProduto = new paginasProdutos(driver);
						
			Assert.assertEquals(produto.toUpperCase(), novoProduto.pegarTituloProduto().getText());
			
			
	}
	
		@Test
		
		public void consultarProdutoLupaInexistente(){
		
				String palavraBuscaN = "monitor";
				
				paginaInicial novaConsulta = new paginaInicial(driver);
				
				novaConsulta.acessarLupa();
				
				novaConsulta.pesquisarLupa(palavraBuscaN);
				
				paginaBusca novaBusca = new paginaBusca(driver);
				
				Assert.assertEquals("No results for \"monitor\"", novaBusca.buscaInexistente());
			

	}
	
	
	@AfterMethod
	
		public void fim() {
		
		navegador.fecharChrome(driver);
		
		
	}	
	
}
