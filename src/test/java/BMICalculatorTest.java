import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BMICalculatorTest {

    @Test
    public void normalCategory() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://healthunify.com/bmicalculator/");
        webDriver.findElement(By.name("wg")).sendKeys("82");
        webDriver.findElement(By.name("ht")).sendKeys("185");

        webDriver.findElement(By.name("cc")).click();

        String category = webDriver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Normal", "Категория не совпадает ");

        webDriver.quit();
    }

    @Test
    public void overWeightCategory() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://healthunify.com/bmicalculator/");
        webDriver.findElement(By.name("wg")).sendKeys("900");
        webDriver.findElement(By.name("ht")).sendKeys("185");

        webDriver.findElement(By.name("cc")).click();

        String category = webDriver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Obese", "Категория не совпадает ");

        webDriver.quit();
    }

    @Test
    public void normalCategoryInPounds() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://healthunify.com/bmicalculator/");

        webDriver.findElement(By.name("wg")).sendKeys("50");

        Select metricSelect = new Select(webDriver.findElement(By.name("opt1")));
        metricSelect.selectByVisibleText("pounds");

        Select heightSelectFirst = new Select(webDriver.findElement(By.name("opt2")));
        heightSelectFirst.selectByVisibleText("7′");

        Select heightSelectSecond = new Select(webDriver.findElement(By.name("opt3")));
        heightSelectSecond.selectByVisibleText("4″");

        webDriver.findElement(By.name("cc")).click();

        String category = webDriver.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Normal", "Категория не совпадает ");

    }
}
