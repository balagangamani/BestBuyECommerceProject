package test;

import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;

import pages.LocationPage;

public class TC002_ValidateUrlIsNotBroken extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC002_ValidateUrlIsNotBroken";
		testDescription = "Given URL Link is broken or not";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
	}

	@Test(priority = 2)
	public void tc_02_validateUrlIsNotBroken() throws Exception {
		LocationPage lp = new LocationPage();
		if (lp.urlResponseCode() == 200) {
			reportStep("Validating Best Buy page URL is broken or not - Pass", "Pass", testName);
		} else {
			reportStep("Validating Best Buy page URL is broken or not - Fail", "Fail", testName);
		}
		AssertJUnit.assertTrue(lp.urlResponseCode() == 200);
	}

}
