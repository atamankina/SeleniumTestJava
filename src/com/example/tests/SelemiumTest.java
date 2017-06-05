/**
 * 
 */
package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Galina
 *
 */
public class SelemiumTest {

	/**
	 * @param args
	 * @throws InterruptedException  
	 */
	public static void main(String[] args) throws InterruptedException {
		 
		  String chromepath = "./chromedriver/chromedriver.exe";
		  		 
		  System.setProperty("webdriver.chrome.driver", chromepath);

		  WebDriver driver = new ChromeDriver();
		  driver.get("https://developer.here.com/");
		  Thread.sleep(1000); //Thread sleep is for a user to see the progress.
		  WebElement topmenu = driver.findElement(By.xpath("//*[@id=\"container\"]/header/div/div[2]/nav/ul/li[1]/div/span")); 
          Thread.sleep(1000);
		  topmenu.click();
		  Thread.sleep(1000);
		  WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"container\"]/header/div/div[2]/nav/ul/li[1]/div/div/ul/ul[4]/li[4]/a"));
		  Thread.sleep(1000);
		  dropdown.click();
		  WebElement sidemenu = driver.findElement(By.xpath("//*[@id=\"toc\"]/ul/li[1]/ul/li[1]/a"));
		  Thread.sleep(1000);
		  sidemenu.click();
		  WebElement image = driver.findElement(By.xpath("//*[@id=\"whatis__fig-whatis-example\"]/a/img"));
		  Thread.sleep(2000);
		  Actions action = new Actions(driver);
		  action.moveToElement(image);
		  action.perform();
		  System.out.println(image.getSize());
		  Thread.sleep(5000);
		  driver.quit();


	}

}
