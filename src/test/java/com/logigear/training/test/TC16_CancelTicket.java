package com.logigear.training.test;
import org.testng.annotations.Test;
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
		bookTicketPage.selectDepartDate(10);
		bookTicketPage.selectDepartFrom("Nha Trang");
		bookTicketPage.selectArriveAt("Sài Gòn");
		bookTicketPage.selectSeatType("Soft seat with air conditioner");
		bookTicketPage.selectTicketAmount(5);
		bookTicketPage.bookTicket();

		MyTicketPage myTicketPage = new MyTicketPage();
		myTicketPage.open();
		myTicketPage.cancelTicket(1);
	}
}
