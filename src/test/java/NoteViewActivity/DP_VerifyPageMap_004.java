package NoteViewActivity;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import Common.AutoCreatePageClass;
import Common.AutoDeleteSpecificPage1Class;
import Common.AutoDeleteSpecificPage2Class;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;


public class DP_VerifyPageMap_004 extends AppiumDriverBase {
	@Test
	public void sampleTest() throws Exception {
		driver.closeApp();

		// 앱 시작
		driver.launchApp();

		// 자동 로그인 로직 (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = (AndroidDriver) login.login(driver);
		Thread.sleep(1000);

		// 자동 페이지 작성 로직 (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = (AndroidDriver) cpage.cpage(driver);
		Thread.sleep(1000);

		// 페이지 보기의 X 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// 최신페이지에서 리스트 선택
		driver.findElement(By.xpath(
				"//android.widget.FrameLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/swipe') and @index='0']"
						+ "//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot') and @index='0']"))
				.click();
		Thread.sleep(3000);

		// 페이지맵 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_pagemap")).click();
		Thread.sleep(3000);

		// 현재 액티비티 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.PageMapActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// 페이지맵의 노드를 탭
		AndroidElement node1 = (AndroidElement) driver
				.findElement(By.xpath("//*[@class='android.widget.RelativeLayout'][@index='0']"
						+ "//android.view.View[contains(@resource-id, 'com.fasoo.digitalpage:id/pageMapViewer') and @index='0']"));
		Point loc = node1.getLocation();
		int x = loc.getX();
		int y = loc.getY();

		// 넓이
		int Width = node1.getSize().width;
		// 높이
		int Height = node1.getSize().height;

		// 탭 좌표 계산
		int nodeX = (int) ((loc.getX() + Width) * 0.5);
		int nodeY = (int) ((loc.getY() + Height) * 0.5);

		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(new PointOption().withCoordinates(nodeX, nodeY)).perform();
		Thread.sleep(1000);

		// 페이지 노드 정보 확인
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout'][@index='0']")).isEnabled());

		// 새 연관 페이지 만들기 메뉴 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnAddNewPage")).click();

		// 페이지편집 뷰 확인
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteEditActivity", getCurrentActivity1);

		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).click();
		driver.findElement(By.id("com.fasoo.digitalpage:id/editNoteContent")).sendKeys("Connection Page");
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_save")).click();
		Thread.sleep(1000);

		// 페이지 보기의 X 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// driver.navigate().back();

		// 페이지맵의 X 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/back")).click();
		Thread.sleep(3000);

		// 페이지 보기 상태에서 연관페이지 영역 정보 확인
		Assert.assertTrue(driver.findElement(By.id("com.fasoo.digitalpage:id/rcyRelativeNotes")).isEnabled());
		assertEquals("Connection Page",
				driver.findElement(By.xpath("//*[@class='android.widget.FrameLayout'][@index='0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary')]"))
						.getText());

		// 페이지 닫기
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// 특정 자동 페이지 삭제 로직 (AutoDeleteSpecificPage1Class.java)
		AutoDeleteSpecificPage1Class spage1 = new AutoDeleteSpecificPage1Class();
		driver = (AndroidDriver) spage1.spage1(driver);
		Thread.sleep(1000);

		// 특정 자동 페이지 삭제 로직 (AutoDeleteSpecificPage2Class.java)
		AutoDeleteSpecificPage2Class spage2 = new AutoDeleteSpecificPage2Class();
		driver = (AndroidDriver) spage2.spage2(driver);
		Thread.sleep(1000);

		// 자동 휴지통 비우기 로직 (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = (AndroidDriver) Empty.Empty(driver);
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub

	}

}
