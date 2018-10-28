package MoreTabMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoLoginClass;

public class DP_PrimeService_003 extends AppiumDriverBase {

	@Test
	public void End_To_End_Test_Sample() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();

		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(3000);

		// 자동 로그인 로직 (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = login.login(driver);
		Thread.sleep(3000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity1);

		// 더보기 아이콘 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@instance='4']")).click();
		Thread.sleep(3000);

		// 프라임 회원 혜택 알아보기 를 탭한다.
		AndroidElement ele = driver.findElement(By.id("com.fasoo.digitalpage:id/txtGetPrimeService"));
		Point loc = ele.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(5000);

		//연간 버튼 탭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnBuyYearly")).click();
		Thread.sleep(3000);
		
		// 창 내용 확인
		driver.findElement(By.id("com.android.vending:id/content1")).isDisplayed();
		String text1 = driver.findElement(By.id("com.android.vending:id/text")).getText();
		Assert.assertTrue(text1.contains("프라임서비스 - 연간 "));
		Thread.sleep(3000);
		
		
		// 기기의 Back 버튼 클릭
		driver.navigate().back();
		Thread.sleep(3000);
		
		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}




