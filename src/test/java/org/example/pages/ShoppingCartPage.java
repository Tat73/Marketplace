package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ShoppingCartPage extends BasePage {

    public WebElement getItemsName() {
        return waiters.fluentWaitVisibilityOfElement(driver.findElement(By.xpath("//div//span[@class='a-truncate-cut']")));
    }

    public WebElement getDeleteProductButton() {
        return driver.findElement(By.xpath("//input[@value='Delete']"));
    }

    public String getItemsNameText() {
        return getItemsName().getText();
    }

    public String getProductFieldValueByFieldNameText(String fieldName) {
        String itemFields = "//span[@class='a-size-small a-text-bold' and contains(text(),'%s')]/following-sibling::span";
        return driver.findElement(By.xpath(String.format(itemFields, fieldName))).getText();
    }

    public void clickOnDeleteButton() {
        getDeleteProductButton().click();
    }
}
