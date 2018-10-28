package HomeActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import Common.AutoLoginClass;
import appium.AppiumDriverBase;
import java.util.concurrent.TimeUnit;

public class DP_HomeActivity_001 extends AppiumDriverBase  {

	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();
		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(1000);

		// 자동 로그인 로직 (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = (AndroidDriver) login.login(driver);
		Thread.sleep(3000);

		// 알림 아이콘 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAlarm")).click();
		Thread.sleep(3000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.ActivityLogsActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// 알림이 없는 경우 메시지 확인
		assertEquals("새로운 알림이 없습니다.", driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@instance='2']")).getText());
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// 현재 액티비티 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity2);
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
