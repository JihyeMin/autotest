package MoreTabMenu;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import appium.AppiumDriverBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DP_RecycleList_002 extends AppiumDriverBase {

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
		Thread.sleep(1000);

		// 페이지 보기의 X 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// 자동 페이지 삭제 로직 (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(1000);

		// 더보기 메뉴 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='4']")).click();

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

		// 디스플레이 확인
		driver.findElement(By.id("com.fasoo.digitalpage:id/layAccount")).isDisplayed();

		DateFormat dateFormat1 = new SimpleDateFormat("yyyy.MM");
		DateFormat dateFormat2 = new SimpleDateFormat("yyy년 M월 d일");
		Date date = new Date();
		String date1 = dateFormat1.format(date);
		String date2 = dateFormat2.format(date);

		assertEquals(date1, driver.findElement(By.id("com.fasoo.digitalpage:id/txtYearMonth")).getText());
		assertEquals(date2, driver.findElement(By.id("com.fasoo.digitalpage:id/txtDate")).getText());

		String text1 = driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@instance='3']")).getText();
		Assert.assertTrue(text1.contains("Create Page Test"));
		Thread.sleep(1000);

		driver.findElement(By.id("com.fasoo.digitalpage:id/btnBack")).click();
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
