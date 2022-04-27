package week5.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week5.day1.AssignmentBaseClass;

public class FunctionContacts extends BaseClass{
	@BeforeTest
	public void setfile() {
		setfilename="CreatContact";
	}
	
	    @Test(dataProvider="data")
		public void creatContact(String updateNote, String desc) {

			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.linkText("Create Contact")).click();
			driver.findElement(By.xpath("//input[@id='firstNameField'][@name='firstName']")).sendKeys("Priya");
			driver.findElement(By.id("lastNameField")).sendKeys("kumari");
			driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Priya");
			driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Kumari");
			driver.findElement(By.id("createContactForm_description")).sendKeys(desc);
			driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("priya@yahoo.com");
			WebElement states = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
	        Select state=new Select(states);
	        state.selectByVisibleText("New York");
	        driver.findElement(By.name("submitButton")).click();
	        driver.findElement(By.linkText("Edit")).click();
	        driver.findElement(By.id("updateContactForm_description")).clear();
	        driver.findElement(By.id("updateContactForm_importantNote")).sendKeys(updateNote);
	        driver.findElement(By.xpath("//input[@name='submitButton'][@value='Update']")).click();
	        String title = driver.getTitle();
	        System.out.println(title);
	        
	        
		}

	}


