package framework.unit.test;

import junit.framework.Assert;

import org.testng.annotations.Test;

import framework.PropertiesLoader;

public class PropertiesLoaderTest {
  @Test
  public void getValidPropTest() {
	  String expected = "firefox";
	  String browser = PropertiesLoader.getValue("browser");
	  
	  Assert.assertEquals("Browser names didn't match", expected,
				browser);
	  
  }
  
  @Test(expectedExceptions = RuntimeException.class)
  public void nullValueTest(){
	  PropertiesLoader.getValue("somevalue");
  }
}
