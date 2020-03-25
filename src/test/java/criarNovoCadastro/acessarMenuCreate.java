package criarNovoCadastro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class acessarMenuCreate {
	
	private WebDriver driver;
	
	public acessarMenuCreate(WebDriver driver) {
			
		this.driver = driver;
		
	}
	
	
	public void acessoMenu() {
		
		WebElement menuUsuario = driver.findElement(By.id("menuUser"));
		
		menuUsuario.click();
		
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInResultMessage")));
		
		
		WebElement campoPassword = driver.findElement(By.name("password"));
		
		campoPassword.click();
		
		WebElement botao = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
		
		botao.click();
		
		botao.click();

		
		
	}
	
		
			
}
