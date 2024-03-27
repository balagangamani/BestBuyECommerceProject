package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.LocationPage;
import pages.SignInPage;

public class TC003_SignIn extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC003_SignIn";
		testDescription = "Sign-In Functionality";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
		sheetName = "signInTestData";
	}

	@Test(dataProvider = "getFromExcel", priority = 4)
	public void tc_03_SignInFunctionality(String email, String password, String xpath, String expMsg) throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		hp.goToSignIn();
		SignInPage sp = new SignInPage();
		String actMsg = sp.signInFunctionality(email, password, xpath);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			reportStep("Validating Sign-In Functionality - Pass", "Pass", testName);
		} else {
			reportStep("Validating Sign-In Functionality - Fail", "Fail", testName);
		}
	}

}
