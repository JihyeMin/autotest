package HomeActivity;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import appium.AppiumDriverBase;
import Common.AutoCreatePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

public class DP_DeletePage_002 extends AppiumDriverBase {

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
		Thread.sleep(3000);

		// �ڵ� ������ �ۼ� ���� (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = cpage.cpage(driver);
		Thread.sleep(3000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteEditActivity", getCurrentActivity1);
		Thread.sleep(3000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity2);
		Thread.sleep(1000);

		// �ֱ� ������ 1��° ������Ʈ
		AndroidElement menu = driver.findElement(By.xpath(
				"//android.widget.FrameLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/swipe') and @index='0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary')]"));
		Point loc = menu.getLocation();
		// ����
		int Width = menu.getSize().width;

		// Swipe ���� ��ǥ ���
		int startx = loc.getX() + Width;
		int starty = loc.getY();
		int endy = (int) (startx * 0.5);

		TouchAction touchAction2 = new TouchAction(driver);
		touchAction2.longPress(new PointOption().withCoordinates(startx, starty))
				.moveTo(new PointOption().withCoordinates(endy, starty)).release().perform();
		Thread.sleep(5000);
		
		// ������ ������ Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/imgDelete")).click();
		Thread.sleep(3000);

		// �ڵ� ������ ���� ���� (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(1000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}
	
	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
