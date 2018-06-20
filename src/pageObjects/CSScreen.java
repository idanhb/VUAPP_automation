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
import static utilities.CommonOps.logger;

public class CSScreen extends Base
{
	utilities.CommonOps comOpsCS = new utilities.CommonOps();
	LoginWindow LW = new LoginWindow();
	RIScreen RIS = new RIScreen();
	
	@FindBy (how=How.XPATH , using="//*[@text='Advanced']")
	public WebElement advancedButton;
	
	@FindBy (how=How.ID , using="cv_settings_recording_options")
	public WebElement recordingOptions;
	
	public void enterToAdvancedMenu()
	{
		try
		{
			comOpsCS.clickButton(advancedButton);
			logger.info("pressed Advanced button");
		}
		catch (Exception e)
		{
			logger.error("Caught Exception: " + e.getMessage());
			fail();
		}

	}
}
