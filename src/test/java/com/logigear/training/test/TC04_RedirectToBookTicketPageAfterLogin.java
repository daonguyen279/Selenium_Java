package com.logigear.training.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.logigear.training.common.Constant;
import com.logigear.training.page.BookTicketPage;
import com.logigear.training.page.LoginPage;

public class TC04_RedirectToBookTicketPageAfterLogin extends BaseTest {
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	
	@Test
	public void TC04() {
		bookTicketPage.open();
		loginPage.loginWith(Constant.VALID_EMAIL, Constant.VALID_PASSWORD);
		Assert.assertTrue(bookTicketPage.doesBookTicketFormExist());
	}

}
