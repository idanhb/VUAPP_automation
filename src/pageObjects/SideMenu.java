package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.fail;
import static utilities.CommonOps.logger;

import utilities.Base;
import utilities.CommonOps;

public class SideMenu extends Base
{
	CommonOps comOpsSideMenu = new CommonOps();
	LoginWindow LW = new LoginWindow();
	RIScreen RIS = new RIScreen();
	
	@FindBy (how=How.ID , using="drawerItem_img_RepositionInterval")
	public WebElement repositionIntervalButton;
	
	@FindBy (how=How.ID , using="drawerItem_img_AddRemovePressureInjuries")
	public WebElement addRemovePIButton;
	
	@FindBy (how=How.ID , using="drawerItem_img_PatientInformation")
	public WebElement patientInformationButton;
	
	@FindBy (how=How.ID , using="drawerItem_img_PatientDischarge")
	public WebElement patientDischargeButton;
	
	@FindBy (how=How.ID , using="drawerItem_img_Settings")
	public WebElement settingsButton;
	
	@FindBy (how=How.ID , using="confirmDischarge_tv_yes")
	public WebElement confirmDischargeButton;
	
	public void pressingPatientInformation()
	{
		try
		{
			clickButton(patientInformationButton);
			logger.info("clicked on Patient Information button");
		}
		catch (Exception e)
		{
			logger.info("Exception Thrown: "+e.getMessage());
			fail(e.getMessage());
		}
	}
	
	public void pressingSettingsButton()
	{
		try
		{
			clickButton(settingsButton);
			logger.info("clicked on Settings button");
		}
		catch (Exception e)
		{
			logger.info("Exception Thrown: "+e.getMessage());
			fail(e.getMessage());
		}
	}
	
	public void DischargingPatient()
	{
		try
		{
			clickButton(patientDischargeButton);
			//pressButton(patientDischargeButton);
			logger.info("clicked on Discharge Patient button");
			clickButton(confirmDischargeButton);
			//pressButton(confirmDischargeButton);
			logger.info("clicked YES to discharge patient");
		}
		catch (Exception e)
		{
			logger.info("Exception Thrown: "+e.getMessage());
			fail(e.getMessage());
		}
	}

}
