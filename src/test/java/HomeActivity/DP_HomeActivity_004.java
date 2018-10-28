package HomeActivity;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

import Common.AutoCreatePageClass;
import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import appium.AppiumDriverBase;


public class DP_HomeActivity_004 extends AppiumDriverBase {

	@Test
	public void End_To_End_Test_Sample() throws Exception {
		driver.closeApp();
		// 앱 시작.
		driver.launchApp();
		// 빠른 검색을 위해, 약간의 sleep 추가.
		Thread.sleep(3000);

		// 자동 로그인 로직 (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = login.login(driver);
		Thread.sleep(3000);

		// 모든 페이지 메뉴 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='3']")).click();
		Thread.sleep(5000);

		// 토글(전체 페이지 보기) 버튼 클릭
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnToggle")).click();
		Thread.sleep(3000);

		// 작성 페이지 개수 확인
		assertEquals("총 0개", driver.findElement(By.id("com.fasoo.digitalpage:id/txtTotalCount")).getText());

		// 작성 페이지가 없는 경우 메시지 확인
		assertEquals("작성된 페이지가 없습니다.\n페이지를 작성하세요.",
				driver.findElement(By.id("com.fasoo.digitalpage:id/txtEmpty")).getText());
		Thread.sleep(3000);

		// 자동 페이지 작성 로직 (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = cpage.cpage(driver);
		Thread.sleep(3000);

		// 페이지 보기의 X 버튼 클릭
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// 작성 페이지 개수 확인
		assertEquals("총 1개", driver.findElement(By.id("com.fasoo.digitalpage:id/txtTotalCount")).getText());

		// 홈 메뉴 클릭
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='0']")).click();
		Thread.sleep(3000);

		// 자동 페이지 삭제 로직
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(3000);

		// 자동 휴지통 비우기 로직
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(3000);

		// 앱 종료.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
