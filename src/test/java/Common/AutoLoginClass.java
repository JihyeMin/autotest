package Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class AutoLoginClass {
	public AppiumDriver<AndroidElement> login(AppiumDriver<AndroidElement> driver) {
		// DigitalPage 로그인 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLoginWiseVine")).click();
		// 사용자 정보 입력
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtEmail")).sendKeys("test04@fasoo.com");
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtPassword")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/edtPassword")).sendKeys("asdf1234$");
		// 로그인 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnLogin")).click();
		
		return driver;
	}

}
