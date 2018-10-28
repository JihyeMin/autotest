package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class AutoLoginClass {
	public AppiumDriver<AndroidElement> login(AppiumDriver<AndroidElement> driver) {
		// DigitalPage �α��� ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLoginWiseVine")).click();
		// ����� ���� �Է�
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).sendKeys("test04@fasoo.com");
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtPassword")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtPassword")).sendKeys("asdf1234$");
		// �α��� ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLogin")).click();
		
		return driver;
	}

}
