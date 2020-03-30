package br.com.RsiHub3.ProjetoHubTDD.execucaoDosTestes;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.RsiHub3.ProjetoHubTDD.comum.navegador;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.menuLogin;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaInicial;
import utilityExcel.Constant;
import utilityExcel.ExcelUtils;


public class executarLogarConta {
	
	private WebDriver driver;
	
	//Funcionando Não Mexer
	
	@BeforeMethod
	
	public void execut() {
		
		driver = navegador.abrirChrome();
	}

	@Test
	
	public void logarComSucesso() throws Exception {

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");
		
		paginaInicial novoAcesso = new paginaInicial(driver);
		
		novoAcesso.acessarMenuLogin();
		
		menuLogin novoMenuLogin = new menuLogin(driver);
		
		novoMenuLogin.preencherUsername(ExcelUtils.getCellData(2, 1));
		
		novoMenuLogin.preencherPassword(ExcelUtils.getCellData(2, 2));
		
		novoMenuLogin.clicarBotaoLogar();
	
		
		Assert.assertEquals(novoAcesso.obterUserLogado(), "jorge_jorge");
		
	}
	
		@Test
		
		public void loginIncorreto() throws Exception{
			
			paginaInicial novoAcesso = new paginaInicial(driver);

			novoAcesso.acessarMenuLogin();
			
			menuLogin novoMenuLogin = new menuLogin(driver);
			
			novoMenuLogin.preencherUsername(ExcelUtils.getCellData(4, 1));
			
			novoMenuLogin.preencherPassword(ExcelUtils.getCellData(4, 1));
			
			novoMenuLogin.clicarBotaoLogar();
			
			//Validação
	
			novoMenuLogin.obterMensagemErro();

			Assert.assertEquals("Incorrect user name or password.", novoMenuLogin.obterMensagemErro());
			
			
	}
		
	
	@AfterMethod
	
		public void fim() {
		
		navegador.fecharChrome(driver);
		
	}	
	
}


