package PasswordSearchActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import appium.AppiumDriverBase;
import java.util.concurrent.TimeUnit;

public class DP_PasswordSearchActivity_001 extends AppiumDriverBase  {

	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// �� ����.
		driver.launchApp();
		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(1000);

		// 'Digitalpage �������� �α���' ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLoginWiseVine")).click();
		Thread.sleep(1000);

		// ��й�ȣ ã�� ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtPasswordSearch")).click();
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.PasswordSearchActivity", getCurrentActivity1);
		Thread.sleep(1000);
		
		// �̸��� �Է� �� �缳�� ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).sendKeys("test04@fasoo.com");
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnReset")).click();
		Thread.sleep(3000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.LoginWiseVineActivity", getCurrentActivity2);
		Thread.sleep(1000);
		
		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub
		
	}
}
