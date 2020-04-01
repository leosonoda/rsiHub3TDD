package br.com.RsiHub3.ProjetoHubTDD.execucaoDosTestes;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.RsiHub3.ProjetoHubTDD.comum.navegador;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaBusca;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginaInicial;
import br.com.RsiHub3.ProjetoHubTDD.pagesObjects.paginasProdutos;
import utilityExtentReport.extentReport;


public class executarConsultaProdutoLupa {
	
	private WebDriver driver;
		
	private String nomeCenario;
	
	//Teste funcionando, não mexer
	
	@BeforeSuite
	public void setandoReport() {
		extentReport.setupReport("Consulta Produto Lupa");
	}
		
	@BeforeMethod
	
	public void execut() {
		
		driver = navegador.abrirChrome();
	}

	@Test
	
	public void consultarProdutoLupa() {
		
			nomeCenario = "Consultar Produto Lupa com Sucesso";
		
			String palavraBuscaP = "mouse";
	 
			String produto = "HP Z4000 Wireless Mouse";
		
	
			paginaInicial novaConsulta = new paginaInicial(driver);	
						
			novaConsulta.acessarLupa();
			
			novaConsulta.pesquisarLupa(palavraBuscaP);
			
			paginaBusca novaBusca = new paginaBusca(driver);
			
			novaBusca.clicarProdutoPaginaBusca(produto);
				
			//Validação
			paginasProdutos novoProduto = new paginasProdutos(driver);
						
			Assert.assertEquals(produto.toUpperCase(), novoProduto.pegarTituloProduto().getText());
			
			
	}
	
		@Test
		
		public void consultarProdutoLupaInexistente(){
			
			nomeCenario = "Consultar Produto Lupa Inexistente";

		
				String palavraBuscaN = "monitor";
				
				paginaInicial novaConsulta = new paginaInicial(driver);
				
				novaConsulta.acessarLupa();
				
				novaConsulta.pesquisarLupa(palavraBuscaN);
				
				paginaBusca novaBusca = new paginaBusca(driver);
				
				Assert.assertEquals("No results for \"monitor\"", novaBusca.buscaInexistente());
			

	}
	
	
	@AfterMethod
	
		public void fim(ITestResult resultado) throws IOException {
		
		ExtentTest test = extentReport.chamandoReport(nomeCenario);
		
		extentReport.reportsDeTestes(test, resultado, driver);
	
		navegador.fecharChrome(driver);
		
		
	}	
	
	@AfterSuite
	public void fimReport() {
		extentReport.terminoReport();
	}
	
}
