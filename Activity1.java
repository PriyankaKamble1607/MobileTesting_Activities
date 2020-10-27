package APPIUM.APPIUM;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1
{
	    AppiumDriver<MobileElement> driver = null;
	    
	    @BeforeClass
	    public void beforeClass() throws MalformedURLException
	    {
	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceName", "Pixel 3");
	        caps.setCapability("platformName", "Android");
	        caps.setCapability("appPackage","com.google.android.apps.tasks");
	        caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	    }

	    @Test
	    public void GoogleTasks() throws InterruptedException 
	    {
	    	        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Create New Message\")")).click();
	
 
	
        // Enter the number to send message to
	
        String contactBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/auto_complete_contact\")";
	
        // Enter your own phone number
	
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("1234567890");
	
 
	
        // Focus on the message text box
	
        String messageBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/hint_message\")";
	
        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();
	
 
	
     
	
        messageBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/sms_edit_text\")";
	
        MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
	
        composeMessageInput.sendKeys("Hello from Appium");
	
 
	
        // Send the message
	
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();
	
 
	
	
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text_view")));
	
 
	
        // Assertion
	
        String messageLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/message_text_view\")";
	
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
	
        Assert.assertEquals(sentMessageText, "Hello from Appium");
	    }
/*
	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	    */
	}
	
