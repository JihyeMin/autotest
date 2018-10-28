package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DP_VerifyPageInfo_002 extends AppiumDriverBase {

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

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteViewActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// i ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_info")).click();
		Thread.sleep(1000);

		// ���÷��� Ȯ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/layNoteInfoContainer")).isDisplayed();
				
		// ���� ��¥ ���
		DateFormat dateFormat1 = new SimpleDateFormat("yyy�� M�� d��");
		Date date = new Date();
		String date1 = dateFormat1.format(date);

		// �ۼ��� Ȯ��
		String text1 = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='2']" + "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtCreatedTime') and @index='2']")).getText();
		Assert.assertTrue(text1.contains(date1));
		
		// ������ Ȯ��
		String text2 = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='4']" + "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtUpdatedTime') and @index='2']")).getText();
		Assert.assertTrue(text2.contains(date1));

		// i ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_info")).click();
		Thread.sleep(1000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

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

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
