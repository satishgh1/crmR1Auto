package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMContactPage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	By scrolltoaddcontact = By.xpath("//h2[@data-id = 'form-sectionHeader-SUMMARY_TAB_column_3_section_1']");
	By clicknewcontactbutton = By.xpath("//button[@aria-label = 'New Contact']");
	By firstname = By.xpath("//input[@aria-label = 'First Name']");
	By lastname = By.xpath("//input[@aria-label = 'Last Name']");
	By email = By.xpath("//input[@aria-label = 'Email']");
	By mobile = By.xpath("//input[@aria-label = 'Mobile Phone']");
	By scrolltocontactaddress = By.xpath("//h2[@data-id = 'form-sectionHeader-SUMMARY_TAB_section_4']");
	By street1 = By.xpath("//input[@aria-label = 'Street 1']");
	By city = By.xpath("//input[@aria-label = 'City']");
	By stateorprovince = By.xpath("//input[@aria-label = 'State/Province']");
	By ziporpostalcode = By.xpath("//input[@aria-label = 'ZIP/Postal Code']");
	By country = By.xpath("//input[@aria-label = 'Country']");
	By clicklistbox = By.xpath("//div[@class = 'wj-listbox-item']");
	By savecontact = By.xpath("//button[@aria-label = 'Save & Close']");
	By verifycontact = By.xpath("//div[@aria-label = 'Active Contacts Account Subgrid']");
	By contactformemailtxtfield = By.xpath("//input[@data-id='emailaddress1.fieldControl-mail-text-input']");
	By contactformbusinessphonetxtfield = By.xpath("//input[@aria-describedby='id-fd46b725-b6a7-47e9-b1d0-6f99bbc77f32-10-telephone16-telephone1.fieldControl-InputMaskControl-description']");

	
	public CRMContactPage(WebDriver driver) {

		this.driver = driver;
	}
	
	public WebElement getscrolltoaddcontact() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(scrolltoaddcontact));
		return driver.findElement(scrolltoaddcontact);
	}
	
	public WebElement getclicknewcontactbutton() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clicknewcontactbutton));
		return driver.findElement(clicknewcontactbutton);
	}

	public WebElement getfirstname() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(firstname));
	return driver.findElement(firstname);
	}

	public WebElement getlastname() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(lastname));
	return driver.findElement(lastname);
	}

	public WebElement getmobile() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(mobile));
	return driver.findElement(mobile);
	}
	
	public WebElement getscrolltocontactaddress() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(scrolltocontactaddress));
		return driver.findElement(scrolltocontactaddress);
	}
	
	public WebElement getemail() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(email));
		return driver.findElement(email);
	}
	
	public WebElement getstreet1() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(street1));
		return driver.findElement(street1);
	}
	
	public WebElement getcity() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(city));
		return driver.findElement(city);
	}
	
	public WebElement getstateorprovince() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(stateorprovince));
		return driver.findElement(stateorprovince);
	}

	public WebElement getziporpostalcode() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(ziporpostalcode));
	return driver.findElement(ziporpostalcode);
	}

	public WebElement getcountry() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(country));
	return driver.findElement(country);
	}

	public WebElement getclicklistbox() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(clicklistbox));
	return driver.findElement(clicklistbox);
	}

	public WebElement getsavecontact() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(savecontact));
	return driver.findElement(savecontact);
	}
	
	public WebElement getverifycontact() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(verifycontact));
		return driver.findElement(verifycontact);
		}
	public WebElement getContactFormEmailField() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactformemailtxtfield));
		return driver.findElement(contactformemailtxtfield);
	}

	public WebElement getContactFormBusinessPhoneField() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactformbusinessphonetxtfield));
		return driver.findElement(contactformbusinessphonetxtfield);
	}
}
