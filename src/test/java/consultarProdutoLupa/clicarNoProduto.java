package consultarProdutoLupa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class clicarNoProduto {
	
	private WebDriver driver;
	
	public clicarNoProduto(WebDriver driver) {
		
		this.driver = driver;	

	}
	
	public void buscar (String nomeProduto) {
	
		driver.findElement(By.linkText(nomeProduto)).click();
		
	}

}
