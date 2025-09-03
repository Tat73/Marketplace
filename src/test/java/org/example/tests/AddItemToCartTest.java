package org.example.tests;

import org.example.driver.BaseTest;
import org.example.object.PhoneProduct;
import org.example.service.AttachSideSheetPageService;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.ShoppingCartPageService;
import org.example.service.StartedPageService;
import org.example.util.ReadDataFromFile;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddItemToCartTest extends BaseTest {

    private ProductPageService productPageService;
    private StartedPageService startedPageService;
    private ResultPageService resultPageService;
    private ShoppingCartPageService shoppingCartPageService;
    private AttachSideSheetPageService attachSideSheetPageService;
    private List<String> list;

    @BeforeMethod(alwaysRun = true)
    public void searchElementAndGoToTheCart() {
        startedPageService = new StartedPageService();
        startedPageService.goToMainPage();
    }

    @Test(description = "Add phone to the cart and check description")
    public void checkPhoneDescription() {
        list = ReadDataFromFile.getDataFromProperties("phone");
        PhoneProduct expectedPhone = new PhoneProduct(list);
        resultPageService = startedPageService.fillSearchField(expectedPhone.getName());
        resultPageService.clickOnSearchButton();
        productPageService = resultPageService.clickOnElementInTheList((expectedPhone.getName()));
        attachSideSheetPageService = productPageService.clickAddCartButton();
        attachSideSheetPageService.clickOnNoThanksButton();
        shoppingCartPageService = attachSideSheetPageService.clickOnCartButton();

        assertThat("These objects are not equal", shoppingCartPageService.getActualPhoneProduct(),
                Matchers.equalTo(expectedPhone));
    }

    @AfterMethod(alwaysRun = true)
    public void deleteElementFromCart() {
        startedPageService.goToStartedPage();
        startedPageService.clickOnCartButton();
        shoppingCartPageService.clickOnDeleteButton();
    }
}
