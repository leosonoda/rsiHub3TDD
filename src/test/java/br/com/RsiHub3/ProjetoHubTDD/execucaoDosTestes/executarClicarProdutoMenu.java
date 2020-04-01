package br.com.RsiHub3.ProjetoHubTDD.execucaoDosTestes;


import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoHubTDD.comum.navegador;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaBusca;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaInicial;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginasProdutos;

public class executarClicarProdutoMenu {
			
		private WebDriver driver;
		
		//Funcionando, Não mexer
		
		
		@BeforeMethod
		
		public void execut() {
			
			driver = navegador.abrirChrome();
		}

		@Test
		
		public void clicarProdutoMenuSucesso(){
			
			String produto = "Beats Studio 2 Over-Ear Matte Black Headphones";
						
			paginaInicial pesquisaNova = new paginaInicial(driver);
			
			pesquisaNova.clicarNaCategoria("headphonesTxt");
			
			paginaBusca novaBusca = new paginaBusca(driver);
			
			novaBusca.clicarProdutoPaginaBusca(produto);
			
			
			//Validação
			//String produto = "BEATS STUDIO 2 OVER-EAR MATTE BLACK HEADPHONES";
			
			paginasProdutos novoProduto = new paginasProdutos(driver);
			
	        Assert.assertEquals(produto.toUpperCase(), novoProduto.pegarTituloProduto().getText());
			
			
			
		}
		
			@Test
			
			public void clicarProdutoMenuInexistente() {
					
			paginaInicial pesquisaNova = new paginaInicial(driver);
						
			//Validação
			
			String produto = "TECLADO";
			
			assertFalse(pesquisaNova.listarCategoriasTela().contains(produto));
			
		}
		
		
		 @AfterMethod
		
			public void fim() {
			
			navegador.fecharChrome(driver);
			
		}	
}
