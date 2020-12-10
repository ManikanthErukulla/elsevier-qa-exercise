package com.elsevier.qa.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElsevierTests extends BaseTest {
	 
	
    @Test (priority=1)
    public void launchHomePage() {
    	String title = homePage.goTo();
    	Assert.assertEquals(title, "My Store");
    }
    
    @Test (priority=2)
    public void navigateToDressesPage() {
    	homePage.navigateToDresses();
    	Assert.assertTrue(dressesPage.dressesPageHeader());
    }

    @Test(priority=3)
    public void selectSummerDressesSection() {
    	dressesPage.navigateToSummerDresses();
    	Assert.assertTrue(summerDressesPage.summerDressesPageHeader());
    }
    
    @Test (priority=4)
    public void addFirstSummerDressToCart() {
    	summerDressesPage.addSummerDress();
    	Assert.assertTrue(productToCartConfirmationPage.productToCartConfirmation());
    }

    @Test (priority=5)
    public void navigateToCartSummaryPage() {
    	productToCartConfirmationPage.navigateToCartSummaryPage();
    	Assert.assertTrue(shoppingCartSummaryPage.productToCartSummaryPage());
    }
    
    @Test (priority=6)
    public void navigateToLoginPageFromCartPage() {
    	shoppingCartSummaryPage.navigateToCheckoutPage();
    	Assert.assertTrue(signInPage.isSignInPageVisible());
    }
}
