package FlipkartTestNGStep;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;


import dev.failsafe.internal.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMobileNames {
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	@DataProvider(name = "ok")
	public Object [][] provide(){
		return new Object[][] {{"new mobiles 5g"}};
	}
		
	
		@Parameters({"Browser"})
		@BeforeClass()
		public static void LaunchBrowser(String Browser) {
			
			if(Browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("start-maximized");
			driver=new ChromeDriver(option);
			
			
			}
			else if(Browser.equals("Edge")) {
				WebDriverManager.edgedriver().setup();
				EdgeOptions option=new EdgeOptions();
				option.addArguments("start-maximized");
				 driver=new EdgeDriver(option);
			}
			
			else {
				System.out.println("Browser not launched");
			}
			
			driver.get("https://www.flipkart.com/");
			
			wait =new WebDriverWait(driver,Duration.ofSeconds(30));

		}
		
		@BeforeMethod
		public void methodName() {
			System.out.println("BeforePrinted");
		}
		
		@AfterMethod
		public void methodsName() {
			System.out.println("AfterPrinted");

		}
		
		
		@Test(priority = 1,dataProvider = "ok",groups = "Smoke")
		public void searchBar(String key) throws InterruptedException {
			WebElement web=driver.findElement(By.xpath("//input[@placeholder=\"Search for Products, Brands and More\"]"));
			
			Thread.sleep(3000);
			web.click();
			web.sendKeys(key,Keys.ENTER);
			
			
		}
		
		@Parameters({"Browser","Sheet"})
		@Test(priority = 2,groups = "Smoke",enabled = true)
		public void mobileName(String Sheet, String Name) throws IOException {
			List<WebElement> web1=driver.findElements(By.xpath("//span[@class=\"_1lRcqv\"]/parent::div/parent::div/div[@class=\"_4rR01T\"]"));
			wait.until(ExpectedConditions.visibilityOfAllElements(web1));
			
			if(Sheet.equals("Chrome")) {
			File f=new File("C:\\Users\\MUKESH\\eclipse-workspace\\com.FlipkartMarchTask\\target\\MukeshTestNG.xls");
			
			FileOutputStream files=new FileOutputStream(f);
			
			FileOutputStream m=new FileOutputStream(f);
			HSSFWorkbook h= new HSSFWorkbook();
			HSSFSheet s1= h.createSheet(Name);

			for(int i=0;i<web1.size();i++) {
				
				WebElement r=web1.get(i);
				String s=r.getText();

				HSSFRow row1=s1.createRow(i);
				HSSFCell cell1=row1.createCell(i);
				
				cell1.setCellValue(s);
			}
				h.write(files);
				h.close();
			System.out.println("success");
			
			}
			else if(Sheet.equals("Edge")) {
				
				File f=new File("C:\\Users\\MUKESH\\eclipse-workspace\\com.FlipkartMarchTask\\target\\MukeshTestNG1.xls");
				
				FileOutputStream files=new FileOutputStream(f);
				
				FileOutputStream m=new FileOutputStream(f);
				HSSFWorkbook h= new HSSFWorkbook();
				HSSFSheet s1= h.createSheet(Name);

				for(int i=0;i<web1.size();i++) {
					
					WebElement r=web1.get(i);
					String s=r.getText();

					HSSFRow row1=s1.createRow(i);
					HSSFCell cell1=row1.createCell(i);
					
					cell1.setCellValue(s);
				}
					h.write(files);
					h.close();
				System.out.println("success");
				
			}
			else {
				System.out.println("File not Success");
			}

		}
			

		
		@AfterClass
		public static void closeBrowser() {
			driver.quit();
		}
		
	
	

}
