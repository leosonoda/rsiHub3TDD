package criarNovoCadastro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class validacaoCriarNovoCadastro {

private WebDriver driver;
	
	public validacaoCriarNovoCadastro(WebDriver driver) {
		
		this.driver = driver;	

		
	}
	
	
	public void validarPositivo() {
		
		WebElement validacao = driver.findElement(By.id("speakersTxt"));
		
		System.out.println(validacao.getText());
        
        String esperado = "SPEAKERS" ;
       
        Assert.assertEquals(esperado, validacao.getText());

			
	}
	
	
	public void validarNegativo() {
		
		
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		espera.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]"), "User name already exists"));
		
		WebElement validacao = driver.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]"));
		
		String esperado = "User name already exists";
		
		Assert.assertEquals(esperado, validacao.getText());
		

		
	}
	
	
	
}

