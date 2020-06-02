package com.logigear.training.test;

import com.logigear.training.common.Constant;
import com.logigear.training.page.BasePage;
import com.logigear.training.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DA_LOGIN_TC005_VerifyThereIsnoLoginDialogWhenSwitchingBetween2RepositorieswithTheSameAccount extends BaseTest{

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    @Test
    public void DA_LOGIN_TC005(){
        loginPage.loginWith(Constant.VALID_USERNAME, Constant.UPPERCASEPASSWORD);
        basePage.selectRepository();
        Assert.assertEquals( Constant.VALID_USERNAME, basePage.getLoginSuccessText());
        Assert.assertEquals( Constant.REPONSITORYNAME, basePage.checkReponsitory());
    }

}
