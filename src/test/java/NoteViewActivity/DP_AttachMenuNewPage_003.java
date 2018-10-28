package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_AttachMenuNewPage_003 extends AppiumDriverBase {

	@Test
	public void End_To_End_Test_Sample() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();
		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(3000);

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

		// 음성 메뉴 탭
		driver.findElement(By.id("com.fasoo.digitalpage:id/layMenuVoice")).click();
		Thread.sleep(1000);

		// 첨부 버튼 상태 확인 - 비활성
		Assert.assertFalse(driver.findElement(By.id("com.fasoo.digitalpage:id/btnAttach")).isEnabled());
		Thread.sleep(1000);
		
		// 녹음 시작
		driver.findElement(By.id("com.fasoo.digitalpage:id/imgRecord")).click();
		Thread.sleep(3000);
		
		assertEquals("녹음 중…", driver.findElement(By.id("com.fasoo.digitalpage:id/txtRecording")).getText());
		
		// 녹음 정지
		driver.findElement(By.id("com.fasoo.digitalpage:id/imgRecord")).click();
		Thread.sleep(3000);

		// 첨부 버튼 상태 확인 - 활성
		Assert.assertTrue(driver.findElement(By.id("com.fasoo.digitalpage:id/btnAttach")).isEnabled());
		Thread.sleep(1000);
		
		// 첨부 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAttach")).click();
		Thread.sleep(3000);

		// 저장 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_save")).click();
		Thread.sleep(3000);

		// 닫기 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
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
