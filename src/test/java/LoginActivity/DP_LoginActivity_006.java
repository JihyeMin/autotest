package LoginActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import appium.AppiumDriverBase;
import java.util.concurrent.TimeUnit;

public class DP_LoginActivity_006 extends AppiumDriverBase  {

	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// �� ����.
		driver.launchApp();
		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(1000);

		// 'Kakao' ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLoginKakao")).click();
		Thread.sleep(5000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".KakaoWebViewActivity", getCurrentActivity);
		Thread.sleep(5000);

		// 'Kakao' ���� �α���
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[45,300][915,426]']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[45,300][915,426]']")).sendKeys("test04@fasoo.com");
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[45,435][915,561]']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[45,435][915,561]']")).sendKeys("test02!#%");
		driver.findElement(By.xpath("//android.view.View[@bounds='[45,642][1035,807]']")).click();
		Thread.sleep(5000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity2);

		// ������ ������ Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();

		// ���� ���� Ȯ��
		assertEquals("test04@fasoo.com", driver.findElement(By.id("com.fasoo.digitalpage:id/txtEmail")).getText());
		Thread.sleep(1000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub
		
	}
}
