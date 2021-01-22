package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMAddMarketingRelationshipOwner {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	// Select Marketing Relationship Owner
	By hdbtn = By.xpath("//button[@data-id = 'header_overflowButton']");
	By marlookupsearch = By.xpath("//span[@data-id='header_xxc_marketingrelationshipownerid.fieldControl-Lookup_xxc_marketingrelationshipownerid_microsoftIcon_searchButton']");
	
	// Save account after selecting marketing relationship owner
	By marownersave = By.xpath("//button[@data-id = 'account|NoRelationship|Form|Mscrm.Form.account.Save']");
	
	// Verify marketing relationship owner added at Summary tab for account
	By marownerverify = By.xpath("//div[@data-lp-id='MscrmControls.FieldControls.SimpleLookupControl|xxc_marketingrelationshipownerid.fieldControl|account']");

	By owner = By.xpath("//span[@data-id='header_xxc_marketingrelationshipownerid.fieldControl-fullname0_0_1']");

	public CRMAddMarketingRelationshipOwner (WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement gethdbtn() {
		
		return driver.findElement(hdbtn);
	}
	
	public WebElement getmarlookupsearch() {
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marlookupsearch));
		return driver.findElement(marlookupsearch);
	}
	
	public WebElement getmarownersave() {
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marownersave));
		return driver.findElement(marownersave);
	}
	
	public WebElement getmarownerverify() {
		
		return driver.findElement(marownerverify);
	}
	
	public WebElement getOwner() {

		return driver.findElement(owner);
	}

}
