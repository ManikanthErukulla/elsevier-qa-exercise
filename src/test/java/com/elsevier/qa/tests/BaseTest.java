package com.elsevier.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;
import com.elsevier.qa.pages.DressesPage;
import com.elsevier.qa.pages.HomePage;
import com.elsevier.qa.pages.ProductToCartConfirmationPage;
import com.elsevier.qa.pages.ShoppingCartSummaryPage;
import com.elsevier.qa.pages.SignInPage;
import com.elsevier.qa.pages.SummerDressesPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	protected HomePage homePage;
	protected DressesPage dressesPage;
	protected SummerDressesPage summerDressesPage;
	protected ProductToCartConfirmationPage productToCartConfirmationPage;
	protected ShoppingCartSummaryPage shoppingCartSummaryPage;
	protected SignInPage signInPage;
	
	@BeforeTest
	public void setUp()
	{
		if (System.getProperty("browser")=="firefox")
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		homePage = new HomePage(driver);
		dressesPage = new DressesPage(driver);
		summerDressesPage = new SummerDressesPage(driver);
		productToCartConfirmationPage = new ProductToCartConfirmationPage(driver);
		shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
		signInPage = new SignInPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
