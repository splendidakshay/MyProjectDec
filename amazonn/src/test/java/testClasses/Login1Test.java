package testClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.LoginPOMAmazon;
import BaseClass.Utility;
import BaseClass.configuration;

public class Login1Test {
	WebDriver driver ;
	LoginPOMAmazon login ;
	String tcid;
	@BeforeClass
	public void start() {
		 driver= Utility.openBrowser() ;

	}
@Test
public void TC101_LoginBlank() {
	tcid="TC101_LoginBlank" ;
	login=new LoginPOMAmazon(driver);
	login.clickPrelog();
	login.enterID("");
	login.clickContinue();
	Reporter.log("LoginBlank Ok", true);
}
@Test
	public void TC102_VerifyBlankErr() throws InterruptedException {
	tcid="TC102_VerifyBlankErr" ;
		String actText = login.getErrMsg() ;
		String exPText ="Enter your email or mobile phone number";
		Assert.assertEquals(actText, exPText);
		Reporter.log("VerifyErrMsg Ok", true);

	}
@Test
public void TC103_invalidIdCheck() {
	tcid = "TC103_invalidIdCheck" ;
	login.enterID("dhghghjdhd");
	login.clickContinue();
	String expInvalidMsg = "We cannot find an account with that email address";
	String actInvMsg = login.getErrMsgInvalid() ;
	Assert.assertEquals(actInvMsg, expInvalidMsg);
	Reporter.log("VerifyInvalidMsg Ok", true);

}
@Test
public void TC104_invPWDCheck() {
	tcid= "TC104_invPWDCheck" ;
	login.enterPWD("jjghf");
	String actmsg = login.getWrongPWDmsg();
	String expText = "Your password is incorrect";
	Assert.assertEquals(actmsg, expText);
	System.out.println("Invpwd msg ok");
}
@Test
public void TC105_verifySucceslogin() throws IOException, InterruptedException {
	Thread.sleep(3000);
	Properties pp= new Properties() ;
	FileInputStream file = new FileInputStream("C:\\Users\\aksha\\eclipse-workspace\\amazonn\\src\\Credentials\\Extainfo.properties") ;
	pp.load(file);
	driver.get("https://www.amazon.in/");
login.enterID(pp.getProperty("email")) ;
login.clickContinue();
login.enterPWD(pp.getProperty("pass"));
login.clickCont2();
	String actText = login.getsuccessloginMsg();
	String expText =  "Deliver to Akshay Aurangabad 431001‌" ;
	Assert.assertEquals(actText, expText);
	System.out.println("user verified succesfully");
}
@AfterMethod
public void TakeSS(ITestResult res) throws IOException {
	if(res.getStatus()==res.FAILURE) {
	Utility.TakeSS(driver,tcid);
	}
}

	
@AfterClass
public void closePage() throws InterruptedException {
	Thread.sleep(4000);
	driver.close();
}
}