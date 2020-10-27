/*Open the Chrome app on your device.
Go to the following URL: https://www.training-support.net/selenium
Scroll to find the To-Do List card and click it.
Once the page loads, find the input field on the page and enter the following three tasks:
Add tasks to list
Get number of tasks
Clear the list
Click on each of the tasks added to strike them out.
Finally, clear the list.
Add assertions to verify that the test has passed or failed.
*/

package APPIUM.APPIUM;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 3");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appServer, caps);
		wait = new WebDriverWait(driver, 50);
		driver.get("https://www.training-support.net/selenium");

	}

	@Test
	public void f() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
	
        wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));
	
 
	
        // Count the number of images shown on the screen
	
        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
	
        System.out.println("Number of image shown currently: " + numberOfImages.size());
	
        
	
        // Assertion before scrolling
	
        Assert.assertEquals(numberOfImages.size(), 4);
	
        
	
        // Scroll to Helen's post
	
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
	
        
	
        // Find the number of images shown after scrolling
	
        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
	
        System.out.println("Number of image shown currently: " + numberOfImages.size());
	
        
	
        // Assertion after scrolling
	
        Assert.assertEquals(numberOfImages.size(), 4);

	}
	/*
	 * @AfterClass public void afterClass() { driver.quit(); }
	 */
}
