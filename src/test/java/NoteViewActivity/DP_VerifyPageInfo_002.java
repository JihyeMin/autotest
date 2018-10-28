package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DP_VerifyPageInfo_002 extends AppiumDriverBase {

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

		// 자동 페이지 작성 로직 (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = cpage.cpage(driver);
		Thread.sleep(1000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteViewActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// i 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_info")).click();
		Thread.sleep(1000);

		// 디스플레이 확인
		driver.findElement(By.id("com.fasoo.digitalpage:id/layNoteInfoContainer")).isDisplayed();
				
		// 오늘 날짜 계산
		DateFormat dateFormat1 = new SimpleDateFormat("yyy년 M월 d일");
		Date date = new Date();
		String date1 = dateFormat1.format(date);

		// 작성일 확인
		String text1 = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']" + "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtCreatedTime') and @index='2']")).getText();
		Assert.assertTrue(text1.contains(date1));
		
		// 수정일 확인
		String text2 = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='4']" + "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtUpdatedTime') and @index='2']")).getText();
		Assert.assertTrue(text2.contains(date1));

		// i 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_info")).click();
		Thread.sleep(1000);

		// 페이지 보기의 X 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// 자동 페이지 삭제 로직 (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(3000);

		// 자동 휴지통 비우기 로직 (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(3000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
