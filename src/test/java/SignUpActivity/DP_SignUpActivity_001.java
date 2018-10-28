package SignUpActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import appium.AppiumDriverBase;
import java.util.concurrent.TimeUnit;

public class DP_SignUpActivity_001 extends AppiumDriverBase  {

	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();
		// �� ����.
		driver.launchApp();
		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(3000);

		driver.findElement(By.id("com.fasoo.digitalpage:id/txtRegisterLink")).click();

		// ȸ������ ������ �ó�����(�̹� ���Ե� �̸��� ���� �Է�)
		// ȯ�� �¾� ���� ����
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).sendKeys("test04@fasoo.com");
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtPassword")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtPassword")).sendKeys("asdf1234$");
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtPasswordConfirm")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtPasswordConfirm")).sendKeys("asdf1234$");
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtNickName")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtNickName")).sendKeys("test04");
		driver.findElement(By.id("com.fasoo.digitalpage:id/chkLegalAgree")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnSignUp")).click();
		Thread.sleep(1000);

		assertEquals("�̹� ���Ե� �����Դϴ�.", driver.findElement(By.id("android:id/alertTitle")).getText());
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}
}
