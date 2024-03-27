package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class CartPage extends ProjectSpecificationMethod {

	@FindBy(xpath = "//a[contains(text(),'Logitech - G502 Lightspeed Wireless Optical Gaming Mouse with RGB Lighting - Black')]")
	WebElement logitechMouseAddedInCart;

	@FindBy(xpath = "//a[contains(text(),'Sony - 75\" Class BRAVIA XR X90K 4K HDR Full Array LED Google TV')]")
	WebElement sony75InchTvAddedInCart;

	@FindBy(xpath = "//a[contains(text(),'Lenovo - ThinkPad E15')]")
	WebElement lenovoThinkPadAddedInCart;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOutInCart;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLogitechMouseInCart() {
		return extractText(logitechMouseAddedInCart);
	}

	public String validateSonyTvInCart() {
		return extractText(sony75InchTvAddedInCart);
	}

	public String validateLenovoThinkPadInCart() {
		return extractText(lenovoThinkPadAddedInCart);
	}

	public void goToCheckOutPage() {
		clickOn(checkOutInCart);
	}

}
