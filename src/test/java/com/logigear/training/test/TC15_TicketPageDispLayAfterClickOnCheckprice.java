package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.page.LoginPage;
import com.logigear.training.page.Mailinator;
import com.logigear.training.page.RegisterPage;
import com.logigear.training.page.TicketPricePage;
import com.logigear.training.page.TimetablePage;

public class TC15_TicketPageDispLayAfterClickOnCheckprice extends BaseTest {
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	Mailinator mailinator = new Mailinator();

	
	@Test
	public void TC15() {
		TimetablePage timetablePage = new TimetablePage();
		timetablePage.open();
		timetablePage.checkPriceFor("Đà Nẵng", "Sài Gòn");
		
		TicketPricePage ticketPricePage = new TicketPricePage();
		Assert.assertEquals(ticketPricePage.getHsTicketPrice(), "310000");
		Assert.assertEquals(ticketPricePage.getSsTicketPrice(), "335000");
		Assert.assertEquals(ticketPricePage.getSscTicketPrice(), "360000");
		Assert.assertEquals(ticketPricePage.getHbTicketPrice(), "410000");
		Assert.assertEquals(ticketPricePage.getSbTicketPrice(), "460000");
		Assert.assertEquals(ticketPricePage.getSbcTicketPrice(), "510000");
	}

}
