/**
 * The scenario is 
 * 1. On the main page, click Develop.
 * 2. On the top menu, select Vizualization.
 * 3. On the side menu, select What is Datalens.
 * 4. Verify image presence.
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
		//  String baseurl = "https://developer.here.com/";
		  String baseurl = "file:///C:/Users/atamanki/Documents/uni/anwsys_ha1/final/index.html";
		  SeleniumTest st = new SeleniumTest();
		  st.setChromeEnvironment(chromepath, baseurl);

		  try{
/*		  //navbar menu
		  st.findAndClickElementByXpath(
				  "//*[@id=\"container\"]/header/div/div[2]/nav/ul/li[1]/div/span");
		  		  
		  //dropdown menu
		  st.findAndClickElementByXpath(
				  "//*[@id=\"container\"]/header/div/div[2]/nav/ul/li[1]/div/div/ul/ul[4]/li[4]/a");
		 		  
		  //side menu
		  st.findAndClickElementByXpath(
				  "//*[@id=\"toc\"]/ul/li[1]/ul/li[1]/a");
		  		  		  
		  //verify image
		  st.verifyImageShownByXpath(
				  "//*[@id=\"whatis__fig-whatis-example\"]/a/img");*/
		  
		  st.verifyImageShownByXpath("/html/body/div/div[2]/div[2]/div[1]/div[1]/div/img");
		  } catch(Exception e){
			  st.shutDownDriver();
		  }
		  //quit
		  st.shutDownDriver();
		  

	}

}
