package com.elsevier.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartSummaryPage {

	private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[contains(text(),'Shopping-cart summary')]")
    private WebElement shoppingCartHeader;
    
    @FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
    private WebElement proceedToCheckout;
    
    public ShoppingCartSummaryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public boolean productToCartSummaryPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.proceedToCheckout));
        return this.proceedToCheckout.isDisplayed();
    }

    public void navigateToCheckoutPage(){
    	this.proceedToCheckout.click();
    }
    
}
