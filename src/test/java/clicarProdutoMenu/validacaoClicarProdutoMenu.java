package clicarProdutoMenu;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class validacaoClicarProdutoMenu {
	
	private WebDriver driver;
	
	public validacaoClicarProdutoMenu(WebDriver driver) {
		this.driver = driver;
	}

	
	
	public void validarPositivo(String produto) {

		WebElement validacaoP = driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']"));
	     
		String produtoP = produto;
		
        Assert.assertEquals(produtoP, validacaoP.getText());
		
		
	}
	
	
	public void validarNegativo() {
		
		
		
	}
	
		
	
}
