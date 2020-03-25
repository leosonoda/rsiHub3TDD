package clicarProdutoMenu;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class pesquisarNovoProduto {
	
	private WebDriver driver;
	
	public pesquisarNovoProduto(WebDriver driver) {
		
			this.driver = driver;
			
	}
	
	
	public void buscar() {

		WebElement paginaHeadphone = driver.findElement(By.id("headphonesTxt"));
		
		paginaHeadphone.click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Beats Studio 2 Over-Ear Matte Black Headphones')]")).click();
		
		
	}
	
	public boolean buscarNegat(String produto) {

		List<WebElement> categorias = driver.findElements(By.xpath("//span[@class='shop_now roboto-bold ng-binding']"));
		
		for (WebElement webElement : categorias) {
			if(webElement.getText().contains(produto));{
				return true;
			}		
		}
		return false;
	
	}
	
	public List
	
	
	
	
	
}
