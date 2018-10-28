package LoginActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import appium.AppiumDriverBase;
import java.util.concurrent.TimeUnit;

public class DP_LoginActivity_006 extends AppiumDriverBase  {

	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();
		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(1000);

		// 'Kakao' 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLoginKakao")).click();
		Thread.sleep(5000);

		// 현재 액티비티 확인
		String getCurrentActivity = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".KakaoWebViewActivity", getCurrentActivity);
		Thread.sleep(5000);

		// 'Kakao' 계정 로그인
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[45,300][915,426]']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[45,300][915,426]']")).sendKeys("test04@fasoo.com");
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[45,435][915,561]']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[45,435][915,561]']")).sendKeys("test02!#%");
		driver.findElement(By.xpath("//android.view.View[@bounds='[45,642][1035,807]']")).click();
		Thread.sleep(5000);

		// 현재 액티비티 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity2);

		// 더보기 아이콘 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();

		// 계정 정보 확인
		assertEquals("test04@fasoo.com", driver.findElement(By.id("com.fasoo.digitalpage:id/txtEmail")).getText());
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub
		
	}
}
