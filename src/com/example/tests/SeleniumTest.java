/**
 * 
 */
package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Galina
 *
 */
public class SeleniumTest {
	
	public static WebDriver driver;

	/**
	 * @param chromepath = path to the chrome driver on the machine
	 */
	public void setChromeEnvironment(String chromepath){
		System.setProperty("webdriver.chrome.driver", chromepath);
		startChromeDriver();
	}
	
	/**
	 * sets the static driver variable to chrome driver
	 */
	private void startChromeDriver(){
		driver = new ChromeDriver();
	}
	
	/**
	 * @param xpath = path to the required element
	 * @throws InterruptedException because of the thread sleep to slow down the process
	 */
	public void findAndClickElementByXpath(String xpath) throws InterruptedException{
		WebElement element = driver.findElement(By.xpath(xpath));
		Thread.sleep(2000);
		element.click();
	}
	
	/**
	 * @param xpath = path to the required image
	 * @throws InterruptedException because of the thread sleep to slow down the process
	 */
	public void verifyImagePresentByXpath(String xpath) throws InterruptedException{
		WebElement image = driver.findElement(By.xpath(xpath));
		Thread.sleep(2000);
    	Boolean imagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);
		if(imagePresent){
			Actions action = new Actions(driver);
			action.moveToElement(image).perform();
			System.out.println("Image is shown with the size" + image.getSize());
		}
		else{System.out.println("Image is not shown.");}

	}
	
	

}
