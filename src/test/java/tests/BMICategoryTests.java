package tests;

import org.testng.annotations.Test;
import pages.HomePageBMI;

public class BMICategoryTests extends BaseTest {

    @Test
    public void starvationCategoryTest() {
        HomePageBMI homePageBMI = new HomePageBMI(driver);
        homePageBMI
                .openHomePage()
                .verifyCategoryRangeKilos("47", "190", "Your category is Starvation")
                .verifyCategoryRangeKilos("48.6", "180", "Your category is Starvation");
    }

    @Test
    public void underweightCategoryTest() {
        HomePageBMI homePageBMI = new HomePageBMI(driver);
        homePageBMI
                .openHomePage()
                .verifyCategoryRangeKilos("48.6", "175", "Your category is Underweight")
                .verifyCategoryRangeKilos("49", "175", "Your category is Underweight")
                .verifyCategoryRangeKilos("49", "165", "Your category is Underweight")
                .verifyCategoryRangeKilos("50.36", "165", "Your category is Underweight");
    }

    @Test
    public void normalCategoryTest() {
        HomePageBMI homePageBMI = new HomePageBMI(driver);
        homePageBMI
                .openHomePage()
                .verifyCategoryRangeKilos("68", "167", "Your category is Normal")
                .verifyCategoryRangeKilos("72.24", "170", "Your category is Normal");
    }

    @Test
    public void overweightCategoryTest() {
        HomePageBMI homePageBMI = new HomePageBMI(driver);
        homePageBMI
                .openHomePage()
                .verifyCategoryRangeKilos("73", "170", "Your category is Overweight")
                .verifyCategoryRangeKilos("52.27", "132", "Your category is Overweight");
    }

    @Test
    public void obeseCategoryTest() {
        HomePageBMI homePageBMI = new HomePageBMI(driver);
        homePageBMI
                .openHomePage()
                .verifyCategoryRangeKilos("120", "187", "Your category is Obese")
                .verifyCategoryRangeKilos("122.4", "187", "Your category is Obese")
                .verifyCategoryRangeKilos("180", "215", "Your category is Obese")
                .verifyCategoryRangeKilos("300", "189", "Your category is Obese");
    }
}
