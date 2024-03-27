package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.LocationPage;

public class TC004_CheckTitleOfAllMenu extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC004_CheckTitleOfAllMenu";
		testDescription = "Check the different menu titles";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
		sheetName = "menuGenricTestData";
	}

	@Test(dataProvider = "getFromExcel", priority = 5)
	public void tc_04_CheckTitleOfAllMenu(String menuName, String expTitle) throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		String actTitle = hp.menuValidation(menuName);
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating the Title of different Menu - Pass", "Pass", testName);
		} else {
			reportStep("Validating the Title of different Menu - Fail", "Fail", testName);
		}
	}

}
