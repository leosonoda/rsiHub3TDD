package br.com.RsiHub3.ProjetoHubTDD.execucaoDosTestes;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoHubTDD.comum.navegador;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.menuLogin;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaCriacaoCadastro;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaInicial;

public class executarCriarNovoCadastro {
	
	private WebDriver driver;
	
	String usuario = "jorgin13"; 
	String email = "jorge.jorge@email.com.br";
	String senha = "123456Senha";
	String senhaConfirm = "123456Senha";
	String nome = "Jorge";
	String sobrenome = "Jorge";
	String telefone = "987654321";
	String pais = "Brazil";
	String cidade = "Osasco";
	String endereco = "Avenida Paulista, 1001";
	String estado = "São Paulo";
	String codPostal = "12345-987";
	
	//Teste funcionando, não mexer

	@BeforeMethod
	
	public void execut() {
		
		driver = navegador.abrirChrome();
	
	}

	@Test
	
		public void cadatroSucesso() {
			
			paginaInicial novoAcesso = new paginaInicial(driver);
	
			novoAcesso.acessarMenuLogin();
			
			menuLogin novoCadastro = new menuLogin(driver);
			
			novoCadastro.acessarMenuCreate();
			
			paginaCriacaoCadastro dadosLeonardo = new paginaCriacaoCadastro(driver);
			
			dadosLeonardo.preencherUsuario(usuario);
			
			dadosLeonardo.preencherEmail(email);
			
			dadosLeonardo.preencherSenha(senha);
			
			dadosLeonardo.preencherConfirSenha(senhaConfirm);
			
			dadosLeonardo.preencherNome(nome);
			
			dadosLeonardo.preencherSobrenome(sobrenome);
			
			dadosLeonardo.preencherTelefone(telefone);
			
			dadosLeonardo.preencherPais(pais);
			
			dadosLeonardo.preencherCidade(cidade);
			
			dadosLeonardo.preencherEndereco(endereco);
			
			dadosLeonardo.preencherEstado(estado);
			
			dadosLeonardo.preencherCodPostal(codPostal);
			
			dadosLeonardo.aceitarTermos();
			
			dadosLeonardo.clicarBotaoRegistro();
			
			//Validação
			
			
		    Assert.assertEquals(usuario, novoAcesso.obterUserLogado());
	
	}
	
	@Test
	
	public void cadastroRepetido() {
		
			String usuarioNegativo = "jorge_jorge"; 
			
			
			
			paginaInicial novoAcesso = new paginaInicial(driver);
			
			novoAcesso.acessarMenuLogin();
			
			menuLogin novoCadastro = new menuLogin(driver);
			
			novoCadastro.acessarMenuCreate();
			
			paginaCriacaoCadastro dadosLeonardo = new paginaCriacaoCadastro(driver);
			
			dadosLeonardo.preencherUsuario(usuarioNegativo);
			
			dadosLeonardo.preencherEmail(email);
			
			dadosLeonardo.preencherSenha(senha);
			
			dadosLeonardo.preencherConfirSenha(senhaConfirm);
			
			dadosLeonardo.preencherNome(nome);
			
			dadosLeonardo.preencherSobrenome(sobrenome);
			
			dadosLeonardo.preencherTelefone(telefone);
			
			dadosLeonardo.preencherPais(pais);
			
			dadosLeonardo.preencherCidade(cidade);
			
			dadosLeonardo.preencherEndereco(endereco);
			
			dadosLeonardo.preencherEstado(estado);
			
			dadosLeonardo.preencherCodPostal(codPostal);
			
			dadosLeonardo.aceitarTermos();
			
			dadosLeonardo.clicarBotaoRegistro();
			
			//Validação
		
			Assert.assertEquals("User name already exists", dadosLeonardo.mensagemErroUser());
			
}
	
	@AfterMethod
	
	public void fim() {
	
	navegador.fecharChrome(driver);
	
	
	}		

}
