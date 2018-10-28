package MoreTabMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoCreateAnotherPageClass;
import Common.AutoDeletePageClass;
import Common.AutoDeleteSpecificPage3Class;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

public class DP_RecycleList_006 extends AppiumDriverBase {

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

		// 자동 페이지 작성 로직 (AutoCreateAnotherPageClass.java)
		AutoCreateAnotherPageClass apage = new AutoCreateAnotherPageClass();
		driver = apage.apage(driver);
		Thread.sleep(3000);

		// 페이지 보기의 X 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// 자동 페이지 삭제 로직 (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(1000);

		// 더보기 메뉴 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();
		Thread.sleep(1000);

		// 페이지 관리 > 휴지통 메뉴를 탭한다.
		AndroidElement menu1 = driver.findElement(By.id("com.fasoo.digitalpage:id/layRecycleList"));
		Point loc1 = menu1.getLocation();
		int x = loc1.getX();
		int y = loc1.getY();

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		Thread.sleep(3000);

		// 휴지통 리스트 1번째 오브젝트
		driver.findElement(By.xpath(
				"//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot') and @index='0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary')]"))
				.click();
		Thread.sleep(3000);

		// ... 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnMenu")).click();
		Thread.sleep(1000);

		// 페이지 복원 메뉴 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/layRestore")).click();
		Thread.sleep(3000);

		// 홈 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='0']")).click();
		Thread.sleep(1000);

		// 리스트 확인
		Assert.assertTrue(driver.findElement(By.xpath(
				"//android.support.v7.widget.RecyclerView[contains(@resource-id, 'com.fasoo.digitalpage:id/recyclerHomeRecentPages') and @index='1']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary') and @text='Create Another Page Test']"))
				.isEnabled());
		Thread.sleep(1000);

		// 특정 자동 페이지 삭제 로직 (AutoDeleteSpecificPage3Class.java)
		AutoDeleteSpecificPage3Class spage3 = new AutoDeleteSpecificPage3Class();
		driver = spage3.spage3(driver);
		Thread.sleep(1000);

		// 자동 휴지통 비우기 로직 (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}
}
