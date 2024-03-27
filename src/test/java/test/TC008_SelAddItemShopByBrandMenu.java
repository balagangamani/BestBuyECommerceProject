package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import base.ProjectSpecificationMethod;
import pages.CartPage;
import pages.HomePage;
import pages.LocationPage;
import pages.ProductPage;

public class TC008_SelAddItemShopByBrandMenu extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {

		testName = "TC008_SelAddItemShopByBrandMenu";
		testDescription = "Search a Item by Brands in Menu and add it in cart";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
	}

	@Test(priority = 9)
	public void tc_08_selAddItemShopByBrandMenu() throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		hp.selectLenovoBrand();
		ProductPage pp = new ProductPage();
		String lenovoThinkPadTitleAtProdPage = pp.addLenovoThinkPadInProdPage();
		hp.goToCartPage();
		CartPage cp = new CartPage();
		String lenovoThinkPadTitleAtCartPage = cp.validateLenovoThinkPadInCart();
		softAssert(lenovoThinkPadTitleAtCartPage, lenovoThinkPadTitleAtProdPage);
		if (lenovoThinkPadTitleAtCartPage.equals(lenovoThinkPadTitleAtProdPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}
}
