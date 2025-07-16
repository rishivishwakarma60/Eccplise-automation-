package com.srashtasoft;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;

import org.openqa.selenium.*;


public class App 
{
    public static void main( String[] args )
    {
    	
    	 AndroidDriver driver=null;
    	
    	  Capabilities options = new BaseOptions()
    		      .amend("platformName", "Android")
    		      .amend("appium:deviceName", "12151314A1123898")
    		      .amend("appium:udid", "12151314A1123898")
    		      .amend("appium:automationName", "UiAutomator2")
    		      .amend("appium:appPackage", "com.example.counter_app")
    		      .amend("appium:appActivity", ".MainActivity")
    		      .amend("appium:noReset", true)
    		      .amend("appium:ignoreHiddenApiPolicyError", true)
    		      .amend("appium:disableSuppressAccessibilityService", true)
    		      .amend("appium:ensureWebviewsHavePages", true)
    		      .amend("appium:nativeWebScreenshot", true)
    		      .amend("appium:newCommandTimeout", 3600)
    		      .amend("appium:connectHardwareKeyboard", true);    

    		    try {
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
					 System.out.println("Session created app started ");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }
}
