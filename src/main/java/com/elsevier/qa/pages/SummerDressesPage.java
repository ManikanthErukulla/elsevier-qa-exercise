package com.elsevier.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerDressesPage {
	
	private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1/span[contains(text(),'Summer Dresses')]")
    private WebElement summer_dresses_header;
    
    @FindBy(id = "list")
    private WebElement list;

    @FindBy(id = "searchbox")
    public WebElement chooseFirstDress;

    @FindBy(xpath = "//span[text()='Add to cart']")
    public WebElement addToCartBtn;
    
    
    public SummerDressesPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public boolean summerDressesPageHeader(){
        this.wait.until(ExpectedConditions.visibilityOf(this.summer_dresses_header));
        return this.summer_dresses_header.isDisplayed();
    }

    public void addSummerDress()  {
    	this.list.click();
    	this.addToCartBtn.click();
    }

}
