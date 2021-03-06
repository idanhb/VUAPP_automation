package pageObjects;

import static org.junit.Assert.fail;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import testCases.Sanity_Login;
import utilities.Base;
import utilities.CommonOps;

public class RIScreen extends Base
{
	private static final Logger LOGGER = Logger.getLogger(RIScreen.class.getName());
	CommonOps comOpsRIS = new CommonOps();
	
	@FindBy (how=How.ID , using="confirmReposition_tv_Edit")
	public WebElement confirmRepositionEditButton;
	
	@FindBy (how=How.ID , using="confirmReposition_tv_Confirm")
	public WebElement confirmRepositionConfirmButton;
	
	@FindBy (how=How.ID , using="confirmReposition_tv_CurrentScheduleTitle")
	public WebElement confirmRepositinCurrentInterval;
	
	@FindBy (how=How.XPATH , using="//*[@text='2.0 HOURS']")
	public WebElement interval_2_Hours;

	@FindBy (how=How.XPATH , using="//*[@text='1.0 HOUR']")
	public WebElement interval_1_Hour;
	
	public void chooseInterval(String intervalTime)
	{
		try
		{
			Thread.sleep(2000);
			clickButton(confirmRepositionEditButton);
			if (intervalTime == "1") {
				clickButton(interval_1_Hour);
			}
			if (intervalTime == "2")
			{
				clickButton(interval_2_Hours);
			}
			Thread.sleep(2000);
			clickButton(confirmRepositionConfirmButton);
		}
		catch (Exception e)
		{
			fail();
		}

	}

}
