package clicarProdutoMenu;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class clicarProdutoMenuCompleto {
	
	
	@Test
	public void test() {
		
		String exePath = "src/test/resources/ChromeDriver/chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.advantageonlineshopping.com/#/");
				
		driver.manage().window().maximize();
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	 

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("special_offer_items")));
		
		
		
		WebElement paginaHeadphone = driver.findElement(By.id("headphonesTxt"));
		
		paginaHeadphone.click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Beats Studio 2 Over-Ear Matte Black Headphones')]")).click();
		
		
		
		//Validação
		WebElement validacaoP = driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']"));
	     
		String produtoP = "BEATS STUDIO 2 OVER-EAR MATTE BLACK HEADPHONES";
		
        Assert.assertEquals(produtoP, validacaoP.getText());
		
		driver.close();
		
	
	}

}
