package kotak;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import helpers.BaseTest;
import pages.DebitCardPage;
import pages.ExploreProductsPage;

public class CompareDebitCards extends BaseTest {

	@Test
	public void verifyComparisionOfPrivyLeagueSignatureAndAccessIndiaDebitCard() {
		try {

			ExploreProductsPage exploreProducts = new ExploreProductsPage(getDriver());

			exploreProducts.openExploreProductTab();

			exploreProducts.openCardsTab();

			exploreProducts.openCreditCardsPage();

			DebitCardPage debitCardPage = new DebitCardPage(getDriver());
			debitCardPage.comparePrivyLeagueSignatureAndAccessIndiaDebitCard();

			debitCardPage.switchToNewTab();

			String actualMessage = debitCardPage.gettingCompareMessageHeader().trim();

			Assert.assertEquals(actualMessage,
					"Comparing Privy League Signature Debit Card and Access India Debit Card",
					"Verify header's message of both the cards");

			Assert.assertEquals(true, debitCardPage.isPrivyLeagueSignatureDebitCardOnComparePageVisible(),
					"Verify Privy League Signature Debit Card is visible on compare page");

			Assert.assertEquals(true, debitCardPage.isAccessIndiaDebitCardOnComparePageVisible(),
					"Verify Access India Debit Card is visible on compare page");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass(alwaysRun = true)
	void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}

}
