package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.baseclass.Baseclass;

public class TakeScreenShot extends Baseclass {

	
	public static void TakeScreenshotForFailedTestCase() {
		String CurrentDirect = System.getProperty("user.dir");
		File SourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SourcePath,new File (CurrentDirect+"/screenshots/"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
