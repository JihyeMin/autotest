package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_BasicNewPage_006 extends AppiumDriverBase {

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

		// New 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/layGNBTabWrite")).click();
		Thread.sleep(1000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteViewActivity", getCurrentActivity1);

		// 내용 없을 때 텍스트 카운트 확인
		assertEquals("0 / 3000", driver.findElement(By.id("com.fasoo.digitalpage:id/txtCount")).getText());

		// 내용 입력
		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).sendKeys("Create Page Test");
		
		// 내용 있을 때 텍스트 카운트 확인
		assertEquals("16 / 3000", driver.findElement(By.id("com.fasoo.digitalpage:id/txtCount")).getText());
		
		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
