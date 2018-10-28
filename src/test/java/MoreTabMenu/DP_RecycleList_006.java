package MoreTabMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoCreateAnotherPageClass;
import Common.AutoDeletePageClass;
import Common.AutoDeleteSpecificPage3Class;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

public class DP_RecycleList_006 extends AppiumDriverBase {

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

		// �ڵ� ������ �ۼ� ���� (AutoCreateAnotherPageClass.java)
		AutoCreateAnotherPageClass apage = new AutoCreateAnotherPageClass();
		driver = apage.apage(driver);
		Thread.sleep(3000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// �ڵ� ������ ���� ���� (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(1000);

		// ������ �޴� Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();
		Thread.sleep(1000);

		// ������ ���� > ������ �޴��� ���Ѵ�.
		AndroidElement menu1 = driver.findElement(By.id("com.fasoo.digitalpage:id/layRecycleList"));
		Point loc1 = menu1.getLocation();
		int x = loc1.getX();
		int y = loc1.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(3000);

		// ������ ����Ʈ 1��° ������Ʈ
		driver.findElement(By.xpath(
				"//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot') and @index='0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary')]"))
				.click();
		Thread.sleep(3000);

		// ... ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnMenu")).click();
		Thread.sleep(1000);

		// ������ ���� �޴� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/layRestore")).click();
		Thread.sleep(3000);

		// Ȩ ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='0']")).click();
		Thread.sleep(1000);

		// ����Ʈ Ȯ��
		Assert.assertTrue(driver.findElement(By.xpath(
				"//android.support.v7.widget.RecyclerView[contains(@resource-id, 'com.fasoo.digitalpage:id/recyclerHomeRecentPages') and @index='1']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary') and @text='Create Another Page Test']"))
				.isEnabled());
		Thread.sleep(1000);

		// Ư�� �ڵ� ������ ���� ���� (AutoDeleteSpecificPage3Class.java)
		AutoDeleteSpecificPage3Class spage3 = new AutoDeleteSpecificPage3Class();
		driver = spage3.spage3(driver);
		Thread.sleep(1000);

		// �ڵ� ������ ���� ���� (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(1000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}
}
