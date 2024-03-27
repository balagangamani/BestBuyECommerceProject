package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import base.ProjectSpecificationMethod;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LocationPage;

public class TC003_CreateAccount extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC003_CreateAccount";
		testDescription = "CreatAccount Functionality";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
		sheetName = "CreateAccount";
	}

	@Test(dataProvider = "getFromExcel", priority = 3)
	public void tc_03_validateCreatAccountFunctionality(String fname, String lname, String emailId, String pass,
			String repass, String mob, String xpathText, String expMsg) throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		hp.goToCreatAccount();
		CreateAccountPage ca = new CreateAccountPage();
		String actMsg = ca.creatAccountFunctionality(fname, lname, emailId, pass, repass, mob, xpathText);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			reportStep("Validating CreatAccount Functionality - Pass", "Pass", testName);
		} else {
			reportStep("Validating CreatAccount Functionality - Fail", "Fail", testName);
		}
	}

}
