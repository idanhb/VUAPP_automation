package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utilities.Base;
import utilities.CommonOps;
import static utilities.CommonOps.logger;
import utilities.Base;

public class AdministratorPopup extends Base
{
	CommonOps comOpsAdminPopup = new CommonOps();
	LoginWindow LW = new LoginWindow();
	RIScreen RIS = new RIScreen();
	
	@FindBy (how=How.ID , using="popupAdministratorKiosk_et_AdministratorUsername")
	public WebElement username;
	
	@FindBy (how=How.ID , using="popupAdministratorKiosk_et_AdministratorPassword")
	public WebElement password;
	
	@FindBy (how=How.XPATH , using="//*[@text='LOG IN']")
	public WebElement loginButton;
	
	public void enterToCSMode() 
	{
		try
		{
			logger.info("start loginToCSMode");
			//comOpsAdminPopup.sendText(username, CommonOps.getData("UserName"));
			sendText(username, CommonOps.getData("UserName"));
			logger.info("after insert username");		
			//comOpsAdminPopup.sendText(password, CommonOps.getData("AdminPassword"));
			sendText(password, CommonOps.getData("AdminPassword"));
			logger.info("after insert password");
			//comOpsAdminPopup.clickButton(loginButton);
			clickButton(loginButton);
			logger.info("after pressing login");
		}
		catch (AssertionError ae)
		{
			logger.info("Assert at loginToCSMode failed: "+ae.getMessage());
			System.out.println(ae);
			fail(ae.getMessage());
		}
		catch (Exception e)
		{
			logger.info("Exception Thrown from loginToCSMode: "+e.getMessage());
			fail(e.getMessage());
		}
		
	}

}
