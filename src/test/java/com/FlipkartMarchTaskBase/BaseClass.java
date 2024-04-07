package com.FlipkartMarchTaskBase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static BaseClass base=null;


	private BaseClass() {
}

	public static BaseClass getInstance() { 
	if(base==null) {
		base=new BaseClass();
	}
	return base;
	
}


public static WebDriver driver;


public void browserLaunch() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options=new ChromeOptions();
	options.addArguments("start-maximized");
	driver =new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	

}
public void launchApplication(String url) {
	driver.get(url);
	
}
public void navigateApplication(String url) {
	driver.navigate().to(url);
}
public void refreshApplication() {
	driver.navigate().refresh();
}
public void backward() {
	driver.navigate().back();
}
public void forward() {
	driver.navigate().forward();
}
public void maximize() {
	driver.manage().window().maximize();
}public void minimize() {
	driver.manage().window().minimize();
}
public void newWindow() {
	driver.switchTo().newWindow(WindowType.WINDOW);
}
public void newTab() {
	driver.switchTo().newWindow(WindowType.TAB);
}
public void browserClose() {
	driver.close();
	
}
public void browserQuit() {
	driver.quit();
}
public String getTitle() {
	String Title=driver.getTitle();
	return Title;
	
}
public String getPageSource() {
	String Source=driver.getPageSource();
	return Source;
}
public String getCurrentUrl() {
	String Url=driver.getCurrentUrl();
	return Url;
}
public void clicks(WebElement Web){
	Web.click();
	
}
public void clean(WebElement Web){
	Web.clear();
	
}
public void submits(WebElement Web){
	Web.submit();
	
}
public void sendValue(WebElement Web, String Value) {
	Web.sendKeys(Value);
}
public void sendAndEnter(WebElement Web, String Value, int no) {
	Web.sendKeys(Value,Keys.ENTER);
}
public boolean display(WebElement Web) {
	boolean Boolean=Web.isDisplayed();
	return Boolean;
	
}
public boolean enable(WebElement Web) {
	boolean Boolean=Web.isEnabled();
	return Boolean;
	}
public boolean selected(WebElement Web) {
	boolean Boolean=Web.isSelected();
	return Boolean;
}
public String getAttributeName(WebElement Web) {
	String getName=Web.getAttribute("name");
	return getName;
	
}
public String getAttributeValue(WebElement Web) {
	String getValue=Web.getAttribute("name");
	return getValue;
	
}


public String text(WebElement Web) {
	String Text=Web.getText();
	return Text;
}
public String cssValue(WebElement Web,int r,String Value) {
	String CssValue=Web.getCssValue(Value);
	return CssValue;
	
}
public void enter(WebElement Web, String Value) {
	Actions action =new Actions(driver);
	action.sendKeys(Web,Value).build().perform();;
}
public void doubleclick(WebElement Web) {
	Actions action =new Actions(driver);
	action.doubleClick(Web).build().perform();
}
public void contextclick(WebElement Web) {
	Actions action =new Actions(driver);
	action.contextClick(Web).build().perform();
}
public void draganddrop(WebElement Web, WebElement Web1) {
	Actions action =new Actions(driver);
	action.dragAndDrop(Web, Web1).build().perform();
}
public void movetoElements(WebElement Web) {
	Actions action =new Actions(driver);
	action.moveToElement(Web).build().perform();
}

public void selectValue(WebElement Web, String Value) {
	Select select= new Select(Web);
	select.selectByValue(Value);
}
public void selectIndex(WebElement Web, int no) {
	Select select= new Select(Web);
	select.selectByIndex(no);
}
public void selectVisibleText(String New, WebElement Web) {
	Select select= new Select(Web);
	select.selectByVisibleText(New);

}

public void deSelectValue(WebElement Web,String Value,int m) {
	Select select= new Select(Web);
	select.deselectByValue(Value);
	
}
public void deSelectIndex(WebElement Web,int no) {
	Select select= new Select(Web);
	select.deselectByIndex(no);

}
public void deSelectVisibleText(WebElement Web,String New) {
	Select select= new Select(Web);
	select.deselectByVisibleText(New);
}

public void selectedOptions(WebElement Web) {
	Select select= new Select(Web);
	List<WebElement>list=select.getOptions();
	for(int i=0;i<list.size();i++) {
		WebElement list1=list.get(i);
		String string=list1.getText();
	}
	
}
public List<WebElement> selectedOptionsreturn(WebElement Web) {
	Select select= new Select(Web);
	List<WebElement>list=select.getOptions();
	return list;
	}
