package com.procamp;

import com.procamp.litecart.utils.Constants;
import org.junit.Test;

public class ShopFunctionalityTest extends BaseTest {

    @Override
    protected String getUrl(){
        return Constants.shopUrl;
    }

    @Test
    public void addAndRemoveProductsToCart() {
        shopPage.tapOnProduct();
//        shopPage.chooseDuckSize();
        shopPage.setBtnAddToCart();
        shopPage.removeProductFromCart();

    }
}
