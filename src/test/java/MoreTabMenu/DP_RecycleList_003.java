package MoreTabMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_RecycleList_003 extends AppiumDriverBase {

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

		// �ڵ� ������ �ۼ� ���� (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = cpage.cpage(driver);
		Thread.sleep(1000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// �ڵ� ������ ���� ���� (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(1000);

		// ������ �޴� Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();

		// ������ ���� > ������ �޴��� ���Ѵ�.
		AndroidElement menu1 = driver.findElement(By.id("com.fasoo.digitalpage:id/layRecycleList"));
		Point loc1 = menu1.getLocation();
		int x = loc1.getX();
		int y = loc1.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(1000);

		// ������ ����Ʈ 1��° ������Ʈ
		AndroidElement menu2 = driver.findElement(By.xpath(
				"//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot') and @index='0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary')]"));
		Point loc2 = menu2.getLocation();
		// ����
		int Width = menu2.getSize().width;
		// ����

		// Swipe ���� ��ǥ ���
		int startx = loc2.getX() + Width;
		int starty = loc2.getY();
		int endy = (int) (startx * 0.5);

		TouchAction touchAction2 = new TouchAction(driver);
		touchAction2.longPress(new PointOption().withCoordinates(startx, starty))
				.moveTo(new PointOption().withCoordinates(endy, starty)).release().perform();
		Thread.sleep(1000);

		driver.findElement(By.id("com.fasoo.digitalpage:id/layDelete")).click();
		Thread.sleep(1000);

		// ���� ���� ���̵� �޽��� Ȯ��
		assertEquals("�������� ���������� �����˴ϴ�.\n�����Ͻðڽ��ϱ�?", driver.findElement(By.id("android:id/message")).getText());
		Thread.sleep(1000);

		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);

		// ������ ������ ���� ��� �޽��� Ȯ��
		assertEquals("������ �������� �����ϴ�.", driver.findElement(By.id("com.fasoo.digitalpage:id/txtEmpty")).getText());
		Thread.sleep(1000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}
}
