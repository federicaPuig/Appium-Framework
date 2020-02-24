package appiumcourse.AppiumMaven.PageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class wiFi {
	
	public wiFi(AppiumDriver driver) {
		//super(driver);
		PageFactory.initElements(new AppiumFieldDecorator((driver)), this);
		
	}
	
	@AndroidFindBy(id ="android:id/checkbox")
	public AndroidElement wiFiCheckBox;
	
	@AndroidFindBy(xpath ="(//android.widget.RelativeLayout)[2]")
	public AndroidElement wiFiButton;
	
	@AndroidFindBy(id ="android:id/edit")
	public AndroidElement wiFiSettings;
	
	@AndroidFindBy(id ="android:id/button1")
	public AndroidElement okButton;
	
	
	//driver.findElementById("android:id/checkbox").click();
	//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
	//driver.findElementById("android:id/edit").sendKeys("test");
	//driver.findElementById("android:id/button1").click();

}
