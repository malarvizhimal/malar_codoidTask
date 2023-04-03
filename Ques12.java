package org.test.codoid;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques12 {

	public static void main(String[] args) {
//		How to shift between tabs of the same browser using selenium?
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("iphone",Keys.ENTER);
		WebElement firstProductClick = driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 14 (Purple, 128 GB)')]"));
		//clicking the first product for openning the new windows
		firstProductClick.click();		
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		//switching to new windows
		for(String i:allWindows) {
			if(!mainWindow.equals(i)) {
				driver.switchTo().window(i);
			}
		}
		//performing actions on new windows
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
	}

}
