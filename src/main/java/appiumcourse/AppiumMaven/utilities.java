package appiumcourse.AppiumMaven;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class utilities {
	AndroidDriver driver;
	
	
	public utilities(AndroidDriver <AndroidElement>driver) {
		this.driver=driver;
	}

	public void scrollToText(String text) {
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
		
	}


}
