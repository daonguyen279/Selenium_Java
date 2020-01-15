package com.logigear.training.page;

import org.openqa.selenium.By;

import com.logigear.training.common.ElementHelper;

public class TimetablePage extends BasePage {
	public TimetablePage() {
		super(By.xpath("//span[.='Timetable']"));
	}

	public void checkPriceFor(String departStation, String arriveStation) {
		ElementHelper lnkCheckPrice = new ElementHelper(By.xpath("//table[@class='MyTable WideTable']/tbody/tr[td[2][.='"
				+ departStation + "'] and td[3][.='" + arriveStation + "']]/td[6]/a"));
		lnkCheckPrice.click();
	}
}
