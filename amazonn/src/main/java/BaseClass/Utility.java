package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void main(String[] args) {
		openBrowser();
	}
public static WebDriver openBrowser() {
	System.setProperty("webdriver.chrome.driver", configuration.driverPath) ;
	ChromeOptions opt = new ChromeOptions() ;
	opt.addArguments("--disable-notifications") ;
	WebDriver driver = new ChromeDriver(opt) ;
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver ;
	
	
}

public static void TakeSS(WebDriver driver, String s) throws IOException {
	Date date= new Date();
	String name = date.toString().replace(":", "_") ;
	File dest= new File(s+configuration.ScreenShotPath+name+".png") ; 
	 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileHandler.copy(source, dest);
}
}