public void allSelectOption(WebElement Web) {
	Select select= new Select(Web);
	List<WebElement> list=select.getAllSelectedOptions();
	for(int i=0;i<list.size();i++) {
		WebElement list1=list.get(i);
		String string=list1.getText();
	}
}
public String firstSelectOption(WebElement Web) {
	Select select= new Select(Web);
	WebElement first=select.getFirstSelectedOption();
	String string=first.getText();
	return string;
}
public boolean multiple(WebElement Web) {
	Select select= new Select(Web);
	boolean Boolean=select.isMultiple();
	return Boolean;
}
public void alertsAccept() {
	Alert alert=driver.switchTo().alert();
	alert.accept();
}
public void alertsDismiss() {
	Alert alert=driver.switchTo().alert();
	alert.dismiss();

}

public String textAlert() {
	Alert alert=driver.switchTo().alert();
	String string=alert.getText();
	return string;
}
public void frames(WebElement Web) {
	driver.switchTo().frame(Web);
	
}
public void framesValue(String value) {
	driver.switchTo().frame(value);	
}
public void listFramesParent(List<WebElement> LWeb, WebElement Web) {
	try {
	for(int i=0;i<LWeb.size();i++) {
		driver.switchTo().frame(i);
		Web.click();
	}
	}
	catch(Exception e){
		driver.switchTo().parentFrame();
	
	}
	
}
	public void listFramesDefault(List<WebElement> LWeb, WebElement Web) {
		try {
		for(int i=0;i<LWeb.size();i++) {
			driver.switchTo().frame(i);
			Web.click();
		}
		}
		catch(Exception e){
			driver.switchTo().defaultContent();
		
		}

	}
	
	public void javaScriptName(WebElement Web, String Name) {
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('Value',"+Name+")",Web);
//		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red')",colour);
//		js.executeScript("arguments[0].scrollIntoView('true')",Web2);

		
	}
	public void javaScriptValue(WebElement Web1, String Value) {
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('Value',"+Value+")",Web1);

	}
	public void javaScriptClick(WebElement Web2) {
		JavascriptExecutor js=(JavascriptExecutor) driver;

	js.executeScript("arguments[0].click()",Web2);
	}

	public void explicityWaits(WebElement Web) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

		Web.click();
		
	}
	public void explicityWaitsSend(String value,WebElement Web1) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

		Web1.sendKeys(value);

	}

	
	public String WindowHandleGetCode() {
		String handle=driver.getWindowHandle();
		return handle;
	}
	public void singleWindowHandles() {
		String Parent=driver.getWindowHandle();
		Set<String> Child=driver.getWindowHandles();
		for(String Childs:Child) {
			if(!Childs.equals(Parent)) {
				driver.switchTo().window(Parent);
			}
		}
	
	}
	public void multiWindowHandles() {
		Set<String> set=driver.getWindowHandles();
		List<String> list=new ArrayList<>();
		list.addAll(set);
		for(int i=0;i<list.size();i++) {
			driver.switchTo().window(list.get(i));
			
			}
	}
	public void screenShot(String my, String path) {
		try {
			TakesScreenshot Take=(TakesScreenshot) driver;
		File file=Take.getScreenshotAs(OutputType.FILE);
		File file1=new File(path);
		FileUtils.copyFile(file, file1);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	public ResultSet sqlconnect(String query) {
			Connection connection =null; 
			ResultSet resultset=null;
				try {
					Class.forName("com.microsoft.sql.server");
					String connectUrl="jdbc:driver//localhost:1433//database=master//username=mukesh;password=poassword//trustConnection=true";
					try {
						connection =DriverManager.getConnection(connectUrl);
						Statement statement = connection.createStatement();
						resultset=statement.executeQuery("Select * from tableName");
//						int in1=resultset.getInt(0);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return resultset;
				
}
	public File  multiExcelOutput (String path, List<WebElement> web1) throws IOException {
				
		File f=new File(path);
		
		FileOutputStream files=new FileOutputStream(f);
		
		FileOutputStream m=new FileOutputStream(f);
		HSSFWorkbook h= new HSSFWorkbook();
		HSSFSheet s1= h.createSheet("Mobile Name");

		for(int i=0;i<web1.size();i++) {
			
			WebElement r=web1.get(i);
			String s=r.getText();
//			
			HSSFRow row1=s1.createRow(i);
			HSSFCell cell1=row1.createCell(i);
			
			cell1.setCellValue(s);
		}
			h.write(files);
			h.close();
			
			System.out.println("Excel Success");
			return f;
		
	}

	
}
