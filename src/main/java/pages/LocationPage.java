package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class LocationPage extends ProjectSpecificationMethod {

	@FindBy(className = "us-link")
	WebElement countryUSA;

	@FindBy(className = "canada-link")
	WebElement countryCanada;

	public LocationPage() {
		PageFactory.initElements(driver, this);
	}

	public void deliveryAtUSA() {
		clickOn(countryUSA);
	}

	public void deliveryAtCanada() {
		clickOn(countryCanada);
	}

	public String bestBuyPageTitle() throws Exception {
		return getPageTitle();
	}

	public int urlResponseCode() throws Exception {
		return getResponseCode(readProperty("url"));
	}

}
