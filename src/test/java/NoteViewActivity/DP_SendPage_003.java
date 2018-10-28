package NoteViewActivity;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoAnotherLoginClass;
import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;

import static org.junit.Assert.assertEquals;

public class DP_SendPage_003 extends AppiumDriverBase {
	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();
		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(1000);

		// 자동 로그인 로직 (AutoAnotherLoginClass.java)
		AutoAnotherLoginClass login = new AutoAnotherLoginClass();
		driver = login.login(driver);
		Thread.sleep(1000);

		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAlarm")).click();
		Thread.sleep(3000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.ActivityLogsActivity", getCurrentActivity1);

		// 받은 페이지 요약 정보 확인
		assertEquals("받은 페이지",
				driver.findElement(By.xpath(
						"//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layTitle')]"
								+ "//android.widget.TextView [@index='0']"))
						.getText());
		assertEquals("1개의 받은 페이지를 확인하세요.", driver.findElement(
				By.xpath("//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layTitle')]"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtReceiveMsg')]"))
				.getText());

		// 받은 페이지 리스트1번 탭
		AndroidElement menu1 = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']"));
		Point loc1 = menu1.getLocation();
		int x = loc1.getX();
		int y = loc1.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(3000);

		// 현재 액티비티 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.ReceivedPageListActivity", getCurrentActivity2);

		//
		assertEquals("test04, test04@fasoo.com",
				driver.findElement(By.xpath("//android.widget.RelativeLayout[@index= '0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSenderEmail')]"))
						.getText());

		//
		driver.findElement(By.id("com.fasoo.digitalpage:id/layRoot")).click();
		Thread.sleep(1000);

		//
		driver.findElement(By.xpath("//android.widget.ImageButton[@index= '0']")).click();
		Thread.sleep(1000);

		//
		driver.findElement(By.xpath("//android.widget.ImageButton[@index= '0']")).click();
		Thread.sleep(1000);

		//
		driver.findElement(By.xpath("//android.widget.ImageButton[@index= '0']")).click();
		Thread.sleep(1000);

		String text1 = driver.findElement(By.xpath("//android.widget.FrameLayout[@index= '0']" + "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary')]")).getText();
		Assert.assertTrue(text1.contains("#받은 페이지"));

		// 자동 페이지 삭제 로직 (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(1000);

		// 자동 휴지통 비우기 로직 (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}


	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub

	}

}
