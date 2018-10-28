package MoreTabMenu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_AppInfoMenu_001 extends AppiumDriverBase {

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

		// ������ �޴� Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@instance='4']")).click();
		Thread.sleep(1000);
		
		// ���� ������ Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnSetting")).click();
		Thread.sleep(1000);
		
		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.SettingPopUpActivity", getCurrentActivity2);
		
		// ���� ž�� Ȯ��
		assertEquals("����", driver.findElement(By.id("com.fasoo.digitalpage:id/txtToolbarTitle")).getText());
		Thread.sleep(1000);
		
		// ���� ���� Ȯ��
		assertEquals("3.2.3", driver.findElement(By.id("com.fasoo.digitalpage:id/txtAppVersion")).getText());
		Thread.sleep(1000);
		
		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
