package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class AutoDeleteSpecificPage2Class {
	public AppiumDriver<AndroidElement> spage2(AppiumDriver<AndroidElement> driver) {
		
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id, 'com.fasoo.digitalpage:id/recyclerHomeRecentPages') and @index='1']" + "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary') and @text='Connection Page']")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnMenu")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/layDelete")).click();
		return driver;
	}
}
