package MoreTabMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import static org.junit.Assert.assertEquals;

import Common.AutoLoginClass;

public class DP_RecycleList_001 extends AppiumDriverBase {

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

		// 더보기 아이콘 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@instance='4']")).click();
		Thread.sleep(1000);

		// 페이지 관리 > 휴지통 메뉴를 탭한다.
		AndroidElement menu1 = driver.findElement(By.id("com.fasoo.digitalpage:id/layRecycleList"));
		Point loc = menu1.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(1000);

		// 탑바 확인
		assertEquals("휴지통", driver.findElement(By.id("com.fasoo.digitalpage:id/tbarTitle")).getText());

		// 삭제된 내역이 없는 경우 메시지 확인
		assertEquals("삭제된 페이지가 없습니다.", driver.findElement(By.id("com.fasoo.digitalpage:id/txtEmpty")).getText());
		Thread.sleep(1000);

		driver.findElement(By.id("com.fasoo.digitalpage:id/btnBack")).click();
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
