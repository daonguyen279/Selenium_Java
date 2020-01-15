package com.logigear.training.page;

import org.openqa.selenium.By;

import com.logigear.training.common.ElementHelper;

public class TicketPricePage extends BasePage {
	public TicketPricePage() {
		super(By.xpath("//span[.='Ticket price']"));
	}
	
	ElementHelper txtHsTicketPrice = new ElementHelper(By.xpath("//table[@class='MyTable MedTable']/tbody/tr[3]/td[1]"));
	ElementHelper txtSsTicketPrice = new ElementHelper(By.xpath("//table[@class='MyTable MedTable']/tbody/tr[3]/td[2]"));
	ElementHelper txtSscTicketPrice = new ElementHelper(By.xpath("//table[@class='MyTable MedTable']/tbody/tr[3]/td[3]"));
	ElementHelper txtHbTicketPrice = new ElementHelper(By.xpath("//table[@class='MyTable MedTable']/tbody/tr[3]/td[4]"));
	ElementHelper txtSbTicketPrice = new ElementHelper(By.xpath("//table[@class='MyTable MedTable']/tbody/tr[3]/td[5]"));
	ElementHelper txtSbcTicketPrice = new ElementHelper(By.xpath("//table[@class='MyTable MedTable']/tbody/tr[3]/td[6]"));
	
	public String getHsTicketPrice() {
		return txtHsTicketPrice.getText();
	}
	public String getSsTicketPrice() {
		return txtSsTicketPrice.getText();
	}
	public String getSscTicketPrice() {
		return txtSscTicketPrice.getText();
	}
	public String getHbTicketPrice() {
		return txtHbTicketPrice.getText();
	}
	public String getSbTicketPrice() {
		return txtSbTicketPrice.getText();
	}
	public String getSbcTicketPrice() {
		return txtSbcTicketPrice.getText();
	}
}
