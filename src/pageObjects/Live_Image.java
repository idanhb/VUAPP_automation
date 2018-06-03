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

public class Live_Image extends Base
{
	//static Logger LOGGER=Logger.getLogger(Live_Image.class.getName());
	utilities.CommonOps comOpsLI = new utilities.CommonOps();
	LoginWindow LW = new LoginWindow();
	RIScreen RIS = new RIScreen();
	
	@FindBy (how=How.ID , using="liveImage_img_MenuButton")
	public WebElement sideMenuButton;
	
	@FindBy (how=How.ID , using="drawerItem_img_PatientInformation")
	public WebElement patientInformationButton;
	
	@FindBy (how=How.ID , using="drawerItem_img_Settings")
	public WebElement settingsButton;
	
	@FindBy (how=How.ID , using="next_reposition_in_blue_bar_text")
	public WebElement nextRepositionText;
	
	public void enterToSideMenu()
	{
		try
		{
			logger.info("start enterToSideMenu");
			logger.info("Thread Sleep of 20 sec");
			Thread.sleep(20000);
			pressButton(sideMenuButton);
			//comOpsLI.clickButton(sideMenuButton);
			System.out.println("after click side menu");			
			
			
			
			//comOpsLI.clickButton(patientInformationButton);
			//System.out.println("after click patient information");
			//comOpsLI.clickButton(LW.editPatienInformationButton);
			//change to different patient every login (a loop)
		}
		catch (AssertionError ae)
		{
			logger.info("Assert failed: "+ae.getMessage());
			System.out.println(ae);
			fail(ae.getMessage());
		}
		catch (Exception e)
		{
			logger.info("Exception Thrown: "+e.getMessage());
			fail(e.getMessage());
		}
	}
	
	//public Live_Image (AndroidDriver<AndroidElement> driver)
	//{
	//	this.driver = (AndroidDriver<AndroidElement>) driver;
	//}
}
