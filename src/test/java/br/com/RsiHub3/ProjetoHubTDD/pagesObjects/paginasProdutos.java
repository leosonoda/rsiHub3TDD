package br.com.RsiHub3.ProjetoHubTDD.pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class paginasProdutos {

		private WebDriver driver;
		
		public paginasProdutos(WebDriver driver) {
			
				this.driver = driver;

	}

	public void validarTituloProduto(String produtoP) {
			
		WebElement validacaoP = driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']"));
		     
	    Assert.assertEquals(produtoP.toUpperCase(), validacaoP.getText());
			
		}
		
		
	
	public void validarBuscarProdutoMenu(String produto) {

		WebElement validacaoP = driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']"));
	     
		String produtoP = produto;
		
        Assert.assertEquals(produtoP, validacaoP.getText());
		
		
	}
	
		

}
