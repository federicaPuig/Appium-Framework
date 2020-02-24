package appiumcourse.AppiumMaven;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import appiumcourse.AppiumMaven.PageObjects.HomePage;
import appiumcourse.AppiumMaven.PageObjects.Preferences;
import appiumcourse.AppiumMaven.PageObjects.wiFi;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class apiDemoTest extends base{

	@Test(dataProvider = "InputData", dataProviderClass = TestData.class)
	public void apiDemo(String input) throws IOException, InterruptedException {
		
		service = startServer();
		//call desired capabilities method (call this in every test)
		AndroidDriver<AndroidElement> driver=Capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//YOU CAN NOT USE THIS ONE AS IT IS COMMON FOR ALL THE OBJECTS
		//driver.findElement(By.id("android:id/text1")).click();
		
		
		//page objects
		HomePage h = new HomePage(driver);
		h.Preferences.click(); //same as = driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		//USE THIS ONE INSTEAD AS THE TEXT IS A UNIQUE ATTRIBUTE 
		
		Preferences p = new Preferences(driver);
		
		p.Dependencies.click(); //same as = driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		
		wiFi w = new wiFi(driver);
		w.wiFiCheckBox.click();
		w.wiFiButton.click();
		w.wiFiSettings.sendKeys(input);
		w.okButton.click();
		
		
		
		//for the last line I can do it with find elementS it will grab all the elements with the same attribute 
		//but then use get and put index 2 (that will be 1) because start from 0, like array
		//driver.findElementsByClassName("android.widget.Button").get(1).click();

		service.stop();
	}
	

	

}
