package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import java.text.SimpleDateFormat;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.Screen;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import testCases.Sanity_Login;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
import static utilities.CommonOps.logger;

public class Base 
{
	//public static ExtentReports extent;
	//public static ExtentTest test;
	//public WebDriverWait wait;
		
	//Screen screen = new Screen();
	public static String timeStamp = new SimpleDateFormat ("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
	protected static CommonVars settings = CommonVars.getInstance();
	TouchAction action = new TouchAction(settings.getDriver());
	
	public String takeSS() throws IOException, ParserConfigurationException, SAXException
	{
		String ScreenShotPath = CommonOps.getData("ScreenShot")+CommonOps.getRandomNumber()+".png";
		File scrFile = ((TakesScreenshot)settings.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(ScreenShotPath));
		logger.info("ScreenShots taken and saved here " + ScreenShotPath);
		return ScreenShotPath;
	}
	
	public static void tearDown() 
	{
	    //for After
		settings.getDriver().quit();
		logger.info("test finished");
	}
	
	// need to complete
		public void verifyImageExists(String image)
		{
			try
			{
				System.out.println("verify image");
				//screen.wait(1);
				System.out.println("after sleep.wait");
				//screen.find(CommonOps.getData(image));
				System.out.println("image verified");
			}
			catch (AssertionError ae)
			{
				fail(ae.getMessage());
			}
			catch (Exception e)
			{
				fail(e.getMessage());
			}
		}

		public void verifyText(WebElement element, String expectedValue)
		{
			try
			{
				System.out.println("inside verify text");
				assertEquals(expectedValue, element.getText());
				logger.info("element "+ element.getText()+ " verified successfully");
			}
			catch (AssertionError ae)
			{
				logger.error("Assert for element "+ element.getText()+ " failed with message: ");
				logger.error(ae.getMessage());
				fail(ae.getMessage());
			}
			catch (Exception e)
			{
				logger.error("Exception found when tried to verify text for element: "+ element.getText());
				logger.error(e.getMessage());
				fail(e.getMessage());
			}
		}
		
		public void pressButton(WebElement element)
		{
			try
			{
				System.out.println("inside press button");
				explicitWait(element);
				settings.getDriver().performTouchAction(action.press(element));
				//settings.getDriver().wait(2000).tap();
				settings.getDriver().tap(1, element, 500);
				logger.info("pressed on button successfully");
				System.out.println("finished click button");
			}
			catch (Exception e)
			{
				logger.error("failed to press on button with exception: "+e.getMessage());
				fail(e.getMessage());
			}
		}
		
		public void clickButton (WebElement element)
		{
			try
			{
				System.out.println("inside click button");
				explicitWait(element);
				element.click();
				logger.info("clicked on button successfully");
				System.out.println("finished click button");
			}
			catch (Exception e)
			{
				logger.error("failed to click on button with exception: "+e.getMessage());
				fail(e.getMessage());
			}
		}
		
		public void sendText (WebElement element, String text)
		{
			try
			{
				//wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
				//wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
				//explicitWait(element);
				//Thread.sleep(1000);
				element.clear();
				logger.info("cleared text field "+element.getText());
				element.sendKeys(text);
				logger.info("inserted text "+text);
			}
			catch (Exception e)
			{
				logger.error("failed to perform sendText for text "+ text+" to element "+element.getText());
				fail();
			}
		}
		
		public void explicitWait(WebElement elem)
		{
			try
			{
				System.out.println(elem.getText());
				(new WebDriverWait(settings.getDriver(), 3)).until(ExpectedConditions.elementToBeClickable(elem));
			}
			catch (Exception e)
			{
				logger.error("explicit failed "+e);
			}
		}

}
