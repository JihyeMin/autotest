package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

public class AutoAccountInfoClass {
	public AppiumDriver<AndroidElement> AccountInfo(AppiumDriver<AndroidElement> driver) {
		
		AndroidElement ele = driver.findElement(By.id("com.fasoo.digitalpage:id/txtName"));
		Point loc = ele.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();

		return driver;
	}
}
