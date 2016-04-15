package opentapsproject;

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet = null;
	FileOutputStream fos;
	Alert a;

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

	public void GetWorkbook(String path) {
		try {
			file = new FileInputStream(new File(path));
			workbook = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			System.out.println("Input Data Excell FileNotFound");
		} catch (IOException e) {
			System.out.println("Excell workbook IOException");
		}
	}

	public String acceptAlert() {
		try {
			a.accept();
			return ("Pass");
		} catch (Exception e) {
	
			return ("Fail");
		}
	
	}

	public String CloseBrowser() {
		try {
			driver.close();
			return ("Pass");
		} catch (WebDriverException e) {
			return ("Fail");
		}
	}

	public void CloseWorkbook(){
		try {
			file.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public String dismissAlert() {
		try {
			a.dismiss();
			return ("Pass");
		} catch (Exception e) {
	
			return ("Fail");
		}
	
	}

	public void EditSheet(int row, int column, String value) {
		try {
			sheet.getRow(row).createCell(column).setCellValue(value);
			// getRow(row).getCell(column)
		} catch (Exception e) {
			System.out.println("Work Sheet not found");
		}
	
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

	public String getAlertText(String actualText) {
		try {
			String result = "Pass";
			if (a.getText() == actualText) {
				result = "Pass";
			} else {
				result = "Fail";
			}
			return (result);
		} catch (Exception e) {
			return ("Fail");
		}
	}

	public int GetExccelRowCount() {
		int RowCount = 0;
		try {
			RowCount = sheet.getLastRowNum();
		} catch (Exception e) {
			System.out.println("Work Sheet not found");
		}
		return RowCount;
	}

	public double GetExcelDoubleValue(int row, int column) {
		Double cellDoubleValue = null;
		try {
			cellDoubleValue = sheet.getRow(row).getCell(column).getNumericCellValue();
		} catch (Exception e) {
			System.out.println("Cell is null");
		}
		return cellDoubleValue;
	}

	public XSSFSheet GetExcelSheetByIndex(int index) {
	
		try {
			sheet = workbook.getSheetAt(index);
		} catch (Exception e) {
			System.out.println("Work Sheet not found");
		}
		return sheet;
	}

	public String GetExcelStringValue(int row, int column) {
		String cellStringValue = null;
		try {
			cellStringValue = sheet.getRow(row).getCell(column).getStringCellValue();
		} catch (Exception e) {
			System.out.println("Cell is null");
		}
	
		return cellStringValue;
	}

	public String GetText(String locator, int locType) {
		String result = null;
	
		try {
			switch (locType) {
			case 1:
				result = driver.findElementByClassName(locator).getText();
				break;
			case 2:
				result = driver.findElementByCssSelector(locator).getText();
				break;
	
			case 3:
				result = driver.findElementById(locator).getText();
				break;
			case 4:
				result = driver.findElementByLinkText(locator).getText();
				break;
			case 5:
				result = driver.findElementByName(locator).getText();
				break;
			case 6:
				result = driver.findElementByXPath(locator).getText();
				break;
	
			}
		} catch (NoSuchElementException e) {
			result = "Fail to get text";
		}
	
		return (result);
	
	}

	public String NavigateTo(String url) {
		try {
			driver.get(url);
			return ("Pass");
		} catch (WebDriverException e) {
			return ("Fail");
	
		}
	}

	public String OpenBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
	
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
	
			}
			return ("Pass");
		} catch (WebDriverException e) {
	
			return ("Fail");
		}
	
	}

	public String SelectValueByIndex(String locator, int locType, int index) {
		try {
			switch (locType) {
			case 1: {
				Select select = new Select(driver.findElementByClassName(locator));
				select.selectByIndex(index);
			}
				break;
	
			case 2: {
				Select select = new Select(driver.findElementByCssSelector(locator));
				select.selectByIndex(index);
			}
				break;
	
			case 3: {
				Select select = new Select(driver.findElementById(locator));
				select.selectByIndex(index);
			}
				break;
	
			case 4: {
				Select select = new Select(driver.findElementByLinkText(locator));
				select.selectByIndex(index);
			}
				break;
	
			case 5: {
				Select select = new Select(driver.findElementByName(locator));
				select.selectByIndex(index);
			}
				break;
	
			case 6: {
				Select select = new Select(driver.findElementByXPath(locator));
				select.selectByIndex(index);
			}
			}
			return ("Pass");
		} catch (NoSuchElementException e) {
			return ("Fail");
		}
	
	}

	public String SwitchToAlert() {
		try {
			a = driver.switchTo().alert();
			return ("Pass");
		} catch (Exception e) {
			return ("Fail");
		}
	
	}

	public void UpdateWB(String path){
		try {
			fos =new FileOutputStream(new File(path));
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fail to update");
		} catch (IOException e) {
			System.out.println("Fail to update");
		}
		
	}

	public String VerifyElement(String locator){
		String result = "Pass";
		
		try {
			driver.findElementByXPath(locator);
			return(result);
		} catch (Exception e) {
			result="Fail";
			return(result);
		}
	}

	public String verifyText(String locator, int locType, String expectedText) {
		String result = "Pass";
		try {
			switch (locType) {
			case 1: {
				if (driver.findElementByClassName(locator).getText().equals(expectedText)) {
					result = "Pass";
				} else {
					result = "Fail";
				}
	
			}
				break;
			case 2: {
				if (driver.findElementByCssSelector(locator).getText().equals(expectedText)) {
					result = "Pass";
				} else {
					result = "Fail";
				}
				break;
			}
			case 3: {
				if (driver.findElementById(locator).getText().equals(expectedText)) {
					result = "Pass";
				} else {
					result = "Fail";
				}
				break;
			}
			case 4: {
				if (driver.findElementByLinkText(locator).getText().equals(expectedText)) {
					result = "Pass";
				} else {
					result = "Fail";
				}
				break;
			}
			case 5: {
				if (driver.findElementByName(locator).getText().equals(expectedText)) {
					result = "Pass";
				} else {
					result = "Fail";
				}
				break;
			}
			case 6: {
				if (driver.findElementByXPath(locator).getText().equals(expectedText)) {
					result = "Pass";
				} else {
					result = "Fail";
				}
				break;
			}
			}
	
		} catch (NoSuchElementException e) {
			result = "Fail";
		}
		return (result);
	
	}

	public String VerifyTitle(String expectedTitle) {
		try {
			if ((driver.getTitle()) == expectedTitle) {
				return ("Pass");
			} else {
				return ("Fail");
			}
		} catch (WebDriverException e) {
			return ("Fail");
		}
	}

	public String verifyUrl(String expectedUrl) {
		if (driver.getCurrentUrl().contains(expectedUrl)) {
			return ("Pass");
		} else {
			return ("Fail");
		}
	
	}

	public void WriteToSheet(int row, int column, String value) {
		try {
			sheet.createRow(row).createCell(column).setCellValue(value);
			// getRow(row).getCell(column)
		} catch (Exception e) {
			System.out.println("Work Sheet not found");
		}
	
	}
	
}
