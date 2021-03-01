package crmframework.crmAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
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
import pageObjects.CRMContactPage;
import pageObjects.CRMHomePage;
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import resources.GenerateData;
import resources.base;

@Listeners({TestListeners.class})
public class OtherTest extends base{
	
	public WebDriverWait wait;
	public String accnameText;
	public String phoneno;
	public GenerateData genData;
	public String buysatCorplvl, outofbusiness;
	public String ContactFirstName;
	public String ContactLastName;
	CRMLandingPage lap;
	CRMLoginPage lp;
	AppLandingPage alp;
	CRMHomePage hp;
	CRMAccountsPage ap;
	CRMIncentiveTab inc;
	CRMAddMarketingRelationshipOwner amro;
	Actions act;
	CRMContactPage cp;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		genData=new GenerateData();
	}
	
	@Test(priority=1)
	public void TS001_VerifyAddIncentiveToAccountTest() throws InterruptedException {

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

	@Test(priority=2)
	public void TS002_VerifyAddIncentiveDetailsToAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify :-
		//TS36- Select any existing Account and add Incentive Details

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

	@Test(priority=3)
	public void TS003_VerifyRelatedTabOnAccountTest() throws InterruptedException {

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
		ap.getPageBackBtn().click();			
		//Thread.sleep(3000);
	}
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}

}
