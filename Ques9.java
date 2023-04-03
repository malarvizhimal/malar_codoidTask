package org.test.codoid;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ques9 {
	public static String getDataFromExcel( String sheetname, int RowNo, int CellNo) throws IOException {
		File loc=new File("C:\\Users\\Malar\\eclipse-workspace\\CodoidTask\\src\\test\\resources\\codoid.xlsx");
		FileInputStream st=new FileInputStream(loc);		
		Workbook w=new XSSFWorkbook(st);		
		Sheet sheet=w.getSheet(sheetname);		
		Row row = sheet.getRow(RowNo);		
		Cell cell = row.getCell(CellNo);		
		int type = cell.getCellType();
		String value=null;
		if(type==1) {
			value = cell.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
				value = sf.format(date);
			}
			else {
				double db = cell.getNumericCellValue();
				long num=(long)db;
				value = String.valueOf(num);
			}
		}
		return value;
	}
	public static void main(String[] args) throws IOException {
//		Read data from Excel and given that data as input for login and password and click on submit and validate the popup which says Login is successful
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement user = driver.findElement(By.name("email"));
		user.sendKeys(getDataFromExcel("FbLogin", 1,0));
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys(getDataFromExcel("FbLogin", 1, 1));
	}

}
