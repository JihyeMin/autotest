package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

public class AutoPicturePageClass {
	public AppiumDriver<AndroidElement> ppage(AppiumDriver<AndroidElement> driver) {
		driver.findElement(By.id("com.fasoo.digitalpage:id/layGNBTabWrite")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAttach")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAttach")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/layMenuPhoto")).click();

		driver.findElement(By.xpath(
				"//*[@class='android.widget.RelativeLayout'][@index='1']" + "//*[@class='android.widget.ImageView'][@resource-id='com.fasoo.digitalpage:id/imgPhoto'][@index='0']")).click();
		
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_save")).click();

		return driver;
	}
}
