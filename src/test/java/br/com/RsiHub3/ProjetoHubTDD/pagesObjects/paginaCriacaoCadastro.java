package br.com.RsiHub3.ProjetoHubTDD.pagesObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class paginaCriacaoCadastro {
		
		private WebDriver driver;
		
		public paginaCriacaoCadastro(WebDriver driver) {
			
				this.driver = driver;

	}
		
		public void novosDados(String usuario, String email, String senha, String senhaConfirm, String nome, String sobrenome,
				String telefone, String pais, String cidade, String endereco, String estado, String codPostal) {
			
			WebElement createUsername = driver.findElement(By.name("usernameRegisterPage"));
			
			createUsername.sendKeys(usuario);
			
			WebElement createEmail = driver.findElement(By.name("emailRegisterPage"));
			
			createEmail.sendKeys(email);
			
			WebElement createPassword = driver.findElement(By.name("passwordRegisterPage"));
		
			createPassword.sendKeys(senha);
			
			WebElement createConfirmPassword = driver.findElement(By.name("confirm_passwordRegisterPage"));
			
			createConfirmPassword.sendKeys(senhaConfirm);
			
			WebElement createFirstName = driver.findElement(By.name("first_nameRegisterPage"));
			
			createFirstName.sendKeys(nome);
			
			WebElement createLastName = driver.findElement(By.name("last_nameRegisterPage"));
			
			createLastName.sendKeys(sobrenome);
			
			WebElement createPhone = driver.findElement(By.name("phone_numberRegisterPage"));
			
			createPhone.sendKeys(telefone);
			
			//
			Select oSelect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));

			oSelect.selectByVisibleText(pais);
			//
			
			WebElement createCity = driver.findElement(By.name("cityRegisterPage"));
			
			createCity.sendKeys(cidade);
			
			WebElement createAdress = driver.findElement(By.name("addressRegisterPage"));
			
			createAdress.sendKeys(endereco);
			
			WebElement createState = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
			
			createState.sendKeys(estado);
			
			WebElement createPostal = driver.findElement(By.name("postal_codeRegisterPage"));
			
			createPostal.sendKeys(codPostal);
			
			WebElement createAgreeCheck = driver.findElement(By.name("i_agree"));
			
			createAgreeCheck.click();
			
			WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			espera.until(ExpectedConditions.elementToBeClickable(By.id("register_btnundefined")));
			
			WebElement botaoRegistro = driver.findElement(By.id("register_btnundefined"));
			
			botaoRegistro.click();
			
			
			
		}
		
		
		public void validarCadastroSucesso() {
			
			WebElement validacao = driver.findElement(By.id("speakersTxt"));
			
			System.out.println(validacao.getText());
	        
	        String esperado = "SPEAKERS" ;
	       
	        Assert.assertEquals(esperado, validacao.getText());

				
		}
		
		
		public void validarCadastroNegativo() {
			
			
			WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			espera.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]"), "User name already exists"));
			
			WebElement validacao = driver.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]"));
			
			String esperado = "User name already exists";
			
			Assert.assertEquals(esperado, validacao.getText());
			

			
		}
		
		
	
}
