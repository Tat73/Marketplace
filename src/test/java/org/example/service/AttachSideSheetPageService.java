package org.example.service;

import org.example.pages.AttachSideSheetPage;

import java.util.logging.Logger;

public class AttachSideSheetPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(AttachSideSheetPageService.class.getName());

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
