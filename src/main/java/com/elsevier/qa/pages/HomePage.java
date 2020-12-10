package com.elsevier.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//a[@title='Dresses'])[2]")
    private WebElement dresses_menu;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String goTo(){
        this.driver.get("http://automationpractice.com/index.php");
        this.wait.until(ExpectedConditions.visibilityOf(this.dresses_menu));
        return driver.getTitle();
    }

    public void navigateToDresses(){
    	this.dresses_menu.click();
    }
}
