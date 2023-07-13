package Testcases;
import org.testng.Assert;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.Basetest;
import pages.Homepage;
import pages.Loginpage;
import pages.Registerpage;

public class homepagetest extends Basetest {
	
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
	}
 
   @BeforeTest
	 public void setExtent() {
	  // specify location of the report
	  htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/myReport.html");

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
	  	  
	  Assert.assertTrue(homepage.verifymyaccountlabel(),"myaccount lable is not displayed");
  }
	
  @Test(priority = 2)
  public void registerpagelabelverification() {
	  
	Assert.assertTrue(homepage.verifyregisterbutton(), "register button is not displayed");  
	  
  }
  
  @Test(priority=3)
   public void registerpagevalidation() {
	 
	  registerpage= homepage.clickonregister();
	   Assert.assertEquals(homepage.validatingregisterpage(),"Register Account","register account is not displaying");
	   
   }
  @Test(priority =4)
  public void loginrpagevalidation() {
	  homepage.clickonlogin();
	  Assert.assertEquals(homepage.validatingloginpage(), "New Customer", "new cusotmer is not displaying");
	  
  }
  
  @AfterTest
	 public void endReport() {
	  extent.flush();
	 }
  
       @AfterMethod
     public void teardown() {
    	driver.quit(); 
     }
     
 
}