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
		// �� ����.
		driver.launchApp();
		// ���� �˻��� ����, �ణ�� sleep �߰�.
		Thread.sleep(3000);

		// �ڵ� �α��� ���� (AutoLoginClass.java)
		AutoLoginClass login = new AutoLoginClass();
		driver = login.login(driver);
		Thread.sleep(3000);

		// ��� ������ �޴� Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='3']")).click();
		Thread.sleep(5000);

		// ���(��ü ������ ����) ��ư Ŭ��
		driver.findElement(By.id("com.fasoo.digitalpage:id/btnToggle")).click();
		Thread.sleep(3000);

		// �ۼ� ������ ���� Ȯ��
		assertEquals("�� 0��", driver.findElement(By.id("com.fasoo.digitalpage:id/txtTotalCount")).getText());

		// �ۼ� �������� ���� ��� �޽��� Ȯ��
		assertEquals("�ۼ��� �������� �����ϴ�.\n�������� �ۼ��ϼ���.",
				driver.findElement(By.id("com.fasoo.digitalpage:id/txtEmpty")).getText());
		Thread.sleep(3000);

		// �ڵ� ������ �ۼ� ���� (AutoCreatePageClass.java)
		AutoCreatePageClass cpage = new AutoCreatePageClass();
		driver = cpage.cpage(driver);
		Thread.sleep(3000);

		// ������ ������ X ��ư Ŭ��
		driver.findElement(By.xpath("//*[@class='android.widget.ImageButton'][@index='0']")).click();
		Thread.sleep(3000);

		// �ۼ� ������ ���� Ȯ��
		assertEquals("�� 1��", driver.findElement(By.id("com.fasoo.digitalpage:id/txtTotalCount")).getText());

		// Ȩ �޴� Ŭ��
		driver.findElement(By.xpath("//*[@class='android.support.v7.app.ActionBar$Tab'][@index='0']")).click();
		Thread.sleep(3000);

		// �ڵ� ������ ���� ����
		AutoDeletePageClass dpage = new AutoDeletePageClass();
		driver = dpage.dpage(driver);
		Thread.sleep(3000);

		// �ڵ� ������ ���� ����
		AutoEmptyTrashboxClass Empty = new AutoEmptyTrashboxClass();
		driver = Empty.Empty(driver);
		Thread.sleep(3000);

		// �� ����.
		driver.closeApp();
		Thread.sleep(1000);
	}

	private void assertEqulas(String string, String getCurrentActivity) {
		// TODO Auto-generated method stub
	}
}
