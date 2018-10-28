package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

public class AutoEmptyTrashboxClass {
	public AppiumDriver<AndroidElement> Empty(AppiumDriver<AndroidElement> driver) {
		// ������ �޴� Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();
		
		// ������ ���� > ������ �޴��� ���Ѵ�.
		AndroidElement ele = driver.findElement(By.id("com.fasoo.digitalpage:id/layRecycleList"));
		Point loc = ele.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		
		// ������ ���� ������ Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnTrash")).click();
		// ������ ���� ����
		driver.findElement(By.id("android:id/button1")).click();

		return driver;
	}

}
