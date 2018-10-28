package LoginActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import appium.AppiumDriverBase;
import java.util.concurrent.TimeUnit;

public class DP_LoginActivity_004 extends AppiumDriverBase  {

	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();

		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(1000);

		// 'Google+' 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLoginGoogle")).click();
		Thread.sleep(1000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".AccountChipAccountPickerActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// 1번 인덱스 사용자 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout'][@index='1']")).click();
		Thread.sleep(1000);

		// 현재 액티비티 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity2);
		Thread.sleep(1000);

		// 더보기 아이콘 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();

		// 계정 정보 확인
		assertEquals("fasootest04@gmail.com", driver.findElement(By.id("com.fasoo.digitalpage:id/txtEmail")).getText());
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub
		
	}
}
