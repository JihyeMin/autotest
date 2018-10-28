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
		// 앱 시작.
		driver.launchApp();
		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(3000);

		driver.findElement(By.id("com.fasoo.digitalpage:id/txtRegisterLink")).click();

		// 회원가입 비정상 시나리오(이미 가입된 이메일 정보 입력)
		// 환경 셋업 문제 검토
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

		assertEquals("이미 가입된 계정입니다.", driver.findElement(By.id("android:id/alertTitle")).getText());
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}
}
