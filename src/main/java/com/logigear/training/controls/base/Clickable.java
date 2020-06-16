package com.logigear.training.controls.base;

import com.logigear.training.drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Clickable extends BaseControl{

    public void click() {
        scrollIntoView();
        this.getRuntimeElement().click();
    }

    public void selectByVisibleText(String value) {
        scrollIntoView();
        Select select = new Select(getRuntimeElement());
        select.selectByVisibleText(value);
    }

}
