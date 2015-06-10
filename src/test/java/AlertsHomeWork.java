

import halpers.Helper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AlertsPageByStatic;

import java.lang.String;import java.util.concurrent.TimeUnit;

public class AlertsHomeWork {
    private WebDriver driver;
    private static final String BASE_URL = "http://the-internet.herokuapp.com/javascript_alerts";

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void AlertContentTest() {
        AlertsPageByStatic.clickAlertButton(driver);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
    }

    @Test
    public void AlertResultTest() {
        AlertsPageByStatic.clickAlertButton(driver);
        driver.switchTo().alert().accept();
        Assert.assertFalse(Helper.isAlertPresent(driver));
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You successfuly clicked an alert");
    }

    @Test
    public void ConfirmContentTest() {
        AlertsPageByStatic.clickConfirmButton(driver);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
    }

    @Test
    public void ConfirmAcceptResultTest() {
        AlertsPageByStatic.clickConfirmButton(driver);
        driver.switchTo().alert().accept();
        Assert.assertFalse(Helper.isAlertPresent(driver));
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");
    }

    @Test
    public void ConfirmDismissResultTest() {
        AlertsPageByStatic.clickConfirmButton(driver);
        driver.switchTo().alert().dismiss();
        Assert.assertFalse(Helper.isAlertPresent(driver));
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    public void PromptContentTest() {
        AlertsPageByStatic.clickPromptButton(driver);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "I am a JS prompt");
    }

    @Test
    public void PromptABCTest() {
        AlertsPageByStatic.clickPromptButton(driver);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("AbcDE 123");
        alert.accept();
        Assert.assertFalse(Helper.isAlertPresent(driver));
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: AbcDE 123");
    }

    @Test
    public void PromptEmptyTest() {
        AlertsPageByStatic.clickPromptButton(driver);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("");
        alert.accept();
        Assert.assertFalse(Helper.isAlertPresent(driver));
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered:");
    }

    @Test
    public void PromptNullResultWithABCTest() {
        AlertsPageByStatic.clickPromptButton(driver);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("AbcDE 123");
        alert.dismiss();
        Assert.assertFalse(Helper.isAlertPresent(driver));
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: null");
    }

    @Test
    public void PromptNullResultWithEmptyTest() {
        AlertsPageByStatic.clickPromptButton(driver);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("");
        alert.dismiss();
        Assert.assertFalse(Helper.isAlertPresent(driver));
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: null");
    }
}
