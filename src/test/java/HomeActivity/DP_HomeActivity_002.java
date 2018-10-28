package HomeActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import appium.AppiumDriverBase;

public class DP_HomeActivity_002 extends AppiumDriverBase {


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

		// ��ü�������� ������ Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnPageMap")).click();
		Thread.sleep(1000);

		// �� ������ ��
		assertEquals("�� ������ �� - 0", driver.findElement(By.id("com.fasoo.digitalpage:id/txtPageCount")).getText());
		Thread.sleep(1000);

		// ��ü�������� X ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/back")).click();
		Thread.sleep(1000);

		// �ڵ� ������ �ۼ� ���� (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = cpage.cpage(driver);
		Thread.sleep(1000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// ��ü�������� ������ Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnPageMap")).click();
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.PageMapActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// �� ������ ��
		assertEquals("�� ������ �� - 1", driver.findElement(By.id("com.fasoo.digitalpage:id/txtPageCount")).getText());
		Thread.sleep(1000);

		// ��ü�������� X ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/back")).click();
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity2);
		Thread.sleep(1000);

		// �ڵ� ������ ���� ���� (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(1000);

		// �ڵ� ������ ���� ���� (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(5000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
