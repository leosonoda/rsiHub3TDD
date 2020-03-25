package logarConta;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class validacaoLogarConta {
	
	private WebDriver driver;
	
	public validacaoLogarConta(WebDriver driver) {
		
		this.driver = driver;	

		
	}
	
	
	public void validarPositivo() {
		
	WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
		
		System.out.println(validacao.getText());
        
        String esperado = "jorge_jorge" ;
       
       Assert.assertEquals(esperado, validacao.getText());
        
			
	}
	
	
	public void validarNegativo() {
		
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		espera.until(ExpectedConditions.textToBePresentInElementLocated(By.id("signInResultMessage"), "Incorrect user name or password."));

		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
	    
        String esperado = "Incorrect user name or password." ;
       
        Assert.assertEquals(esperado, validacao.getText());
		
		
	}
	
	
	
}
