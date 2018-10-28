package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class AutoDeletePageClass {
	public AppiumDriver<AndroidElement> dpage(AppiumDriver<AndroidElement> driver) {
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/swipe') and @index='0']" + "//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot') and @index='0']")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnMenu")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/layDelete")).click();
		return driver;
	}
}
