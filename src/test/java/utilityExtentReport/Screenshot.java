package utilityExtentReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;





public class Screenshot {
	
	public static String printar(WebDriver driver, String nomeArquivo) {
		
		TakesScreenshot tirarPrint = (TakesScreenshot) driver;
		
		File src = tirarPrint.getScreenshotAs(OutputType.FILE);
		
		String caminho = System.getProperty("user.dir") + "/Screenshot/" + nomeArquivo + ".png";
		
		 File destino = new File (caminho);
		 
		 try {
			 FileUtils.copyFile(src, destino);
		 } catch (IOException e) {
			 System.out.println("Errou ao gerar Screenshot" + e.getMessage());
		 }
		 
		 return caminho;
		
	}

}
