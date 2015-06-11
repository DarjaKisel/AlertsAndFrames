package pages;

import halpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FactoryFramesPage {
    @FindBy(name = "frame-top")
    private WebElement topFrame;

    @FindBy(css = "frame")
    public List<WebElement> listOfFrames;

    @FindBy(name = "frame-left")
    private WebElement leftFrame;

    @FindBy(name = "frame-middle")
    private WebElement middleFrame;

    @FindBy(name = "frame-right")
    private WebElement rightFrame;

    @FindBy(name = "frame-bottom")
    private WebElement bottomFrame;

    //getters
    public WebElement getTopFrame() {
        return topFrame;
    }

    public WebElement  getLeftFrame() {
        return leftFrame;
    }

    public String  getLeftFrameName() {
        return "frame-left";
    }

    public WebElement  getMiddleFrame() {
        return middleFrame;
    }

    public String getMiddleFrameName() {
        return "frame-middle";
    }

    public WebElement  getRightFrame() {
        return rightFrame;
    }

    public String getRightFrameName() {
        return "frame-right";
    }

    public WebElement getBottomFrame() {
        return bottomFrame;
    }
}
