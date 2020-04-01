package br.com.RsiHub3.ProjetoHubTDD.pagesObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class paginaBusca {
	
		private WebDriver driver;
		
		public paginaBusca(WebDriver driver) {
			
				this.driver = driver;

	}

		public void clicarProdutoPaginaBusca(String nomeProduto) {
				
			driver.findElement(By.linkText(nomeProduto)).click();
					
		}
	
		public String buscaInexistente() {
				
				WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(60));
				
				espera.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='ng-binding']"), "No results for \"monitor\""));
				
				WebElement validacao = driver.findElement(By.xpath("//span[@class='ng-binding']"));
				
				return validacao.getText();
		           
		}
		
}
