package com.logigear.training.pages;

import com.logigear.training.controls.common.LGButton;
import com.logigear.training.controls.common.LGLink;
import com.logigear.training.controls.common.LGSelectBox;
import com.logigear.training.controls.common.LGTextBox;
import com.logigear.training.forms.NewPageForm;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DashBoardPage {
    LGLink divMenu = new LGLink("css=ul.head-menu");

    LGLink lnkMyAccount = new LGLink("css=ul.head-menu > li:nth-of-type(5) [href='#']");

    LGLink lnkLogout = new LGLink("css=[href='logout.do']");

    LGLink txtLoginUsername = new LGLink("css=a[href='#Welcome']");

    LGLink lnkGlobal = new LGLink("xpath=//li[@class='mn-setting']/a[@href='javascript:void(0);']");

    LGLink lnkAddPage = new LGLink("xpath=//a[.='Add Page']");

    LGTextBox txtPageName = new LGTextBox("id=name");

    LGSelectBox sltParentPage = new LGSelectBox("id=parent");

    LGSelectBox sltColumnNumber = new LGSelectBox("id=columnnumber");

    LGSelectBox sltPossition = new LGSelectBox("id=afterpage");

    LGButton btnOK = new LGButton("id=OK");

    LGLink lnkPageName = new LGLink("xpath=//a[@href='/TADashboard/c3nrdyly98ad.page']");

    @Step("click my account")
    public void clickMyAccount() {
        txtLoginUsername.click();
        lnkMyAccount.click();
    }

    @Step("click add page")
    public void clickAddPage() {
        lnkGlobal.click();
        lnkAddPage.click();
    }

    @Step("enter page name '{pageName}'")
    public void enterPageName(String pageName) {
        txtPageName.type(pageName);
    }

    @Step("select parent page '{pageName}'")
    public void selectParentPage(String pageName) {
        txtPageName.type(pageName);
    }

    @Step("input page information")
    public void inputPageInformation(NewPageForm newPage) {
        if (newPage.pageName != null) txtPageName.type(newPage.pageName);
        if (newPage.parentPage != null) sltParentPage.selectByVisibleText(newPage.parentPage);
        if (newPage.columnNumber != null) sltColumnNumber.selectByVisibleText(newPage.columnNumber);
        if (newPage.position != null) sltPossition.selectByVisibleText(newPage.position);
    }

    @Step("submit page information")
    public void submitPageInformation() {
        btnOK.click();
    }

    @Attachment(value = "login success text")
    public String getLoginSuccessText() {
        return txtLoginUsername.getText();
    }

    @Step("logout")
    public void logout() {
        try {
            txtLoginUsername.click();
            lnkLogout.click();
        } catch (NoSuchElementException ex) {

        }
    }

    public Integer getPagePosition(String pageName) {
        List<WebElement> children = divMenu.getRuntimeElement().findElements(By.tagName("li"));
        LGLink lnkPage = new LGLink("xpath=//a[.='" + pageName + "']");
        return children.indexOf(lnkPage);
    }
}