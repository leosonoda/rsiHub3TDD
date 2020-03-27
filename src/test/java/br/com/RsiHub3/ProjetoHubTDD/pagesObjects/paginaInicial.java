package br.com.RsiHub3.ProjetoHubTDD.pagesObjects;

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
	
	public void clicarNaCategoria(String categoria) {

		driver.findElement(By.id(categoria)).click();
		
	}
	
	
		public List<String> listarCategoriasTela() {
			
			List<WebElement> categorias = driver.findElements(By.xpath("//span[@class='shop_now roboto-bold ng-binding']"));
			
			List<String> lista = new ArrayList<String>();
			
			String var;
						
			for (WebElement webElement : categorias) {
				var = webElement.getText();
				lista.add(var);
			}
			
			return lista;
			
		}
		
		public void acessarLupa() {
		
			WebElement lupa = driver.findElement(By.id("menuSearch"));
			
			lupa.click();
			
		}
		
		public void pesquisarLupa(String palavraBusca) {
			
			WebElement caixaBusca = driver.findElement(By.id("autoComplete"));
			
			caixaBusca.sendKeys(palavraBusca);
			
			caixaBusca.sendKeys(Keys.ENTER);
			
		}
		
		
		public void acessarMenuLogin() {
			
			WebElement menuLogin = driver.findElement(By.id("menuUser"));
			
			menuLogin.click();
			
			WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInResultMessage")));
			
			WebElement campoPassword = driver.findElement(By.name("password"));
			
			campoPassword.click();
			
		}
		
		
		public String obterUserLogado() {
			
			WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));    

		        return validacao.getText();
					
			}
		
}