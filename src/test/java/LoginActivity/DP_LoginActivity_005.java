package LoginActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import appium.AppiumDriverBase;
import java.util.concurrent.TimeUnit;

public class DP_LoginActivity_005 extends AppiumDriverBase  {

	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();
		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(1000);

		// 'Naver' 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLoginNaver")).click();
		Thread.sleep(3000);

		// 알림 팝업 - 취소 버튼 클릭
		driver.findElement(By.id("android:id/content"));
		assertEquals("네이버 앱을 설치하면\n이용할 수 있는 서비스입니다.", driver.findElement(By.id("android:id/message")).getText());
		driver.findElement(By.id("android:id/button2")).click();
		Thread.sleep(3000);

		// 현재 액티비티 확인
		String getCurrentActivity = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".OAuthLoginInAppBrowserActivity", getCurrentActivity);
		Thread.sleep(3000);

		// 'Naver' 계정 로그인
		driver.findElement(By.id("id")).click();
		driver.findElement(By.id("id")).sendKeys("fasootest01");
		driver.findElement(By.id("pw")).click();
		driver.findElement(By.id("pw")).sendKeys("Test04!#%");
		driver.findElement(By.id("login_submit")).click();
		Thread.sleep(5000);

		// 현재 액티비티 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity2);

		// 더보기 아이콘 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();
		Thread.sleep(1000);

		// 계정 정보 확인
		assertEquals("fasootest01@naver.com", driver.findElement(By.id("com.fasoo.digitalpage:id/txtEmail")).getText());
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub
		
	}
}
