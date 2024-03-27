package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import base.ProjectSpecificationMethod;
import pages.LocationPage;

public class TC001_NavigatingtoBestBuy extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {
		testName = "TC001_NavigatingtoBestBuy";
		testDescription = "Navigating to the Best Buy e-commerce website";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
	}

	@Test(priority = 1)
	public void tc_01_navgatingToBestBestApp() throws Exception {
		LocationPage lp = new LocationPage();
		String actTitle = lp.bestBuyPageTitle();
		String expTitle = "Best Buy International: Select your Country - Best Buy";
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating Best Buy Page Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Best Buy Page Title - Fail", "Fail", testName);
		}
	}

}
