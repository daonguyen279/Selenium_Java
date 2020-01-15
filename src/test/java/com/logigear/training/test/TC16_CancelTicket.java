package com.logigear.training.test;
import org.testng.annotations.Test;

import com.logigear.training.common.Constant;
import com.logigear.training.page.BookTicketPage;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.Mailinator;
import com.logigear.training.page.MyTicketPage;
import com.logigear.training.page.RegisterPage;

public class TC16_CancelTicket extends BaseTest {
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	Mailinator mailinator = new Mailinator();

	@Test
	public void TC16() {
		registerPage.registerAndLoginWithRandomValue();
		BookTicketPage bookTicketPage = new BookTicketPage();
		bookTicketPage.open();
		bookTicketPage.selectDepartDate(Constant.DEPART_DATE);
		bookTicketPage.selectDepartFrom(Constant.DEPART_FROM);
		bookTicketPage.selectArriveAt(Constant.ARRIVE_AT);
		bookTicketPage.selectSeatType(Constant.SEAT_TYPE);
		bookTicketPage.selectTicketAmount(Constant.TICKET_AMOUNT);
		bookTicketPage.bookTicket();

		MyTicketPage myTicketPage = new MyTicketPage();
		myTicketPage.open();
		myTicketPage.cancelTicket(1);
	}
}
