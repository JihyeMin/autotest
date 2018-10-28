package MoreTabMenu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_AppInfoMenu_001 extends AppiumDriverBase {

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
		
		// 현재 액티비티 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.SettingPopUpActivity", getCurrentActivity2);
		
		// 설정 탑바 확인
		assertEquals("설정", driver.findElement(By.id("com.fasoo.digitalpage:id/txtToolbarTitle")).getText());
		Thread.sleep(1000);
		
		// 버전 정보 확인
		assertEquals("3.2.3", driver.findElement(By.id("com.fasoo.digitalpage:id/txtAppVersion")).getText());
		Thread.sleep(1000);
		
		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
