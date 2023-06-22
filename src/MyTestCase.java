import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyTestCase {
  DesiredCapabilities caps = new DesiredCapabilities() ;
  SoftAssert myAssertion = new SoftAssert();
  Random  myRandom = new Random ();


  @BeforeTest
  public void mySetup() {
	 File app = new File ("src/calculator.apk");
	 caps.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
	  
	 caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	 caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel");
//	 caps.setCapability("chromedriverExecutable","C:\\Users\\User\\OneDrive\\Desktop\\chromeweb\\chromedriver.exe");
//	 caps.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
  }
  
  @Test() 
  public void ClickonDigits8462() throws MalformedURLException, InterruptedException {
	  AndroidDriver driver= new  AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);

		List<WebElement> myButtons = driver.findElements(By.className("android.widget.ImageButton"));

		   driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
           driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
           driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
           driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
           Thread.sleep(2000);
//         Test
		   String [] myNumber = {"8", "4", "6","2"};
		   int index = myRandom.nextInt(0,4);
	       System.out.println(myNumber[index]);
    
//		   softAssert
		   String Expected ="8462";
		   String Actul =driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
		
		   myAssertion.assertEquals(Actul,Expected);
	       myAssertion.assertAll();
		}
  
  @AfterTest () 
  public void Finish() {
  
  }}