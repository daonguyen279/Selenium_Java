package com.logigear.training.pages;

import com.logigear.training.controls.common.LGButton;
import com.logigear.training.controls.common.LGLink;
import com.logigear.training.controls.common.LGSelectBox;
import com.logigear.training.controls.common.LGTextBox;
import com.logigear.training.controls.common.LGCheckbox;
import com.logigear.training.drivermanager.DriverManager;
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

    LGLink lnkGlobal = new LGLink("xpath=//li[@class='mn-setting']/a");

    LGLink lnkAddPage = new LGLink("xpath=//a[.='Add Page']");

    LGLink linkAdminister = new LGLink("css=#header .head-menu a[href=\"#Administer\"]");

    LGLink linkDataProfiles = new LGLink("css=#ulAdminister a[href=\"profiles.jsp\"]");

    LGTextBox txtPageName = new LGTextBox("id=name");

    LGSelectBox sltParentPage = new LGSelectBox("id=parent");

    LGSelectBox sltColumnNumber = new LGSelectBox("id=columnnumber");

    LGSelectBox sltPossition = new LGSelectBox("id=afterpage");

    LGButton btnOK = new LGButton("id=OK");

    LGLink lnkPageName = new LGLink("xpath=//a[@href='/TADashboard/c3nrdyly98ad.page']");

    LGCheckbox chbIsPublic = new LGCheckbox ("id=ispublic");


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

    @Step("click data profiles menu")
    public void clickDataProfilesMenu() {
        linkAdminister.click();
        linkDataProfiles.click();
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

    @Step("check on is public checkbox")
    public void checkOnIsPublicCheckbox() {
        chbIsPublic.check();
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

    @Step("get page postition ")
    public Integer getPagePosition(String pageName) {
        List<WebElement> children = divMenu.getRuntimeElement().findElements(By.tagName("li"));
        LGLink lnkPage = new LGLink("xpath=//a[.='" + pageName + "']");
        return children.indexOf(lnkPage);
    }

    @Step("check that the position of '{page2}' is next to '{page1}'")
    public boolean checkPagePosition(String page1, String page2) {
        List<WebElement> links = DriverManager.getDriver().findElements(By.xpath("//div[@id=\"main-menu\"]//li/a[contains(@href, \"/TADashboard\")]"));
        boolean check = false;
        for (int i=0; i<links.size();i++) {
            if (links.get(i).getText().equalsIgnoreCase(page1)) {
                int nextPage = i+1;
                if (links.get(nextPage).getText().equalsIgnoreCase(page2)) {
                    System.out.println("Section " + i + ":" + links.get(i+1).getText());
                    check = true;
                }
            }
        } return check;
    }
}