package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import base.ProjectSpecificationMethod;
import pages.CartPage;
import pages.HomePage;
import pages.LocationPage;
import pages.ProductPage;

public class TC006_SearchAddItemInCart extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {

		testName = "TC006_SearchAddItemInCart";
		testDescription = "Search a Item in search box and add it in cart";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
	}

	@Test(priority = 7)
	public void tc_06_SearchAddItemInCart() throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		hp.searchProduct("Mouse");
		ProductPage pp = new ProductPage();
		String prodTitleAtProductPage = pp.addLogitechMouse();
		CartPage cp = new CartPage();
		String prodTitleAtCartPage = cp.validateLogitechMouseInCart();
		softAssert(prodTitleAtProductPage, prodTitleAtCartPage);
		if (prodTitleAtProductPage.equals(prodTitleAtCartPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}
}
