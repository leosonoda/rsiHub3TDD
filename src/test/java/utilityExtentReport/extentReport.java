package utilityExtentReport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReport {
	
	
	public static ExtentHtmlReporter htmlReporter;
	
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	
	
	public static void setupReport(String nomeReport) {
		
		htmlReporter = new ExtentHtmlReporter("src/test/resources/Reports/" + nomeReport + ".html");
		
		htmlReporter.config().setDocumentTitle("Report1");
		
		htmlReporter.config().setReportName("Report2");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
	}
	
	
	public static ExtentTest chamandoReport(String nomeTeste) {
		
		test = extent.createTest(nomeTeste);
		
		return test;
		
		
	}
	
	
	public static void reportsDeTestes (ExtentTest teste, ITestResult resultado, WebDriver driver) throws IOException {
		
		test.addScreenCaptureFromPath(Screenshot.printar(driver, resultado.getName()));
		
		if (resultado.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Cenário de Teste com Falha: " + resultado.getName());
			test.log(Status.FAIL, "Cenário de Teste com Falha: " + resultado.getThrowable());	
			
		} else if (resultado.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Cenário de Teste foi pulado: " + resultado.getName());
			
		}else if (resultado.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Cenário de Teste RODANDO LISO: " + resultado.getName());
			
		}

	}
	
	public static void terminoReport() {
		extent.flush();
		
	}
	
	

}
