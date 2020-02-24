package appiumcourse.AppiumMaven.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preferences {
	
	/*public Preferences(AppiumDriver driver) {
		//PageFactory.initElements(new AppiumFieldDecorator((driver), 20, TimeUnit.SECONDS, this);
		PageFactory.initElements(new AppiumFieldDecorator(driver), 20, TimeUnit.SECONDS, this);
	}*/
	
	public Preferences(AppiumDriver driver) {
		//super(driver);
		PageFactory.initElements(new AppiumFieldDecorator((driver)), this);
		
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	public AndroidElement Dependencies;

}
