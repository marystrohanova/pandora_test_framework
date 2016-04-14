package pandora;

import java.util.UUID;

import org.testng.annotations.Test;

import framework.FrameworkBase;
import framework.page.PandoraFrontPage;
import framework.page.PandoraRadioPage;
import framework.page.PandoraRegisterPage;
import framework.page.PandoraUserHomePage;

public class PandoraTest extends FrameworkBase{
	
	@Test
	public void signUpTest(){
		String email = randomEmail();
		String password = "xsw123";
		String birthYear = "1989";
		String zip = "60642";
		
		PandoraFrontPage frontPage = new PandoraFrontPage();
		frontPage.open();
		frontPage.clickSignUp();
		
		PandoraRegisterPage registerPage = new PandoraRegisterPage();
		registerPage.fillInEmailWith(email);
		registerPage.fillInPasswordWith(password);
		registerPage.fillInBirthYearWith(birthYear);
		registerPage.fillInZipWith(zip);
		registerPage.chooseGender();
		registerPage.clickSubmitBtn();
		
		PandoraUserHomePage userHomePage = new PandoraUserHomePage();
		userHomePage.assertUserEmail(email);
	}
	
	@Test
	public void searchRadioTest(){
		String radio = "Muse";
		PandoraFrontPage frontPage = new PandoraFrontPage();
		frontPage.open();
		frontPage.searchRadio(radio);
		
		PandoraRadioPage radioPage = new PandoraRadioPage();
		radioPage.assertRadioPresense(radio);
	}
	
	 private static String randomEmail() {
	    return "random-" + UUID.randomUUID().toString() + "@example.com";
	 }

}
