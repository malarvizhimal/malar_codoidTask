package org.test.codoid;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques2 {
	public static void main(String[] args) {
//		Write code for positive and negative scenarios for Alerts
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(@onclick,'alertbox()')]")).click();
		Alert a=driver.switchTo().alert();
		a.accept();	
		driver.findElement(By.xpath("(//a[contains(@class,'analystic')])[2]")).click();
		driver.findElement(By.xpath("//button[contains(@onclick,'confirmbox()')]")).click();
		Alert c=driver.switchTo().alert();
		c.dismiss();
		driver.findElement(By.xpath("(//a[contains(@class,'analystic')])[3]")).click();
		driver.findElement(By.xpath("//button[contains(@onclick,'promptbox()')]")).click();
		Alert p=driver.switchTo().alert();
		p.sendKeys("hai");
		p.accept();
	}

}
