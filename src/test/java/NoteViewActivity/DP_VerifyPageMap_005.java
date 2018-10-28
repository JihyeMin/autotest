package NoteViewActivity;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoCreatePageClass;
import Common.AutoDeleteSpecificPage1Class;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;
import appium.AppiumDriverBase;

import static org.junit.Assert.assertEquals;


public class DP_VerifyPageMap_005 extends AppiumDriverBase {
	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();

		// �� ����
		driver.launchApp();

		// �ڵ� �α��� ���� (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = (AndroidDriver) login.login(driver);
		Thread.sleep(1000);

		// �ڵ� ������ �ۼ� ���� (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = (AndroidDriver) cpage.cpage(driver);
		Thread.sleep(1000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// �ֽ����������� ����Ʈ ����
		driver.findElement(By.xpath(
				"//android.widget.FrameLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/swipe') and @index='0']"
						+ "//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot') and @index='0']"))
				.click();
		Thread.sleep(3000);

		// �������� ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_pagemap")).click();
		Thread.sleep(3000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.PageMapActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// ���������� ��带 ��
		AndroidElement node1 = (AndroidElement) driver
				.findElement(By.xpath("//*[@class='android.widget.RelativeLayout'][@index='0']"
						+ "//android.view.View[contains(@resource-id, 'com.fasoo.digitalpage:id/pageMapViewer') and @index='0']"));
		Point loc = node1.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		// ����
		int Width = node1.getSize().width;
		// ����
		int Height = node1.getSize().height;

		// �� ��ǥ ���
		int nodeX = (int) ((loc.getX() + Width) * 0.5);
		int nodeY = (int) ((loc.getY() + Height) * 0.5);

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(nodeX, nodeY)).perform();
		Thread.sleep(1000);

		// ������ ��� ���� Ȯ��
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout'][@index='0']")).isEnabled());

		// ������ ������ ���� �޴� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAddLinkPages")).click();

		// ������ ������ ���� �� Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.RelatedNoteSelectionActivity", getCurrentActivity1);
		assertEquals("�ۼ��� �������� �����ϴ�.",
				driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@index='4']")).getText());

		// ������ ������ ���� ���� X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// ���������� X ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/back")).click();
		Thread.sleep(3000);

		// ������ �ݱ�
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// Ư�� �ڵ� ������ ���� ���� (AutoDeleteSpecificPage1Class.java)
		AutoDeleteSpecificPage1Class spage1 = new AutoDeleteSpecificPage1Class();
		driver = (AndroidDriver) spage1.spage1(driver);
		Thread.sleep(1000);

		// �ڵ� ������ ���� ���� (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = (AndroidDriver) Empty.Empty(driver);
		Thread.sleep(1000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub

	}

}
