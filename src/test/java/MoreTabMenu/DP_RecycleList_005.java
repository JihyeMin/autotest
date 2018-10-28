package MoreTabMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

public class DP_RecycleList_005 extends AppiumDriverBase {

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

		// 자동 페이지 작성 로직 (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = cpage.cpage(driver);
		Thread.sleep(3000);

		// 페이지 보기의 X 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// 자동 페이지 삭제 로직 (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(3000);

		// 더보기 메뉴 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();

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
		Thread.sleep(3000);

		// 영구 삭제 메뉴 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/layDeleteEternity")).click();
		Thread.sleep(1000);

		// 영구 삭제 가이드 메시지 확인
		assertEquals("페이지가 영구적으로 삭제됩니다.\n삭제하시겠습니까?", driver.findElement(By.id("android:id/message")).getText());
		Thread.sleep(1000);

		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);

		// 삭제된 내역이 없는 경우 메시지 확인
		assertEquals("삭제된 페이지가 없습니다.", driver.findElement(By.id("com.fasoo.digitalpage:id/txtEmpty")).getText());
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

}
