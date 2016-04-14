package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.FrameworkBase;
import framework.configuration.XlsDataProvider;

public class PandoraRegisterPage {
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	By emailInput = new By.ByCssSelector(XlsDataProvider.getLocator("email_input"));
	By passwordInput = new By.ByCssSelector(XlsDataProvider.getLocator("password_input"));
	By birthYearInput = new By.ByCssSelector(XlsDataProvider.getLocator("birth_year_input"));
	By zipInput = new By.ByCssSelector(XlsDataProvider.getLocator("zip_input"));
	
	public PandoraRegisterPage() {
		this.driver = FrameworkBase.driverCabinet.get();
		this.wait = new WebDriverWait(driver, 10);
	}
	
	public void fillInEmailWith(String email){
		WebElement weEmailInput = driver.findElement(emailInput);
		weEmailInput.click();
		weEmailInput.sendKeys(email);
	}
	
	public void fillInPasswordWith(String password){
		WebElement wepasswordInput = driver.findElement(passwordInput);
		wepasswordInput.click();
		wepasswordInput.sendKeys(password);
	}
	
	public void fillInBirthYearWith(String year){
		WebElement weBirthYearInput = 
				wait.until(ExpectedConditions.elementToBeClickable(birthYearInput));
		weBirthYearInput.sendKeys(year);
	}
	
	public void fillInZipWith(String zip){
		WebElement weZipInput = 
				wait.until(ExpectedConditions.elementToBeClickable(zipInput));;
		weZipInput.sendKeys(zip);
	}
	
	public void chooseGender(){
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("document.querySelector('#register_female.onboarding__form__radio').style.display = 'block'");
			((JavascriptExecutor)driver).executeScript("document.querySelector('#register_female.onboarding__form__radio').click();");
		} else {
		    throw new IllegalStateException("This driver does not support JavaScript!");
		}
	}
	
	public void clickSubmitBtn(){
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("document.querySelector('input[type=\"submit\"]').click()");
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}
	}

}
