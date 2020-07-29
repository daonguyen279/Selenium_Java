package com.logigear.training.pages;

import com.logigear.training.drivermanager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DataProfilesPage {
    public List<String> profilesList() {
        List<WebElement> elements = DriverManager.getDriver().findElements(By.cssSelector("#ccontent table.GridView tbody tr td:nth-child(2)"));
        List<String> profiles = new ArrayList<String>();
        elements.forEach((e) -> profiles.add(e.getText().trim()));
        return profiles;
    }

    public List<WebElement> editButtonsList() {
        List<WebElement> elements = DriverManager.getDriver().findElements(By.cssSelector("#ccontent table.GridView tbody tr td a"));
        List<WebElement> editButtons = new ArrayList<WebElement>();
        elements.forEach((e) -> {
            if (e.getText().equals("Edit")) {
                editButtons.add(e);
            }
        });
        return editButtons;
    }

    public List<WebElement> deleteButtonsList() {
        List<WebElement> elements = DriverManager.getDriver().findElements(By.cssSelector("#ccontent table.GridView tbody tr td a"));
        List<WebElement> deleteButtons = new ArrayList<WebElement>();
        elements.forEach((e) -> {
            if (e.getText().equals("Delete")) {
                deleteButtons.add(e);
            }
        });
        return deleteButtons;
    }
}
