package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import base.ProjectSpecificationMethod;
import pages.HomePage;
import pages.LocationPage;

public class TC005_ValidateLinkInBottomOfHomePage extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC005_ValidateLinkInBottomOfHomePage";
		testDescription = "Link in HomePage bottom is broken or not";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
	}

	@Test(priority = 6)
	public void tc_05_validateLinkInBottomOfHomePage() throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		String actTitle = hp.validateTermsAndCondtionLink();
		String expTitle = "BestBuy.com Terms and Conditions";
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating the Title of link in bottom of Home Page - Pass", "Pass", testName);
		} else {
			reportStep("Validating the Title of link in bottom of Home Page - Fail", "Fail", testName);
		}
	}
}
