package pageObjects;

import static org.junit.Assert.fail;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.Base;
import utilities.CommonOps;
import static utilities.CommonOps.logger;
public class LoginWindow extends Base
{
	//private static final Logger LOGGER = Logger.getLogger(LoginWindow.class.getName());
	CommonOps comOpsLW = new CommonOps();
	
	@FindBy (how=How.ID , using="patientLogin_tv_Edit")
	public WebElement editPatienInformationButton;
	
	@FindBy (how=How.ID , using="patientLogin_et_MedicalRecordNumber")
	public WebElement MRNNumber;
	
	@FindBy (how=How.ID , using="patientLogin_et_LastName")
	public WebElement lastNameField;
	
	@FindBy (how=How.ID , using="patientLogin_et_FirstName")
	public WebElement firstNameField;
	
	@FindBy (how=How.ID , using="patientLogin_et_Weight")
	public WebElement weightField;
	
	@FindBy (how=How.XPATH , using="//*[@text='CONFIRM']")
	public WebElement confirmPatientDetailsButton;
	
	@FindBy (how=How.XPATH , using="//*[@text='SUBMIT']")
	public WebElement submitPatientDetailsButton;
	
	@FindBy (how=How.XPATH , using="//*[@text='NO']")
	public WebElement PIPopupNo;
	
	@FindBy (how=How.XPATH , using="//*[@text='YES']")
	public WebElement PIPopupYes;
	
	public void changePatientDetails()
	{
		try
		{
			Thread.sleep(5000);
			logger.info("changePatientDetails");
			MRNNumber.clear();
			sendText(MRNNumber, CommonOps.getData("MRNNumber2"));
			logger.info("MRN#2 inserted");
			lastNameField.clear();
			sendText(lastNameField, CommonOps.getData("LastName"));
			firstNameField.clear();
			sendText(firstNameField, CommonOps.getData("FirstName"));
			weightField.clear();
			sendText(weightField, CommonOps.getData("Weight"));
			logger.info("finished insert details. continue to confirm");
			clickButton(confirmPatientDetailsButton);
			Thread.sleep(1000);
			clickButton(PIPopupNo);
		}
		catch (Exception e)
		{
			logger.error("Caught Exception: " + e.getMessage());
			fail();
		}
	}
	
	public void fillNewPatientDetails()
	{
		try
		{
			Thread.sleep(10000);
			logger.info("fillNewPatientDetails");
			sendText(MRNNumber, CommonOps.getData("MRNNumber1"));
			logger.info("MRN#1 inserted");
			sendText(lastNameField, CommonOps.getData("LastName"));
			logger.info("Last name inserted");
			sendText(firstNameField, CommonOps.getData("FirstName"));
			logger.info("First name inserted");
			sendText(weightField, CommonOps.getData("Weight"));
			logger.info("Patient weight inserted");
			logger.info("finished insert patient details. continue to confirm");
			Thread.sleep(1000);
			clickButton(submitPatientDetailsButton);
			logger.info("Details inserted and clicked button SUBMIT");
			clickButton(PIPopupNo);
		}
		catch (Exception e)
		{
			logger.error("Caught Exception: " + e.getMessage());
			fail();
		}
	}
}
