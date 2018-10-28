package HomeActivity;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoCreatePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;

import appium.AppiumDriverBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class DP_DeletePage_001 extends AppiumDriverBase {

	@Test
	public void End_To_End_Test_Sample() throws Exception {
		driver.closeApp();
		// �� ����.
		driver.launchApp();
		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(1000);

		// �ڵ� �α��� ���� (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = login.login(driver);
		Thread.sleep(1000);

		// �ڵ� ������ �ۼ� ���� (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = cpage.cpage(driver);
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.NoteEditActivity", getCurrentActivity1);
		Thread.sleep(1000);
		
		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);
		
		// �ֱ� ������ 1�� ����Ʈ�� Ŭ��
		driver.findElement(By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/swipe') and @index='0']" + "//android.widget.RelativeLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/layRoot') and @index='0']")).click();
		Thread.sleep(1000);
		
		// '...'��ư �޴��� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnMenu")).click();
		Thread.sleep(1000);
		
		// ���� �޴��� Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/layDelete")).click();
		Thread.sleep(1000);
		
		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity2 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity2);
		Thread.sleep(1000);
		
		// �ڵ� ������ ���� ���� (AutoEmptyTrashboxClass.java)
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(1000);
				
		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
