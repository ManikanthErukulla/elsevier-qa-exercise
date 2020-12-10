package com.elsevier.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	
	private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[text()='Authentication']")
    private WebElement signInPageHeader;

    
    public SignInPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public boolean isSignInPageVisible(){
        this.wait.until(ExpectedConditions.visibilityOf(this.signInPageHeader));
        return this.signInPageHeader.isDisplayed();
    }

}
