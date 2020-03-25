package consultarProdutoLupa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class pesquisarProduto {
	
	private WebDriver driver;
	
	public pesquisarProduto(WebDriver driver) {
		
		this.driver = driver;	
		
		
	}
	
	public void pesquisa(String produto) {
		
		driver.findElement(By.id("menuSearch")).click();
		
		driver.findElement(By.id("autoComplete")).sendKeys(produto);

		driver.findElement(By.id("autoComplete")).sendKeys(Keys.ENTER);

		
	}

}
