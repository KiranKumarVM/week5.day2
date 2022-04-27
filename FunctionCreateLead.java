package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionCreateLead extends BaseClass {
	

	@BeforeTest
	public void setFileName() {
		setfilename= "CreateLead";
	}
	
	@Test(dataProvider="data")
	public void data(String fname, String lname, String mname) {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		String attribute = driver.findElement(By.id("createLeadForm_companyName")).getAttribute("value");
		System.out.println(attribute);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(mname);
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Automation Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Welcome to the Automation");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("saikumaram@gmail.com");
		
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select states=new Select(state);
		states.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}
}
