package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageBMI extends BasePage {

    public HomePageBMI(WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://healthunify.com/bmicalculator/";

    By weightField = By.name("wg");
    By heightField = By.name("ht");
    By weightDropDown = By.name("opt1");
    By heightDropDownFirstValue = By.name("opt2");
    By heightDropDownSecondValue = By.name("opt3");
    By calculateBtn = By.name("cc");
    By categoryResult = By.name("desc");

    public HomePageBMI openHomePage() {
        driver.get(baseURL);
        return this;
    }

    public HomePageBMI setUserWeight(String userWeight) {
        writeText(weightField, userWeight);
        return this;
    }

    public HomePageBMI setUserHeight(String userHeight) {
        writeText(heightField, userHeight);
        return this;
    }

    public HomePageBMI setDropdownHeight(String firstValue, String secondValue) {
        selectFromDropDown(heightDropDownFirstValue, firstValue);
        selectFromDropDown(heightDropDownSecondValue, secondValue);
        return this;
    }

    public HomePageBMI verifyCategoryResult(String expectedResult) {
        assertEquals(categoryResult, expectedResult);
        return this;
    }

    public HomePageBMI clickCalculate() {
        click(calculateBtn);
        return this;
    }

    public HomePageBMI setWeightOption(String weightOption) {
        selectFromDropDown(weightDropDown, weightOption);
        return this;
    }

    public HomePageBMI verifyCategoryRangeKilos(String userWeight, String userHeight, String expectedCategory) {
        setUserWeight(userWeight);
        setUserHeight(userHeight);
        clickCalculate();
        verifyCategoryResult(expectedCategory);
        return this;
    }

    public HomePageBMI verifyCategoryRangePounds() {

        return this;
    }

}
