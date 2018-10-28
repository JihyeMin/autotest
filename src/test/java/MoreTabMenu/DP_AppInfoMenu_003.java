package MoreTabMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_AppInfoMenu_003 extends AppiumDriverBase {

	@Test
	public void End_To_End_Test_Sample() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();

		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(1000);

		// 자동 로그인 로직 (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = login.login(driver);
		Thread.sleep(1000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity1);

		// 더보기 메뉴 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@instance='4']")).click();
		Thread.sleep(1000);
		
		// 설정 아이콘 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnSetting")).click();
		Thread.sleep(1000);
		
		// 설정 탑바 확인
		assertEquals("설정", driver.findElement(By.id("com.fasoo.digitalpage:id/txtToolbarTitle")).getText());
		Thread.sleep(1000);
		
		// 개인정보처리방침 영역 탭
		AndroidElement ele = driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@instance='15']"));
		Point loc = ele.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(5000);
		
		// 현재 액티비티 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.SettingPopUpActivity", getCurrentActivity2);
		
		// 이용약관 탑바 확인
		assertEquals("개인정보처리방침", driver.findElement(By.id("com.fasoo.digitalpage:id/txtToolbarTitle")).getText());
		Thread.sleep(1000);
		
		// X버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);
				
		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
