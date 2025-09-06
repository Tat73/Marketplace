package org.example.service;

import org.example.pages.AttachSideSheetPage;


public class AttachSideSheetPageService extends BasePageService {

    AttachSideSheetPage attachSideSheetPage = new AttachSideSheetPage();

    public void clickOnNoThanksButton() {
        log.info("Click on 'No thanks ' button");
        attachSideSheetPage.getNoThanksBtn().click();
    }

    public ShoppingCartPageService clickOnCartButton() {
        log.info("Click on 'Cart' button");
        attachSideSheetPage.getCartBtn().click();
        return new ShoppingCartPageService();
    }

}
