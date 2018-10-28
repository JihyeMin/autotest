package LoginActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import appium.AppiumDriverBase;
import java.util.concurrent.TimeUnit;

public class DP_LoginActivity_005 extends AppiumDriverBase  {

	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// �� ����.
		driver.launchApp();
		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(1000);

		// 'Naver' ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLoginNaver")).click();
		Thread.sleep(3000);

		// �˸� �˾� - ��� ��ư Ŭ��
		driver.findElement(By.id("android:id/content"));
		assertEquals("���̹� ���� ��ġ�ϸ�\n�̿��� �� �ִ� �����Դϴ�.", driver.findElement(By.id("android:id/message")).getText());
		driver.findElement(By.id("android:id/button2")).click();
		Thread.sleep(3000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".OAuthLoginInAppBrowserActivity", getCurrentActivity);
		Thread.sleep(3000);

		// 'Naver' ���� �α���
		driver.findElement(By.id("id")).click();
		driver.findElement(By.id("id")).sendKeys("fasootest01");
		driver.findElement(By.id("pw")).click();
		driver.findElement(By.id("pw")).sendKeys("Test04!#%");
		driver.findElement(By.id("login_submit")).click();
		Thread.sleep(5000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity2);

		// ������ ������ Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();
		Thread.sleep(1000);

		// ���� ���� Ȯ��
		assertEquals("fasootest01@naver.com", driver.findElement(By.id("com.fasoo.digitalpage:id/txtEmail")).getText());
		Thread.sleep(1000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub
		
	}
}
