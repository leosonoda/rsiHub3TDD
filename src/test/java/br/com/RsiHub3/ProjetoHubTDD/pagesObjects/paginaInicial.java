package br.com.RsiHub3.ProjetoHubTDD.pagesObjects;

import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class paginaInicial {
	
	private WebDriver driver;
	
	public paginaInicial(WebDriver driver) {
		
			this.driver = driver;

}

	public void buscarProdutoMenu() {

		WebElement paginaHeadphone = driver.findElement(By.id("headphonesTxt"));
		
		paginaHeadphone.click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Beats Studio 2 Over-Ear Matte Black Headphones')]")).click();
	
		
	}
	
	
	public void buscaProdutoMenuNegativo() {
			
			
			List<WebElement> categorias = driver.findElements(By.xpath("//span[@class='shop_now roboto-bold ng-binding']"));
			
			List<String> lista = new ArrayList<String>();
			
			String var;
						
			for (WebElement webElement : categorias) {
				var = webElement.getText();
				lista.add(var);
			}
			
			String produto = "TECLADO";
			
			assertFalse(lista.contains(produto));
				
		}
	
		
		public void pesquisaProdutoLupa(String produto) {
			
			driver.findElement(By.id("menuSearch")).click();
			
			driver.findElement(By.id("autoComplete")).sendKeys(produto);
	
			driver.findElement(By.id("autoComplete")).sendKeys(Keys.ENTER);

		
	}
	
	
		public void acessarMenuLogin() {
					
					WebElement menuUsuario = driver.findElement(By.id("menuUser"));
					
					menuUsuario.click();
					
					WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
					
					espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInResultMessage")));
			
			
		}
		
	
	
	
}