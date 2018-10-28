package MoreTabMenu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;


import Common.AutoAccountInfoClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_AccountInfo_007 extends AppiumDriverBase {

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

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity1);

		// ������ ������ Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@instance='4']")).click();
		Thread.sleep(1000);

		// ���� ���� ������ ���Ѵ�. (AutoAccountInfoClass.java)
		AutoAccountInfoClass AccountInfo1 = new AutoAccountInfoClass();
		driver = AccountInfo1.AccountInfo(driver);
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		assertEquals("����", driver.findElement(By.id("com.fasoo.digitalpage:id/tbarTitle")).getText());
		Thread.sleep(1000);

		// �α׾ƿ� ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLogout")).click();
		Thread.sleep(1000);

		// �˸�â Ȯ��
		assertEquals("�α׾ƿ� �Ͻðڽ��ϱ�?", driver.findElement(By.id("android:id/message")).getText());
		Thread.sleep(1000);

		// Ȯ�� ��ư Ŭ��
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ�� 
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.LoginActivity", getCurrentActivity2);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}

