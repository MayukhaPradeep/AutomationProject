package page;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SantamonicaPage {
	WebDriver driver;
	//Object repository
	By logo=By.xpath("//*[@id=\"AgencyLogo\"]");
	
	By login=By.id("UlMyAccount");
	By createaccount=By.xpath("/html/body/form/div[6]/div/div/div[2]/div/div/div[2]/div[2]/div[1]/a");
	
	By title=By.name("ddlTitle");
	By firstname=By.name("txtFirstName");
	By lastname=By.name("txtLastName");
	By email=By.name("txtEmail");
	By address=By.name("txtAddress");
	By city =By.name("txtCity");
	By state=By.name("txtState");
	By zip=By.name("txtPostalCode");
	By country=By.name("ddlCountry");
	By countrycode=By.name("countryCode");
	By phone=By.name("txtPhone");
	By mobile=By.name("txtMobile");
	By username=By.name("txtUserName1");
	By password=By.name("txtPassword1");
	By confirmpassword=By.name("txtConfPassword");
	By registerbutton=By.name("btnSubmit");
	
	By usernamelog=By.id("txtLogin");
	By passwordlog=By.id("txtPassword");
	By loginbutton=By.id("btnlogin2");
	
	By busbutton=By.xpath("//*[@id=\"nav-bus-tab\"]");
	By busfrom=By.name("ctl00$ContentPlaceHolder1$redSourceTxt");
	By busto=By.name("ctl00$ContentPlaceHolder1$redDestinationTxt");
	By date=By.xpath("//*[@id=\"ContentPlaceHolder1_dt_redbus\"]");
	By nextarrow=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]");
	By searchbutton=By.xpath("//*[@id=\"ContentPlaceHolder1_RedBusButton\"]");
	By monthandyear=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div");
	
	By more=By.xpath("//*[@id=\"menu1\"]");
	By education=By.xpath("//*[@id=\"nav-tab\"]/div/ul/li[3]/a");
	
	public SantamonicaPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//LOGO VERIFICATION
	public void logo()
	{
		Boolean l=driver.findElement(logo).isDisplayed();
		if(l)
		{
			System.out.println("Logo test passed & Logo is displayed");
		}
		else
		{
			System.out.println("Logo test failed & Logo is not displayed");
		}
	}
	//TITLE VERFICATION OF HOME PAGE
	public void titleverification()
	{
		String actual=driver.getTitle();
		System.out.println("Actual title is "+actual);
		String expected="Santamonica Tours & Travels Pvt Ltd.";
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("Title verification test : Pass");
		}
		else
		{
			System.out.println("Title verification test : Fail");
		}
	}
	//CONTENT VERIFICATION OF HOME PAGE
	public void contentverification()
	{
		String content=driver.getPageSource();
		if(content.contains("Currently Running Offers"))
		{
			System.out.println("Content Verification test: Pass");
			
		}
		else
		{
			System.out.println("Content Verfication test: Fail");
		}
	}
	//URL VERIFICATION OF REGISTRATION PAGE
	public void regurlverification()
	{
		String actual=driver.getCurrentUrl();
		System.out.println("actual url is "+actual);
		String expected="https://www.santamonicafly.com/Home.aspx";
		if(expected.equals(actual))
		{
			System.out.println("URL verification of registration page is passed");
		}
		else
		{
			System.out.println("URL verification of registration page is failed");
		}
	}
	//REGISTRATION PAGE
	public void registration() throws Exception
	{
		driver.findElement(login).click();
		Thread.sleep(1000);
		driver.findElement(createaccount).click();
		
		Select t= new Select(driver.findElement(title));
		t.selectByValue("Miss.");
		driver.findElement(firstname).sendKeys("Harry");
		driver.findElement(lastname).sendKeys("K");
		driver.findElement(email).sendKeys("harryk@gmail.com");
		driver.findElement(address).sendKeys("abc,abcd");
		driver.findElement(city).sendKeys("abc");
		driver.findElement(state).sendKeys("kerala");
		driver.findElement(zip).sendKeys("231458");
		Select a=new Select(driver.findElement(country));
		a.selectByValue("IN");
		Select b=new Select(driver.findElement(countrycode));
		b.selectByValue("+91");
		driver.findElement(phone).sendKeys("2531467");
		driver.findElement(mobile).sendKeys("9632145075");
		driver.findElement(username).sendKeys("Harryk1");
		driver.findElement(password).sendKeys("Harryk12");
		driver.findElement(confirmpassword).sendKeys("Harryk12");
		Thread.sleep(10000);
		driver.findElement(registerbutton).click();
		System.out.println("registration completed");
		driver.findElement(By.xpath("//*[@id=\"AlertPop\"]/div/div/div[3]/a")).click();
	}
	
	//LOGIN PAGE
	public void login() throws Exception
	{
		driver.findElement(login).click();
		Thread.sleep(1000);
		File f=new File("D:\\\\manual assignment&project\\\\santamonica.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String user=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("username is "+user);
		    String pass=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password is "+pass);
			
			driver.findElement(usernamelog).clear();
			driver.findElement(usernamelog).sendKeys(user);
			driver.findElement(passwordlog).clear();
			driver.findElement(passwordlog).sendKeys(pass);
		}
		driver.findElement(loginbutton).click();
		Thread.sleep(1000);
	}
	//LOGIN PAGE URL VERIFICATION
	public void urlverification()
	{
		String actual=driver.getCurrentUrl();
		System.out.println(actual);
		String expected="https://www.santamonicafly.com/Home.aspx";
		if(expected.equals(actual))
		{
			System.out.println("pass and the url is "+actual);
		}
		else
		{
			System.out.println("fail and the url is "+actual);
		}
	}
	//BUS BOOKING PAGE
	public void busbooking() throws Exception
	{
		driver.findElement(busbutton).click();
		Thread.sleep(1000);
		driver.findElement(busfrom).sendKeys("Chennai");
		driver.findElement(busto).sendKeys("Bangalore");
		driver.findElement(date).click();
		while(true)
		{
			
			String may=driver.findElement(monthandyear).getText();
			if(may.equalsIgnoreCase("february 2024"))
			{
				System.out.println(may);
				break;
			}
			else
			{
				driver.findElement(nextarrow).click();
			}	
		}
		List<WebElement> days = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
		for(WebElement dates1:days)
		{
			String d=dates1.getText();
			if(d.equals("20"))
			{
				System.out.println("date selected");
				dates1.click();
				System.out.println("date is "+d);
				break;
			}
		}
		driver.findElement(searchbutton).click();
		Thread.sleep(2000);
		driver.navigate().to("https://www.santamonicafly.com/Home.aspx");
		
	
	}
	//SCREENCHOT SAVED IN PACKAGE
	public void screenshot() throws Exception
	{
		File homescreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(homescreenshot, new File("./screenshot//HomeScreenshot.png"));
		System.out.println("Screenshot of home page taken");
		
		File logoscreenshot=driver.findElement(logo).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(logoscreenshot, new File("./screenshot//LogoScreenshot.png"));
		System.out.println("Screenshot of logo taken");
	}
	//MOUSE HOVER ON MORE AND SELECTING EDUCATION AND PAGE OPENS IN NEW TAB
	public void mousehoverandwindowhandling() throws Exception
	{
		System.out.println("mousehover");
		System.out.println(driver);
		Actions act=new Actions(driver);
		Thread.sleep(1000);
		WebElement morekey=driver.findElement(more);
		act.moveToElement(morekey).perform();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement educationkey=driver.findElement(education);
		wait.until(ExpectedConditions.visibilityOf(educationkey));
		driver.findElement(education).click();
		
		String parentwindow=driver.getWindowHandle();
		driver.findElement(more).click();
		
		Set<String> allwindowhandles = driver.getWindowHandles();
		for(String handle:allwindowhandles)
		{
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"launchevent\"]/div/div/div[1]/button")).click();
				Thread.sleep(2000);
				driver.close();
			}
			driver.switchTo().window(parentwindow);
		}
	}

}
