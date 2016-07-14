import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class ReferenceAndroidNativeTest {

	private AppiumDriver driver;
	private long startTime;

	/* This is the setup that will be run before the test. */
	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("testobject_app_id", "1");
		capabilities.setCapability("testobject_api_key", System.getenv("TESTOBJECT_API_KEY")); // API key through env variable
		capabilities.setCapability("testobject_device", System.getenv("TESTOBJECT_DEVICE_ID")); // device id through env variable
		capabilities.setCapability("testobject_appium_version", "1.5.2");

		long allocationTime = startTime = System.currentTimeMillis();
		driver = new AndroidDriver(new URL("https://app.testobject.com:443/api/appium/wd/hub"), capabilities);
		System.out.println("Device allocation took: " + (System.currentTimeMillis() - allocationTime));
	}

	@After
	public void tearDown() {
		long tearDown = System.currentTimeMillis();
		if (driver != null) {
			driver.quit();
		}
		System.out.println("Driver quit took: " + (System.currentTimeMillis() - tearDown));
		System.out.println("The whole test took: " + (System.currentTimeMillis() - startTime));
	}

	@Test
	public void factorialMinusOperationFirst() {
		MobileElement buttonTwo = (MobileElement) (driver.findElement(By.id("net.ludeke.calculator:id/digit2")));

		buttonTwo.click();

		MobileElement buttonPlus = (MobileElement) (driver.findElement(By.id("net.ludeke.calculator:id/plus")));

		buttonPlus.click();

		MobileElement buttonEquals = (MobileElement) (driver.findElement(By.id("net.ludeke.calculator:id/equal")));
		MobileElement resultField = (MobileElement) (driver.findElement(By.xpath("//android.widget.EditText[1]")));

        /* Add two and two. */
		buttonTwo.click();
		buttonEquals.click();

        /* Check if within given time the correct result appears in the designated field. */
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.textToBePresentInElement(resultField, "4"));
	}

	@Test
	public void factorialMinusOperationSecond() {
		MobileElement buttonTwo = (MobileElement) (driver.findElement(By.id("net.ludeke.calculator:id/digit2")));

		buttonTwo.click();

		MobileElement buttonPlus = (MobileElement) (driver.findElement(By.id("net.ludeke.calculator:id/plus")));

		buttonPlus.click();

		MobileElement buttonEquals = (MobileElement) (driver.findElement(By.id("net.ludeke.calculator:id/equal")));
		MobileElement resultField = (MobileElement) (driver.findElement(By.xpath("//android.widget.EditText[1]")));

        /* Add two and two. */
		buttonTwo.click();
		buttonEquals.click();

        /* Check if within given time the correct result appears in the designated field. */
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.textToBePresentInElement(resultField, "4"));
	}

}
