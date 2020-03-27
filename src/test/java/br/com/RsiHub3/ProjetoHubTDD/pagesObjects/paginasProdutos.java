package br.com.RsiHub3.ProjetoHubTDD.pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class paginasProdutos {

		private WebDriver driver;
		
		public paginasProdutos(WebDriver driver) {
			
				this.driver = driver;

	}

		public WebElement pegarTituloProduto() {
				
			WebElement nomeProduto = driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']"));
			     		
			return nomeProduto;
		
	}
	
}
