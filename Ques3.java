package org.test.codoid;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques3 {
	public static void main(String[] args) {
//		Write code for Cross Browser Testing
		//launching chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driverChrome = new ChromeDriver(options);
		driverChrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driverChrome.manage().window().maximize();
		driverChrome.get("https://www.facebook.com/");
		driverChrome.quit();
		//launching edge driver
		WebDriverManager.edgedriver().setup();
		WebDriver driverEdge = new EdgeDriver();
		driverEdge.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driverEdge.manage().window().maximize();
		driverEdge.get("https://www.facebook.com/");
		driverEdge.quit();	
	}
}
