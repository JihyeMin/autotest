package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

public class AutoVoicePageClass {
	public AppiumDriver<AndroidElement> vpage(AppiumDriver<AndroidElement> driver) {
		driver.findElement(By.id("com.fasoo.digitalpage:id/layGNBTabWrite")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAttach")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAttach")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/layMenuVoice")).click();

		// ���� ����
		driver.findElement(By.id("com.fasoo.digitalpage:id/imgRecord")).click();
		// ���� ����
		driver.findElement(By.id("com.fasoo.digitalpage:id/imgRecord")).click();
		// ÷�� ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAttach")).click();		

		driver.findElement(By.id("com.fasoo.digitalpage:id/action_save")).click();

		return driver;
	}
}
