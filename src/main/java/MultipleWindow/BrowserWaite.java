package MultipleWindow;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserWaite {
	
	WebDriver  driver;
	
	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);
	}
	
//	public WebDriver driver(String driverName){
//		WebDriver d;
//		
//		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
//		d = new ChromeDriver();
//	}
//	
	@Test
	public void implicityWait(){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.get("http://localhost/ac");
		 
//		 WebElement myDynamicElement = driver.findElement(By.id("myDynamicElement"));
	}

	@Test
	public void fluientWait(){
		 
	}
	
	@Test
	public void ExpecteddCondition(){
		driver.get("http://localhost/ac/wp-admin");
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("wp-submit")));
		element.click();
	}

}
