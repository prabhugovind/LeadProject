package opentapsproject;

import org.junit.Test;



public class EditTestCase extends Wrapper{

	@Test
	public void opentapsCall() throws Throwable{
		
		
		launchApp("firefox", "http://demo1.opentaps.org");
		entertextByid("username", ReadFromExcel("./data/Opentaps_Edit.xlsx", 1, 0));
		entertextByid("password", ReadFromExcel("./data/Opentaps_Edit.xlsx", 1, 1));
		submitByclassname("decorativeSubmit");
		clickByXpath("//*[@id='label']/a");
		sleep();
		clickBy("Leads", 4);
		sleep();
		clickBy("Find Leads",4);
		sleep();
		
		enterBy("//div[@class='x-form-item x-tab-item'][2]/div/input",6,ReadFromExcel("./data/Opentaps_Edit.xlsx", 1, 2));
		
		sleep();
		clickByXpath("//button[contains(text(),'Find Leads')]");
		
		sleep();
		clickBy(ReadFromExcel("./data/Opentaps_Edit.xlsx", 1, 3),4);
		VerifyTitle("View Lead | opentaps CRM");
		clickBy("Edit",4);
		selectValueByIndex("id","addDataSourceForm_dataSourceId",  Integer.parseInt(ReadFromExcel("./data/Opentaps_Edit.xlsx", 1, 4)));
		
		clickByXpath("(//*[@class='smallSubmit'])[2]");
		sleep();
		selectValueByIndex("id","addMarketingCampaignForm_marketingCampaignId",  Integer.parseInt(ReadFromExcel("./data/Opentaps_Edit.xlsx", 1, 5)));
		
		clickByXpath("(//*[@class='smallSubmit'])[3]");
		sleep();
		clickByXpath("(//*[@class='smallSubmit'])[1]");
		
	}

}
