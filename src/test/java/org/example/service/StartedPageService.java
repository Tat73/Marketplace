package org.example.service;

import org.example.pages.StartedPage;

import java.util.logging.Logger;

public class StartedPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(StartedPageService.class.getName());
    private final StartedPage startedPage = new StartedPage();


    public ResultPageService fillSearchField(String text) {
        log.info("Fill search filed with text " + text);
        startedPage.fillSearchField(text);
        return new ResultPageService();
    }

    public StartedPageService goToMainPage() {
        startedPage.goToMainPage();
        return this;
    }

    public ShoppingCartPageService clickOnCartButton() {
        log.info("Click on Cart button");
        startedPage.clickOnCartButton();
        return new ShoppingCartPageService();
    }

    public StartedPageService goToStartedPage() {
        startedPage.goToStartedPage();
        return this;
    }
}
