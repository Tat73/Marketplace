package org.example.pages;

import org.example.util.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StartedPage extends BasePage {

    public WebElement getCartButton() {
        return driver.findElement(By.xpath("//a[@id='nav-cart']"));
    }

    public WebElement getSearchField() {
        return driver.findElement(By.xpath("//input[@name='field-keywords']"));
    }

    public StartedPage goToMainPage() {
        driver.navigate().to(GetProperties.getProperties("config", "logoUrl"));
        return this;
    }

    public StartedPage goToStartedPage() {
        driver.navigate().to(GetProperties.getProperties("config", "goTomainPage"));
        return this;
    }

    public StartedPage fillSearchField(String text) {
        getSearchField().clear();
        getSearchField().sendKeys(text);
        return this;
    }

    public void clickOnCartButton() {
        getCartButton().click();
    }
}
