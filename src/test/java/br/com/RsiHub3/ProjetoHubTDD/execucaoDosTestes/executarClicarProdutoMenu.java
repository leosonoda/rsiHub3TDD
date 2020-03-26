package br.com.RsiHub3.ProjetoHubTDD.execucaoDosTestes;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoHubTDD.comum.navegador;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaInicial;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginasProdutos;

public class executarClicarProdutoMenu {
			
		private WebDriver driver;
			
		@BeforeMethod
		
		public void execut() {
			
			driver = navegador.abrirChrome();
		}

		@Test
		
		public void clicarProdutoMenuSucesso() {
			
			paginaInicial pesquisaNova = new paginaInicial(driver);
			
			pesquisaNova.buscarProdutoMenu();
			
			String produto = "BEATS STUDIO 2 OVER-EAR MATTE BLACK HEADPHONES";
			
			paginasProdutos validaPosit = new paginasProdutos(driver);
			
			validaPosit.validarBuscarProdutoMenu(produto);
			
		}
		
			@Test
			
			public void clicarProdutoMenuInexistente() {
				
			paginaInicial pesquisaNova = new paginaInicial(driver);
			
			pesquisaNova.buscaProdutoMenuNegativo();
			
		}
		
		
		 @AfterMethod
		
			public void fim() {
			
			navegador.fecharChrome(driver);
			
		}	
}
