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
	By marlookupclick = By.xpath("//input[@data-id = 'header_xxc_marketingrelationshipownerid.fieldControl-LookupResultsDropdown_xxc_marketingrelationshipownerid_textInputBox_with_filter_new']");
	By marlookupsearch = By.xpath("//span[@data-id='header_xxc_marketingrelationshipownerid.fieldControl-Lookup_xxc_marketingrelationshipownerid_microsoftIcon_searchButton']");
	By marlookupselect = By.xpath("//div[@data-id = 'header_xxc_marketingrelaionshipownerid.fieldControl-LookupResultsDropdown_xxc_marketingrelationshipownerid_infoContainer']");
	
	// Save account after selecting marketing relationship owner
	
	By marownersave = By.xpath("//button[@data-id = 'account|NoRelationship|Form|Mscrm.Form.account.Save']");
	
	// Verify marketing relationship owner added at Summary tab for account
	
	By marownerverify = By.xpath("//div[@data-id = 'xxc_marketingrelationshipownerid.fieldControl-LookupResultsDropdown_xxc_marketingrelationshipownerid_selected_tag_text']");
	
	public CRMAddMarketingRelationshipOwner (WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement gethdbtn() {
		
		return driver.findElement(hdbtn);
	}
	
	public WebElement getmarlookupclick() {
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marlookupclick));
		return driver.findElement(marlookupclick);
	}
	
	public WebElement getmarlookupsearch() {
		
		return driver.findElement(marlookupsearch);
	}
	
	public WebElement getmarlookupselect() {
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marlookupselect));
		return (WebElement) driver.findElements(marlookupselect);
	}
	
	public WebElement getmarownersave() {
		
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marownersave));
		return driver.findElement(marownersave);
	}
	
	public WebElement getmarownerverify() {
		
		return driver.findElement(marownerverify);
	}

}
