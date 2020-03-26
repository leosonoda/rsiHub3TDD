package br.com.RsiHub3.ProjetoHubTDD.execucaoDosTestes;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoHubTDD.comum.navegador;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.menuLogin;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaCriacaoCadastro;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaInicial;

public class executarCriarNovoCadastro {
	
	private WebDriver driver;
	
	String usuario = "jorgines"; 
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
			
			paginaInicial acessoMenu = new paginaInicial(driver);
	
			acessoMenu.acessarMenuLogin();
			
			menuLogin novoCadastro = new menuLogin(driver); 
		
			novoCadastro.acessarMenuCreate();
			
			paginaCriacaoCadastro dadosLeonardo = new paginaCriacaoCadastro(driver);
			
			dadosLeonardo.novosDados(usuario, email, senha, senhaCofirm, nome, sobrenome, telefone, 
					pais, cidade, endereco, estado, codPostal);
			
		
			//Validação
			
			paginaCriacaoCadastro novaValid = new paginaCriacaoCadastro(driver);
			
			novaValid.validarCadastroSucesso();
	
	}
	
	@Test
	
	public void cadastroRepetido() {
		
		String usuarioNegativo = "jorge_jorge"; 
		
		paginaInicial acessoMenu = new paginaInicial(driver);
		
		acessoMenu.acessarMenuLogin();
		
		menuLogin novoCadastro = new menuLogin(driver); 
	
		novoCadastro.acessarMenuCreate();
		
		paginaCriacaoCadastro dadosLeonardo = new paginaCriacaoCadastro(driver);
		
		dadosLeonardo.novosDados(usuarioNegativo, email, senha, senhaCofirm, nome, sobrenome, telefone, 
				pais, cidade, endereco, estado, codPostal);
		
		
		//Validação
		
		paginaCriacaoCadastro novaValid = new paginaCriacaoCadastro(driver);
		
		novaValid.validarCadastroNegativo();
		
}
	
	@AfterMethod
	
	public void fim() {
	
	navegador.fecharChrome(driver);
	
	
	}		

}
