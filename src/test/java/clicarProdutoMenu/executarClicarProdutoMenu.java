package clicarProdutoMenu;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Comum.navegador;

public class executarClicarProdutoMenu {
			
		private WebDriver driver;
			
		@BeforeMethod
		
		public void execut() {
			
			driver = navegador.abrirChrome();
		}

		@Test
		
		public void clicarProdutoMenu() {
			
			pesquisarNovoProduto pesquisaNova = new pesquisarNovoProduto(driver);
			
			pesquisaNova.buscar();
			
			String produto = "BEATS STUDIO 2 OVER-EAR MATTE BLACK HEADPHONES";
			
			validacaoClicarProdutoMenu validaPosit = new validacaoClicarProdutoMenu(driver);
			
			validaPosit.validarPositivo(produto);
			
				
		
		}
		
			@Test
			
			public void clicarProdutoMenuInexistente() {
		
		pesquisarNovoProduto novaBusca = new pesquisarNovoProduto(driver);
		
		novaBusca.buscarNegat("Celular");
		
		assertTrue(new pesquisarNovoProduto(driver).buscarNegat("Celular"));
			

		}
		
		
		 @AfterMethod
		
			public void fim() {
			
			navegador.fecharChrome(driver);
			
			
		}	
		
	


}
