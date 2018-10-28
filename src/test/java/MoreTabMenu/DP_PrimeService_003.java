package MoreTabMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoLoginClass;

public class DP_PrimeService_003 extends AppiumDriverBase {

	@Test
	public void End_To_End_Test_Sample() throws Exception {
		driver.closeApp();
		// �� ����.
		driver.launchApp();

		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(3000);

		// �ڵ� �α��� ���� (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = login.login(driver);
		Thread.sleep(3000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity1);

		// ������ ������ Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@instance='4']")).click();
		Thread.sleep(3000);

		// ������ ȸ�� ���� �˾ƺ��� �� ���Ѵ�.
		AndroidElement ele = driver.findElement(By.id("com.fasoo.digitalpage:id/txtGetPrimeService"));
		Point loc = ele.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(5000);

		//���� ��ư ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnBuyYearly")).click();
		Thread.sleep(3000);
		
		// â ���� Ȯ��
		driver.findElement(By.id("com.android.vending:id/content1")).isDisplayed();
		String text1 = driver.findElement(By.id("com.android.vending:id/text")).getText();
		Assert.assertTrue(text1.contains("�����Ӽ��� - ���� "));
		Thread.sleep(3000);
		
		
		// ����� Back ��ư Ŭ��
		driver.navigate().back();
		Thread.sleep(3000);
		
		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}




