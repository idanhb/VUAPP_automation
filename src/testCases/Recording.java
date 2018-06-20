package testCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.javascript.host.css.CSS;

import pageObjects.AdministratorPopup;
import pageObjects.CSScreen;
import utilities.Base;
import utilities.CommonOps;
import utilities.CommonVars;
import static utilities.CommonOps.logger;

public class Recording extends Base
{
	static pageObjects.Live_Image LI;
	static pageObjects.LoginWindow LW;  
	static pageObjects.RIScreen RS;
	static pageObjects.AdministratorPopup AdminPopup;
	static pageObjects.CSScreen CS;
	static pageObjects.RecordingManager RM;
	static pageObjects.AdvancedScreen AS;
	static pageObjects.SideMenu SM;
	
	@BeforeClass
	  public static void startTest() throws ParserConfigurationException, SAXException, IOException
	  {
		//setUp();
		logger.info("######################    onCreate.Recording    ######################");
		LI = PageFactory.initElements(settings.getDriver(),  pageObjects.Live_Image.class);
		LW = PageFactory.initElements(settings.getDriver(),  pageObjects.LoginWindow.class);
		RS = PageFactory.initElements(settings.getDriver(),  pageObjects.RIScreen.class);
		AdminPopup = PageFactory.initElements(settings.getDriver(),  pageObjects.AdministratorPopup.class);
		CS = PageFactory.initElements(settings.getDriver(),  pageObjects.CSScreen.class);
		RM = PageFactory.initElements(settings.getDriver(),  pageObjects.RecordingManager.class);
		AS = PageFactory.initElements(settings.getDriver(),  pageObjects.AdvancedScreen.class);
		SM = PageFactory.initElements(settings.getDriver(),  pageObjects.SideMenu.class);
	  }
	  
	  @Test
	  public void test1() throws ParserConfigurationException, SAXException, IOException
	  {
		  LW.fillNewPatientDetails();
		  //RS.chooseInterval();
		  LI.enterToSideMenu();
		  SM.pressingSettingsButton();		  
		  AdminPopup.enterToCSMode();
		  CS.enterToAdvancedMenu();
		  AS.enterToRecordingManager();
		  RM.playRecording();
		  
		//verifyText(LI.nextRepositionText, CommonOps.getData("ExpectedInterval"));
		//ComOps.verifyImageExists("ScreenShotResetInterval");
	  }
	  
	  @After
	  public void endTest()
	  {
		  LI.enterToSideMenu();
		  SM.DischargingPatient();
		  //tearDown();
	  }

}
