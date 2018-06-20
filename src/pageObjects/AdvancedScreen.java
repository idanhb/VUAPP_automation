package pageObjects;

import static org.junit.Assert.fail;
import static utilities.CommonOps.logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdvancedScreen 
{
	utilities.CommonOps comOpsAS = new utilities.CommonOps();
	LoginWindow LW = new LoginWindow();
	RIScreen RIS = new RIScreen();
	
	@FindBy (how=How.XPATH , using="//*[@text='Advanced']")
	public WebElement advancedButton;
	
	@FindBy (how=How.ID , using="cv_settings_recording_options")
	public WebElement recordingOptions;
	
	public void enterToRecordingManager()
	{
		try
		{
			comOpsAS.clickButton(recordingOptions);
			logger.info("pressed Recording Options button");
		}
		catch (Exception e)
		{
			logger.error("Caught Exception: " + e.getMessage());
			fail();
		}
	}

}
