package logarConta;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class inclusaoDadosLogin {
	
	private WebDriver driver;
	
	public inclusaoDadosLogin(WebDriver driver) {
		
		this.driver = driver;	
	
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
	

}
