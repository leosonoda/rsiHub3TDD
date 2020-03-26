package br.com.RsiHub3.ProjetoHubTDD.pagesObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class menuLogin {
	
		private WebDriver driver;
		
		public menuLogin(WebDriver driver) {
			
			this.driver = driver;

	}

		
	public void acessarMenuCreate() {
			
			
			WebElement campoPassword = driver.findElement(By.name("password"));
			
			campoPassword.click();
			
			WebElement botao = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
			
			botao.click();
			
			botao.click();
			
		}
		
	public void novoLogin(String usuario, String senha) {
			
			WebElement menuUsuario = driver.findElement(By.id("menuUser"));
			
			menuUsuario.click();
			
			WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInResultMessage")));
			
			WebElement user = driver.findElement(By.name("username"));
			
			user.sendKeys(usuario);
			
			WebElement password = driver.findElement(By.name("password"));
			
			password.sendKeys(senha);
			
			
			espera.until(ExpectedConditions.elementToBeClickable(By.id("sign_in_btnundefined")));
			
			WebElement botaoLogar = driver.findElement(By.id("sign_in_btnundefined"));
			
			botaoLogar.click();
			
			
		}
		
	
	public void validarLoginSucesso() {
		
	WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
		
		System.out.println(validacao.getText());
        
        String esperado = "jorge_jorge" ;
       
       Assert.assertEquals(esperado, validacao.getText());
        
			
	}
	
	
	public void validarLoginSemSucesso() {
		
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		espera.until(ExpectedConditions.textToBePresentInElementLocated(By.id("signInResultMessage"), "Incorrect user name or password."));

		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
	    
        String esperado = "Incorrect user name or password." ;
       
        Assert.assertEquals(esperado, validacao.getText());
		
		
	}
	
		

}
