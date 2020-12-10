package com.elsevier.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductToCartConfirmationPage {
	
	private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h2")
    private WebElement cartConfirmationMsg;
    
    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckout;
    
    public ProductToCartConfirmationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public boolean productToCartConfirmation(){
        this.wait.until(ExpectedConditions.visibilityOf(this.cartConfirmationMsg));
        
        return this.cartConfirmationMsg.getText().contains("Product successfully added to your shopping cart");
    }

    public void navigateToCartSummaryPage(){
    	this.proceedToCheckout.click();
    }

}
