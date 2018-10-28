package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_SendPage_002 extends AppiumDriverBase {
	@Test
	public void sampleTest() throws Exception {
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
		Thread.sleep(10000);

		// 페이지 보기의 X 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		// driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(5000);

		// 최근 페이지 1번 리스트를 클릭
		driver.findElement(By.xpath(
				"//android.widget.FrameLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/swipe') and @index='0']"
						+ "//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot') and @index='0']"))
				.click();
		Thread.sleep(1000);

		// '...'버튼 메뉴를 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnMenu")).click();
		Thread.sleep(1000);

		// '보내기' 하위 메뉴를 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/laySendPage")).click();
		Thread.sleep(1000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".communication.ui.PageSendActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// 유효한 이메일 입력
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).sendKeys("test01@fasoo.com");
		Thread.sleep(1000);
		driver.findElement(By.id("com.fasoo.digitalpage:id/rvAutoCompleteList")).click();
		Thread.sleep(1000);

		Assert.assertTrue(driver
				.findElement(By.xpath(
						"//android.widget.LinearLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot')]"))
				.isEnabled());
		assertEquals("test01",
				driver.findElement(By.xpath("//*[@class='android.support.v7.widget.RecyclerView'][@index='0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtAccountName')]"))
						.getText());
		assertEquals("test01@fasoo.com",
				driver.findElement(By.xpath("//*[@class='android.support.v7.widget.RecyclerView'][@index='0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtEmailAddress')]"))
						.getText());
		Thread.sleep(1000);

		// 보내기 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_send_page")).click();
		Thread.sleep(3000);

		// 현재 액티비티 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteVeiwActivity", getCurrentActivity2);
		Thread.sleep(1000);

		// 페이지 보기의 X 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub

	}

}
