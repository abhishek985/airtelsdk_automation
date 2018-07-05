package Testclasses;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public  class atvsample {

	static WebDriver dr;
	public static DesiredCapabilities init() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.VERSION, "4.4.2");
		//capabilities.setCapability(MobileCapabilityType.PLATFORM, "Windows");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage","tv.airtel.visionsample");
		capabilities.setCapability("appActivity",".activity.SplashActivity");
		capabilities.setCapability("autoGrantPermissions","true");

		return capabilities;
	}

	@Test
	public void login() throws InterruptedException, IOException, ParseException {		
		WebDriver dr = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),atvsample.init());
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(10000);
		System.out.println("Home Page");
		//		Boolean reg= dr.findElementById("tv.airtel.visionsample:id/btn_register").isDisplayed();
		//		if(reg = true) {
		//			dr.findElementById("tv.airtel.visionsample:id/btn_register").click();
		//			dr.findElementById("tv.airtel.visionsample:id/et_mobile_no").click();
		//			dr.findElementById("tv.airtel.visionsample:id/et_mobile_no").sendKeys("8888888888");
		//			//dr.findElementById("tv.airtel.visionsample:id/btn_send_otp").click();
		//			dr.findElementById("tv.airtel.visionsample:id/btn_login").click();
		//			dr.findElementById("tv.airtel.visionsample:id/et_otp").sendKeys("1234");
		//			dr.findElementById("tv.airtel.visionsample:id/btn_login").click();
		//			//  dr.navigate().back();
		//			//   KeyEvent keyEvent = Key;
		//		}
		//
		//		else{
		//
		//			System.out.println("Seamless Login");
		//
		//		}


		String s1=new Util.python1().python();
		new Util.python().script(s1,1);
		dr.findElement(By.xpath(("//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]" +
				"/android.widget.FrameLayout/android.widget.ImageView"))).click();
		System.out.println("switched to player page");
		Thread.sleep(10000);

		dr.findElement(By.id("tv.airtel.visionsample:id/iv_play")).click();
		System.out.println("playing");
		
		for(int i=0;i<3;i++) {
		String s2=new Util.python1().python();
		new Util.python().script(s2,i+2);
		Thread.sleep(2000);
		}

		//dr.navigate().back();		
	}
}
