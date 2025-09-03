package org.example.service;

import org.example.object.PhoneProduct;
import org.example.pages.ShoppingCartPage;

import java.util.logging.Logger;

public class ShoppingCartPageService extends BasePageService {

    public static final Logger log = Logger.getLogger(ShoppingCartPageService.class.getName());
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public String getItemNameText() {
        String name = shoppingCartPage.getItemsNameText();
        log.info("Get item name - " + name);
        return name;
    }

    public String getProductFieldValueByFieldNameText(String fieldName) {
        String fieldValue = shoppingCartPage.getProductFieldValueByFieldNameText(fieldName);
        log.info("Get field value - " + fieldValue);
        return fieldValue;
    }

    public ShoppingCartPageService clickOnDeleteButton() {
        log.info("Click on 'Delete' button");
        shoppingCartPage.clickOnDeleteButton();
        return new ShoppingCartPageService();
    }

    public PhoneProduct getActualPhoneProduct() {
        PhoneProduct phoneProduct = new PhoneProduct();
        String productName = getItemNameText();
        phoneProduct.setName(productName);
        phoneProduct.setSize(getProductFieldValueByFieldNameText("Size"));
        phoneProduct.setColor(getProductFieldValueByFieldNameText("Color"));
        phoneProduct.setServiceProvider(getProductFieldValueByFieldNameText("Service provider"));
        return phoneProduct;
    }
}
