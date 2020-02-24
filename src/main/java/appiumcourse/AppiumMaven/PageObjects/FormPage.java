package appiumcourse.AppiumMaven.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	//Concatenate driver
		public FormPage(AppiumDriver driver) {
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
			
		}
		
		@AndroidFindBy(className = "android.widget.EditText")
		private WebElement nameField;
		//driver.findElement(By.className("android.widget.EditText")).sendKeys("Federica");
		
		@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
		public WebElement femaleOption;
		//driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		@AndroidFindBy(id = "android:id/text1")
		private WebElement countryList;
		//driver.findElement(By.id("android:id/text1")).click();
		
		/*@AndroidFindBy(id = "android:id/text1")
		public WebElement CountriesList;
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		 */
		
		@AndroidFindBy(xpath = "//*[@text = 'Argentina']")
		public WebElement country;
		//driver.findElement(By.xpath("//*[@text = 'Argentina']")).click();
		
		@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
		public WebElement letsShopButton;
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		public WebElement getNameField() {
			System.out.println("trying to find name field");
			return nameField;
		}
		
		public WebElement getCountrySelection() {
			System.out.println("trying to find country");
			return countryList;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
