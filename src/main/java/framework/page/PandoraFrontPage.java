package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import framework.FrameworkBase;
import framework.configuration.XlsDataProvider;

public class PandoraFrontPage {
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	String url = "http://www.pandora.com/";
	By onBordForm = new By.ByCssSelector(XlsDataProvider.getLocator("on_bord_form"));
	By searchRadioInput = new By.ByCssSelector(XlsDataProvider.getLocator("inputSearch"));
	
	public PandoraFrontPage() {
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 10);
	}
	
	public void open(){
		driver.get(url);
		System.out.println("Loading page: " + url);
	}
	
	public void clickSignUp(){
		WebElement registerLink = driver.findElement(By.cssSelector(XlsDataProvider.getLocator("register_link")));
		registerLink.click();
  
		wait.until(ExpectedConditions.presenceOfElementLocated(onBordForm));
	}
	
	public void searchRadio(String radio){
		WebElement searchInput = driver.findElement(searchRadioInput);
    	searchInput.clear();
    	searchInput.sendKeys(radio + Keys.ENTER);
	}
}
