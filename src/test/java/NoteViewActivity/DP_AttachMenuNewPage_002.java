package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

public class DP_AttachMenuNewPage_002 extends AppiumDriverBase {

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

		// New ��ư ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/layGNBTabWrite")).click();
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteViewActivity", getCurrentActivity1);

		// + ��ư ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageView'][@instance='0']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.ImageView'][@instance='0']")).click();
		Thread.sleep(1000);

		// ���� �޴� ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/layMenuPhoto")).click();
		Thread.sleep(1000);

		// ���� �ٹ� ��ư ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnStartGallery")).click();
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".gallery.GalleryActivity", getCurrentActivity2);
		Thread.sleep(1000);

		// V ��ư ���� Ȯ�� - ��Ȱ��
		Assert.assertFalse(driver.findElement(By.id("com.fasoo.digitalpage:id/action_pick_done")).isEnabled());

		// ���� �ٹ����� 1��° ���� ����
		driver.findElement(By.xpath(
				"//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/fl') and @index='1']"
						+ "//android.widget.ImageView[contains(@resource-id, 'com.fasoo.digitalpage:id/iv_galleryitem') and @index='0']"))
				.click();
		Thread.sleep(1000);

		// V ��ư ���� Ȯ�� - Ȱ��
		Assert.assertTrue(driver.findElement(By.id("com.fasoo.digitalpage:id/action_pick_done")).isEnabled());

		// V ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_pick_done")).click();
		Thread.sleep(1000);

		// ���� ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_save")).click();
		Thread.sleep(3000);

		// �ݱ� ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// �ڵ� ������ ���� ���� (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(1000);

		// �ڵ� ������ ���� ����
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
