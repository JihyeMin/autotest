package appium;
 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
 
public class AppiumDriverBase {
 
    protected AppiumDriver<AndroidElement> driver;
    protected WebDriverWait wait;
 
    @Before
    public void setup() throws Exception {
 
    //relative path to apk file
   // final File classpathRoot = new File(System.getProperty("user.dir"));
   // final File appDir = new File(classpathRoot, "src/test/resources/apps/");
   // final File app = new File(appDir, "DigitalPage_v3.2.1.apk");
 
    //setting up desired capability
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("platform", "ANDROID");
    caps.setCapability("platformVersion", "5.0.1");
    caps.setCapability("unicodeKeyboard", true);
    caps.setCapability("deviceName", "Samsung Galaxy S4");
    caps.setCapability("appPackage", "com.fasoo.digitalpage");
    caps.setCapability("appActivity", "com.fasoo.digitalpage.ui.LoginActivity");
    //caps.setCapability("app", app.getAbsolutePath());
 
    //initializing driver object
    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
 
    //initializing explicit wait object
    //wait = new WebDriverWait(driver, 10);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 
    @After
    public void tearDown() throws Exception {
    //quit the driver
    driver.quit();
    
    }
}