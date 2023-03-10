package Assesment;

import org.junit.After;
import org.junit.Before;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import Configuration.PathConfig;
import abc.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	
		driver=new ChromeDriver();
		
		driver.get("https://www.calculator.net");
	}
	
	@Test
	public void testMultiplication() {
		driver.findElement(By.id("cpar1")).sendKeys("432");
		
		driver.findElement(By.xpath("//td[text()='×']")).click();
		
		driver.findElement(By.id("cpar2")).sendKeys("525");
		
		driver.findElement(By.xpath("//input[@value='Calculate']")).click();
		
		int result = Integer.parseInt(driver.findElement(By.xpath("//font[contains(text(),'423 × 525 = ')]")).getText().split(" = ")[1]);
		
		Assert.assertEquals(result, 222075);
		
	}
	@Test
	public void testDivision() {
		driver.findElement(By.id("cpar1")).sendKeys("4000");
		
		driver.findElement(By.xpath("//td[text()='÷']")).click();
		
		driver.findElement(By.id("cpar2")).sendKeys("200");
		
		driver.findElement(By.xpath("//input[@value='Calculate']")).click();
		
		int result = Integer.parseInt(driver.findElement(By.xpath("//font[contains(text(),'4000 ÷ 200 = ')]")).getText().split(" = ")[1]);
		
				Assert.assertEquals(result, 20);
	}

	@Test
	public void testAddition() {
		driver.findElement(By.id("cpar1")).sendKeys("-234234");
		
		driver.findElement(By.xpath("//td[text()='+']")).click();
		
		driver.findElement(By.id("cpar2")).sendKeys("345345");
		
		driver.findElement(By.xpath("//input[@value='Calculate']"));
		
		int result = Integer.parseInt(driver.findElement(By.xpath("//font[contains(text(),'-234234 + 345345 = ')]")).getText().split("=")[1]);
		
		Assert.assertEquals(result, 111111);
	}
	@Test
	public void testSubtraction() {
		driver.findElement(By.id("cpar1")).sendKeys("234823");
		
		driver.findElement(By.xpath("//td[text()='−']")).click();
		
		driver.findElement(By.id("cpar2")).sendKeys("23094823");
		
		driver.findElement(By.xpath("//input[@value='Calculate']")).click();
		
		int result = Integer.parseInt(driver.findElement(By.xpath("//font[contains(text(),'234823 − (-23094823) = ')]")).getText().split("=")[1]);
		
		Assert.assertEquals(result, 23329646);
		
		
	}
	@AfterMethod
	public void Teardown() {
		driver.quit();
		
	}
}
