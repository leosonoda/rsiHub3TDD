package consultarProdutoLupa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class validacaoConsultarProdutoLupa {
	

	private WebDriver driver;
	
	public validacaoConsultarProdutoLupa(WebDriver driver) {
		
		this.driver = driver;	

		
	}
	
	
	public void validarPositivo(String produtoP) {
		
		WebElement validacaoP = driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']"));
	     
        Assert.assertEquals(produtoP.toUpperCase(), validacaoP.getText());
		
		
	}
	
	
	public void validarNegativo() {
		
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-binding']")));
		
		WebElement validacao = driver.findElement(By.xpath("//span[@class='ng-binding']"));
        
        String esperado = "No results for \"monitor\"";
        
        Assert.assertEquals(esperado, validacao.getText());
		
		
	}
	
	

}
