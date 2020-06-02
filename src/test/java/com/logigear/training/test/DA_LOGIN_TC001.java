package com.logigear.training.test;

import com.logigear.training.common.Constant;
import com.logigear.training.common.DriverManager;
import com.logigear.training.common.Log;
import com.logigear.training.page.GeneralPage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DA_LOGIN_TC001 extends BaseTest {
    GeneralPage generalPage = new GeneralPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "Verify that user can login specific repository successfully via Dashboard login page with correct credentials")
    public void TC001() {
        Log.info("1.Navigate to Dashboard login page");
        generalPage.navigateTo(Constant.URL);

        Log.info("2.Login with valid username and password");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Log.info("3.Verify that Dashboard Mainpage appears");
        String expectedScreenTitle = "TestArchitect ™ - Execution Dashboard";
        Assert.assertEquals(expectedScreenTitle, generalPage.getScreenTitle(), "Dashboard Mainpage should be displayed");
    }

    @AfterMethod
    public void afterMethod() {
        Log.info("Logout");
        generalPage.logOut();
    }
}
