package criarNovoCadastro;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Comum.navegador;

public class executarCriarNovoCadastro {
	
	private WebDriver driver;
	
	String usuario = "jorge5"; 
	String email = "jorge.jorge@email.com.br";
	String senha = "123456Senha";
	String senhaCofirm = "123456Senha";
	String nome = "Jorge";
	String sobrenome = "Jorge";
	String telefone = "987654321";
	String pais = "Brazil";
	String cidade = "Osasco";
	String endereco = "Avenida Paulista, 1001";
	String estado = "São Paulo";
	String codPostal = "12345-987";

	@BeforeMethod
	
	public void execut() {
		
		driver = navegador.abrirChrome();
	
	}

	@Test
	
		public void cadatroSucesso() {
			
			acessarMenuCreate novoCadastro = new acessarMenuCreate(driver);
			
			novoCadastro.acessoMenu();
			
			insercaoDados dadosLeonardo = new insercaoDados(driver);
			
			dadosLeonardo.novosDados(usuario, email, senha, senhaCofirm, nome, sobrenome, telefone, 
					pais, cidade, endereco, estado, codPostal);
			
		
			//Validação
			
			validacaoCriarNovoCadastro novaValid = new validacaoCriarNovoCadastro(driver);
			
			novaValid.validarPositivo();
	
	}
	
	@Test
	
	public void cadastroRepetido() throws InterruptedException {
		
		String usuarioNegativo = "jorge_jorge"; 
		
		acessarMenuCreate novoCadastro = new acessarMenuCreate(driver);
		
		novoCadastro.acessoMenu();
		
		insercaoDados dadosLeonardo = new insercaoDados(driver);
		
		dadosLeonardo.novosDados(usuarioNegativo, email, senha, senhaCofirm, nome, sobrenome, telefone, 
				pais, cidade, endereco, estado, codPostal);
		
		
		//Validação
		
		validacaoCriarNovoCadastro novaValid = new validacaoCriarNovoCadastro(driver);
		
		novaValid.validarNegativo();
		
		
}
	
	
	
	@AfterMethod
	
	public void fim() {
	
	navegador.fecharChrome(driver);
	
	
	}		

}
