package genericLibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
 public WebDriver driver;
 public propertyfile pdata=new propertyfile();
 public WebDriverUtilies Utilies=new WebDriverUtilies();
 
 @BeforeMethod
 public void openApp() throws IOException {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get(pdata.getPropertydata("url"));
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 }
 @AfterMethod
 public void closeApp(TestResult res) throws IOException {
	int status = res.getStatus();
	String Name =res.getName();
	if(status==2) {
	photo p=new photo();
	p.getPhoto(driver, Name);
	}
	driver.quit();
 }
}
