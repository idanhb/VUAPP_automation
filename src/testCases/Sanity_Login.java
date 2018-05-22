package testCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import utilities.Base;
import utilities.CommonOps;
import utilities.Settings;
import static utilities.CommonOps.logger;

public class Sanity_Login extends Base
{
	static pageObjects.Live_Image LI;
	static pageObjects.LoginWindow LW;  
	static pageObjects.RIScreen RS;
	
	@Before
	  public void startTest() throws ParserConfigurationException, SAXException, IOException
	  {
		//setUp();
		logger.info("######################    onCreate    ######################");
		LI = PageFactory.initElements(settings.getDriver(),  pageObjects.Live_Image.class);
		LW = PageFactory.initElements(settings.getDriver(),  pageObjects.LoginWindow.class);
		RS = PageFactory.initElements(settings.getDriver(),  pageObjects.RIScreen.class);
	  }
	  
	  @Test
	  public void test1() throws ParserConfigurationException, SAXException, IOException
	  {
		//LI.enterToPatientDetails();
		//LW.fillPatientDetails();
		LW.fillNewPatientDetails();
		RS.chooseInterval();
		verifyText(LI.nextRepositionText, CommonOps.getData("ExpectedInterval"));
		//ComOps.verifyImageExists("ScreenShotResetInterval");
	  }
	  
	  @After
	  public void endTest()
	  {
		tearDown();
	  }

}
