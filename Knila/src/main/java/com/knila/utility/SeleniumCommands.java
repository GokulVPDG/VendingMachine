package com.knila.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCommands {

	public static WebDriver driver;

	public static void launchBrowser(String browser) throws Throwable {

		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {

			throw new Exception("Given browser name is not matching");
		}
	}

	public static void openApp(String url) {

		driver.get(url);
		driver.manage().window().maximize();

	}

	public static void enterText(WebElement ele, String name) {

		ele.sendKeys(name);

	}
	
	public static void enterTextUsingJS(WebElement ele, String attribute,String name) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('"+attribute+"','"+name+"')", ele);

	}

	public static void clickButton(WebElement ele) {

		ele.click();

	}

	public static String getProperty(String key, String dataType) throws Throwable, IOException {

		Properties p = new Properties();
		if(dataType.equals("System")) {
		p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//config/System.property")));
		}else {
			p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//TestData/Data.property")));
				
		}
		return p.getProperty(key);

	}
	
	public static void dropdownSelect(WebElement e,String name) {
		
		Select s=new Select(e);
		
		s.selectByVisibleText(name);

	}
	
	public static void closeBrowser() {
		
		driver.close();

	}
	
	public static void screenShot() throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat s=new SimpleDateFormat("yyyyMMddHHmmss");
		String x = s.format(new Date());
		
		FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"//ScreenShot//"+x+".png"));

	}
	
	public static void scrollDown(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

}
