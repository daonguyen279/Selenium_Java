package com.logigear.training.utilities;

import com.logigear.training.drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {
    WebElement runtimeElement;
    By locator;

    public ElementHelper(java.lang.String locator) {
        super();
        this.locator = locator;
    }

    public WebElement getRuntimeElement() {
        if (runtimeElement == null) {
            this.runtimeElement = DriverManager.getDriver().findElement(this.locator);
        }
        return this.runtimeElement;
    }

    public void clear() {
        this.getRuntimeElement().clear();
    }

    public void type(String content) {
        this.getRuntimeElement().sendKeys(content);
    }

    public void type(Keys key) {
        this.getRuntimeElement().sendKeys(key);
    }

    public String getText() {
        return this.getRuntimeElement().getText();
    }

    public void click() {
        scrollIntoView();
        this.getRuntimeElement().click();
    }

    public void selectByVisibleText(String value) {
        scrollIntoView();
        Select select = new Select(getRuntimeElement());
        select.selectByVisibleText(value);
    }

    public String getAttribute(String attribute) {
        return getRuntimeElement().getAttribute("href");
    }

    public void scrollIntoView() {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                getRuntimeElement());
    }

    public void waitForVisibility() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.visibilityOf(getRuntimeElement()));
    }

    public void waitForFrameToBeAvailableAndSwitchToIt() {
        new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getRuntimeElement()));
    }
}
