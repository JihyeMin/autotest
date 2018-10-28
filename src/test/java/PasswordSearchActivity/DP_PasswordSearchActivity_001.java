package PasswordSearchActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import appium.AppiumDriverBase;
import java.util.concurrent.TimeUnit;

public class DP_PasswordSearchActivity_001 extends AppiumDriverBase  {

	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();
		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(1000);

		// 'Digitalpage 계정으로 로그인' 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLoginWiseVine")).click();
		Thread.sleep(1000);

		// 비밀번호 찾기 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtPasswordSearch")).click();
		Thread.sleep(1000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.PasswordSearchActivity", getCurrentActivity1);
		Thread.sleep(1000);
		
		// 이메일 입력 후 재설정 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).sendKeys("test04@fasoo.com");
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnReset")).click();
		Thread.sleep(3000);

		// 현재 액티비티 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.LoginWiseVineActivity", getCurrentActivity2);
		Thread.sleep(1000);
		
		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub
		
	}
}
