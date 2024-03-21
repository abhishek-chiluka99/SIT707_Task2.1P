package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "F:/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
//		// Send first name
		
		
		WebElement lastname = driver.findElement(By.id("lastname"));
		WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement confirmpassword = driver.findElement(By.id("confirmPassword"));
		//WebElement custype = driver.findElement(By.className("MuiButtonBase-root MuiToggleButton-root MuiToggleButtonGroup-grouped MuiToggleButtonGroup-groupedHorizontal sc-kkGfuU kDaVeE"));
		
		System.out.println("Found firstname:" + element +"\n" + "Foud lastname:" + lastname + "\n" + "Found phone Number: " + phoneNumber + "\n" + "Found email: " + "\n" + 
		"Found password:" + password );
		
		lastname.sendKeys("Chiluka");
		element.click();
		element.sendKeys("Abhishek");
		phoneNumber.sendKeys("04022558811");
		email.sendKeys("s223046759@deakin.edu.au");
		password.sendKeys("12345678");
		confirmpassword.sendKeys("12345678");
		driver.findElement(By.cssSelector("button[type='button']")).click();

		driver.findElement(By.cssSelector("button[type='submit']")).click(); 

		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 try {
			 FileUtils.copyFile(scrFile, new File("G:/screenshot.png"));
		 }catch(IOException e) {
			 System.out.println("Failed to save screenshot");
			 e.printStackTrace();		 }
		 
		// Sleep a while
		sleep(10);
		
		
		
		
		// close chrome driver
		driver.close();	
	}
	public static void bunnings_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "F:/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);      
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uid")));
		
		WebElement email = driver.findElement(By.id("uid"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement FirstName = driver.findElement(By.id("firstName"));
		WebElement LastName = driver.findElement(By.id("lastName"));
		WebElement checkbox = driver.findElement(By.id("communicationPrefFlag"));
		
		
		
		//sending values to the respective id
		
		
		email.sendKeys("s223046759@gmail.com");
		password.sendKeys("12345678");
		FirstName.sendKeys("Abhishek");
		LastName.sendKeys("Chiluka");
		checkbox.click();
		driver.findElement(By.cssSelector("button.bui")).click();
		
		
			
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 
		 try {
			 FileUtils.copyFile(scrFile, new File("G:/screenshot1.png"));
		 }catch(IOException e) {
			 System.out.println("Failed to save screenshot");
			 e.printStackTrace();		 }
		 
		// Sleep a while
		sleep(10);
		
		
		
		
		// close chrome driver
		driver.close();	
	}
	
}
