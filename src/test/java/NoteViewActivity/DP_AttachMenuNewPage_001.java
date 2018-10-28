package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoLoginClass;

public class DP_AttachMenuNewPage_001 extends AppiumDriverBase {

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

		// New 버튼 탭
		driver.findElement(By.id("com.fasoo.digitalpage:id/layGNBTabWrite")).click();
		Thread.sleep(1000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteViewActivity", getCurrentActivity1);

		// + 버튼 탭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageView'][@instance='0']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.ImageView'][@instance='0']")).click();
		Thread.sleep(3000);

		// 사진 메뉴 탭
		driver.findElement(By.id("com.fasoo.digitalpage:id/layMenuPhoto")).click();
		Thread.sleep(3000);

		// 카메라롤 탭
		driver.findElement(By.id("com.fasoo.digitalpage:id/layCamera")).click();
		Thread.sleep(3000);

		// 현재 액티비티 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".Camera", getCurrentActivity2);
		Thread.sleep(1000);

		// 기기의 Back 버튼 클릭
		driver.navigate().back();
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
