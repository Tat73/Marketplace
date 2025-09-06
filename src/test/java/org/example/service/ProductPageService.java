package org.example.service;

import org.example.pages.ProductPage;


public class ProductPageService extends BasePageService {

    private ProductPage productPage = new ProductPage();

    public int getQuantityOfItemsInTheCart() {
        return productPage.getQuantityOfItemsInTheCart();
    }

    public boolean isAddToCartButtonDisplayed() {
        boolean result = productPage.isAddToCartButtonDisplayed();
        log.info("'Add to Cart' button displayed " + result);
        return result;
    }

    public AttachSideSheetPageService clickAddCartButton() {
        log.info("Click on 'Add to Cart' button");
        productPage.clickAddCartButton();
        return new AttachSideSheetPageService();
    }
}
