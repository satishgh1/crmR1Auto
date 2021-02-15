package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMAccountsPage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	By accountnewbtn = By.xpath("//span[contains(text(),'New')]");
	By accountNametxtbx = By.xpath("//input[@id='id-276390f9-8bbf-4452-8f24-636b0ccaee2c-1-name8-name.fieldControl-text-box-text']");
	By accountnamesearchtable= By.xpath("//div[@data-id='cell-0-2']");
	By phn = By.xpath("//input[@aria-label='Phone']");		
	By address = By.xpath("//h2[contains(text(),'Address')]");
	By acctypetxtbx = By.xpath("//input[@id='xxc_typecode_ledit']");
	By acctypeexpandbtn = By.xpath("//button[@aria-label='Toggle menu']");
	By acctypebuyer = By.xpath("//div[contains(text(),'Buyer')]");
	By street1 = By.xpath("//input[@aria-label='Street 1']");
	By state = By.xpath("//input[@aria-label='State/Province']");
	By countrytxtbx = By.xpath("//input[@aria-label='Country']");
	By city = By.xpath("//input[@aria-label='City']");
	By zip = By.xpath("//input[@aria-label='ZIP/Postal Code']");
	By cntryexpandbtn = By.xpath("//button[@aria-label='Toggle Dropdown']");
	By countryname = By.xpath("//body/div[@id='_dropdown']/div[3]");
	By accsavenclosebtn = By.xpath("//button[@aria-label='Save & Close']");
	By cletterfilterlink = By.xpath("//a[@id='F_link']");
	By accountname = By.xpath("//div[@data-id='cell-2-2']");
	By addtimelinebtn = By.xpath("//button[@aria-label='Create a timeline record.']");
	By appointmentactivityoptn = By.xpath("//li[@aria-label='Appointment Activity']");
	By timelinesubjecttxtbx = By.xpath("//input[@aria-label='Subject']");
	By timelinesavenclosebtn = By.xpath("//button[@data-id='quickCreateSaveAndCloseBtn']");
	By successmsg = By.xpath("//span[@data-id='notification-message']");
	By accpagebackbtn = By.xpath("//span[@class='symbolFont BackButton-symbol pa-ak ']");
	By relatedTab = By.xpath("//li[@title='Related']");
	By activitiesRelatedTab = By.xpath("//span[@id='navActivities_Related']"); // added xpath for activities option at Related Dropdown list
	By activityTab = By.xpath("//li[@title='Activities']");  // added xpath for activity tab
	By allfilterlink = By.xpath("//a[@id='All_link']");
	By deactivateaccname = By.xpath("//div[@data-id='cell-1-2']");
	By deactivatebtn = By.xpath("//button[@aria-label='Deactivate']");
	By deactivateokbtn = By.xpath("//button[@data-id='ok_id']");
	By activatebtn = By.xpath("//button[@aria-label='Activate']");
	By accdropdownbtn = By.xpath("//span[@class='symbolFont ChevronDownMed-symbol  ']");
	By inactiveacctsoptn = By.xpath("//*[text()='Inactive Accounts']");
	By validateInactiveAcc = By.xpath("//div[@data-id='cell-0-2']");
	By accnaviagtebtn = By.xpath("//button[contains(@title, 'Navigate to') and contains(@class ,'cc-ds-rowbtn cc-gridcell-navigable wj-btn wj-btn-default cc-ds-rowbtn-nav')]");
	By parentacclabel = By.xpath("//label[contains(text(),'Parent Account')]");
	By parentacctxtbx = By.xpath("//div[@data-lp-id='MscrmControls.FieldControls.SimpleLookupControl|parentaccountid.fieldControl|account']");
	By parentaccsearchbtn = By.xpath("//button[@aria-label='Search records for Parent Account, Lookup field']");
	By selectparentacc = By.xpath("//span[@id='id-276390f9-8bbf-4452-8f24-636b0ccaee2c-4-parentaccountid6-parentaccountid.fieldControl-LookupResultsDropdown_parentaccountid_0_resultsLabel_0_0']");
	By recentrecordslink = By.xpath("//button[contains(text(),'Recent records')]");
	By accsavebtn = By.xpath("//button[@aria-label='Save']");
	By activatepopupstatusfield = By.xpath("//select[@aria-label='Status']");
	By accstatusbuysatcorplevel = By.xpath("//option[contains(text(),'Buys at Corporate Level')]");
	By activatepopupactivatebtn = By.xpath("//button[@data-id='ok_id']");
	By accstatusreason = By.xpath("//div[@data-lp-id='MscrmControls.FieldControls.PicklistStatusControl|header_statuscode.fieldControl|account']");
	By activeaccountslabel = By.xpath("//h1[@aria-label='Active Accounts']");
	By inactiveaccountslabel = By.xpath("//h1[@aria-label='Inactive Accounts']");
	By statusreasonbuysatcorplevelinheader = By.xpath("//div[@title='Buys at Corporate Level']");
	By pageno = By.xpath("//span[@title='Current page']");
	By accstatusoutofbusiness = By.xpath("//option[contains(text(),'Out of Business')]");
	By deactivatepopupdeactivatebtn = By.xpath("//button[@data-id='ok_id']");
	By statusreasonoutofbusinessinheader = By.xpath("//div[@title='Out of Business']");
	By backbtn = By.xpath("//span[@class='symbolFont BackButton-symbol pa-ah ']");
	By acctypemedia = By.xpath("//div[contains(text(),'Media')]");
	By mediasegmentationfieldlabel = By.xpath("//label[contains(text(),'Media Segmentation')]");
	By mediatypefieldlabel = By.xpath("//label[contains(text(),'Media Type')]");
	By mediasegmentationdrpdown = By.xpath("//select[@aria-label='Media Segmentation']");
	By mediasegmentationname = By.xpath("//option[contains(text(),'Las Vegas Local')]");
	By mediatypedrpdown = By.xpath("//select[@aria-label='Media Type']");
	By mediatypename = By.xpath("//option[contains(text(),'Print - Magazine')]");
	By acctypeselectedvaluetxtbx = By.xpath("//div[@data-lp-id='MscrmControls.MultiSelectPicklist.UpdMSPicklistControl|xxc_typecode.fieldControl|account']");
	By removeacctypemediabtn = By.xpath("//button[@aria-label='Remove Media']");
	By newaccountheader = By.xpath("//h1[@title='New Account']");
	By discardchangesbtn = By.xpath("//button[@aria-label='Discard changes']");
	By notetimelineoptn = By.xpath("//li[@data-id='notescontrol-createNewRecord_flyoutMenuItem_notes']");
	By notetitletimeline =By.xpath("//input[@id='create_note_medium_title']");
	By noteiframe = By.xpath("//body[@aria-label='Enter text...']");
	By notetextenter = By.xpath("//body[@aria-label='Enter text...']");		
	By addnotebutton = By.xpath("//button[@id='create_note_add_btn']");
	By cancelnotebutton = By.xpath("//button[@id='create_note_cancel_btn']");
	By notesubject = By.xpath("//div[@id='timeline_record_title_text520480cb-f222-56a8-9dcb-c78e97e2bce7']");
	By viewcreatednote = By.xpath("//div[@id='TL_Group_key_3']//div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]");
	By posttimelineoptn =By.xpath("//li[@data-id='notescontrol-createNewRecord_flyoutMenuItem_post']");
	By posttextenter = By.xpath("//textarea[@id='create_post_postText']");
	By postAddButton = By.xpath("//button[@id='create_post_add_btn']");
	By postCancelButton = By.xpath("//button[@id='create_post_cancel_btn']");
	By viewCreatedPost = By.xpath("//div[@id='TL_Group_key_3']//div[1]/div[1]/div[2]/div[2]/div[1]/div[1]");
	By auditHistoryRelatedTab = By.xpath("//span[@id='navAudit_Related']"); //xpath added for AuditHistory option from Related Dropdown list
	By auditHistoryTab = By.xpath("//li[@title='Audit History']"); // xpath for Activity History Tab
	By deleteNote = By.xpath("//div[@id='TL_Group_key_3']//div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/button[2]/span");
	By timelineDetails = By.xpath("//div[@id='TL_Group_key_3']//div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/label[1]");
	By okConfirmBtn = By.xpath("//span[@id='confirmButtonText']");
	By deletePost = By.xpath("//div[@id='TL_Group_key_3']//div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/button[3]/span");
	By validateaccnameinsearchresults = By.xpath("//div[@data-id='cell-0-2']");
	By applocation = By.xpath("//input[@data-id = 'location.fieldControl-text-box-text']");
	By phonecalloption = By.xpath("//li[@aria-label = 'Phone Call Activity']");
	By phonecallsubject = By.xpath("//input[@data-id='subject.fieldControl-text-box-text']");
	By clickphonecallduedatecalendor = By.xpath("//div [@class = 'ms-TextField-wrapper']/div/i");
	By phonecallduedatecurrent = By.xpath("//button[@class='dayButton-222 dayIsToday-223 ms-CalendarDay-dayIsToday']");
	By phonecallduetimoption = By.xpath("//div[@id = 'scheduledend_fabric_comboboxwrapper']/button/span");
	By phonecallselectduetime = By.xpath("//button[@id = 'scheduledend_fabric_combobox-list47']");
	By clickregiongridfunnel = By.xpath("//div[@data-id = 'xxc_regionid']");
	By clickfunnelfilter = By.xpath("//button[@aria-label = 'Filter by']");
	By clickoperatordd = By.xpath("//div[@aria-label = 'Filter by operator']");
	By selectoperator = By.xpath("//button[@data-index = '0']");
	By clickvaluetextbox = By.xpath("//input[@aria-label = 'Filter by Value']");
	By selectregionvalue = By.xpath("//div[@id = 'sug-0']");
	By selectvalueregionactual = By.xpath("//div[@aria-label = 'Data']/div");
	By clickapplybutton = By.xpath("//button[@type = 'submit']");
	By clickaddressgridfunnel = By.xpath("//div[@data-id = 'address1_stateorprovince']");
	By clickaddressvaluefield = By.xpath("//div[@class = 'ms-TextField-wrapper']/div/input");
	By clickdbanamegridfunnel = By.xpath("//div[@data-id = 'name']");
	By selectoperatorone = By.xpath("//button[@data-index = '4']");
	By clearfiltergrid = By.xpath("//button[@aria-label = 'Clear filter']");
	By clickdbaphonegridfunnel = By.xpath("//div[@data-id = 'telephone1']");
	By clickdbacitygridfunnel = By.xpath("//div[@data-id = 'address1_city']");
	By accdbanametxtbx = By.xpath("//input[@aria-label='Account DBA Name']");
	By duplicaterecordspopuptitle = By.xpath("//h1[@aria-label='Duplicate records found']");
	By duplicaterecordspopupcancelbtn = By.xpath("//span[contains(text(),'Cancel')]");
	By unsavedchangespopuptitle = By.xpath("//h1[@aria-label='Unsaved changes']");
	By phoneinsearchtable = By.xpath("//div[@data-id='cell-0-3']");
	By phonetxboxlabel = By.xpath("//label[contains(text(),'Phone')]");
	By hletterfilterlink = By.xpath("//li[@aria-label='Filter table by h']");
	By duplicaterecordspopupignorensavebtn = By.xpath("//button[@aria-label='Ignore and save']");
	By clickoverflowbutton = By.xpath("//button[@data-id = 'OverflowButton']");
	By clickexporttoexcelbutton = By.xpath("//button[@data-id = 'account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.ExportToExcel.Menu$splitButtonId']");
	By openexcelonline = By.xpath("//span[@aria-label = 'Open in Excel Online']");
	By saveexcelonline = By.xpath("//button[@data-id = 'export_to_excelonline_save']");
	By closepopupexcelonline = By.xpath("//button[@data-id = 'okButton']");
	By exporttostaticworksheet = By.xpath("//span[@aria-label = 'Static Worksheet']");
	By exporttostaticworksheetpageonly = By.xpath("//span[@aria-label = 'Static Worksheet (Page only)']");
	By exporttodynamicworksheet = By.xpath("//span[@aria-label = 'Dynamic Worksheet']");
	By selectcheckbox1 = By.xpath("//input[@data-id = 'entitySelector_id.fieldControl-selectAllCheckBoxElementKeyaccountxxc_accountactivecontactcount']");
	By selectcheckbox2 = By.xpath("//input[@data-id = 'entitySelector_id.fieldControl-selectAllCheckBoxElementKeyaccountaccountnumber']");
	By exportworksheetpopup = By.xpath("//button[@data-id = 'export_excel']");
	By exporttodynamicpivottable = By.xpath("//span[@aria-label = 'Dynamic PivotTable']");
	
	
	public CRMAccountsPage(WebDriver driver) {

		this.driver = driver;
	}
	
	public WebElement getAccountnametxtbx() {
		
		return driver.findElement(accountNametxtbx);
	}
	
	public WebElement getAccountNewbtn() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(accountnewbtn);
	}
	public WebElement getAccountNameSearchTable() throws InterruptedException
	{
		Thread.sleep(6000);
		return driver.findElement(accountnamesearchtable);
	}
	public WebElement getPhone()
	{
		return driver.findElement(phn);
	}
	
	public WebElement getAddress()
	{
		return driver.findElement(address);
	}
	
	public WebElement getAccTypetxtbx()
	{
		return driver.findElement(acctypetxtbx);
	}
	
	public WebElement getAcctypeExpandbtn()
	{
		return driver.findElement(acctypeexpandbtn);
	}
	
	public WebElement getAccTypeBuyer()
	{
		return driver.findElement(acctypebuyer);
	}
	
	public WebElement getStreet1()
	{
		return driver.findElement(street1);
	}
	
	public WebElement getState()
	{
		return driver.findElement(state);
	}
	
	public WebElement getCity()
	{
		return driver.findElement(city);
	}
	
	public WebElement getZipcode()
	{
		return driver.findElement(zip);
	}
	
	public WebElement getCountrytxbx()
	{
		return driver.findElement(countrytxtbx);
	}
	
	public WebElement getCountrydrpbtn()
	{
		return driver.findElement(cntryexpandbtn);
	}
	
	public WebElement getCountryName()
	{
		return driver.findElement(countryname);
	}
	
	public WebElement getAccSaveCloseBtn() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(accsavenclosebtn);
	}
	
	
	public WebElement getAccountName() throws InterruptedException
	{
		Thread.sleep(10000);
		return driver.findElement(accountname);
	}
	
	public WebElement getAddTimelineBtn()
	{
		return driver.findElement(addtimelinebtn);
	}
	
	public WebElement getApptmntActivityOptn()
	{
		return driver.findElement(appointmentactivityoptn);
	}
	
	public WebElement getTimelineSujecttxbx()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(timelinesubjecttxtbx));
		return driver.findElement(timelinesubjecttxtbx);
	}
	
	public WebElement getTimelineSavenClosebtn()
	{
		return driver.findElement(timelinesavenclosebtn);
	}
	
	public WebElement getSuccessMsg()
	{
		return driver.findElement(successmsg);
	}
	
	public WebElement getAccPageBackBtn()
	{
		return driver.findElement(accpagebackbtn);
	}
	
	public WebElement getRelatedTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(relatedTab));
		return driver.findElement(relatedTab);
	}
	
	public WebElement getSelectActivitiesRelated() {
		return driver.findElement(activitiesRelatedTab);
	}
	public WebElement getActivityTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(activityTab));
		return driver.findElement(activityTab);
	}
	
	public WebElement getAllFilterLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allfilterlink));
		return driver.findElement(allfilterlink);
	}
	
	public WebElement getDeactivateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deactivatebtn));
		return driver.findElement(deactivatebtn);
	}
	
	public WebElement getDeactivateOkBtn() {
		return driver.findElement(deactivateokbtn);
	}
	public WebElement getActivateBtn() {
		return driver.findElement(activatebtn);
	}
	
	public WebElement getDeactivateAccName() {
		return driver.findElement(deactivateaccname);
	}
	
	public WebElement getActiveAccDropDownBtn() {
		return driver.findElement(accdropdownbtn);
	}
	
	public WebElement getInactiveAccOptn() {
		return driver.findElement(inactiveacctsoptn);
	}
	
	public WebElement getValidateInactiveAccName() {
		return driver.findElement(validateInactiveAcc);
	}

	public WebElement getCLetterFilterLink() throws InterruptedException {
		
		Thread.sleep(10000);
//		wait = new WebDriverWait (driver,20);
//		wait.until(ExpectedConditions.elementToBeClickable(cletterfilterlink));
		return driver.findElement(cletterfilterlink);
	}

	public WebElement getAccNaviagteBtn() {
		return driver.findElement(accnaviagtebtn);
	}
	
	public WebElement getParentAccLabel() {
		return driver.findElement(parentacclabel);
	}
	
	public WebElement getParentAcctxbx() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(parentacctxtbx));
		return driver.findElement(parentacctxtbx);
	}
	
	public WebElement getParentAccSearchBtn() {
		return driver.findElement(parentaccsearchbtn);
	}
	
	public WebElement selectParentAccName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectparentacc));
		return driver.findElement(selectparentacc);
	}
	
	public WebElement getRecentRecordsLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(recentrecordslink));
		return driver.findElement(recentrecordslink);
	}
	
	public WebElement getAccSaveBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(accsavebtn));
		return driver.findElement(accsavebtn);
	}
	
	public WebElement getActivatePopupStatusField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activatepopupstatusfield));
		return driver.findElement(activatepopupstatusfield);
	}

	public WebElement getAccStatusBuysatCorpLevel() {
		return driver.findElement(accstatusbuysatcorplevel);
	}

	public WebElement getActivatePopupActivatebtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(activatepopupactivatebtn)).click();
		return driver.findElement(activatepopupactivatebtn);
	}

	public WebElement getStatusReasonBuysatCorpLevelInHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasonbuysatcorplevelinheader));
		return driver.findElement(statusreasonbuysatcorplevelinheader);
	}

	public WebElement getAccStatusReson() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasonbuysatcorplevelinheader));
		return driver.findElement(accstatusreason);
	}

	public WebElement getActiveAccountsLabel() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeaccountslabel));
		return driver.findElement(activeaccountslabel);
	}

	public WebElement getInactiveAccountsLabel() {

		return driver.findElement(inactiveaccountslabel);
	}
	
	public WebElement getAccStatusOutofBusiness() {

		return driver.findElement(accstatusoutofbusiness);
	}
	
	public WebElement getDeactivatePopupDeactivatebtn() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(deactivatepopupdeactivatebtn)).click();
		return driver.findElement(deactivatepopupdeactivatebtn);
	}
	
	public WebElement getAccStatusResonForInactiveAcc() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasonoutofbusinessinheader));
		return driver.findElement(accstatusreason);
	}
	
	public WebElement getPageBackBtn()
	{
		return driver.findElement(backbtn);
	}

	public WebElement getAccTypeMedia()
	{
		return driver.findElement(acctypemedia);
	}

	public List<WebElement> getMediaSegmentationFieldLabel() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElements(mediasegmentationfieldlabel);
	}
	
	public List<WebElement> getMediaTypeFieldLabel()
	{
		return driver.findElements(mediatypefieldlabel);
	}
	
	public WebElement getMediaSegmentationDropdown()
	{
		return driver.findElement(mediasegmentationdrpdown);
	}
	
	public WebElement getMediaSegmentationName()
	{
		return driver.findElement(mediasegmentationname);
	}
	
	public WebElement getMediaTypeDropdown()
	{
		return driver.findElement(mediatypedrpdown);
	}
	
	public WebElement getMediaTypeName()
	{
		return driver.findElement(mediatypename);
	}
	
	public WebElement getAccTypeSelectedValueTxtbx()
	{
		return driver.findElement(acctypeselectedvaluetxtbx);
	}
	
	public WebElement getRemoveAccTypeMediaBtn()
	{
		return driver.findElement(removeacctypemediabtn);
	}
	
	public WebElement getNewAccountHeader()
	{
		return driver.findElement(newaccountheader);
	}
	
	public WebElement getDiscardChangesBtn()
	{
		return driver.findElement(discardchangesbtn);
	}

	public WebElement getNoteTimelineOptn()
	{
		return driver.findElement(notetimelineoptn);
	}
	public WebElement getNoteTitleTextbox()
	{
		return driver.findElement(notetitletimeline);	
	}
	public WebElement getNoteiframe()
	{
		return driver.findElement(noteiframe);
	}
	public WebElement getNoteTextEnter()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(notetextenter));
		return driver.findElement(notetextenter);
	}
	public WebElement getAddNoteButton()
	{
		return driver.findElement(addnotebutton);
	}
	public WebElement getCancelNoteButton()
	{
		return driver.findElement(cancelnotebutton);
	}
	public WebElement getNoteSubject()
	{
		return driver.findElement(notesubject);
	}
	public WebElement getViewCreatedNote()
	{
		return driver.findElement(viewcreatednote);
	}
	public WebElement getPostTimelineOptn()
	{
		return driver.findElement(posttimelineoptn);
	}
	public WebElement getPostTextEnter()
	{
		return driver.findElement(posttextenter);
	}
	public WebElement getPostAddButton()
	{
		return driver.findElement(postAddButton);
	}
	public WebElement getPostCancelButton()
	{
		return driver.findElement(postCancelButton);
	}
	
	public WebElement getViewCreatedPost()
	{
		return driver.findElement(viewCreatedPost);
	}
	public WebElement getAuditHistoryRelatedTab()
	{
		return driver.findElement(auditHistoryRelatedTab);
	}	
	public WebElement getAuditHistoryTab()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(auditHistoryTab));
		return driver.findElement(auditHistoryTab);
	}
	public WebElement getDeleteNote()
	{
		return driver.findElement(deleteNote);	
	}
	public WebElement getTimelineDetails()
	{
		return driver.findElement(timelineDetails);
	}
	public WebElement getOkConfirmBtn()
	{
		return driver.findElement(okConfirmBtn);
	}
	public WebElement getDeletePost()
	{
		return driver.findElement(deletePost);	
	}

	public WebElement getValidateAccnameInSearchResults() throws InterruptedException
	{
		Thread.sleep(20000);
		return driver.findElement(validateaccnameinsearchresults);
	}
	
	public WebElement getapplocation() {
		
		return driver.findElement(applocation);
	}
	
	public WebElement getphonecalloption() {
		
		return driver.findElement(phonecalloption);
	}

	public WebElement getphonecallsubject() {
		
		return driver.findElement(phonecallsubject);
	}

	public WebElement getclickphonecallduedatecalendor() {
		
		return driver.findElement(clickphonecallduedatecalendor);
	}

	public WebElement getphonecallduedatecurrent() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phonecallduedatecurrent));
		return driver.findElement(phonecallduedatecurrent);
	}


	public WebElement getphonecallduetimoptionn() {
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phonecallduetimoption));
		return driver.findElement(phonecalloption);
	}

	public WebElement getphonecallselectduetime() {
		
		return driver.findElement(phonecallselectduetime);
	}
	
	public WebElement getclickregiongridfunnel() {
		return driver.findElement(clickregiongridfunnel);
	}

	public WebElement getclickfunnelfilter() {
		return driver.findElement(clickfunnelfilter);
	}

	public WebElement getclickoperatordd() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickoperatordd));
		return driver.findElement(clickoperatordd);
	}

	public WebElement getselectoperator() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectoperator));
		return driver.findElement(selectoperator);
	}

	public WebElement getsclickvaluetextbox() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickvaluetextbox));
		return driver.findElement(clickvaluetextbox);
	}

	public WebElement getselectregionvalue() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectregionvalue));
		return driver.findElement(selectregionvalue);
	}
	
	public WebElement getselectregionvalueactual() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectvalueregionactual));
		return driver.findElement(selectvalueregionactual);
	}

	public WebElement getclickapplybutton() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickapplybutton));
		return driver.findElement(clickapplybutton);
	}

	public WebElement getclickaddressgridfunnel() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickaddressgridfunnel));
		return driver.findElement(clickaddressgridfunnel);
	}

	public WebElement getclickaddressvaluefield() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickaddressvaluefield));
		return driver.findElement(clickaddressvaluefield);
	}

	public WebElement getclickdbanamegridfunnel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickdbanamegridfunnel));
		return driver.findElement(clickdbanamegridfunnel);
	}
	
	public WebElement getselectoperatorone()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectoperatorone));
		return driver.findElement(selectoperatorone);
	}

    public WebElement getclearfiltergrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clearfiltergrid));
		return driver.findElement(clearfiltergrid);
	}
	
	public WebElement getclickdbaphonegridfunnel()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickdbaphonegridfunnel));
		return driver.findElement(clickdbaphonegridfunnel);
	}

	public WebElement getclickdbacitygridfunnel()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickdbacitygridfunnel));
		return driver.findElement(clickdbacitygridfunnel);
	}
	
	public WebElement getAccDBANametxbox()
	{
//		wait = new WebDriverWait (driver,20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(newaccountheader));
		return driver.findElement(accdbanametxtbx);
	}
	
	public WebElement getDuplicateRecordsPopupTitle()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(duplicaterecordspopuptitle));
		return driver.findElement(duplicaterecordspopuptitle);
	}
	
	public WebElement getDuplicateRecordsPopupCancelbtn()
	{
		return driver.findElement(duplicaterecordspopupcancelbtn);
	}
	
	public WebElement getUnsavedChangesPopupTitle()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(unsavedchangespopuptitle));
		return driver.findElement(unsavedchangespopuptitle);
	}
	public WebElement getPhoneinSearchTable()
	{
		return driver.findElement(phoneinsearchtable);
	}
	
	public WebElement getPhoneTxtbxLabel() throws InterruptedException
	{
		Thread.sleep(2000);
		return driver.findElement(phonetxboxlabel);
	}
	
	public WebElement getHLetterFilterLink() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(hletterfilterlink));
		return driver.findElement(hletterfilterlink);
	}
	
	public WebElement getDuplicateRecordsPopupIgnorenSavebtn()
	{
		return driver.findElement(duplicaterecordspopupignorensavebtn);
	}
	
	public WebElement getclickoverflowbutton() {
		
		return driver.findElement(clickoverflowbutton);
	}
	
	public WebElement getclickexporttoexcelbutton() {
		
		return driver.findElement(clickexporttoexcelbutton);
	}

	public WebElement getopenexcelonline() {
		
		return driver.findElement(openexcelonline);
	}

	public WebElement getsaveexcelonline() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(saveexcelonline));
		return driver.findElement(saveexcelonline);
	}

	public WebElement getclosepopupexcelonline() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(closepopupexcelonline));
		return driver.findElement(closepopupexcelonline);
	}

	public WebElement getexporttostaticworksheet() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exporttostaticworksheet));
		return driver.findElement(exporttostaticworksheet);
	}

	public WebElement getexporttostaticworksheetpageonly() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exporttostaticworksheetpageonly));
		return driver.findElement(exporttostaticworksheetpageonly);
	}

	public WebElement getexporttodynamicworksheet() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exporttodynamicworksheet));
		return driver.findElement(exporttodynamicworksheet);
	}

	public WebElement getselectcheckbox1() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectcheckbox1));
		return driver.findElement(selectcheckbox1);
	}

	public WebElement getselectcheckbox2() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectcheckbox2));
		return driver.findElement(selectcheckbox2);
	}

	public WebElement getexportworksheetpopup() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exportworksheetpopup));
		return driver.findElement(exportworksheetpopup);
	}

	public WebElement getexporttodynamicpivottable() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exporttodynamicpivottable));
		return driver.findElement(exporttodynamicpivottable);
	}
}

	