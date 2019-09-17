package com.procamp;

import com.procamp.litecart.utils.Constants;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShopFunctionalityTest extends BaseTest {

    @Override
    protected String getUrl(){
        return Constants.shopUrl;
    }

    @Test
    public void addAndRemoveProductsToCart() {
        shopPage.tapOnProduct();
        shopPage.setBtnAddToCart();
        shopPage.openCart();
        shopPage.removeProductFromCart();
        assertFalse(shopPage.shoppingCartDisplayed());

    }
}
