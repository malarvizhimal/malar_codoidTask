package org.test.codoid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques6 {

	public static void main(String[] args) {
//		Select multiple options from the dropdown
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.softwaretestingmaterial.com/sample-webpage-to-automate/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		WebElement drop = driver.findElement(By.name("multipleselect[]"));
		Select sc = new Select(drop);
		sc.selectByIndex(0);
		sc.selectByValue("msmanual");
		sc.selectByVisibleText("Selenium");
		boolean selectedMultiple = sc.isMultiple();
		System.out.println(selectedMultiple);
	}

}
