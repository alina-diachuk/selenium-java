package com.procamp;

import com.procamp.litecart.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnit4.class)
public class ShopFunctionalityTest extends BaseTest {

    @Override
    protected String getUrl(){
        return Constants.SHOP_URL;
    }

    @Test
    public void addAndRemoveProductsToCart() {
        shopPage.tapOnProduct();
        shopPage.setBtnAddToCart();
        int addedCartItemCount = shopPage.getCartItemCount();
        shopPage.openCart();
        shopPage.removeProductFromCart();
        shopPage.returnHome();
        boolean deletedCartItemCount = shopPage.isBadgeExists();


        assertThat(addedCartItemCount).isGreaterThan(0);
        assertThat(deletedCartItemCount).isTrue();


    }
}
