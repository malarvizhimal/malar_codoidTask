package org.test.codoid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques11 {

	public static void main(String[] args) {
//		Write code for handling multiple browsers and switch to new windows?		        
//				chrome
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				WebDriver driverChrome = new ChromeDriver(options);
				driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driverChrome.manage().window().maximize();
//				firefox
				WebDriverManager.edgedriver().setup();
				WebDriver driverEdge = new EdgeDriver();
				driverEdge.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driverEdge.manage().window().maximize();
//				Open Chrome and navigate to a website
				WebDriver chromeDriver = new ChromeDriver();
				chromeDriver.get("https://www.google.com");		        
//				Open Firefox and navigate to the same website
		        WebDriver edgeDriver = new EdgeDriver();
		        edgeDriver.get("https://www.google.com");
//		      Perform some actions on each browser window
		        WebElement chromeSearchBox = chromeDriver.findElement(By.name("q"));
		        chromeSearchBox.sendKeys("Selenium");
		        chromeSearchBox.submit();		        
		        WebElement firefoxSearchBox = edgeDriver.findElement(By.name("q"));
		        firefoxSearchBox.sendKeys("Java");
		        firefoxSearchBox.submit();		  
//		      Switch to the new Firefox window and perform some actions
		        String mainWindowHandle = edgeDriver.getWindowHandle();
		        for (String handle : edgeDriver.getWindowHandles()) {
		        	if (!handle.equals(mainWindowHandle)) {
		        		edgeDriver.switchTo().window(handle);
		        		WebElement firefoxResult = edgeDriver.findElement(By.xpath("//h3[contains(text(),'Java Programming Language')]"));
		        		System.out.println(firefoxResult.getText());
				        }
		        	}	
	}

}
