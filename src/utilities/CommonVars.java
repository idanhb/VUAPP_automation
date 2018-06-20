package utilities;

import static org.junit.Assert.fail;
import static utilities.CommonOps.logger;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.xml.sax.SAXException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonVars
{
	private AndroidDriver<AndroidElement> driver = null;
	private static CommonVars instance;
	
	public CommonVars()
	{
		try 
		{
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("reportDirectory", CommonOps.getData("reportDirectory"));
			dc.setCapability("reportFormat", CommonOps.getData("reportFormat"));
			dc.setCapability("testName", CommonOps.getData("testName"));
			dc.setCapability(MobileCapabilityType.UDID, CommonOps.getData("UDID"));
			dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, CommonOps.getData("APP_PACKAGE"));
			dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".activity.MainActivity");
			driver = new AndroidDriver<>(new URL(CommonOps.getData("URL")), dc);
		}
		catch (Exception e)
		{
			fail();
		}
	}
	
	public static CommonVars getInstance() {
		if (instance == null)
			instance = new CommonVars();
		
		return instance;
	}
	
	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}

	public static void tearDown() {
		//for After
		//LI.enterToSideMenu();
		//SM.DischargingPatient();
		instance.getDriver().quit();
		logger.info("test finished");
	}
}
