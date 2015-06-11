import com.sun.xml.internal.ws.handler.HandlerException;
import halpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FactoryFramesPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FramesHomeWork {
    private WebDriver driver;
    private static final String BASE_URL = "http://the-internet.herokuapp.com/nested_frames";
    private static final int PAGE_FRAMES_NUMBER = 2;
    private static final int PAGE_TOP_FRAMES_NUMBER = 3;
    private static final String [] TOP_FRAMES = new String[] {"LEFT", "MIDDLE", "RIGHT"};
    private static final String BOTTOM_FRAME = "BOTTOM";
    private static final By FIND_NAME_BY = By.cssSelector("html>body");

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
    public void countFramesTest() {
        FactoryFramesPage page = PageFactory.initElements(driver, FactoryFramesPage.class);
        Assert.assertEquals(page.listOfFrames.size(), PAGE_FRAMES_NUMBER);
        Helper.switchToFrame(driver, page.getTopFrame());
        Assert.assertEquals(page.listOfFrames.size(), PAGE_TOP_FRAMES_NUMBER);
    }

    @Test
    public void checkFramesNamesTest() {
        FactoryFramesPage page = PageFactory.initElements(driver, FactoryFramesPage.class);
        Assert.assertTrue(page.getTopFrame().isDisplayed());
        Assert.assertTrue(page.getBottomFrame().isDisplayed());
        driver.switchTo().frame(page.getTopFrame());
        Assert.assertTrue(page.getLeftFrame().isDisplayed());
        Assert.assertTrue(page.getMiddleFrame().isDisplayed());
        Assert.assertTrue(page.getRightFrame().isDisplayed());
        for (int i =0; i < PAGE_TOP_FRAMES_NUMBER; i++) {
            driver.switchTo().frame(page.listOfFrames.get(i));
            Assert.assertEquals(driver.findElement(FIND_NAME_BY).getText(), TOP_FRAMES[i]);
            driver.switchTo().parentFrame();
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame(page.getBottomFrame());
        Assert.assertEquals(driver.findElement(FIND_NAME_BY).getText(), BOTTOM_FRAME);
    }
}
