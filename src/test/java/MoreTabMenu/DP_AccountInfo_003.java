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

import Common.AutoAccountInfoClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;


public class DP_AccountInfo_003 extends AppiumDriverBase {

	@Test
	public void End_To_End_Test_Sample() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();

		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(1000);

		// 자동 로그인 로직 (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = login.login(driver);
		Thread.sleep(1000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity1);

		// 더보기 아이콘 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@instance='4']")).click();
		Thread.sleep(1000);

		// 계정 정보 영역을 탭한다. (AutoAccountInfoClass.java)
		AutoAccountInfoClass AccountInfo1 = new AutoAccountInfoClass();
		driver = AccountInfo1.AccountInfo(driver);
		Thread.sleep(1000);

		// 현재 액티비티 확인
		assertEquals("계정", driver.findElement(By.id("com.fasoo.digitalpage:id/tbarTitle")).getText());
		Thread.sleep(1000);

		// 프로필 수정 메뉴 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/layProfileSettings")).click();
		Thread.sleep(5000);

		// 프로필 이미지 여역 탭
		AndroidElement ele1 = driver.findElement(By.id("com.fasoo.digitalpage:id/imgAccountPhoto"));
		Point loc1 = ele1.getLocation();
		int x = loc1.getX();
		int y = loc1.getY();

		TouchAction touchAction1 = new TouchAction(driver);
		touchAction1.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(1000);

		// 사진 앨범에서 선택 하위 메뉴 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtSelect")).click();
		Thread.sleep(1000);

		// 사진 앨범 버튼 탭
		driver.findElement(By.xpath(
				"//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/fl') and @index='1']"
						+ "//android.widget.ImageView[contains(@resource-id, 'com.fasoo.digitalpage:id/iv_galleryitem') and @index='0']"))
				.click();
		Thread.sleep(1000);

		Assert.assertTrue(
				driver.findElement(By.id("com.fasoo.digitalpage:id/chkbox_gallery_photo_select")).isEnabled());
		Thread.sleep(1000);

		// 카메라롤 V적용
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_pick_done")).click();
		Thread.sleep(1000);

		// 프로필 V적용
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnDone")).click();
		Thread.sleep(1000);

		// 이 후 작업
		// 프로필 수정 메뉴 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/layProfileSettings")).click();
		Thread.sleep(5000);

		// 프로필 이미지 여역 탭
		AndroidElement ele2 = driver.findElement(By.id("com.fasoo.digitalpage:id/imgAccountPhoto"));
		Point loc2 = ele2.getLocation();
		int z = loc2.getX();
		int w = loc2.getY();

		TouchAction touchAction2 = new TouchAction(driver);
		touchAction2.tap(new PointOption().withCoordinates(z, w)).perform();
		Thread.sleep(1000);

		// 사진 앨범에서 선택 하위 메뉴 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/txtDelete")).click();
		Thread.sleep(1000);

		// 프로필 V적용
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnDone")).click();
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
