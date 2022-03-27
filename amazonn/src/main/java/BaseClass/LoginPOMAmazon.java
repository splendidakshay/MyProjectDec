package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOMAmazon {
	
	//Declaration
	@FindBy(xpath="//a[@id='nav-link-accountList']") private WebElement preLogin ;
	@FindBy(xpath="//input[@type='email']") private WebElement eMail ;
	@FindBy(xpath="//span[@id='continue']") private WebElement continueBtn ;
	@FindBy(xpath="(//div[@class='a-alert-content'])[2]") private WebElement errMsg ;
	@FindBy(xpath="//span[@class='a-list-item']") private WebElement errMSgINvalid ;
	@FindBy(xpath="//input[@id='continue']") private WebElement cont2Btn ;
	@FindBy(xpath="//input[@type='password']") private WebElement pass ;
	@FindBy(xpath="//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span") private WebElement WrongpassMsg ;
	@FindBy(xpath="//div[@id='glow-ingress-block']") private WebElement succesLoginMsg ;


	//initialization
	public LoginPOMAmazon(WebDriver dri){
		PageFactory.initElements(dri, this);
	}
	
	//Usage
	public void clickPrelog() {
		preLogin.click();
	}
public String enterID(String id) {
	eMail.sendKeys(id);
	return id ;
}
public void clickContinue() {
	continueBtn.click();
}
public String getErrMsg() {
	String x = errMsg.getText().toString() ;
	return x;
}
public String getErrMsgInvalid() {
	return errMSgINvalid.getText();
	
}
public void clickCont2() {
	cont2Btn.click();
}
public void enterPWD(String b) {
	pass.sendKeys(b);
}
public String getWrongPWDmsg() {
	return WrongpassMsg.getText();
		
}
public String getsuccessloginMsg() {
	return succesLoginMsg.getText();
}
}
	

