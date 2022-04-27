package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionEditLead extends BaseClass{
 
	@BeforeTest
	public void setFileName() {
		setfilename= "Editor";
	}
	
	@Test(dataProvider="data")
	public void edits(String company, String Descr) {
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Create Lead")).click();
	
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys("SAI");
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys("RAM");
	driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Kumar");
	driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("CSE");
	driver.findElement(By.id("createLeadForm_description")).sendKeys(Descr);
	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Tcsuser@gmail.com");
	
	WebElement eleCountry = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
	Select elecoun= new Select(eleCountry);
	elecoun.selectByVisibleText("New York");
	driver.findElement(By.name("submitButton")).click();
	
	driver.findElement(By.linkText("Edit")).click();
	driver.findElement(By.id("updateLeadForm_description")).clear();
    driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("HI IM");
    driver.findElement(By.name("submitButton")).click();
    
    String title = driver.getTitle();
    System.out.println(title);
}

}
