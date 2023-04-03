package org.test.codoid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques5 {
	public static void main(String[] args) throws InterruptedException {
//		Automate Menu and Sub Menu and click on a link in Sub Menu and navigate to the page and click on an element
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Actions ac = new Actions(driver);
		WebElement menu = driver.findElement(By.xpath("//div[contains(text(),'Fashion')]"));
		ac.moveToElement(menu).perform();
		Thread.sleep(3000);
		WebElement subMenu = driver.findElement(By.xpath("//a[@class='_6WOcW9 _2-k99T']"));
		ac.moveToElement(subMenu).perform();
		WebElement sunMenuClick = driver.findElement(By.xpath("(//a[@class='_6WOcW9 _3YpNQe'])[4]"));
		ac.click(sunMenuClick).perform();	
	}

}
