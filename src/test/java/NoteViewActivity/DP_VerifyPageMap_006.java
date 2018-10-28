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

import Common.AutoCreateAnotherPageClass;
import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoDeleteSpecificPage1Class;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_VerifyPageMap_006 extends AppiumDriverBase {
	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// �� ����.
		driver.launchApp();
		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(1000);

		// �ڵ� �α��� ���� (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = login.login(driver);
		Thread.sleep(1000);

		// �ڵ� ������ �ۼ� ���� (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = cpage.cpage(driver);
		Thread.sleep(1000);
		
		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);
		
		// �ڵ� ������ �ۼ� ���� (AutoCreateAnotherPageClass.java)
		AutoCreateAnotherPageClass apage = new AutoCreateAnotherPageClass();
		driver = apage.apage(driver);
		Thread.sleep(1000);
				
		// �������� ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_pagemap")).click();
		Thread.sleep(1000);
				
		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.PageMapActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// ���������� ��带 ��
		AndroidElement node1 = driver.findElement(By.xpath("//*[@class='android.widget.RelativeLayout'][@index='0']" + "//android.view.View[contains(@resource-id, 'com.fasoo.digitalpage:id/pageMapViewer') and @index='0']"));
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
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout'][@index='0']")).isEnabled());
		
		// ������ ������ ���� �޴� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAddLinkPages")).click();
		Thread.sleep(1000);

		// ������ ������ ���� �� Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.RelatedNoteSelectionActivity", getCurrentActivity2);
		
		// ������ ������ ����Ʈ1 ����
		driver.findElement(By.xpath("//android.widget.CheckBox[contains(@resource-id, 'com.fasoo.digitalpage:id/chkSelect') and @index='1']")).click();
		Thread.sleep(1000);

		// ������ ������ ���� �� �Ϸ�
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_regist")).click();
		Thread.sleep(1000);
		
		// ���������� X ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/back")).click();
		Thread.sleep(1000);
		
		// ������ ���� ���¿��� ���������� ���� ���� Ȯ��
		Assert.assertTrue(driver.findElement(By.id("com.fasoo.digitalpage:id/rcyRelativeNotes")).isEnabled());
		assertEquals("Create Page Test", driver.findElement(By.xpath("//*[@class='android.widget.FrameLayout'][@index='0']" + "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary')]")).getText());
		
		// ������ �ݱ�
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);
		 
		// Ư�� �ڵ� ������ ���� ���� (AutoDeleteSpecificPage1Class.java)
		AutoDeleteSpecificPage1Class spage1 = new AutoDeleteSpecificPage1Class();
		driver = spage1.spage1(driver);
		Thread.sleep(1000);
		
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
