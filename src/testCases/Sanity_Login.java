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

import utilities.Base;
import utilities.CommonOps;
import utilities.CommonVars;
import static utilities.CommonOps.logger;

public class Sanity_Login extends Base
{
static pageObjects.Live_Image LI;
static pageObjects.LoginWindow LW;
static pageObjects.RIScreen RS;
static pageObjects.SideMenu SM;

@BeforeClass
  public static void startTest() throws ParserConfigurationException, SAXException, IOException
  {
    //setUp();
    logger.info("######################    onCreate    ######################");
    LI = PageFactory.initElements(settings.getDriver(),  pageObjects.Live_Image.class);
    LW = PageFactory.initElements(settings.getDriver(),  pageObjects.LoginWindow.class);
    RS = PageFactory.initElements(settings.getDriver(),  pageObjects.RIScreen.class);
    SM = PageFactory.initElements(settings.getDriver(),  pageObjects.SideMenu.class);
  }
@Test
  //login with patient from empty MRN screen
    public void test1() throws ParserConfigurationException, SAXException, IOException
  {
    //LI.enterToSideMenu();
    //SM.DischargingPatient();
    //LW.fillPatientDetails();
      LW.fillNewPatientDetails();
      RS.chooseInterval("2");
      verifyText(LI.nextRepositionText, CommonOps.getData("ExpectedInterval_2H"));
    //ComOps.verifyImageExists("ScreenShotResetInterval");
  }
@Test
//Change patient with interval of 1 hour
    public void test2() throws ParserConfigurationException, SAXException, IOException
    {
        LI.enterToSideMenu();
        SM.pressingPatientInformation();
        LW.changePatientDetails();
        RS.chooseInterval("1");
        verifyText(LI.nextRepositionText, CommonOps.getData("ExpectedInterval_1H"));
    }

@AfterClass
    public static void endTest()
    {
        utilities.CommonVars.tearDown();
    }

}
