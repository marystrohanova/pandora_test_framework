package framework.unit.test;

import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import framework.DriverManager;

public class DriverManagerTest {
  @Test
  public void getFirefoxBrowserTest() {
	  RemoteWebDriver driver = DriverManager.getDriver();
	  Assert.assertTrue("Driver ", driver.getClass() == FirefoxDriver.class);
	  driver.close();
  }
}
