package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

public class AutoCreateAnotherPageClass {
	public AppiumDriver<AndroidElement> apage(AppiumDriver<AndroidElement> driver) {
		driver.findElement(By.id("com.fasoo.digitalpage:id/layGNBTabWrite")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).sendKeys("Create Another Page Test");
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_save")).click();

		return driver;
	}
}
