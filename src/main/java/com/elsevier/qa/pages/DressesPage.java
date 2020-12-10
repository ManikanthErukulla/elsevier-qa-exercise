package com.elsevier.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DressesPage {
	
	private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2[contains(text(),'Dresses')]")
    private WebElement dresses_header;

    @FindBy(xpath = "//h5/a[text()='Summer Dresses']")
    private WebElement summerDresses;
    
    public DressesPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public boolean dressesPageHeader(){
        this.wait.until(ExpectedConditions.visibilityOf(this.dresses_header));
        return this.dresses_header.isDisplayed();
    }

    public void navigateToSummerDresses(){
    	this.summerDresses.click();
    }

}
