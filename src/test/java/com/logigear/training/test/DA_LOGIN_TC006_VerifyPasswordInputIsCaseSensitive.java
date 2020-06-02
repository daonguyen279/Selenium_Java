package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.Constant;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.BasePage;


public class DA_LOGIN_TC006_VerifyPasswordInputIsCaseSensitive extends BaseTest {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    @Test
    public void DA_LOGIN_TC006() {
        loginPage.loginWith(Constant.VALID_USERNAME, Constant.UPPERCASEPASSWORD);
        Assert.assertEquals( Constant.VALID_USERNAME, basePage.getLoginSuccessText());
        basePage.logout();
        LoginPage loginPage = new LoginPage();
        loginPage.loginWith(Constant.VALID_USERNAME, Constant.LOWERPASSWORD);

        }

}
