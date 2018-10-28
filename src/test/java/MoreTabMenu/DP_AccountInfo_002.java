package MoreTabMenu;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoAccountInfoClass;
import Common.AutoLoginClass;
import static org.junit.Assert.assertEquals;

public class DP_AccountInfo_002 extends AppiumDriverBase {

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
		
		// ������ ���� �޴� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/layProfileSettings")).click();
		Thread.sleep(1000);

		// ������ ȭ�� Ȯ��
		//assertEquals("������", driver.findElement(By.id("com.fasoo.digitalpage:id/tbarTitle")).getText());
		assertEquals("test04", driver.findElement(By.id("com.fasoo.digitalpage:id/txtName")).getText());
		Thread.sleep(1000);
		
		// �̸� ����
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnDeleteName")).click();
		Thread.sleep(1000);
		
		// �̸� ����
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtName")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtName")).sendKeys("Fasoo Test");
		Thread.sleep(1000);
		
		// ����
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnDone")).click();
		Thread.sleep(1000);
		
		// �� �ڷΰ��� ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnBack")).click();
		Thread.sleep(1000);
		
		// ���� �̸� Ȯ��
		assertEquals("Fasoo Test", driver.findElement(By.id("com.fasoo.digitalpage:id/txtName")).getText());
		Thread.sleep(1000);
		
		// �� �� �۾�
		// ���� ���� ������ ���Ѵ�. (AutoAccountInfoClass.java)
		AutoAccountInfoClass AccountInfo2 = new AutoAccountInfoClass();
		driver = AccountInfo2.AccountInfo(driver);
		Thread.sleep(1000);
		
		// ������ ���� �޴� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/layProfileSettings")).click();
		Thread.sleep(3000);
		
		// �̸� ����
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnDeleteName")).click();
		Thread.sleep(1000);
				
		// �̸� ����
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtName")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtName")).sendKeys("test04");
		Thread.sleep(1000);
				
		// ����
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnDone")).click();
		Thread.sleep(1000);
				
		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
