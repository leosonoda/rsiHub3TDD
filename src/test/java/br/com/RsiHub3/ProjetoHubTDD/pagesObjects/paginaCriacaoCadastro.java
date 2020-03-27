package br.com.RsiHub3.ProjetoHubTDD.pagesObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class paginaCriacaoCadastro {
		
		private WebDriver driver;
		
		public paginaCriacaoCadastro(WebDriver driver) {
			
				this.driver = driver;

	}
		
		public void preencherUsuario(String usuario) {
			WebElement createUsername = driver.findElement(By.name("usernameRegisterPage"));
			
			createUsername.sendKeys(usuario);	
		}
	
		public void preencherEmail(String email) {
			WebElement createEmail = driver.findElement(By.name("emailRegisterPage"));
			
			createEmail.sendKeys(email);	
		}
		
		public void preencherSenha(String senha) {

			WebElement createPassword = driver.findElement(By.name("passwordRegisterPage"));
			
			createPassword.sendKeys(senha);
		}
		
		
		public void preencherConfirSenha(String senhaConfirm) {
			WebElement createConfirmPassword = driver.findElement(By.name("confirm_passwordRegisterPage"));
			
			createConfirmPassword.sendKeys(senhaConfirm);	
		}
		
		public void preencherNome(String nome) {
			WebElement createFirstName = driver.findElement(By.name("first_nameRegisterPage"));
			
			createFirstName.sendKeys(nome);
		}
		
		public void preencherSobrenome(String sobrenome) {
			WebElement createLastName = driver.findElement(By.name("last_nameRegisterPage"));
			
			createLastName.sendKeys(sobrenome);
		}
		
		public void preencherTelefone(String telefone) {
			
			WebElement createPhone = driver.findElement(By.name("phone_numberRegisterPage"));
			
			createPhone.sendKeys(telefone);
		}
		
		public void preencherPais(String pais) {
			
			Select oSelect = new Select(driver.findElement(By.name("countryListboxRegisterPage")));

			oSelect.selectByVisibleText(pais);	
		}

		public void preencherCidade(String cidade) {
			WebElement createCity = driver.findElement(By.name("cityRegisterPage"));
			
			createCity.sendKeys(cidade);	
		}
		
		public void preencherEndereco(String endereco) {
			WebElement createAdress = driver.findElement(By.name("addressRegisterPage"));
			
			createAdress.sendKeys(endereco);
		}
		
		public void preencherEstado(String estado) {
			WebElement createState = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
			
			createState.sendKeys(estado);	
		}
		
		public void preencherCodPostal(String codPostal) {
		WebElement createPostal = driver.findElement(By.name("postal_codeRegisterPage"));
	
			createPostal.sendKeys(codPostal);		
		}
		
		public void aceitarTermos() {
			WebElement createAgreeCheck = driver.findElement(By.name("i_agree"));
			
			createAgreeCheck.click();	
		}
			
		public void clicarBotaoRegistro() {
			
			WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			espera.until(ExpectedConditions.elementToBeClickable(By.id("register_btnundefined")));
			
			WebElement botaoRegistro = driver.findElement(By.id("register_btnundefined"));
			
			botaoRegistro.click();
		}
		
		
		public String mensagemErroUser() {
			
			WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			espera.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]"), "User name already exists"));
			
			WebElement validacao = driver.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]"));
			
			return validacao.getText();
		}
		
		
	
}
