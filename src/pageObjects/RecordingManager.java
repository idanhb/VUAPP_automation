package pageObjects;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.fail;
import static utilities.CommonOps.logger;
import utilities.Base;

public class RecordingManager extends Base
{
	utilities.CommonOps comOpsRM = new utilities.CommonOps();
	LoginWindow LW = new LoginWindow();
	RIScreen RIS = new RIScreen();
	
	@FindBy (how=How.XPATH , using="//*[@text='Use playlist']")
	public WebElement usePlaylistFlag;
	
	@FindBy (how=How.ID , using="remote_recordings")
	public WebElement remoteRecordingsRadioButton;
	
	@FindBy (how=How.ID , using="recording_tv_StartStopPlayButton")
	public WebElement startStopPlayingButton;
	
	@FindBy (how=How.XPATH , using="//*[@index='0']")
	public WebElement firstRecordingIndex;
	
	@FindBy (how=How.XPATH , using="//*[@text='38:a2:8c:c9:71:d2']")
	public WebElement myRecording;
	
	@FindBy (how=How.XPATH , using="//*[@class='android.widget.TableLayout' and ./*[./*[@text='02:13']]]")
	public WebElement firstRecordIndex;
	
	public void playRecording()
	{
		try
		{
			comOpsRM.clickButton(usePlaylistFlag);
			comOpsRM.clickButton(remoteRecordingsRadioButton);
			comOpsRM.clickButton(myRecording);
			comOpsRM.clickButton(firstRecordIndex);
			logger.info("StartStop playing button state is: " + startStopPlayingButton.getText());
			if (startStopPlayingButton.getText() == "Start Playing")
			{
				logger.info("Starting playback with recording from unit " + myRecording.getText());
				comOpsRM.clickButton(startStopPlayingButton);
			}
			else 
			{
				logger.info("playback already running. Pressing twice on start/stop button");
				comOpsRM.clickButton(startStopPlayingButton);
				comOpsRM.clickButton(startStopPlayingButton);
			}
		}
		catch (Exception e)
		{
			logger.error("Caught Exception: " + e.getMessage());
			fail();
		}
	}
	
}


