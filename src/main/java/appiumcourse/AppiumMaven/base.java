package appiumcourse.AppiumMaven;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	
		public static AndroidDriver<AndroidElement>  driver;
		public static AppiumDriverLocalService service;
	
		public AppiumDriverLocalService startServer() {
			boolean flag = checkIfServerIsRunning(4723);
			if(!flag) {
				service=AppiumDriverLocalService.buildDefaultService();
				service.start();
			}
			return service;
		}
		
		public static boolean checkIfServerIsRunning(int port) {
			
			boolean isServerRunning = false;
			ServerSocket serverSocket;
			
			try {
				serverSocket = new ServerSocket(port);
				serverSocket.close();
			} catch(IOException e){
				//if control comes here, it's means that the port is in use
				isServerRunning=true;
			}finally {
				serverSocket =null;
			}
			return isServerRunning;
			
		}
		
		//start emulator
		public static void startEmulator() throws IOException, InterruptedException {
			//C:\Users\Usuario\eclipse-workspace\AppiumMavenFramework\src\main\java\
			Runtime.getRuntime().exec(System.getProperty ("user.dir") + "\\src\\main\\java\\Resources\\startEmulator.bat");
			Thread.sleep(6000);
		}
	
		//WITH THIS METHOS WE INVOKE THE ANDROID STUDIO EMULATOR
		//we create a method as we are going to use this for every test case
		public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException{
			
			
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\appiumcourse\\AppiumMaven\\global.properties");
			
			Properties prop = new Properties();
			prop.load(file);
			
			 
			
			File appDir = new File ("src");
			//File fs = new File (f, "ApiDemos-debug.apk");
			File app = new File (appDir, (String) prop.get(appName));
			DesiredCapabilities cap = new DesiredCapabilities();
			
			
			//String device = (String) prop.get("device");
			
			String device = System.getProperty("deviceName");
		
			if(device.contains("federica")) {
				startEmulator();
			}else if(device.contains("real")){
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			}
			
			//WITH THIS WE INVOKE THE ANDROID STUDIO EMULATOR
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
			
			//WITH THIS METHOS WE INVOKE OUR NATIVE MOBILE
			//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			
			
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
			//cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			AndroidDriver<AndroidElement> driver = new AndroidDriver <>(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			return driver;
			
		}
		
		/*public static void getScreenshot(String result) throws IOException {
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\test\\"+result+"screenshot.png"));
		}*/
		public static void getScreenshot(String result) throws IOException {
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\test\\"+result+"screenshot.png"));
		}
		
		
		
	
		
	}


