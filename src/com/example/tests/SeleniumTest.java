/**
 * The class provides methods to navigate to specific site elements and to verify image presence.
 */
package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.*;

/**
 * @author Galina
 *
 */
public class SeleniumTest {
	
	public static WebDriver driver;

	/**
	 * set up the test environment using the Chrome browser
	 * @param chromepath = path to the chrome driver on the machine
	 * @param url = url of the website
	 */
	public void setChromeEnvironment(String chromepath, String url){
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		driver.get(url);
	}
			
	/**
	 * find and click specific element by xpath
	 * @param xpath = path to the required element
	 * @throws InterruptedException because of the thread sleep to slow down the process
	 */
	public void findAndClickElementByXpath(String xpath) throws InterruptedException{
		try{
			assertTrue(verifyElementPresent(By.xpath(xpath)));
			} catch(AssertionError e){
				System.out.println("Element not found: " + xpath); 
			}
		WebElement element = driver.findElement(By.xpath(xpath));
		System.out.println("Element found: " + xpath);
		Thread.sleep(2000);
		element.click();
	}
	
	/**
	 * verify if image is shown on the page by image xpath
	 * @param xpath = path to the required image
	 * @throws InterruptedException because of the thread sleep to slow down the process
	 *                              so that you can see the progress
	 */
	public void verifyImageShownByXpath(String xpath) throws InterruptedException{
		try{
			assertTrue(verifyElementPresent(By.xpath(xpath)));
			} catch(AssertionError e){
				System.out.println("Image element not found: " + xpath); 
		}
		WebElement image = driver.findElement(By.xpath(xpath));
		System.out.println("Image found: " + xpath);
		Thread.sleep(2000);
    	Boolean imagePresent = (Boolean) ((JavascriptExecutor)driver)
    			.executeScript("return arguments[0].complete && "
    					+ "typeof arguments[0].naturalWidth != \"undefined\" && "
    					+ "arguments[0].naturalWidth > 0", image);

		try{
			assertTrue(imagePresent);
			} catch(AssertionError e){
				System.out.println("Image not shown."); 
			}
		
    	if(imagePresent){
			Actions action = new Actions(driver);
			action.moveToElement(image).perform();
			Thread.sleep(2000);
			System.out.println("Image is shown.");
    	}

	}
	
	/**
	 * shut down the environment after test
	 */
	public void shutDownDriver(){
		if (driver != null) driver.quit();
	}
	
    /**
     * @param by = selenium locator
     * @return = true if element present, false if not
     */
    private boolean verifyElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	

}
