package MultipleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MultipleWindowHandle {
	private WebDriver driver;
	@Test
	public void newWindow() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		WebElement clickElement = driver.findElement(By.id("button1")); 
 
		for(int i = 0; i < 1; i++)
		{
			clickElement.click();
			Thread.sleep(3000);
		}
	}

	@Test
	public void newWindowHandle() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		WebElement clickElement = driver.findElement(By.id("button1")); 
 
		for(int i = 0; i < 1; i++)
		{
			clickElement.click();
			Thread.sleep(3000);
		}
 
		Set<String> allWindowHandles = driver.getWindowHandles();
 
		for(String handle : allWindowHandles)
		{
			System.out.println("Window handle - > " + handle);
		}

	}

	@Test
	public void newWindowSwitch() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		WebElement clickElement = driver.findElement(By.id("button1")); 
 
		for(int i = 0; i < 1; i++)
		{
			clickElement.click();
			Thread.sleep(3000);
		}
 
		Set<String> allWindowHandles = driver.getWindowHandles();
 
		for(String handle : allWindowHandles)
		{
			System.out.println("Switching to window - > " + handle);
			System.out.println("Navigating to google.com");
			driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
			driver.get("http://google.com");
		}

	}

	@Test
	public void newWindowClose() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		WebElement clickElement = driver.findElement(By.id("button1")); 
 
		for(int i = 0; i < 1; i++)
		{
			clickElement.click();
			Thread.sleep(3000);
		}
 
		Set<String> allWindowHandles = driver.getWindowHandles();
		String lastWindowHandle = "";
		for(String handle : allWindowHandles)
		{
			System.out.println("Switching to window - > " + handle);
			System.out.println("Navigating to google.com");
			driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
			driver.get("http://google.com");
			lastWindowHandle = handle;
		}
 
		//Switch to the parent window
		driver.switchTo().window(parentWindowHandle);
		//close the parent window
		driver.close();
		//at this point there is no focused window, we have to explicitly switch back to some window.
		driver.switchTo().window(lastWindowHandle);
		driver.get("http://toolsqa.com");

	}
	@AfterTest
	public void endSession(){
	driver.close();
	driver.quit();   
	} 
}
