package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPageByStatic {
    //elements
    public static final By JS_ALERT_BUTTON = By.cssSelector("button[onclick='jsAlert()']");
    public static final By JS_CONFIRM_BUTTON = By.cssSelector("button[onclick='jsConfirm()']");
    public static final By JS_PROMPT_BUTTON = By.cssSelector("button[onclick='jsPrompt()']");
    //behavior
    public static void clickAlertButton(WebDriver driver) {
        driver.findElement(JS_ALERT_BUTTON).click();
    }
    public static void clickConfirmButton(WebDriver driver) {
        driver.findElement(JS_CONFIRM_BUTTON).click();
    }
    public static void clickPromptButton(WebDriver driver) {
        driver.findElement(JS_PROMPT_BUTTON).click();
    }
}
