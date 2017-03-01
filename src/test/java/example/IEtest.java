package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class IEtest {
	
	 private WebDriver driver;

	  @BeforeClass
	  public static void setupClass() {
	    //InternetExplorerDriverManager.getInstance().setup();
	  }

	  @BeforeTest
	  public void setupTest() {
		  InternetExplorerDriverManager.getInstance().setup();
		  driver = new InternetExplorerDriver();
	  }

	  @AfterClass
	  public void teardown() {
	    if (driver != null) {
	      driver.quit();
	    }
	  }

	  @Test
	  public void test() {
	    // Your test code here. For example:
	    WebDriverWait wait = new WebDriverWait(driver, 30); // 30 seconds of timeout
	    driver.get("https://en.wikipedia.org/wiki/Main_Page"); // navigate to Wikipedia

	    By searchInput = By.id("searchInput"); // search for "Software"
	    wait.until(ExpectedConditions.presenceOfElementLocated(searchInput));
	    driver.findElement(searchInput).sendKeys("Software");
	    By searchButton = By.id("searchButton");
	    wait.until(ExpectedConditions.elementToBeClickable(searchButton));
	    driver.findElement(searchButton).click();

	    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"),
	        "Computer software")); // assert that the resulting page contains a text
	  }
}
