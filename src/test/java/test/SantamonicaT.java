package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.SantamonicaPage;

public class SantamonicaT {
	public static WebDriver driver;
	@BeforeTest
	public void browser()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.santamonicafly.com/");
		driver.manage().window().maximize();
	}
    @Test
	public void reg() throws Exception
	{
    	SantamonicaPage ob=new SantamonicaPage(driver);
    	ob.logo();
    	ob.titleverification();
    	ob.contentverification();
		ob.registration();
    	ob.regurlverification();
		ob.login();
	    ob.urlverification();
		ob.busbooking();
    	ob.screenshot();
    	ob.mousehoverandwindowhandling();	
	}

}
