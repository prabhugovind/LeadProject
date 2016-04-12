package opentapsproject;

import java.io.IOException;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.Alert;

public class MergeTestCase extends Wrapper
{
	@Test
	public void login() throws Throwable 
	{
		
		launchApp((ReadFromExcel("./data/TC4.xlsx/", 1, 0)),(ReadFromExcel("./data/TC4.xlsx/", 1, 1)));
		entertextByid("username", (ReadFromExcel("./data/TC4.xlsx/", 1, 2)));
		entertextByid("password", (ReadFromExcel("./data/TC4.xlsx/", 1, 3)));
		submitByclassname("decorativeSubmit");
		String Handle = GetprimaryWindowhandle();
		System.out.println(Handle);
	    clickByXpath("//*[@id='button']/a/img");
	    clickByXpath("//ul[@class='sectionTabBar']//li[2]//a[contains(text(),'Leads')]");
	    clickByXpath("//ul[@class='shortcuts']//li[4]//a[contains(text(),'Merge Leads')]");
	    clickByXpath("//table[@class='twoColumnForm']//a/img[@src='/images/fieldlookup.gif']");
	    switchToLastWindow();
	    Thread.sleep(1000);
	    entertextByxpath("//input[@name='id']", (ReadFromExcel("./data/TC4.xlsx/", 1,4)));
	    submitByclassname("x-btn-text");
	    Thread.sleep(1000);
	    submitByclassname("linktext"); 
	    switchToprimaryWindow(Handle);  
	    clickByXpath("(//img[@alt='Lookup'])[2]");
	    switchToLastWindow();
	    Thread.sleep(1000);
	    entertextByxpath("//input[@name='id']", (ReadFromExcel("./data/TC4.xlsx/", 1,5)));
	    submitByclassname("x-btn-text");
	    Thread.sleep(1000);
	    submitByclassname("linktext");
	    switchToprimaryWindow(Handle);
	    submitByclassname("buttonDangerous");
	    
	    Alert a = driver.switchTo().alert();
	    a.accept();
	    
	    Thread.sleep(2000);
	    clickByXpath("//a[@href='/crmsfa/control/findLeads']");
	    Thread.sleep(1000);
	    
	    entertextByxpath("//input[@name='id']",(ReadFromExcel("./data/TC4.xlsx/", 1,4)));
	    
	    clickByXpath("//em[@unselectable='on']/button");
	    Thread.sleep(1000);
	    verifyTextByXpath("/div[@class='x-paging-info']", "No records to display");
	    
}
}