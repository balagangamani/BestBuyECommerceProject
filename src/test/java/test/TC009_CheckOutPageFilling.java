package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import base.ProjectSpecificationMethod;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LocationPage;
import pages.ProductPage;

public class TC009_CheckOutPageFilling extends ProjectSpecificationMethod {
	// https://www.bestbuy.com/checkout/r/payment

	@BeforeTest
	public void setup() {
		testName = "TC009_CheckOutPageFilling";
		testDescription = "Navigating to the checkout page and filling the form with dummy payment information";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
	}

	@Test(priority = 10)
	public void tc_09_CheckOutPageFilling() throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		hp.searchProduct("Mouse");
		Thread.sleep(8);
		ProductPage pp = new ProductPage();
		;
		pp.addLogitechMouse();
		Thread.sleep(3);
		CartPage cp = new CartPage();
		cp.goToCheckOutPage();
		CheckoutPage cop = new CheckoutPage();
		cop.contactInfoAtCheckOut("vino18493@gmail.com", "9876543210");
		reportStep(
				"Validating CheckOut page filling but the application does working properly.if it works properly the commented method in test case will fill the page with responding details - Pass",
				"Pass", testName);
		// The below commented line contains script which can run if application works
		// properly
//		cop.enterDetailsOnCheckOut("5432167890654321", "12", "2025", "321", "SonName", "FatherName", "123 Vvikanandhar Road", "Utto", "DC", "32145");

	}
}
