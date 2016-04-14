package framework.page;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;
import framework.configuration.XlsDataProvider;

public class PandoraUserHomePage {
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	By spanUserEmail = new By.ByCssSelector(XlsDataProvider.getLocator("user_email_span"));
	
	public PandoraUserHomePage(){
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 10);
	}
	
	public void assertUserEmail(String email){
		WebElement weUserEmail = 
				wait.until(ExpectedConditions.visibilityOfElementLocated(spanUserEmail));
		String actualUserEmail = weUserEmail.getText();
		System.out.println("User has registered as " + actualUserEmail);
		Assert.assertEquals("Emails didnt match", email,
				actualUserEmail);
	}

}
