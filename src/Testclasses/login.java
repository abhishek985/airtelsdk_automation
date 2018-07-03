package Testclasses;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class login {

	public void login() throws InterruptedException, MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.VERSION, "7.1.1");
		capabilities.setCapability("deviceName", "e060b2a4");
		capabilities.setCapability("appPackage","tv.airtel.visionsample");
		capabilities.setCapability("appActivity",".activity.SplashActivity");
		capabilities.setCapability("autoGrantPermissions","true");


		AndroidDriver  dr = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
		if(dr.findElementById("tv.airtel.visionsample:id/btn_register") != null)
		{
			dr.findElementById("tv.airtel.visionsample:id/btn_register").click();
			dr.findElementById("tv.airtel.visionsample:id/et_mobile_no").click();
			dr.findElementById("tv.airtel.visionsample:id/et_mobile_no").sendKeys("8888888888");
			dr.findElementById("tv.airtel.visionsample:id/btn_send_otp").click();
			dr.findElementById("tv.airtel.visionsample:id/btn_login").click();
			dr.findElementById("tv.airtel.visionsample:id/et_otp").sendKeys("1234");
			dr.findElementById("tv.airtel.visionsample:id/btn_login").click();
		}}
		
		catch(Exception e)
		{
			System.out.println("Seamlessly logged in ");
		}

	}
}
