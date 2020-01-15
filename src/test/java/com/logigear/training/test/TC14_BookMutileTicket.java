package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.Constant;
import com.logigear.training.page.BookTicketPage;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.Mailinator;
import com.logigear.training.page.RegisterPage;

public class TC14_BookMutileTicket extends BaseTest {
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	Mailinator mailinator = new Mailinator();

	

	@Test
	public void TC14() {
		registerPage.registerAndLoginWithRandomValue();

		BookTicketPage bookTicketPage = new BookTicketPage();
		bookTicketPage.open();
		bookTicketPage.selectDepartDate(Constant.DEPART_DATE);
		bookTicketPage.selectDepartFrom(Constant.DEPART_FROM);
		bookTicketPage.selectArriveAt(Constant.ARRIVE_AT);
		bookTicketPage.selectSeatType(Constant.SEAT_TYPE);
		bookTicketPage.selectTicketAmount(Constant.TICKET_AMOUNT);
		bookTicketPage.bookTicket();
		Assert.assertEquals(bookTicketPage.getBookTicketSuccessMessageText(), Constant.BOOK_TICKET_SUCCESS_MESSAGE);
	}

}
