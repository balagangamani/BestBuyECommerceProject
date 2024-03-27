package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import base.ProjectSpecificationMethod;
import pages.CartPage;
import pages.HomePage;
import pages.LocationPage;
import pages.ProductPage;

public class TC007_SelAddItemShopByDeptMenu extends ProjectSpecificationMethod {

	@BeforeTest
	public void setup() {

		testName = "TC007_SelAddItemShopByDeptMenu";
		testDescription = "Search a Item by Department in Menu and add it in cart";
		testCategory = "Regression";
		testAuthor = "Bala Gangamani";
	}

	@Test(priority = 8)
	public void tc_07_selAddItemShopByDeptMenu() throws Exception {
		LocationPage lp = new LocationPage();
		lp.deliveryAtUSA();
		HomePage hp = new HomePage();
		hp.selectTvMenuInHomePage();
		ProductPage pp = new ProductPage();
		String sony75TitleAtProdPage = pp.addSony75InchTVInProdPageM2();// pp.addSony75InchTVInProdPage()
		hp.goToCartPage();
		CartPage cp = new CartPage();
		String sony75TitleAtCartPage = cp.validateSonyTvInCart();
		softAssert(sony75TitleAtCartPage, sony75TitleAtProdPage);
		if (sony75TitleAtCartPage.equals(sony75TitleAtProdPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}
}
