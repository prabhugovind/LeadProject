package opentapsproject;

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Wrapper {


	RemoteWebDriver driver;

	public void launchApp(String browser, String url)

	{
		try {
			if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}

			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (WebDriverException e) {

			System.out.println("Browser not launched");
		}
	}

	public void entertextByid(String id, String value)

	{
		try {
			driver.findElementById(id).clear();
			driver.findElementById(id).sendKeys(value);
		} catch (NoSuchElementException e) {

			System.out.println("No Such Element");
		}

	}

	public void submitByclassname(String cName)
	{
		try {

			driver.findElementByClassName(cName).click();
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element");
		}

	}

	public String TimeOut(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return ("Pass");
	}

	public void verifyTextByXpath(String xpath,String vText)

	{

		try {
			String c=driver.findElementByXPath(xpath).getText();
			if(c.equals(vText))
			{
				System.out.println("Verification");
			}
			else
			{
				System.out.println("Verification Failed");
			}
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element");
		}	
	}

	public void enterByName(String name, String value)

	{
		try {
			driver.findElementByName(name).clear();
			driver.findElementById(name).sendKeys(value);
		} catch (NoSuchElementException e) {

			System.out.println("No Such Element");
		}

	}

	public void clickByXpath(String path)

	{
		try {

			driver.findElementByXPath(path).click();
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element");
		}

	}

	public String VerifyTitle(String title)

	{
		try {

			String c=driver.getTitle();
			if(c.equals(title))
			{
				return ("Pass");
			}
			else
			{
				return ("Fail");
			}
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element");
			return ("Fail");
		}	
	}

	public String VerifyUrl(String url)
	{
		try {

			String c=driver.getCurrentUrl();
			if(c.equals(url))
			{
				return("Pass");
			}
			else
			{
				return("Fail");
			}
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element");
			return("Fail");
		}	
	}

	public void selectValueByIndex(String attribute, String attribute_Value,int sIndex)
	{
		try {
			if (attribute.equalsIgnoreCase("id")) {
				WebElement ole = driver.findElement(By.id(attribute_Value));
				Select dropdown = new Select(ole);
				dropdown.selectByIndex(sIndex);
			}
			else if (attribute.equalsIgnoreCase("classname")) {
				WebElement ole = driver.findElement(By.className(attribute_Value));
				Select dropdown = new Select(ole);
				dropdown.selectByIndex(sIndex);
			}
			else if (attribute.equalsIgnoreCase("name")) {
				WebElement ole = driver.findElement(By.name(attribute_Value));
				Select dropdown = new Select(ole);
				dropdown.selectByIndex(sIndex);
			}
			else if (attribute.equalsIgnoreCase("tagname")) {
				WebElement ole = driver.findElement(By.tagName(attribute_Value));
				Select dropdown = new Select(ole);
				dropdown.selectByIndex(sIndex);
			}
			else if (attribute.equalsIgnoreCase("cssselector")) {
				WebElement ole = driver.findElement(By.cssSelector(attribute_Value));
				Select dropdown = new Select(ole);
				dropdown.selectByIndex(sIndex);
			}
			else if (attribute.equalsIgnoreCase("linktext")) {
				WebElement ole = driver.findElement(By.linkText(attribute_Value));
				Select dropdown = new Select(ole);
				dropdown.selectByIndex(sIndex);
			}
			else if (attribute.equalsIgnoreCase("xpath")) {
				WebElement ole = driver.findElement(By.xpath(attribute_Value));
				Select dropdown = new Select(ole);
				dropdown.selectByIndex(sIndex);
			}
		} catch (NoSuchElementException e) {
			System.out.println("No Such Element Exception");
		}
	}

	public void switchToLastWindow()
	{
		try {
			
			Set<String> wHandle = driver.getWindowHandles();
			for (String handle : wHandle) {

				driver.switchTo().window(handle);
				System.out.println(driver.getWindowHandle());

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No Window Exist");
		}

	}
	
	public String GetprimaryWindowhandle()
    {
    	
    		try {
				String PWindowHw = driver.getWindowHandle();
				return PWindowHw;
			} catch (NoSuchWindowException e) {
				// TODO Auto-generated catch block
				System.out.println("No Window Exist");


			}
    		return null;
    }

	public void switchToprimaryWindow(String PWindowHw)
	
	{
		try {
			driver.switchTo().window(PWindowHw);
		} catch (NoSuchWindowException e) {
			System.out.println("No Window Exist");
	
			
		}

	}

	public void switchToFirstFrame()
	{
		List <WebElement> FrameCollection = driver.findElementsByTagName("iframe");

		for (WebElement FrameLocal : FrameCollection) 
		{
			driver.switchTo().frame(FrameLocal);
			break;
		}

	}

	public void acceptAlert()
	{
		try {
			Alert a = driver.switchTo().alert();
			a.accept();
		} catch (Exception e) {

			System.out.println("No Alert available to switch");
		}

	}

	public String clickBy(String locator, int locType) {
		String result = "Pass";
		try {
			switch (locType) {
			case 1:
				driver.findElementByClassName(locator).click();
				break;
			case 2:
				driver.findElementByCssSelector(locator).click();
				break;

			case 3:
				driver.findElementById(locator).click();
				break;

			case 4:
				driver.findElementByLinkText(locator).click();
				break;

			case 5:
				driver.findElementByName(locator).click();
				break;

			case 6:
				driver.findElementByXPath(locator).click();
				break;
			}

		} catch (NoSuchElementException e) {
			result = "Fail";
		}
		return (result);

	}

	public void dismissAlert()
	{
		try {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		} catch (Exception e) {

			System.out.println("No Alert available to switch");
		}

	}

	public void switchToFrameByElement(String Element,String attribute_Value)
	{

		try {
			if (Element.equalsIgnoreCase("linktext")) {
				driver.switchTo().frame(driver.findElement(By.linkText(attribute_Value)));
			}
			if (Element.equalsIgnoreCase("cssSelector")) {
				driver.switchTo().frame(driver.findElement(By.cssSelector(attribute_Value)));
			}
			if (Element.equalsIgnoreCase("tagName")) {
				driver.switchTo().frame(driver.findElement(By.tagName(attribute_Value)));
			}
			if (Element.equalsIgnoreCase("xpath")) {
				driver.switchTo().frame(driver.findElement(By.xpath(attribute_Value)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No Such Element Exception");
		}
	}

	public void verifytext(String attribute,String attribute_Value,String vText)
	{
		try {
			if (attribute.equalsIgnoreCase("id")) {
				String c = driver.findElement(By.id(attribute_Value)).getText();
				if (c.equals(vText)) {
					System.out.println("Verification Successfull");
				} else {
					System.out.println("Verification failed");
				} 
			}

			else if (attribute.equalsIgnoreCase("name")) {
				String c = driver.findElement(By.name(attribute_Value)).getText();
				if (c.equals(vText)) {
					System.out.println("Verification Successfull");
				} else {
					System.out.println("Verification failed");
				} 
			}

			else if (attribute.equalsIgnoreCase("tagname")) {
				String c = driver.findElement(By.tagName(attribute_Value)).getText();
				if (c.equals(vText)) {
					System.out.println("Verification Successfull");
				} else {
					System.out.println("Verification failed");
				} 
			}

			else if (attribute.equalsIgnoreCase("classname")) {
				String c = driver.findElement(By.className(attribute_Value)).getText();
				if (c.equals(vText)) {
					System.out.println("Verification Successfull");
				} else {
					System.out.println("Verification failed");
				} 
			}

			else if (attribute.equalsIgnoreCase("cssselector")) {
				String c = driver.findElement(By.cssSelector(attribute_Value)).getText();
				if (c.equals(vText)) {
					System.out.println("Verification Successfull");
				} else {
					System.out.println("Verification failed");
				} 
			}

			else if (attribute.equalsIgnoreCase("linktext")) {
				String c = driver.findElement(By.linkText(attribute_Value)).getText();
				if (c.equals(vText)) {
					System.out.println("Verification Successfull");
				} else {
					System.out.println("Verification failed");
				} 
			}
		} catch (Exception e) {
			System.out.println("NosuchElement Exception occured");
		}

	}	

	public String ReadFromExcel(String FileName, int Rownum,int Colnum) throws Throwable

	{

		FileInputStream fis = new FileInputStream(new File(FileName));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet =  workbook.getSheetAt(0);
		String cellValue = null;
		try {
			cellValue = sheet.getRow(Rownum).getCell(Colnum).getStringCellValue();
		} catch (Exception e) {
			System.out.println("Cell is null");
		}
		return cellValue;
	}

	public String enterBy(String locator, int locType, String text) {
		String result = "Pass";
		try {
			switch (locType) {
			case 1:
				driver.findElementByClassName(locator).sendKeys(text);
				break;
			case 2:
				driver.findElementByCssSelector(locator).sendKeys(text);
				break;

			case 3:
				driver.findElementById(locator).sendKeys(text);
				break;

			case 4:
				driver.findElementByLinkText(locator).sendKeys(text);
				break;

			case 5:
				driver.findElementByName(locator).sendKeys(text);
				break;

			case 6:
				driver.findElementByXPath(locator).sendKeys(text);
				break;
			}

		} catch (NoSuchElementException e) {
			result = "Fail";
		}
		return (result);

	}
	public void entertextByxpath(String xpath, String value)

	{
		try {
			driver.findElementByXPath(xpath).clear();
			driver.findElementByXPath(xpath).sendKeys(value);
		} catch (NoSuchElementException e) {

			System.out.println("No Such Element");
		}

	}

	public void sleep(){
  	 try {
  		Thread.sleep(10000);
  	} catch (InterruptedException e) {
  		
  		e.printStackTrace();
  	}
  	}
	
}
