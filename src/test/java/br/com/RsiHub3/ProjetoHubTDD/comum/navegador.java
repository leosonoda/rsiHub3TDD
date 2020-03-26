package br.com.RsiHub3.ProjetoHubTDD.comum;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class navegador {
	
	//private static WebDriver driver;
		
	
	public static WebDriver abrirChrome() {
		
		String exePath = "src/test/resources/ChromeDriver/chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.advantageonlineshopping.com/#/");
		
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("special_offer_items")));
		
		
		return driver;
			
	}
	
	
	public static void fecharChrome(WebDriver driver) {
		
		driver.close();
	
		
		
		
	}
	
	


}
