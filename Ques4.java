package org.test.codoid;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques4 {
	public static void main(String[] args) {
//		Write code for handling Frames
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://chercher.tech/practice/frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("---total frames---");
		System.out.println(frames.size());
		WebElement f1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(f1);
		WebElement txtent = driver.findElement(By.xpath("//b[@id='topic']//following::input"));
		txtent.sendKeys("maran");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement drp = driver.findElement(By.id("animals"));
		Select s=new Select(drp);
		s.selectByVisibleText("Big Baby Cat");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame1");
		driver.switchTo().frame("frame3");
		WebElement clk = driver.findElement(By.id("a"));
		clk.click();
		driver.switchTo().parentFrame();
		txtent.sendKeys("abc");		
	}

}
