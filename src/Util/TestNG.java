package Util;
import org.testng.annotations.Test;

public class TestNG {
		
	@Test
	public void login() throws Exception
	{
		new Testclasses.login().login();
		Thread.sleep(2000);
		new python().script();
	}
	
	

}
