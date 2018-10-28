package MoreTabMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoAccountInfoClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;


public class DP_AccountInfo_003 extends AppiumDriverBase {

	@Test
	public void End_To_End_Test_Sample() throws Exception {
		driver.closeApp();
		// �� ����.
		driver.launchApp();

		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(1000);

		// �ڵ� �α��� ���� (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = login.login(driver);
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity1);

		// ������ ������ Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@instance='4']")).click();
		Thread.sleep(1000);

		// ���� ���� ������ ���Ѵ�. (AutoAccountInfoClass.java)
		AutoAccountInfoClass AccountInfo1 = new AutoAccountInfoClass();
		driver = AccountInfo1.AccountInfo(driver);
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		assertEquals("����", driver.findElement(By.id("com.fasoo.digitalpage:id/tbarTitle")).getText());
		Thread.sleep(1000);

		// ������ ���� �޴� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/layProfileSettings")).click();
		Thread.sleep(5000);

		// ������ �̹��� ���� ��
		AndroidElement ele1 = driver.findElement(By.id("com.fasoo.digitalpage:id/imgAccountPhoto"));
		Point loc1 = ele1.getLocation();
		int x = loc1.getX();
		int y = loc1.getY();

		TouchAction touchAction1 = new TouchAction(driver);
		touchAction1.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(1000);

		// ���� �ٹ����� ���� ���� �޴� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtSelect")).click();
		Thread.sleep(1000);

		// ���� �ٹ� ��ư ��
		driver.findElement(By.xpath(
				"//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/fl') and @index='1']"
						+ "//android.widget.ImageView[contains(@resource-id, 'com.fasoo.digitalpage:id/iv_galleryitem') and @index='0']"))
				.click();
		Thread.sleep(1000);

		Assert.assertTrue(
				driver.findElement(By.id("com.fasoo.digitalpage:id/chkbox_gallery_photo_select")).isEnabled());
		Thread.sleep(1000);

		// ī�޶�� V����
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_pick_done")).click();
		Thread.sleep(1000);

		// ������ V����
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnDone")).click();
		Thread.sleep(1000);

		// �� �� �۾�
		// ������ ���� �޴� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/layProfileSettings")).click();
		Thread.sleep(5000);

		// ������ �̹��� ���� ��
		AndroidElement ele2 = driver.findElement(By.id("com.fasoo.digitalpage:id/imgAccountPhoto"));
		Point loc2 = ele2.getLocation();
		int z = loc2.getX();
		int w = loc2.getY();

		TouchAction touchAction2 = new TouchAction(driver);
		touchAction2.tap(new PointOption().withCoordinates(z, w)).perform();
		Thread.sleep(1000);

		// ���� �ٹ����� ���� ���� �޴� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtDelete")).click();
		Thread.sleep(1000);

		// ������ V����
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnDone")).click();
		Thread.sleep(1000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
