package crmframework.crmAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.AppLandingPage;
import pageObjects.CRMAccountsPage;
import pageObjects.CRMAddMarketingRelationshipOwner;
import pageObjects.CRMHomePage;
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import resources.base;

@Listeners({TestListeners.class})
public class AccountPageTest extends base {

	public WebDriverWait wait;
	public String accnameText;
	CRMLandingPage lap;
	CRMLoginPage lp;
	AppLandingPage alp;
	CRMHomePage hp;
	CRMAccountsPage ap;
	CRMIncentiveTab inc;
	CRMAddMarketingRelationshipOwner amro;
	Actions act;

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
	}

	@Test(priority=1)
	public void verifyCrmHomePage() throws IOException, InterruptedException {

		//The purpose of this test case to verify:-
		//TS1- Login to CRM Application and  Select published Apps (Demand Driver Management)

		driver.get(prop.getProperty("url")); //CRM App
		driver.manage().window().maximize();
		lap = new CRMLandingPage(driver);
		lap.getLogin().sendKeys(prop.getProperty("username"));
		lap.getnext().click();

		lp= new CRMLoginPage(driver);
		lp.getpwd().click();
		lp.getpwd().sendKeys(prop.getProperty("password"));
		lp.getsignin().click();
		//Wait to enter the verification code from Mobile
		Thread.sleep(30000);
		lp.getVerify().click();
		lp.getdontshowcheckbox().click();
		lp.getsigninYes().click();
		//to wait on Published App Landing page
		Thread.sleep(15000);
		driver.switchTo().frame("AppLandingPage");
		alp = new AppLandingPage(driver);
		//select Demand Driver application on Landing Page
		alp.getddm().click();

		hp = new CRMHomePage(driver);
		hp.getHometitle().isDisplayed();
		System.out.println("Login to CRM successfully");
	}

	@Test(priority=2)
	public void verifyCreateNewAccount() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS2- Create New Account

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
		//Select Accounts menu from left navigation bar
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();
		//Wait till Active Accounts page is displayed
		//new WebDriverWait (driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'New')]")));

		ap = new CRMAccountsPage(driver);
		//Thread.sleep(10000);
		//Click on 'New' button
		ap.getAccountNewbtn().click();
		//Wait till new account page is displayed
		//new WebDriverWait (driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='New Account']")));

		//Fill all the mandatory fields to create new account
		//Enter Account Name
		WebElement accountName = driver.findElement(By.xpath("//input[@id='id-276390f9-8bbf-4452-8f24-636b0ccaee2c-1-name8-name.fieldControl-text-box-text']"));
		accountName.click();
		accnameText = "Cyb_POC";
		accountName.sendKeys(accnameText);

		//Enter Phone no.
		ap.getPhone().click();
		ap.getPhone().sendKeys(prop.getProperty("phone"));
		//Thread.sleep(5000);

		//Scroll up the page till Address field
		act = new Actions(driver);
		act.moveToElement(ap.getAddress()).perform();

		//Select account type
		ap.getAccTypetxtbx().click();
		ap.getAcctypeExpandbtn().click();
		ap.getAccType().click();
		ap.getAddress().click();

		//Scroll down on the page
		act.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
		act.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).release().perform();

		Thread.sleep(5000);
		//Enter Street1 address
		ap.getStreet1().sendKeys(prop.getProperty("street1"));

		//Enter City
		ap.getCity().click();
		ap.getCity().sendKeys(prop.getProperty("city"));

		//Enter state
		ap.getState().click();
		ap.getState().sendKeys(prop.getProperty("state"));

		//Enter zipcode
		ap.getZipcode().click();
		ap.getZipcode().sendKeys(prop.getProperty("zipcode"));

		//Enter country
		ap.getCountrytxbx().click();
		ap.getCountrydrpbtn().click();
		ap.getCountryName().click();

		//Click on Save and Close button
		ap.getAccSaveCloseBtn().click();
		//Wait till Active Accounts page is displayed
		//new WebDriverWait (driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Active Accounts']")));

		//Verify the newly created account
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(accnameText);
		hp.getstartsearch().click();
		Thread.sleep(10000);
		WebElement validateAccName = driver.findElement(By.xpath("//a[contains(text(),'"+accnameText+"')]"));
		System.out.println(validateAccName.getText());
		Assert.assertTrue(validateAccName.isDisplayed());
		System.out.println("New Account is created successfully");
		//		else {
		//			System.out.println("Failed to create a new account");
		//		}
		//Clear the search term to navigate to active accounts page
		hp.getClearSearch().click();
	}

	@Test(priority=3)
	public void verifyAddTimelineToAccount() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS7- Select any account and add Timeline

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap.getCLetterFilterLink().click();	

		//Select the account name in list
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//Click on create a timeline button
		ap.getAddTimelineBtn().click();
		ap.getApptmntActivityOptn().click();

		ap.getTimelineSujecttxbx().click();
		String subtext = "Cyb_ApptJan";
		ap.getTimelineSujecttxbx().sendKeys(subtext);

		ap.getTimelineSavenClosebtn().click();

		//Verify that added Timeline is reflected correctly
		WebElement timeline = driver.findElement(By.xpath("//*[text()='"+subtext+"']"));
		Assert.assertEquals(timeline.getText(), subtext);

		//Verify that expected Success message displayed
		Assert.assertEquals("Your changes were saved.", ap.getSuccessMsg().getText());

		//Navigate back to Active accounts list
		ap.getAccPageBackBtn().click();
	}

	@Test(priority=4)
	public void verifyAddIncentiveToAccount() throws InterruptedException {

		//The purpose of this test case to verify:-
		//TS4-Select any existing Account and add Incentive

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		ap.getAllFilterLink().click();
		//Thread.sleep(3000);

		// Search Account Name
		hp.getSearchAccountField().sendKeys("Cyb_QATest");
		hp.getstartsearch().click();
		//Thread.sleep(10000);

		inc = new CRMIncentiveTab(driver);
		// Open Account
		inc.accname().click();
		ap.getAccNaviagteBtn().click();
		//Thread.sleep(10000);

		// Click Incentives tab at existing account
		inc.getinctab().click();

		// Open New Incentive Form
		inc.getnewinc().click();

		// Select Contact at New Incentive Form
		inc.getconclick().click();
		inc.getconsearch().click();
		inc.getconselect().click();

		// Select Market at New Incentive Form
		inc.getmarclick().click();
		inc.getmarsearch().click();
		inc.getmarselect().click();

		// Select Referral Source at New Incentive Form
		inc.getrefclick().click();
		inc.getrefsearch().click();
		inc.getrefselect().click();

		// Enter Other Incentive Source at New Incentive Form
		inc.getosclick().click();
		inc.getosvalue().sendKeys("None");

		// Save and Close Incentive
		inc.getincsave().click();
		Thread.sleep(15000);
		// Incentive Verification
		if (inc.accname().getText().contains("Cyb") && inc.conname().getText().contains("Test") && inc.marname().getText().contains("Jan"))
		{
			System.out.println ("Incentive added successfully.");
		}
		else
		{
			System.out.println ("Incentive not added.");
		}

		//Navigate back to Active accounts list
		ap.getAccPageBackBtn().click();
		//Thread.sleep(3000);

		//Clear the search term
		hp.getClearSearch().click();
	}

	@Test(priority=5)
	public void verifyAddIncentiveDetailsToAccount() throws InterruptedException
	{
		//The purpose of this test case to verify :-
		//TS5- Select any existing Account and add Incentive Details

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap.getCLetterFilterLink().click();
		//Thread.sleep(4000);	

		//Select the account name in list
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		inc = new CRMIncentiveTab(driver);
		//Select 'Incentives' tab
		inc.getinctab().click();

		//Click on 'New Incentive Details' button
		inc.getIncDetaills().click();

		//Enter the data in Incentive field 
		inc.getInctxtbx().click();
		inc.getInctxtbx().sendKeys(Keys.ENTER); 

		inc.getIncChangeView().click();
		inc.getIncActiveIncs().click();
		//Thread.sleep(2000);
		inc.getIncName().click();

		//Enter the data in Incentive Category field
		inc.getIncCattxtbx().click();
		inc.getIncCattxtbx().sendKeys(prop.getProperty("incentivecategory"));
		inc.getIncCatSearch().click();
		String IncCatagtitle = inc.getIncCatName().getText();
		inc.getIncCatName().click();
		inc.getIncDetailsSavenClose().click();
		//Thread.sleep(5000);

		//Verify that added Incentive details are reflected correctly
		if ((inc.getValidateIncName().getText()).contains(IncCatagtitle)) {
			System.out.println("Incentive details get added successfully");
		}
		else {
			System.out.println("Fails to add Incentive Details");
		}

		//Verify that expected Success message displayed
		//Thread.sleep(3000);
		System.out.println(inc.getIncdtlsSuccessMsg().getText());
		Assert.assertEquals("Your changes were saved.", inc.getIncdtlsSuccessMsg().getText());

		ap = new CRMAccountsPage(driver);
		//Navigate back to Active accounts list
		ap.getAccPageBackBtn().click();
		//Thread.sleep(3000);
	}

	@Test(priority=6)
	public void verifyRelatedTabOnAccount() throws InterruptedException {

		//The purpose of this test case to verify :-
		//Select any existing account and Verify Related Tab Functionality 

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap.getCLetterFilterLink().click();
		//Thread.sleep(4000);	

		//Select the account name in list
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();
		//Thread.sleep(5000);
		//click on Related Tab and select Activities option from list. 
		ap.getRelatedTab().click();
		ap.getSelectActivitiesRelated().click();
		//Thread.sleep(5000);
		Boolean displayActivityTab = ap.getActivityTab().isDisplayed();
		System.out.println("Activities Tab Opened successfully:"+displayActivityTab);

		//Navigate back to Active accounts list
		ap.getAccPageBackBtn().click();				
		//Thread.sleep(3000);
	}

	@Test(priority=7)
	public void verifyAddMarketingRelationshipOwnerToAccount() throws InterruptedException {

		//The purpose of this test case to verify:-
		//TS8- Add relationship manager to account

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);

		//Navigate to Accounts under Demand Driver in left menu
		hp.getAccountTab().click();

		//Select and open an active account on the Accounts grid view
		ap.getCLetterFilterLink().click();
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		amro = new CRMAddMarketingRelationshipOwner(driver);
		// Click arrow to open marketing relationship window
		amro.gethdbtn().click();

		//Click on Marketing Relationship Owner field search icon  to select a user from lookup
		amro.getmarlookupsearch().click();

		//Select a user entity from the Marketing Relationship Owner lookup
		WebElement marowner = amro.getOwner();
		String ownertxt =marowner.getText();
		System.out.println(ownertxt);
		marowner.click();

		// Save selected marketing relationship owner
		amro.getmarownersave().click();	

		//Scroll up the page till Address field
		act = new Actions(driver);
		act.moveToElement(ap.getAddress()).perform();

		//Verify Marketing Relationship Owner lookup value in Account Information section in the Summary tab
		WebElement verifyOwner = amro.getmarownerverify();
		Assert.assertTrue(verifyOwner.getText().contains(ownertxt));
		System.out.println("Marketing Relationship Owner get added successfully");
		//Navigate back to Active accounts list
		ap.getAccPageBackBtn().click();
	}

	@Test(priority=8)
	public void verifySearchAccount() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS3- Search any existing Account by Account DBA Name

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);

		hp.getAccountTab().click();	
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(accnameText);
		hp.getstartsearch().click();
		//Thread.sleep(10000);
		WebElement validateAccName = driver.findElement(By.xpath("//a[contains(text(),'"+accnameText+"')]"));
		Boolean checkvalidateAccName = validateAccName.isDisplayed();

		Assert.assertTrue(checkvalidateAccName);
		System.out.println("New Account searched");
		//Clear the search term to navigate to active accounts page
		hp.getClearSearch().click();
	}

	@Test(priority=9)
	public void verifyDeactivateAccount() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS9- Select any existing Account and deactivate it

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);

		hp.getAccountTab().click();
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(accnameText);
		hp.getstartsearch().click();
		//Thread.sleep(10000);

		WebElement validateAccName = driver.findElement(By.xpath("//a[contains(text(),'"+accnameText+"')]"));
		validateAccName.click();
		ap.getAccNaviagteBtn().click();
		//Thread.sleep(10000);
		//Click on Deactivate button
		ap.getDeactivateBtn().click();

		//Click on 'Deactivate button of confirmation pop-up
		ap.getDeactivateOkBtn().click();
		Assert.assertTrue(ap.getActivateBtn().isDisplayed());

		//Navigate back to Active accounts page
		ap.getAccPageBackBtn().click();

		//Click on 'Active Accounts' drop-down view button
		ap.getActiveAccDropDownBtn().click();

		//Select 'Inactive Accounts' option
		ap.getInactiveAccOptn().click();

		//Thread.sleep(6000);
		//Click on 'A' link to sort accounts starts with 'A'
		try {
			ap.getCLetterFilterLink().click();
			//Thread.sleep(3000);

			//Validate deactivated account
			hp.getSearchAccountField().click();
			hp.getSearchAccountField().sendKeys(accnameText);
			hp.getstartsearch().click();
			//Thread.sleep(10000);
			Assert.assertTrue(ap.getValidateInactiveAccName().isDisplayed());
		}
		catch (StaleElementReferenceException exe) {
			System.out.println(exe.getMessage());
		}
		catch (IllegalArgumentException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
