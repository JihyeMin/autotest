package NoteViewActivity;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;


public class DP_SendPage_003_After extends AppiumDriverBase {
	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// �� ����.
		driver.launchApp();
		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(3000);

		// �ڵ� �α��� ���� (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = login.login(driver);
		Thread.sleep(3000);
		
		// 
		AndroidElement menu1 = driver.findElement(By.xpath("//android.widget.ScrollView[contains(@resource-id, 'com.fasoo.digitalpage:id/layHomeScroll') and @index='0']"));
		
		Point loc1 = menu1.getLocation();
		// ����
		int Width = menu1.getSize().width;
		// ����
		int Height = menu1.getSize().height;

		// Swipe ���� ��ǥ ���
		int startx = (int) ((loc1.getX() + Width) * 0.5);
		int starty = loc1.getY();
		int endy = (int) ((starty + Height) * 0.5);

		TouchAction touchAction1 = new TouchAction(driver);
		touchAction1.longPress(new PointOption().withCoordinates(startx, starty))
				.moveTo(new PointOption().withCoordinates(startx, endy)).release().perform();
		Thread.sleep(5000);

		// �ڵ� ������ ���� ���� (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(3000);

		// �ڵ� ������ ���� ���� (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(3000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}
	
	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub

	}

}
