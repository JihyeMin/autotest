package HomeActivity;

import org.junit.Test;
import org.openqa.selenium.By;

import Common.AutoDeletePageClass;
import Common.AutoEmptyTrashboxClass;
import Common.AutoLoginClass;
import Common.AutoVoicePageClass;

import appium.AppiumDriverBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static org.junit.Assert.assertTrue;

public class DP_VerifyPageSummary_003 extends AppiumDriverBase {

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

		// ���� ������ �ۼ� ���� (AutoVoicePageClass.java)
		AutoVoicePageClass vpage = new AutoVoicePageClass();
		driver = vpage.vpage(driver);
		Thread.sleep(1000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(1000);

		// ���� ��Ƽ��Ƽ Ȯ��
		String getCurrentActivity1 = ((AndroidDriver<AndroidElement>) driver).currentActivity();
		assertEqulas(".ui.HomeActivity", getCurrentActivity1);
		Thread.sleep(1000);

		// ���� ������ ��� ���� Ȯ��
		String actualString = driver.findElement(By.xpath("//android.widget.FrameLayout[contains(@resource-id, 'com.fasoo.digitalpage:id/swipe') and @index='0']"
				+ "//android.widget.TextView[contains(@resource-id, 'com.fasoo.digitalpage:id/txtSummary')]")).getText();
		assertTrue(actualString.contains("���� �ð�"));
		Thread.sleep(1000);

		// �ڵ� ������ ���� ���� (AutoDeletePageClass.java)
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
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
