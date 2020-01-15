package com.logigear.training.page;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.logigear.training.common.ElementHelper;

public class BookTicketPage extends BasePage {
	ElementHelper frmBookTicket = new ElementHelper(By.xpath("//form[./fieldset/legend = 'Book ticket form']"));

	ElementHelper sltDepartDate = new ElementHelper(By.xpath("//select[@name = 'Date']"));

	ElementHelper sltDepartFrom = new ElementHelper(By.xpath("//select[@name = 'DepartStation']"));

	ElementHelper sltArriveAt = new ElementHelper(By.xpath("//select[@name = 'ArriveStation']"));

	ElementHelper sltSeatType = new ElementHelper(By.xpath("//select[@name = 'SeatType']"));

	ElementHelper sltTicketAmount = new ElementHelper(By.xpath("//select[@name = 'TicketAmount']"));

	ElementHelper btnBookTicket = new ElementHelper(By.xpath("//input[@value='Book ticket']"));

	ElementHelper txtBookTicketSuccessMessage = new ElementHelper(By.cssSelector("#content h1"));

	public BookTicketPage() {
		super(By.xpath("//span[.='Book ticket']"));
	}

	By getMenuLocator() {
		return menuLocator;
	}

	public boolean doesBookTicketFormExist() {
		try {
			return frmBookTicket.getRuntimeElement().isDisplayed();
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

	public String getBookTicketSuccessMessageText() {
		return txtBookTicketSuccessMessage.getText();
	}

	public void selectDepartDate(int value) {
		String pattern = "M/d/yyyy";
		String date = DateTimeFormatter.ofPattern(pattern).format(LocalDate.now().plusDays(value));
		sltDepartDate.selectByVisibleText(date);
	}

	public void selectDepartFrom(String value) {
		sltDepartFrom.selectByVisibleText(value);
	}

	public void selectArriveAt(String value) {
		sltArriveAt.selectByVisibleText(value);
	}

	public void selectSeatType(String value) {
		sltSeatType.selectByVisibleText(value);
	}

	public void selectTicketAmount(int value) {
		sltTicketAmount.selectByVisibleText(Integer.toString(value));
	}

	public void bookTicket() {
		btnBookTicket.click();
	}
}
