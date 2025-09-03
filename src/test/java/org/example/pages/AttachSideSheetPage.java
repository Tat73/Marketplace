package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AttachSideSheetPage extends BasePage {

    public WebElement getNoThanksBtn(){
        return driver.findElement(By.xpath("//span[@id='attachSiNoCoverage-announce']//preceding-sibling::input[@class='a-button-input']"));
    }

    public  WebElement getCartBtn() {
        return driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button-announce']/preceding-sibling::input"));
    }
}
