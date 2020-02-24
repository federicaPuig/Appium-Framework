package appiumcourse.AppiumMaven.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class checkOutPage {

	//Concatenate driver
			public checkOutPage(AppiumDriver driver) {
				PageFactory.initElements(new AppiumFieldDecorator(driver), this);
				
			}
			
			@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
			public List<WebElement> productList;
			//String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName"))
			
			@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
			public List<WebElement> totalAmount;
			//driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl"))
			
			
			
			
			
			
			
			
			
			
	
}
