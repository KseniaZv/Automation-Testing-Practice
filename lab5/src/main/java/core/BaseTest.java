package core;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
	
	private static final Logger log = LogManager.getLogger(BaseTest.class);
    protected static ConfigReader configReader = new ConfigReader();
	protected static WebDriver driver;
	protected static WPDriver wp;
	private String url = configReader.getStartURL();
	
	@BeforeSuite
	public void setupSuite(){

		log.debug("Initializing driver");
		log.info(getClass().getSimpleName() + " test is in progress");
		log.info("Open browser");
		switch (configReader.getBrowser().toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;

        }
		driver.manage().window().maximize();
	}
	@BeforeClass
	public void setupClass(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Navigate to " + url);
		driver.get(url);
	}
	@AfterClass
	public void closeClass(){
		takeScreenshot();
		log.debug("Took screenshot after Class of tests is over");
		log.info("Class is over.");
	}
	@AfterSuite
	public void closeSuite(){
		driver.quit();
	}
	
	public static void takeScreenshot(){
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
		LocalDateTime timePoint = LocalDateTime.now();
		String name = "logData/screenshots/screenshot "  + timePoint.get(ChronoField.YEAR_OF_ERA) + "-" + timePoint.getMonth() + "-" + timePoint.getDayOfMonth() + "("+ timePoint.getHour() + "-" + timePoint.getMinute() + "-" + timePoint.getSecond() + ").png";
		File destFile=new File(name);
		log.info("Screenshot name is " + name);
        try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
