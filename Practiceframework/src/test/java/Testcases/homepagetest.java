package Testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import base.Basetest;
import pages.Homepage;
import pages.Loginpage;
import pages.Registerpage;
import utilities.Testutil;
public class homepagetest extends Basetest {
	
	private  final Logger logger = LogManager.getLogger(homepagetest.class);
	
	public homepagetest() throws IOException {
		
		super();
		
	}
	Homepage homepage;
	Loginpage loginpage;
	Registerpage registerpage;
	public ExtentSparkReporter htmlReporter;
	 public ExtentReports extent;
	 public ExtentTest test;
	
   @BeforeMethod
	public void setup() {
	   initialization( );
	   homepage  = new Homepage();
	   homepage.clickonmyaccount();
	  logger.info("Initialisation started"); 
	}
 
   @BeforeTest
	 public void setExtent() {
	  // specify location of the report
	  htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/myReport.html");

	  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
	  htmlReporter.config().setReportName("Functional Testing"); // Name of the report
	  htmlReporter.config().setTheme(Theme.DARK);
	  
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	  // Passing General information
	  extent.setSystemInfo("Host name", "localhost");
	  extent.setSystemInfo("Environemnt", "QA");
	  extent.setSystemInfo("user", "Madhu");
	  
	 }
  @Test(priority=1)
  public void myaccountlabelverification() {
	  test = extent.createTest("myaccountlabelverification");
		  Assert.assertTrue(homepage.verifymyaccountlabel(),"myaccount lable is not displayed");
  logger.info("myaccountlabel verification test");
  }
	
  @Test(priority = 2)
  public void registerpagelabelverification() {
	  test = extent.createTest("registerpagelabelverification");
	Assert.assertTrue(homepage.verifyregisterbutton(), "register button is not displayed");  
	  logger.info("registerpagelabelverification test started");
  }
  
  @Test(priority=3)
   public void registerpagevalidation() {
	  test = extent.createTest("registerpagevalidation");
	  registerpage= homepage.clickonregister();
	   Assert.assertEquals(homepage.validatingregisterpage(),"Register Account","register account is not displaying");
	   
   }
  @Test(priority =4)
  public void loginrpagevalidation() {
	  test = extent.createTest("loginrpagevalidation");
	  homepage.clickonlogin();
	  Assert.assertEquals(homepage.validatingloginpage(), "Ne Customer", "new cusotmer is not displaying");
	
	 
  }
  
  @AfterTest
	 public void endReport() {
	  extent.flush();
	 
	 }
  
       @AfterMethod
    
    		 public void tearDown(ITestResult result) throws IOException {
    			  if (result.getStatus() == ITestResult.FAILURE) {
    				 
    			  
    			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
    			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
    			   String screenshotPath = Testutil.getScreenshotas(driver, result.getName());
    			   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
    			  } else if (result.getStatus() == ITestResult.SKIP) {
    			   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
    			  }
    			  else if (result.getStatus() == ITestResult.SUCCESS) {
    			   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
    			  }  
    	driver.quit(); 
     }
     
 
}