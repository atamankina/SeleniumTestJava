/**
 * 
 */
package com.example.tests;

/**
 * @author Galina
 *
 */
public class Main {

	/**
	 * @param args 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		 
		  //set environment and go to website
		  String chromepath = "./chromedriver/chromedriver.exe";	 
		  String baseurl = "https://developer.here.com/";
		  SeleniumTest st = new SeleniumTest();
		  st.setChromeEnvironment(chromepath, baseurl);

		  //navbar menu
		  st.findAndClickElementByXpath(
				  "//*[@id=\"container\"]/header/div/div[2]/nav/ul/li[1]/div/span");
		  		  
		  //dropdown menu
		  st.findAndClickElementByXpath(
				  "//*[@id=\"container\"]/header/div/div[2]/nav/ul/li[1]/div/div/ul/ul[4]/li[4]/a");
		 		  
		  //side menu
		  st.findAndClickElementByXpath(
				  "//*[@id=\"toc\"]/ul/li[1]/ul/li[1]/a");
		  		  		  
		  //verify image
		  st.verifyImagePresentByXpath(
				  "//*[@id=\"whatis__fig-whatis-example\"]/a/img");
		  
		  //quit
		  st.shutDownDriver();
		  

	}

}
