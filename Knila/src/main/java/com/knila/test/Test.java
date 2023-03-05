package com.knila.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.knila.pages.AdminPage;
import com.knila.pages.LoginPage;
import com.knila.pages.PatientDetailsPage;
import com.knila.pages.RegisterPage;
import com.knila.utility.SeleniumCommands;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test extends SeleniumCommands {
	static ExtentTest test;
	static ExtentReports report;
	@BeforeTest
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport\\ExtentReportResults.html");
		test = report.startTest("Knila");
	}
	@BeforeClass
	public void beforeClass() throws Throwable {

		launchBrowser("Chrome");
		test.log(LogStatus.PASS,"Chrome Browser", "Browser lauched successfully");

	}

	@org.testng.annotations.Test
	public void purchaseTest() throws Throwable, Throwable {

		openApp(getProperty("url", "System"));
		test.log(LogStatus.PASS, "Application Launch","Navigated to the specified URL");
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		LoginPage l=new LoginPage();
		enterText(l.getTxtUserName(), getProperty("username", "System"));
		test.log(LogStatus.PASS, "Name","Name entered Successfully");
		enterText(l.getTxtUserPass(), getProperty("password", "System"));
		test.log(LogStatus.PASS, "Password","Password entered Successfully");
		clickButton(l.getBtnLocation());
		test.log(LogStatus.PASS, "Location","Location selected Successfully");
		clickButton(l.getBtnLogin());
		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		AdminPage a = new AdminPage();
		clickButton(a.getListbox());
		test.log(LogStatus.PASS, "Register","Register clicked Successfully");
		
		RegisterPage r = new RegisterPage();
		
		enterText(r.getGivenName(), getProperty("Given", "Data"));
		test.log(LogStatus.PASS, "FirstName","FirstName entered Successfully");
		
		enterText(r.getLastName(), getProperty("Last", "Data"));
		test.log(LogStatus.PASS, "LastName","LastName entered Successfully");
		clickButton(r.getBtnGender());
		test.log(LogStatus.PASS, "Gender","Gender clicked Successfully");
		clickButton(r.getBtnMale());
		test.log(LogStatus.PASS, "Male","Male clicked Successfully");
		clickButton(r.getBtnBirthDate());
		test.log(LogStatus.PASS, "BirthDate","BirthDate clicked Successfully");
		enterText(r.getTxtDate(), getProperty("Date", "Data"));
		test.log(LogStatus.PASS, "Date","Date entered Successfully");
//		enterText(r.getTxtDate(), getProperty("Date", "Data"));
//		test.log(LogStatus.PASS, "Login","Login clicked Successfully");
		dropdownSelect(r.getDrpdwnMonth(), getProperty("Month", "Data"));
		test.log(LogStatus.PASS, "Month","Month Selected Successfully");
		enterText(r.getTxtYear(), getProperty("Year", "Data"));
		test.log(LogStatus.PASS, "Year","Year entered Successfully");
		clickButton(r.getBtnAddr());
		test.log(LogStatus.PASS, "Address","Address clicked Successfully");
		enterText(r.getTxtAddr1(), getProperty("Address", "Data"));
		test.log(LogStatus.PASS, "Address","Address entered Successfully");
		enterText(r.getBtnAddr2(), getProperty("Address1", "Data"));
		test.log(LogStatus.PASS, "Address1","Address1 entered Successfully");
		clickButton(r.getBtnPhoneNum());
		test.log(LogStatus.PASS, "PhoneNumber","PhoneNumber clicked Successfully");
		enterText(r.getTxtPhoneNum(), getProperty("Phone", "Data"));
		test.log(LogStatus.PASS, "PhoneNumber","PhoneNumber entered Successfully");
		clickButton(r.getBtnRelatives());
		test.log(LogStatus.PASS, "Relative","Relative clicked Successfully");
		clickButton(r.getBtnConfirm());
		test.log(LogStatus.PASS, "Confirm","Confirm clicked Successfully");
		clickButton(r.getBtnConfirm2());
		test.log(LogStatus.PASS, "Registered","Registered Successfully");
		
		PatientDetailsPage p = new PatientDetailsPage();
		clickButton(p.getBtnstartVisit());
		test.log(LogStatus.PASS, "StartVisit","Startvisit clicked Successfully");
		clickButton(p.getBtnStartVisitConfirm());
		test.log(LogStatus.PASS, "Confirm","Confirm clicked Successfully");
		clickButton(p.getBtnAttachment());
		test.log(LogStatus.PASS, "Attachmentbutton","Attachment clicked Successfully");
		clickButton(p.getBtnAttchUpload());
		test.log(LogStatus.PASS, "Attachmentbutton1","Attachment1 clicked Successfully");
		
		Thread.sleep(5000);
		//Upload the file
		Robot robot=new Robot();
		
		StringSelection s=new StringSelection(System.getProperty("user.dir")+"\\ExtentReport\\ExtentReportResults.html");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, s);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		enterText(p.getTxtCaption(), getProperty("Caption", "Data"));
		test.log(LogStatus.PASS, "Caption","Caption entered Successfully");
		
		clickButton(p.getBtnUpload());
		test.log(LogStatus.PASS, "AttachmentUpload","Attachment Uploaded Successfully");

		//Check toaster message
		//assertEquals(p.getVerifySuccessfulMessage(), getProperty("VerifyMessage", "Data"));
		
		
		driver.navigate().back();
		driver.navigate().back();
		
		Thread.sleep(3000);
		assertTrue(p.getVerifyAttachment().isDisplayed());
		test.log(LogStatus.PASS, "VerifyAttachment","Attachment Verified Successfully");
		
		Thread.sleep(3000);
		String date = p.getVerifyLastEntry().getText();
		test.log(LogStatus.PASS, "VerifyLastEntry","Last Entry Verified Successfully");
		
		SimpleDateFormat simple=new SimpleDateFormat("dd.MMM.yyyy");
		Date d=new Date();
		Assert.assertEquals(simple.format(d), date);
		
		clickButton(p.getBtnEndVisit());
		test.log(LogStatus.PASS, "EndVisit","End visit clicked Successfully");

		clickButton(p.getBtnConfirmEndVisit());
		test.log(LogStatus.PASS, "EndVisitConfirm","End visit confirmed Successfully");

		Thread.sleep(2000);
		clickButton(p.getBtnDeletepatient());
		test.log(LogStatus.PASS, "DeletePatient","Patient deleted Successfully");

	
		enterText(p.getTxtReasonForDelete(), getProperty("Reason","Data" ));
		test.log(LogStatus.PASS, "DeletedReason","Deleted Reason entered Successfully");

		
		
	
	}
	
	@AfterMethod
	public void after(ITestResult r) throws Throwable {

		if(r.getStartMillis()==ITestResult.FAILURE) {
			screenShot();
		}
	}

	@AfterClass
	public void afterClass() throws Throwable {
		driver.quit();
		report.endTest(test);
		report.flush();

	}
	
	

}
