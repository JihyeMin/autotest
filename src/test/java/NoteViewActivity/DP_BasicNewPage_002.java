package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

public class DP_BasicNewPage_002 extends AppiumDriverBase {

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

		// �������� �ۼ��ϼ��� ���� ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtHomeWritePageMsg")).click();
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteViewActivity", getCurrentActivity1);

		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).sendKeys("Create Page Test");
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_save")).click();
		Thread.sleep(1000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// �ڵ� ������ ���� ���� (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(3000);

		// �ڵ� ������ ���� ����
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(3000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
