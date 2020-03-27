package br.com.RsiHub3.ProjetoHubTDD.pagesObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class menuLogin {
	
		private WebDriver driver;
		
		public menuLogin(WebDriver driver) {
			
			this.driver = driver;

	}
		
		public void preencherUsername(String usuario) {
			WebElement user = driver.findElement(By.name("username"));
			
			user.sendKeys(usuario);
			
		}
		
		public void preencherPassword(String senha) {
			WebElement pass = driver.findElement(By.name("password"));
			
			pass.sendKeys(senha);
			
		}
		
		public void clicarBotaoLogar() {
			WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			espera.until(ExpectedConditions.elementToBeClickable(By.id("sign_in_btnundefined")));
			
			WebElement botaoLogar = driver.findElement(By.id("sign_in_btnundefined"));
			
			botaoLogar.click();
			
		}
		
		public void acessarMenuCreate() {
			
			WebElement botao = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
			
			botao.click();
			
			botao.click();
			
		}
		
		public String obterMensagemErro() {
		
			WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			espera.until(ExpectedConditions.textToBePresentInElementLocated(By.id("signInResultMessage"), "Incorrect user name or password."));
	
			WebElement validacao = driver.findElement(By.id("signInResultMessage"));
		    
			return validacao.getText();
	
	}
		
}
