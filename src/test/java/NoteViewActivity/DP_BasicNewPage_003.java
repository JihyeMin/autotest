package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_BasicNewPage_003 extends AppiumDriverBase {

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

		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).sendKeys("Create Page Test");
		
		// 닫기 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// 알림창 리소스 확인 및 저장 후 나가기 버튼 클릭
		assertEquals("작성중인 페이지가 저장되지 않았습니다.\n페이지를 저장하고 나가시겠습니까?", driver.findElement(By.id("android:id/message")).getText());
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);

		// 자동 페이지 삭제 로직 (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(1000);

		// 자동 휴지통 비우기 로직
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
