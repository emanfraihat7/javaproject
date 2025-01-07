package firstpro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();
	

	String myWebSite = "https://www.saucedemo.com/";

	String userName = "standard_user";
	String passwordInput = "secret_sauce";
	
	
	@BeforeTest

	public void mySetup() {
		
		driver.get(myWebSite);

		driver.manage().window().maximize();
		
		
	}

	@Test(priority=1)

	public void Login() {
		WebElement UserNameField= driver.findElement(By.id("user-name"));
		WebElement PassField= driver.findElement(By.id("password"));
		WebElement InputButton= driver.findElement(By.id("login-button"));
		
		UserNameField.sendKeys(userName);
		PassField.sendKeys(passwordInput);
		InputButton.click();
	}
	
	
	@Test(priority=2, enabled=false)
	
	public void AddElement() throws InterruptedException {
		Thread.sleep(2000);
//		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		List<WebElement> AddToCartButtons= driver.findElements(By.className("btn"));
		for(int i=0;i<AddToCartButtons.size();i++) {
			if(i==4) {
				break;
			}
			AddToCartButtons.get(i).click();

		}

	}
	
	@Test(priority=3)
	
	public void RemoveElement() throws InterruptedException {
	
		Thread.sleep(2000);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		
	}
	
	@Test(priority=4)
	public void AddItemsWithSouce() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> ItemsNames= driver.findElements(By.className("inventory_item_name "));
		List<WebElement> AddToCartButtons= driver.findElements(By.className("btn"));
	
		for (int i = 0; i < ItemsNames.size(); i++) {

			if (ItemsNames.get(i).getText().startsWith("Sauce")) {
				continue;

			}
			AddToCartButtons.get(i).click();

		}
		
		

	}
	

	@AfterTest
	public void AfterTheTestIsDone() {
	}
	

}
