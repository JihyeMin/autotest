package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class AutoCreatePageClass {
	public AppiumDriver<AndroidElement> cpage(AppiumDriver<AndroidElement> driver) {
		driver.findElement(By.id("com.fasoo.digitalpage:id/layGNBTabWrite")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).sendKeys("Create Page Test");
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_save")).click();
		return driver;
	}

}
