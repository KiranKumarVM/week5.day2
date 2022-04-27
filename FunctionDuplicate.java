package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FunctionDuplicate extends BaseClass {
	@BeforeTest
	public void fileName() {
		setfilename="DuplicateLead";
	}
	@Test(dataProvider="data")
	public void duplicate(String oldcom, String name, String newcom) {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(oldcom);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("SAI");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kumar");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("RAm");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Hi Guys");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("saikumarram@tcs.com");
		WebElement selState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selSta = new Select(selState);
		selSta.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();

		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.linkText("Duplicate Lead")).click();
		WebElement comName = driver.findElement(By.id("createLeadForm_companyName"));
		comName.clear();
		comName.sendKeys(newcom);
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.clear();
		firstName.sendKeys(name);
		driver.findElement(By.className("smallSubmit")).click();

		String title2 = driver.getTitle();
		System.out.println(title2);
	}
}
