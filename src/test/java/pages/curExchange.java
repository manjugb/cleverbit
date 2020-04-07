package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;


public class curExchange extends BasePage {

	public pages.DriverHandler dh = new pages.DriverHandler();

	public WebDriver driver;
	public static final String ANSI_RED_TEXT = "\033[31m";
	public static final String ANSI_GREEN_TEXT = "\033[32;1;2m";

	public curExchange(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	// Amount
	@FindBy(how = How.XPATH, using = "//input[@id='amount']")
	WebElement elmAmount;

	String elmSeldescur;
	// sel source currency
	@FindBy(how = How.XPATH, using = "//input[@name='From']")
	WebElement elmSelsourcecur;

	// sel dest currency
	@FindBy(how = How.XPATH, using = "//input[@name='To']")
	WebElement elmDestCur;
	// click calc
	@FindBy(how = How.XPATH, using = "//button[@class='OldButton-jvvAjr SubmitButton-fCPQGw ilGkLV submitButton']")
	WebElement elmCLickCalc;

	// swaping option
	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContainer']/div[@class='GradientStyled-cppXvn dGZPbD gradient']/div[@class='CenterpieceContainer-dSIInE jBdjhw']/main[@class='Main-qeYMh hqxsYs']/div[@class='sc-AxheI fniENO']/div[@class='ConverterContainer-cnPALV CustomConverterContainer-dQlrWq jvifoo']/div/div[@id='currencyConverter']/div[@class='RowContainer-jiJByP eOAMnW']/div[@id='converterForm']/form[@class='Form-qfhCc sc-AxmLO gCBjtB']/button[@class='OldButton-jvvAjr InverseButton-bUiBpw gyMxCe converterform-inverseButton inverseButton']/*[1]")
	WebElement swapOption;
	// h1 heading Results
	@FindBy(how = How.XPATH, using = "//h1[@id='main-heading']")
	WebElement elmResults;

	// Single Currency destination value
	@FindBy(how = How.CSS, using = "div.GradientStyled-cppXvn.dGZPbD.gradient:nth-child(2) div.CenterpieceContainer-dSIInE.jBdjhw main.Main-qeYMh.hqxsYs:nth-child(3) div.sc-AxheI.fniENO div.ConverterContainer-cnPALV.CustomConverterContainer-dQlrWq.jvifoo div.Wrapper-jDUUyL.jwmWMe div.RowContainer-jiJByP.kvCuPY:nth-child(2) div.converterresult-wrapper.converterResult section.OldRow-gYxWJD.ConverterResultInfo-bjqRmZ.jXnjSC div.OldColumn-eIZHbH.RateInfoColumn-bKHmkg.bzuvlO.second:nth-child(1) > div.sc-fzoLsD.fYZyZu:nth-child(1)")
	WebElement elmDestValue;

	// Single Currency Source value
	@FindBy(how = How.CSS, using = "div.GradientStyled-cppXvn.dGZPbD.gradient:nth-child(2) div.CenterpieceContainer-dSIInE.jBdjhw main.Main-qeYMh.hqxsYs:nth-child(3) div.sc-AxheI.fniENO div.ConverterContainer-cnPALV.CustomConverterContainer-dQlrWq.jvifoo div.Wrapper-jDUUyL.jwmWMe div.RowContainer-jiJByP.kvCuPY:nth-child(2) div.converterresult-wrapper.converterResult section.OldRow-gYxWJD.ConverterResultInfo-bjqRmZ.jXnjSC div.OldColumn-eIZHbH.RateInfoColumn-bKHmkg.bzuvlO.second:nth-child(1) > div.sc-fzoLsD.fYZyZu:nth-child(2)")
	WebElement elmSourceValue;

	// Value converstionTitle

	@FindBy(how = How.XPATH, using = "//span[@class='converterresult-resultTitle']")
	WebElement convTitle;

	// h1 mainheading
	@FindBy(how = How.XPATH, using = "//h1[@id='main-heading']")
	WebElement elmhead;

	// amout convertion rate
	@FindBy(how = How.XPATH, using = "//div[@class='converterresult-flexCon']")
	WebElement elmAmountConvResults;

//Verifying the title of page

	/*public void verify_Title_page(String exptitle) throws Throwable{
		
		 String actualTitle = driver.getTitle();
         Assert.assertEquals(actualTitle, exptitle);
		if(actTitle.equalsIgnoreCase(exptitle)) {
		
		Assert.assertEquals("Condition true", actTitle, exptitle);
		}
		else {
			Assert.assertNotEquals(exptitle,exptitle);
		}
		
}*/

	// Enter Amount
	public void enter_key(String keyword) throws Throwable {
		if (elmAmount.isDisplayed()) {
			elmAmount.clear();
			elmAmount.sendKeys(keyword);
		} else {
			System.out.println("Element " + elmSelsourcecur + " Not Found");
		}
	}

	// Enter or choose source currency
	public void enter_key_source(String keyword) throws Throwable {
		if (elmSelsourcecur.isDisplayed()) {
			elmSelsourcecur.sendKeys(keyword);
		} else {
			System.out.println("Element " + elmSelsourcecur + " Not Found");
		}

	}

	// Press Enter
	public void press_enter_source() throws Throwable {
		if (elmSelsourcecur.isDisplayed()) {
			elmSelsourcecur.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Element " + elmSelsourcecur + " Not Found");
		}

	}

	// Enter or choose dest currency
	public void enter_key_dest(String keyword) throws Throwable {
		if (elmDestCur.isDisplayed()) {
			elmDestCur.sendKeys(keyword);
		} else {
			System.out.println("Element " + elmDestCur + " Not Found");
		}

	}

	// Press Enter
	public void press_enter_dest() throws Throwable {
		if (elmDestCur.isDisplayed()) {
			elmDestCur.sendKeys(Keys.ENTER);
		} else {
			System.out.println("Element " + elmDestCur + " Not Found");
		}

	}

	// Click on calc button
	public void clk_calcbut() throws Throwable {
		if (elmCLickCalc.isDisplayed()) {
			elmCLickCalc.click();
		} else {
			System.out.println("Element " + elmCLickCalc + " Not Found");
		}

	}

	// Swap Option to click
	public void clk_swap() throws Throwable {
		if (swapOption.isDisplayed()) {
			swapOption.click();
		} else {
			System.out.println("Element " + swapOption + " Not Found");
		}
	}

	// Verify h1 heading Resultslt

	public void single_results(String expSingleResults) throws Throwable {
		String actSingRes = elmResults.getText().toString();
		if (elmResults.isEnabled() && actSingRes.equalsIgnoreCase(expSingleResults)) {
			Assert.assertEquals(expSingleResults, actSingRes);
		} else {
			Assert.assertNotEquals(expSingleResults, actSingRes);
		}

	}

//Verify Single Currency destination value
	public void single_cur_dest_value(String expDestvalue) throws Throwable {
		String actDesVal = elmDestValue.getText().toString();
		if (elmResults.isDisplayed()) {
			Assert.assertEquals(expDestvalue, actDesVal);
		} else {
			Assert.assertNotEquals(expDestvalue, actDesVal);
		}

	}

	// Verify Single Currency destination value
	public void single_cur_source_value(String expSourcevalue) throws Throwable {
		String actDesVal = elmSourceValue.getText().toString();
		if (elmResults.isDisplayed()) {
			Assert.assertEquals(elmSourceValue, actDesVal);
		} else {
			Assert.assertNotEquals(elmSourceValue, actDesVal);
		}

	}

	// Verify Value converstionTitle

	public void verify_convTitle(String expConvTitel) throws Throwable {
		String actConvTitle = convTitle.getText().toString();
		if (convTitle.isDisplayed()) {
			Assert.assertEquals(expConvTitel, actConvTitle);
		} else {
			Assert.assertNotEquals(expConvTitel, actConvTitle);
		}
	}

	// h1 main heading title
	public void verify_h1_main_heading_title(String h1mainhtitle) throws Throwable {
		String acth1mainhead = elmhead.getText().toString();
		if (elmhead.isEnabled()) {
			Assert.assertEquals(h1mainhtitle, acth1mainhead);
		} else {
			Assert.assertNotEquals(h1mainhtitle, acth1mainhead);
		}

	}

	// Verify Amount Conversion amount
	public void verify_amount_convValue(String expConValue) throws Throwable {
		String actConvAmount = elmAmountConvResults.getText().toString();
		if (elmAmountConvResults.isEnabled()) {
			Assert.assertEquals(expConValue, actConvAmount);
		} else {
			Assert.assertNotEquals(expConValue, actConvAmount);
		}
	}

	private curExchange ensurePageLoaded() {
		waitForPageToLoad();
		try {
			getElementByCSS(elmSeldescur);
		} catch (TimeoutException e) {
			System.out.println("Timeout exceeded while waiting for " + this.getClass().getSimpleName() + " to load!");
		}
		return this;
	}

	@Override
	public boolean pageHasText(String text) {
		return isElementPresent(By.xpath("//*[contains(text(), '" + text + "')]"));
	}

//boolean isElementPresent(By by) {
//	try{
//		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//	} catch(TimeoutException e) {
//		return false;
//	}
//	return true;
//}

	public void verifyKeyword(String strExpKeyword) throws Throwable {
		if (pageHasText(strExpKeyword)) {
			Assert.assertTrue(pageHasText(strExpKeyword));
			System.out.println(ANSI_GREEN_TEXT + "" + strExpKeyword + "" + "Found");
			// test.log(Status.PASS, "Search Key Found");
		} else {
			Assert.assertFalse(pageHasText(strExpKeyword));
			System.out.println(ANSI_GREEN_TEXT + "" + strExpKeyword + "" + "Not Found");
			// test.log(Status.FAIL, "Search Key NOT Found");

		}
	}

	@Override
	public boolean isPageLoaded() {
		return ensurePageLoaded().isElementPresent(By.cssSelector(elmSeldescur));
	}
}
