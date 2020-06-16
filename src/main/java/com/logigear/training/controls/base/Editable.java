package com.logigear.training.controls.base;

import com.logigear.training.drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Editable extends BaseControl{


    public void clear() {
        this.getRuntimeElement().clear();
    }

    public void type(String content) {
        this.getRuntimeElement().sendKeys(content);
    }

    public void type(Keys key) {
        this.getRuntimeElement().sendKeys(key);
    }

}
