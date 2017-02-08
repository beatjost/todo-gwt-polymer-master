package name.christianbauer.todo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;

public class DemoUiTestCase extends Selenide {

	@Rule
	public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();
	private static WebDriver webDriver;
	
	@BeforeClass
	public static void initDriver() {
		Configuration.reportsFolder = "build/reports/tests/screenshots";
		webDriver = getLocalDriver();
		webDriver.manage().window().setSize(new Dimension(1920, 1080));
		WebDriverRunner.setWebDriver(webDriver);
	}

	@AfterClass
	public static void tearDown() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}

	@Test
	public void addItem() {
		open("http://localhost:8080/todo-gwt-polymer-master/");
		$(By.id("title")).waitUntil(Condition.appear, 2000);
		screenshot("LoadTodoApp");
		assertEquals(2, $$(By.id("todoItem")).size());
		$(By.xpath("//*[@id='controls']/button")).click();
		screenshot("ItemAdded");
		assertEquals(3, $$(By.id("todoItem")).size());
	}
	
	public static List<String> getBrowserLog() {
		return getWebDriverLogs(LogType.BROWSER);
	}
	
    private static PhantomJSDriver getLocalDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); 
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                      "assets/phantomjs.exe");
        return new PhantomJSDriver(desiredCapabilities);                     
    }

}