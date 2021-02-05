package crmframework.crmAutomation;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
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
import resources.GenerateData;
import resources.base;

@Listeners({TestListeners.class})
public class AccountPageTest extends base {

	public WebDriverWait wait;
	public String accnameText;
	public GenerateData genData;
	public String buysatCorplvl, outofbusiness;
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
		genData=new GenerateData();
	}

	@Test(priority=1)
	public void verifyCrmHomePage() throws IOException, InterruptedException {

		//The purpose of this test case to verify:-
		//TS1- Login to CRM Application and  Select published Apps (Demand Driver Management)

		driver.get(prop.getProperty("url")); //CRM App
		driver.manage().window().maximize();
		lap = new CRMLandingPage(driver);
		//lap.getLogin().sendKeys(prop.getProperty("username"));
		lap.getLogin().sendKeys(System.getenv("username"));
		lap.getnext().click();

		lp= new CRMLoginPage(driver);
		lp.getpwd().click();
		lp.getpwd().sendKeys(System.getenv("password"));
		//lp.getpwd().sendKeys(prop.getProperty("password"));/
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
		Thread.sleep(10000);
		//Click on 'New' button
		ap.getAccountNewbtn().click();
		//Wait till new account page is displayed
		//new WebDriverWait (driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@title='New Account']")));

		//Fill all the mandatory fields to create new account
		//Enter Account Name
		WebElement accountName = driver.findElement(By.xpath("//input[@id='id-276390f9-8bbf-4452-8f24-636b0ccaee2c-1-name8-name.fieldControl-text-box-text']"));
		accountName.click();
		/*		accnameText = "Cyb_POC";
		accountName.sendKeys(accnameText);*/

		//to create random generated account name
		accountName.sendKeys(genData.generateRandomAlphaNumeric(10));
		String accnameText= accountName.getAttribute("Value");
		System.out.println("Created Account"+accnameText);

		//Enter Random generated Phone no.
		/*		ap.getPhone().click();
		ap.getPhone().sendKeys(prop.getProperty("phone"));*/
		//Thread.sleep(5000);

		ap.getPhone().click();
		ap.getPhone().sendKeys(genData.generateRandomNumber(10));

		//Scroll up the page till Address field
		act = new Actions(driver);
		act.moveToElement(ap.getAddress()).perform();

		//Select account type
		ap.getAccTypetxtbx().click();
		ap.getAcctypeExpandbtn().click();
		ap.getAccTypeBuyer().click();
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
		String validateAccName = ap.getAccountNameSearchTable().getText();
		Assert.assertEquals(validateAccName, accnameText);
		System.out.println("Searched Account"+ validateAccName);

		/*WebElement validateAccName = driver.findElement(By.xpath("//a[contains(text(),'"+accnameText+"')]"));
		System.out.println(validateAccName.getText());
		Assert.assertTrue(validateAccName.isDisplayed());*/
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

		//Click on 'C' link to sort accounts starts with 'C'
		try {
			ap.getCLetterFilterLink().click();

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

	@Test(priority=10)
	public void verifyParentAccount() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T43- A new field 'Parent Account ' is available on the Account Form under 
		//ACCOUNT INFORMATION section and data values available in it.

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Select and open an active account on the Accounts grid view
		ap.getCLetterFilterLink().click();
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//Verify new field 'Parent Account ' is available on the account form
		Assert.assertTrue(ap.getParentAccLabel().isDisplayed());

		//Click on 'Search' button
		ap.getParentAccSearchBtn().click();

		//Click on 'Recent Records' link
		ap.getRecentRecordsLink().click();

		boolean staleElement = true;
		try {
			while(staleElement){
				//Select a parent account from lookup
				WebElement Parentaccfrmlist = ap.selectParentAccName();
				String selectedAccName = Parentaccfrmlist.getText();
				System.out.println("Expected Parent account name: " +selectedAccName);
				Parentaccfrmlist.click();

				//Verify that selected account is displayed as Parent Account value on account form
				WebElement Parentaccinform = ap.getParentAcctxbx();
				System.out.println("Actual Parent account name: " + Parentaccinform.getText());
				Assert.assertTrue(Parentaccinform.getText().contains(selectedAccName));

				//Click on Save & Close button
				ap.getAccSaveCloseBtn().click();
				staleElement = false;
			}
		}
		catch (StaleElementReferenceException exe) {
			staleElement = false;
			System.out.println(exe.getMessage());
		}
	}

	@Test(priority=11)
	public void verifyAccountStatusToActivateAccount() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T39- Account Status and Account Status Reason functionality for account activation

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Click on the select a view drop-down available below header
		ap.getActiveAccDropDownBtn().click();

		//Select 'Inactive Accounts' option
		ap.getInactiveAccOptn().click();

		boolean staleElement = true;
		try {
			while(staleElement){
				//Open any Inactive account from list
				ap.getCLetterFilterLink().click();
				ap.getAccountName().click();
				ap.getAccNaviagteBtn().click();

				//Click 'Activate' button available in the top panel
				ap.getActivateBtn().click();

				//Select 'Account Status: Buys at Corporate Level' in the confirm Account Activation pop-up
				ap.getActivatePopupStatusField().click();
				WebElement buysatcorplevelstatus = ap.getAccStatusBuysatCorpLevel();
				buysatCorplvl = ap.getAccStatusBuysatCorpLevel().getText();
				System.out.println("Account Status: " + buysatCorplvl);
				buysatcorplevelstatus.click();

				//Click on 'Activate' button
				ap.getActivatePopupActivatebtn();
				staleElement = false;
			}
		}
		catch (StaleElementReferenceException exe) {
			staleElement = false;
			System.out.println(exe.getMessage());
		}
		catch (WebDriverException ex) {
			System.out.println(ex.getMessage());
		}
		
		//Verify that Account is activated and selected account Status Reason is displayed at the right side of the header.
		WebElement accstatusreasoninheader = ap.getAccStatusReson();
		System.out.println("Account Status Reason: " + (accstatusreasoninheader.getText()));
		Assert.assertTrue(accstatusreasoninheader.getText().contains(buysatCorplvl));

		//Verify that Top ribbon 'Activate' option changes to 'Deactivate'
		Assert.assertTrue(ap.getDeactivateBtn().isDisplayed());

		//Click on Save & Close button
		ap.getAccSaveCloseBtn().click();
	}
	
	@Test(priority=12)
	public void verifyAccountStatusToDeactivateAccount() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T40- Account Status and Account Status Reason functionality for account deactivation

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		boolean staleElement = true;
		try {
			while(staleElement){
				//Open any Active account from list
				ap.getCLetterFilterLink().click();
				ap.getAccountName().click();
				ap.getAccNaviagteBtn().click();

				//Click 'Deactivate' button available in the top panel
				ap.getDeactivateBtn().click();

				//Select 'Account Status: Out of Business' in the confirm Account Deactivation pop-up
				ap.getActivatePopupStatusField().click();
				WebElement outofbusinessstatus = ap.getAccStatusOutofBusiness();
				outofbusiness = ap.getAccStatusOutofBusiness().getText();
				System.out.println("Account Status: " + outofbusiness);
				outofbusinessstatus.click();

				//Click on 'Deactivate' button
				ap.getDeactivatePopupDeactivatebtn();
				staleElement = false;
			}
		}
		catch (StaleElementReferenceException exe) {
			staleElement = false;
			System.out.println(exe.getMessage());
		}
		catch (WebDriverException ex) {
			System.out.println(ex.getMessage());
		}
		
		//Verify that Account is deactivated and selected account status reason is displayed at the right side of the header.
		WebElement statusreasonforinactiveaccinheader = ap.getAccStatusResonForInactiveAcc();
		System.out.println("Account Status Reason: " + (statusreasonforinactiveaccinheader.getText()));
		Assert.assertTrue(statusreasonforinactiveaccinheader.getText().contains(outofbusiness));

		//Verify that Top ribbon 'Deactivate' option changes to 'Activate'
		Assert.assertTrue(ap.getActivateBtn().isDisplayed());

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}

	@Test(priority=13)
	public void verifyMediaSegmentationField() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T29- Media Segmentation drop-down field is visible on Account form only if Type equal to 'Media' is selected

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Click on 'New' button to open new Account Form
		ap.getAccountNewbtn().click();

		//Scroll up the page till Address field
		act = new Actions(driver);
		act.moveToElement(ap.getAddress()).perform();

		//Select account Type as 'Media' in Account information section
		ap.getAccTypetxtbx().click();
		ap.getAcctypeExpandbtn().click();
		ap.getAccTypeMedia().click();
		ap.getAddress().click();

		//Verify that 'Media Segmentation' and 'Media Type' fields are displayed
		List<WebElement> mediasegmentnlabel = ap.getMediaSegmentationFieldLabel();
		Assert.assertTrue(mediasegmentnlabel.size()!= 0);

		List<WebElement> mediatypelabel = ap.getMediaTypeFieldLabel();
		Assert.assertTrue(mediatypelabel.size()!= 0);

		//Click on 'Media Segmentation' drop down
		ap.getMediaSegmentationDropdown().click();
		//Select a value in Media Segmentation (Las Vegas Local)
		ap.getMediaSegmentationName().click();

		//Click on Media Type drop down
		ap.getMediaTypeDropdown().click();
		//Select any value in Media Type field
		ap.getMediaTypeName().click();

		//Update the account Type as 'Buyer' 
		ap.getAccTypeSelectedValueTxtbx().click();
		ap.getRemoveAccTypeMediaBtn().click();
		ap.getAcctypeExpandbtn().click();
		ap.getAccTypeBuyer().click();
		ap.getNewAccountHeader().click();

		//Verify that Media Segmentation and Media Type fields should be disappeared from the new account form
		List<WebElement> mediasegmentnlabel1 = ap.getMediaSegmentationFieldLabel();
		Assert.assertFalse(mediasegmentnlabel1.size()!= 0);
		
		List<WebElement> mediatypelabel1 = ap.getMediaTypeFieldLabel();
		Assert.assertFalse(mediatypelabel1.size()!= 0);

		//Navigate back to Active accounts list

		ap.getPageBackBtn().click();
		ap.getDiscardChangesBtn().click();
	}
	
	@Test(priority=14)
	public void verifyAddNoteToAccount() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//T98- Select any account and add Note to account

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap.getCLetterFilterLink().click();	

		//Select the account name in list
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//Click on create a timeline button and select Note option
		ap.getAddTimelineBtn().click();
		ap.getNoteTimelineOptn().click();
		
		ap.getNoteTitleTextbox().click();
		String subjectnote = "Cyb_Note";
		ap.getNoteTitleTextbox().sendKeys(subjectnote);
		Thread.sleep(15000);
		/*ap.getNoteiframe().click();
		ap.getNoteiframe().sendKeys(genData.generateRandomString(25));
		driver.switchTo().frame(ap.getNoteiframe());
		ap.getNoteTextEnter().click();
		ap.getNoteTextEnter().sendKeys(genData.generateRandomString(25));*/
		ap.getAddNoteButton().click();
		
		//to scroll down
		act = new Actions(driver);
		act.moveToElement(ap.getViewCreatedNote()).perform();
		
		String validateNoteSubject = ap.getViewCreatedNote().getText();
		Assert.assertEquals(validateNoteSubject, subjectnote);
		System.out.println("Note title is: "+ validateNoteSubject);
		Thread.sleep(10000);
		ap.getTimelineDetails().click();
		ap.getDeleteNote().click();
		ap.getOkConfirmBtn().click();
		System.out.println("Note Deleted");
		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}
	
	@Test(priority=15)
	public void verifyAddNewPostToAccount() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//T299- Select any account and add Post to account

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap.getCLetterFilterLink().click();	

		//Select the account name in list
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();
		
		//Click on create a timeline button and select Note option
		ap.getAddTimelineBtn().click();
		ap.getPostTimelineOptn().click();
		ap.getPostTextEnter().click();
		ap.getPostTextEnter().sendKeys(genData.generateRandomString(25));
		String postText= ap.getPostTextEnter().getAttribute("title");
		System.out.println("Created Post: "+postText);
		ap.getPostAddButton().click();
		String validatePostText = ap.getViewCreatedPost().getText();
		System.out.println("Viewed Post is: "+ validatePostText);
		Assert.assertEquals(validatePostText, postText);
		ap.getTimelineDetails().click();
		ap.getDeletePost().click();
		ap.getOkConfirmBtn().click();
		System.out.println("Post Deleted.");
		ap.getPageBackBtn().click();
	}

	@Test(priority=16)
	public void verifyAuditHistoryTabOnAccount() throws InterruptedException {

		//The purpose of this test case to verify :-
		//T300: Select any existing account and click on Audit History Tab Functionality 

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
		ap.getAuditHistoryRelatedTab().click();
		//Thread.sleep(5000);
		Boolean displayAuditHistoryTab = ap.getAuditHistoryTab().isDisplayed();
		System.out.println("Activities Tab Opened successfully:"+displayAuditHistoryTab);
		
		String validateAuditHistoryTab = ap.getAuditHistoryTab().getText();
		Assert.assertEquals(validateAuditHistoryTab, "Audit History");
		
		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
		
	}

	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
