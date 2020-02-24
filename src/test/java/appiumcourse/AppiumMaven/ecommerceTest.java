package appiumcourse.AppiumMaven;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appiumcourse.AppiumMaven.base;
import appiumcourse.AppiumMaven.PageObjects.FormPage;
import appiumcourse.AppiumMaven.PageObjects.checkOutPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerceTest extends base{

	
		// TODO Auto-generated method stub

	@Test
	public void totalValidation() throws IOException, InterruptedException {
		
		service = startServer();
		
		AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FormPage f = new FormPage(driver);
		//f.nameField.sendKeys("federica");
		f.getNameField().sendKeys("federica");
		driver.hideKeyboard();
		
		f.femaleOption.click();
		f.getCountrySelection().click();
		
		//driver.findElement(By.className("android.widget.EditText")).sendKeys("Federica");
		//HIDE KEYBOARD
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		//driver.findElement(By.id("android:id/text1")).click();
		utilities u = new utilities(driver);
		u.scrollToText("Argentina");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		f.country.click();
		//driver.findElement(By.xpath("//*[@text = 'Argentina']")).click();
		f.letsShopButton.click();
		//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//add an item in the cart - first find the complete products list, then pass the name of the product to identify it 
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textContains(\"Air\").instance(0));"));
		
		//click on the add to cart button
		
		//First after find the product, get the number of visible product in the page
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		//loop into the list and get the texts of the visible products in the list
		for (int i=0; i<count; i++) {
			//save the text into a new variable
			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			//compare
			if (text.contains("Air")){
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				//break;
			}
			
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		
		
		//it will store the amount of the first item in the cart
		int size = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum = 0;
		
		checkOutPage c = new checkOutPage(driver);
		
		for (int j=0; j<size; j++) {
			String amount1 = c.productList.get(j).getText();	
			double amount = getAmount(amount1);	
			sum = sum + amount;
		}
		
		//we updated this code using the for loop
		/*String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();		
		//it will store the amount of the second item in the cart
		double value1 = getAmount(amount1);
		String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		double value2 = getAmount(amount2);*/
		//double sumOfProducts = value1 + value2;
		
		
				System.out.println(sum);
				
				String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
				total = total.substring(1);
				double finalTotal = Double.parseDouble(total);
				System.out.println(finalTotal);
				Assert.assertEquals(finalTotal, sum);
		
		/*// test case 3
		String lastPageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageText, "Jordan 6 Rings");	*/
		
		service.stop();
		
	}
	
	@BeforeTest
	public void killAllTheProcess() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	
	//method get amount
	/*
	 * //amount is a string ($120), to convert it into an int first use this to remove the $
				amount1 = amount1.substring(1);
				//then convert it into double
				double value1 = Double.parseDouble(amount1);
	 */
		public static double getAmount(String value){
			value = value.substring(1);
			double value1 = Double.parseDouble(value);
			return value1;
		}

}
