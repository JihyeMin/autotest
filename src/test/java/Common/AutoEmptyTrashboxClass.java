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
		// 더보기 메뉴 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();
		
		// 페이지 관리 > 휴지통 메뉴를 탭한다.
		AndroidElement ele = driver.findElement(By.id("com.fasoo.digitalpage:id/layRecycleList"));
		Point loc = ele.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		
		// 휴지통 비우기 아이콘 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnTrash")).click();
		// 휴지통 비우기 동의
		driver.findElement(By.id("android:id/button1")).click();

		return driver;
	}

}
