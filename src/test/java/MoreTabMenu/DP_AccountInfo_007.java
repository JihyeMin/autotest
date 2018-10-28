package MoreTabMenu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;


import Common.AutoAccountInfoClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_AccountInfo_007 extends AppiumDriverBase {

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

		// 더보기 아이콘 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@instance='4']")).click();
		Thread.sleep(1000);

		// 걔정 정보 영역을 탭한다. (AutoAccountInfoClass.java)
		AutoAccountInfoClass AccountInfo1 = new AutoAccountInfoClass();
		driver = AccountInfo1.AccountInfo(driver);
		Thread.sleep(1000);

		// 현재 액티비티 확인
		assertEquals("계정", driver.findElement(By.id("com.fasoo.digitalpage:id/tbarTitle")).getText());
		Thread.sleep(1000);

		// 로그아웃 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLogout")).click();
		Thread.sleep(1000);

		// 알림창 확인
		assertEquals("로그아웃 하시겠습니까?", driver.findElement(By.id("android:id/message")).getText());
		Thread.sleep(1000);

		// 확인 버튼 클릭
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);

		// 현재 액티비티 확인 
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.LoginActivity", getCurrentActivity2);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}

