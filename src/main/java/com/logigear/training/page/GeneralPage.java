package com.logigear.training.page;

import com.logigear.training.common.Constant;
import com.logigear.training.common.DriverManager;
import com.logigear.training.common.ElementHelper;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class GeneralPage {
    private String menuItemLink = "//ul[@class='head-menu']//a[text()='%s']";
    private ElementHelper lnkAccount = new ElementHelper(By.xpath(String.format(menuItemLink, Constant.USERNAME)));
    private ElementHelper lnkLogout = new ElementHelper(By.xpath(String.format(menuItemLink, "Logout")));

    public void navigateTo(String url) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getDriver().get(Constant.URL);
    }

    public void logOut() {
        lnkAccount.click();
        lnkLogout.click();
    }

    public String getScreenTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
