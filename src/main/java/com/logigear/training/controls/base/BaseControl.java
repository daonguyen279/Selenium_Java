package com.logigear.training.controls.base;

import com.logigear.training.drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseControl {
    WebElement runtimeElement;
    public String locator;


    public WebElement getRuntimeElement() {
        if (runtimeElement == null) {
            this.runtimeElement = DriverManager.getDriver().findElement(getByLocator());
        }
        return this.runtimeElement;
    }
    private By getByLocator() {
        String body = this.locator.replaceAll("[\\w\\s]*=(.*)", "$1").trim();
        String type = this.locator.replaceAll("([\\w\\s]*)=.*", "$1").trim();
        switch (type.toLowerCase()) {
            case "css":
                return By.cssSelector(body);
            case "id":
                return By.id(body);
            case "class":
                return By.className(body);
            case "link":
                return By.linkText(body);
            case "xpath":
                return By.xpath(body);
            case "text":
                return By.xpath(String.format("//*[contains(text(), '%s')]", body));
            case "name":
                return By.name(body);
            default:
                return By.xpath(locator);
        }
    }
    public String getText() {
        return this.getRuntimeElement().getText();
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
