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
		// �� ����.
		driver.launchApp();
		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(1000);

		// �ڵ� �α��� ���� (AutoAnotherLoginClass.java)
		AutoAnotherLoginClass login = new AutoAnotherLoginClass();
		driver = login.login(driver);
		Thread.sleep(1000);

		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAlarm")).click();
		Thread.sleep(3000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.ActivityLogsActivity", getCurrentActivity1);

		// ���� ������ ��� ���� Ȯ��
		assertEquals("���� ������",
				driver.findElement(By.xpath(
						"//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layTitle')]"
								+ "//android.widget.TextView [@index='0']"))
						.getText());
		assertEquals("1���� ���� �������� Ȯ���ϼ���.", driver.findElement(
				By.xpath("//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layTitle')]"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtReceiveMsg')]"))
				.getText());

		// ���� ������ ����Ʈ1�� ��
		AndroidElement menu1 = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']"));
		Point loc1 = menu1.getLocation();
		int x = loc1.getX();
		int y = loc1.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(3000);

		// ���� ��Ƽ��Ƽ Ȯ��
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
		Assert.assertTrue(text1.contains("#���� ������"));

		// �ڵ� ������ ���� ���� (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(1000);

		// �ڵ� ������ ���� ���� (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(1000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}


	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub

	}

}
