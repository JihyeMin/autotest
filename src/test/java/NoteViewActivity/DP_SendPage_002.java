package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_SendPage_002 extends AppiumDriverBase {
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
		Thread.sleep(10000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		// driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(5000);

		// �ֱ� ������ 1�� ����Ʈ�� Ŭ��
		driver.findElement(By.xpath(
				"//android.widget.FrameLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/swipe') and @index='0']"
						+ "//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot') and @index='0']"))
				.click();
		Thread.sleep(1000);

		// '...'��ư �޴��� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnMenu")).click();
		Thread.sleep(1000);

		// '������' ���� �޴��� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/laySendPage")).click();
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".communication.ui.PageSendActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// ��ȿ�� �̸��� �Է�
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).sendKeys("test01@fasoo.com");
		Thread.sleep(1000);
		driver.findElement(By.id("com.fasoo.digitalpage:id/rvAutoCompleteList")).click();
		Thread.sleep(1000);

		Assert.assertTrue(driver
				.findElement(By.xpath(
						"//android.widget.LinearLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot')]"))
				.isEnabled());
		assertEquals("test01",
				driver.findElement(By.xpath("//*[@class='android.support.v7.widget.RecyclerView'][@index='0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtAccountName')]"))
						.getText());
		assertEquals("test01@fasoo.com",
				driver.findElement(By.xpath("//*[@class='android.support.v7.widget.RecyclerView'][@index='0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtEmailAddress')]"))
						.getText());
		Thread.sleep(1000);

		// ������ ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_send_page")).click();
		Thread.sleep(3000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteVeiwActivity", getCurrentActivity2);
		Thread.sleep(1000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub

	}

}
