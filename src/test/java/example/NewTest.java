package example;		

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;		
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;		


public class NewTest {
	
	    private WebDriver driver;
	    
	    @BeforeClass
	    public static void setupClass() {
	       // ChromeDriverManager.getInstance().setup();
	    }
		@BeforeTest
		public void beforeTest() {	
		    //driver = new FirefoxDriver();
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			
		}		
	    
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}	
		
		@Test				
		public void testEasy() {	
			driver.get("http://www.guru99.com/selenium-tutorial.html");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Free Selenium Tutorials")); 		
		}	
			
}	