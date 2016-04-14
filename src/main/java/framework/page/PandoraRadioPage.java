package framework.page;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;
import framework.configuration.XlsDataProvider;


public class PandoraRadioPage {
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	By divSearchCol = new By.ByCssSelector(XlsDataProvider.getLocator("divSearchCol"));
	By divSearchDetails = new By.ByCssSelector(XlsDataProvider.getLocator("divSearchDetails"));
	
	public PandoraRadioPage(){
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 10);
	}
	
	public void assertRadioPresense(String radio){
		wait.until(ExpectedConditions.presenceOfElementLocated(divSearchCol));

    	List<WebElement> searchResults = driver.findElements(divSearchDetails); 
    	
    	String radioFound = searchResults.get(0).getText();
    	Assert.assertEquals("Radio stations didn't match", radio,
    			radioFound);
	}

}
