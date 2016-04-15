package opentapsproject;

public class DeleteLead extends Wrapper {

	public static void main(String[] args) {
		DeleteLead dl = new DeleteLead();
		dl.Test3();
	}
	public void Test3(){
		
		GetWorkbook("./data/Opentaps_testFeed.xlsx");
		GetExcelSheetByIndex(0);
		OpenBrowser("chrome");
		TimeOut(30);
		NavigateTo(GetExcelStringValue(2,3));
		EditSheet(3,4, enterBy(GetExcelStringValue(3,1), (int)GetExcelDoubleValue(3,2), GetExcelStringValue(3,3)));
		EditSheet(4,4, enterBy(GetExcelStringValue(4,1), (int)GetExcelDoubleValue(4,2), GetExcelStringValue(4,3)));
		EditSheet(5,4, clickBy(GetExcelStringValue(5,1), (int)GetExcelDoubleValue(5,2)));
		EditSheet(6,4, clickBy(GetExcelStringValue(6,1), (int)GetExcelDoubleValue(6,2)));
		EditSheet(7,4, clickBy(GetExcelStringValue(7,1), (int)GetExcelDoubleValue(7,2)));
		EditSheet(8,4, clickBy(GetExcelStringValue(8,1), (int)GetExcelDoubleValue(8,2)));
		EditSheet(9,4, clickBy(GetExcelStringValue(9,1), (int)GetExcelDoubleValue(9,2)));
		EditSheet(10,4, enterBy(GetExcelStringValue(10,1), (int)GetExcelDoubleValue(10,2), GetExcelStringValue(10,3)));
		EditSheet(11,4, clickBy(GetExcelStringValue(11,1), (int)GetExcelDoubleValue(11,2)));
		String ID = GetText(GetExcelStringValue(12,1), (int)GetExcelDoubleValue(12,2));
		EditSheet(13,4, clickBy(GetExcelStringValue(13,1), (int)GetExcelDoubleValue(13,2)));
		EditSheet(14,4, clickBy(GetExcelStringValue(14,1), (int)GetExcelDoubleValue(14,2)));
		EditSheet(15,4, clickBy(GetExcelStringValue(15,1), (int)GetExcelDoubleValue(15,2)));
		EditSheet(16,4, enterBy(GetExcelStringValue(16,1), (int)GetExcelDoubleValue(16,2), ID));
		EditSheet(17,4, clickBy(GetExcelStringValue(17,1), (int)GetExcelDoubleValue(17,2)));
		EditSheet(18,4, VerifyElement(GetExcelStringValue(18,1)));
		EditSheet(19,4, CloseBrowser());
		CloseWorkbook();
		UpdateWB("./data/Opentaps_testFeed.xlsx");	
	}

}
