package NoteViewActivity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

import appium.AppiumDriverBase;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoCreateAnotherPageClass;
import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import static org.junit.Assert.assertEquals;


public class DP_MergePage_001 extends AppiumDriverBase {
	@Test
	public void sampleTest() throws Exception {
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

		// 자동 페이지 작성 로직 (AutoCreateAnotherPageClass.java)
		AutoCreateAnotherPageClass apage = new AutoCreateAnotherPageClass();
		driver = apage.apage(driver);
		Thread.sleep(1000);

		// '...'버튼 메뉴를 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnMenu")).click();
		Thread.sleep(1000);

		// '합치기' 하위 메뉴를 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/layMerge")).click();
		Thread.sleep(3000);

		// 합치기 페이지 선택 뷰 확인
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteMergeActivity", getCurrentActivity1);

		// 머지할 페이지 리스트1 선택
		driver.findElement(By.xpath(
				"//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRadioSelect') and @index='0']"))
				.click();
		Thread.sleep(3000);

		// 머지할 페이지 선택 후 완료
		driver.findElement(By.id("com.fasoo.digitalpage:id/action_done")).click();
		Thread.sleep(3000);

		// 페이지 닫기
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// 병합된 페이지 요약정보 확인
		assertEquals("Create Another Page Test\nCreate Page Test", driver.findElement(By.xpath(
				"//android.widget.FrameLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/swipe') and @index='0']"
						+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary') and @index='1']"))
				.getText());

		// 자동 페이지 삭제 로직 (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(1000);

		// 자동 휴지통 비우기 로직 (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(1000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity1) {
		// TODO Auto-generated method stub

	}

}
