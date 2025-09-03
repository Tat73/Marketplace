package org.example.tests;

import org.example.driver.BaseTest;
import org.example.service.ProductPageService;
import org.example.service.ResultPageService;
import org.example.service.StartedPageService;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class CheckFilterWorkTest extends BaseTest {

    private final StartedPageService startedPageService = new StartedPageService();
    private ResultPageService resultPageService;

    @BeforeMethod(alwaysRun = true)
    public void searchElement() {
        startedPageService.goToMainPage();
        resultPageService = startedPageService.fillSearchField("iPhone");
        resultPageService.clickOnSearchButton();
    }

    @Test(description = "Check that the result list is not empty")
    public void checkSearch() {
        assertThat("List of items is empty", !resultPageService.isListEmpty());
    }

    @Test(description = "Empty cart verification")
    public void cartIsEmpty() {
        ProductPageService productPageService = resultPageService.clickOnFirstElementInListOfItems();
        int quantity = productPageService.getQuantityOfItemsInTheCart();
        assertThat("Cart is not empty by default", quantity, Matchers.equalTo(0));
        assertThat("'Add to cart button is not displayed'", productPageService.isAddToCartButtonDisplayed());
    }

    @Test(description = "Filter list of items")
    public void isPriceSortedFromMaxToMinTest() {
        resultPageService.clickOnPriceSortingFilter();
        resultPageService.clickOnDropdownWithFilter("Price: High to Low");
        List<Integer> actualResultProductList = resultPageService.listOfProductPrice();
        List<Integer> newList = new ArrayList<>(actualResultProductList);
        List<Integer> sortedNaturalOrderList = newList.stream().sorted(Integer::compareTo).toList();
        List<Integer> expectedResultProductList = sortedNaturalOrderList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        assertThat("Price is sorted wrong", actualResultProductList, Matchers.equalTo(expectedResultProductList));
    }

    @Test(description = "Check 'See more' button displayed after using filter", dataProvider = "modelYears")
    public void isSeeMoreButtonDisplayedAfterUsingFilterTest(String year) {
        resultPageService.clickOnFilterInput(year);
        resultPageService.clickOnRandomColor();
        assertThat("'See more' button is displayed ", !resultPageService.isButtonDisplayedInTheYearFilter("See more"));
    }

    @DataProvider(name = "modelYears")
    public static Object[][] createData() {
        return new Object[][]{
                {"2024"},
                {"2018"}
        };
    }
}
