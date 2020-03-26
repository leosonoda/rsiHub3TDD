package br.com.RsiHub3.ProjetoHubTDD.pagesObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class paginaBusca {
	
		private WebDriver driver;
		
		public paginaBusca(WebDriver driver) {
			
				this.driver = driver;

	}

	public void clicarProdutoPaginaBusca(String nomeProduto) {
			
		driver.findElement(By.linkText(nomeProduto)).click();
			
			
	}
	
	public void validarBuscarProdutoInexistente() {
			
			WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			espera.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='ng-binding']"), "No results for \"monitor\""));
			
			WebElement validacao = driver.findElement(By.xpath("//span[@class='ng-binding']"));
			
	        String esperado = "No results for \"monitor\"";
	        
	        Assert.assertEquals(esperado, validacao.getText());
	        
	}
	
	}
