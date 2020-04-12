package tests;

import org.testng.annotations.Test;
import pages.HomePageBMI;

public class BMIGeneralTests extends BaseTest {

    @Test(priority = 0)
    public void verifyEmptyWeightPopUp() {
        HomePageBMI homePageBMI = new HomePageBMI(driver);
        homePageBMI
                .openHomePage()
                .clickCalculate()
                .verifyAlertText("Enter the value for weight");
    }

    @Test(priority = 1)
    public void verifyEmptyHeightPopUp() {
        HomePageBMI homePageBMI = new HomePageBMI(driver);
        homePageBMI
                .openHomePage()
                .setUserWeight("87")
                .clickCalculate()
                .verifyAlertText("Height should be taller than 33cms");
    }

    @Test(priority = 2)
    public void verifyMinWeighPopupKg(){
        HomePageBMI homePageBMI = new HomePageBMI(driver);
        homePageBMI
                .openHomePage()
                .setWeightOption("kilograms")
                .setUserWeight("9")
                .clickCalculate()
                .verifyAlertText("Weight should be greater than 10kgs");

    }

    @Test(priority = 3)
    public void verifyMinWeighPopupPounds(){
        HomePageBMI homePageBMI = new HomePageBMI(driver);
        homePageBMI
                .openHomePage()
                .setWeightOption("pounds")
                .setUserWeight("21")
                .clickCalculate()
                .verifyAlertText("Weight should be greater than 22lbs");
    }


}
