/**
 * The scenario is 
 * 1. On the main page, click Develop.
 * 2. On the top menu, select Visualization.
 * 3. On the side menu, select What is Data lens.
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
		 
		  //Input
		  String baseurl = "https://developer.here.com/";
		  String develop = "//*[@id=\"container\"]/header/div/div[2]/nav/ul/li[1]/div/span";
		  String visualization = "//*[@id=\"container\"]/header/div/div[2]/nav/ul/li[1]/div/div/ul/ul[4]/li[4]/a";
		  String whatis = "//*[@id=\"toc\"]/ul/li[1]/ul/li[1]/a";
		  String image = "//*[@id=\"whatis__fig-whatis-example\"]/a/img";
		  
		  //set environment and go to website
		  String chromepath = "./chromedriver/chromedriver.exe";
		  SeleniumTest st = new SeleniumTest();
		  st.setChromeEnvironment(chromepath, baseurl);

		  //go through scenario
		  try{
		      st.findAndClickElementByXpath(develop);
		  	  st.findAndClickElementByXpath(visualization);
		 	  st.findAndClickElementByXpath(whatis);
		      st.verifyImageShownByXpath(image);	  
		  } catch(Exception e){
		  		st.shutDownDriver();
		  }
		  
		  //quit
		  st.shutDownDriver();
		  

	}

}
