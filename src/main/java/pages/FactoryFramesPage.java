package pages;

import org.openqa.selenium.WebElement;
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

    public WebElement  getMiddleFrame() {
        return middleFrame;
    }

    public WebElement  getRightFrame() {
        return rightFrame;
    }

    public WebElement getBottomFrame() {
        return bottomFrame;
    }
}
