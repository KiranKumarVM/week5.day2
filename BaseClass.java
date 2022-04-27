package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;
	public String setfilename;
	
	@DataProvider(name="data")
	public String[][] function() throws IOException {
		return ReadExcel.getExcel(setfilename);
	}
	@Parameters({"username","password","url"})
	@BeforeMethod
  public void beforeMethod(String usName, String pWord, String url) {
		 WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys(usName);
			driver.findElement(By.id("password")).sendKeys(pWord);
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


}
