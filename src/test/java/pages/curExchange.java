package pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	// svg source currency
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[2]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]")
	public WebElement elmSelsourcecur;

	// TypeText source
	@FindBy(how = How.XPATH, using = "//div[@class=CurrencyInputWrapper-Djuqw fmFlNB]")
	public WebElement elmsourtext;

	// sel dest currency
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/div[2]/div[2]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[2]/div[1]")
	public WebElement elmDestCur;
	// click calc
	@FindBy(how = How.XPATH, using = "//button[@class='OldButton-jvvAjr SubmitButton-fCPQGw ilGkLV submitButton']")
	WebElement elmCLickCalc;

	// swaping option
	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContainer']/div[@class='GradientStyled-cppXvn dGZPbD gradient']/div[@class='CenterpieceContainer-dSIInE jBdjhw']/main[@class='Main-qeYMh hqxsYs']/div[@class='sc-AxheI fniENO']/div[@class='ConverterContainer-cnPALV CustomConverterContainer-dQlrWq jvifoo']/div/div[@id='currencyConverter']/div[@class='RowContainer-jiJByP eOAMnW']/div[@id='converterForm']/form[@class='Form-qfhCc sc-AxmLO gCBjtB']/button[@class='OldButton-jvvAjr InverseButton-bUiBpw gyMxCe converterform-inverseButton inverseButton']/*[1]")
	WebElement swapOption;
	// h1 heading Results
	@FindBy(how = How.XPATH, using = "//*[@id=\"converterResult\"]/div/div")
	WebElement elmResults;

	// conversion rate
	@FindBy(how = How.XPATH, using = "//span[@class='converterresult-toAmount']")
	WebElement elmconvRate;

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

	@FindBy(how = How.CSS, using = "div.GradientStyled-cppXvn.dGZPbD.gradient:nth-child(2) div.CenterpieceContainer-dSIInE.jBdjhw main.Main-qeYMh.hqxsYs:nth-child(3) div.sc-AxheI.fniENO div.ConverterContainer-cnPALV.CustomConverterContainer-dQlrWq.jvifoo div.Wrapper-jDUUyL.jwmWMe div.RowContainer-jiJByP.eOAMnW div.converterform-wrapper.converterForm form.Form-qfhCc.sc-AxmLO.gCBjtB div.converterform-field-wrap:nth-child(2) div.css-1pcexqc-container.converterform-dropdown div.css-ty0g2a-control.converterform-dropdown__control:nth-child(1) div.css-1hwfws3.converterform-dropdown__value-container.converterform-dropdown__value-container--has-value > div.CurrencyInputWrapper-Djuqw.fmFlNB")
	WebElement elmsourcelist;

	// Type

	// select list

//Home Page Text validations

	/*
	 * public void select_source_list() throws Throwable{ elmsourcelist.click();
	 * Select select = new Select(elmsourcelist); //((WebElement)
	 * select).sendKeys("Text_From_Your_Listbox");
	 * elmsourcelist.select("Text_From_Your_Listbox"); }
	 */
	/*
	 * //select source public void select_currency(String selCur) throws Throwable{
	 * //span[@class='dropdown-currencyCode'][contains(text(),'USD')]
	 * //span[@class='dropdown-currencyName']//span[contains(text(),'US Dollar')]
	 * 
	 * driver.findElement(By.xpath(
	 * "//span[@class='dropdown-currencyCode']//span[text()='"+selCur+"']")).click()
	 * ; }
	 */

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
			elmSelsourcecur.click();
			elmSelsourcecur.sendKeys(keyword);
		} else {
			System.out.println("Element " + elmSelsourcecur + " Not Found");
		}

	}

	public void enter_key_sources(String keyword) throws Throwable {
		if (elmsourtext.isDisplayed()) {
			elmsourtext.click();
			elmsourtext.sendKeys(keyword);
		} else {
			System.out.println("Element " + elmsourtext + " Not Found");
		}

	}

	// Press Enter
	public void press_enter_source() throws Throwable {

		Actions action = new Actions(driver);
		action.moveToElement(elmSelsourcecur).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(elmSelsourcecur));
		elmSelsourcecur.click();

	}

	// Enter or choose dest currency
	public void enter_key_dest(String keyword) throws Throwable {
		if (elmDestCur.isDisplayed()) {
			elmDestCur.click();
			// elmDestCur.sendKeys(keyword);
		} else {
			System.out.println("Element " + elmDestCur + " Not Found");
		}

	}

	// Press Enter
	public void press_enter_dest() throws Throwable {
		if (elmDestCur.isDisplayed()) {
			// elmDestCur.sendKeys(Keys.ENTER);
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

	public void single_results(String amt, String source, String dest, String curName) throws Throwable {
		String actSingRes = elmResults.getText().toString();

		if (elmResults.isDisplayed()) {

			assertTrue(actSingRes.contains(amt));
			assertTrue(actSingRes.contains(source));
			assertTrue(actSingRes.contains(dest));
			assertTrue(actSingRes.contains("="));

			System.out.println("Converstion Results: " + actSingRes + " Matched");
		} else {
			assertFalse(actSingRes.contains(amt));
			assertFalse(actSingRes.contains(source));
			assertFalse(actSingRes.contains(dest));
			assertFalse(actSingRes.contains("="));

			System.out.println("Conversion Results: " + actSingRes + "Not Matched");
		}
	}
	

	public void convRate() throws Throwable {
		String actSingRes = elmconvRate.getText().toString();
		   // regular expression for an integer number 
       // String regex = "^[0-9]+(?:\\.[0-9]+)?$"; 
          
        /*// compiling regex 
        Pattern p = Pattern.compile(regex); 
          
        // Creates a matcher that will match input against regex 
        Matcher m = p.matcher(actSingRes); 
        
        if(m.find() && m.group().equals(actSingRes)) {
            System.out.println(actSingRes + " is a valid float number"); }
        
        else {
            System.out.println(actSingRes + " is not a valid float number"); }
        */
        
		if (actSingRes.matches("^[-+]?\\d*\\.?\\d*$")) {
			//Assert.assertThat(actSingRes.matches("^[-+]?\\d*\\.?\\d*$"));
			assertTrue(actSingRes.matches("^[-+]?\\d*\\.?\\d*$"));
			//assertThat(actSingRes).matches("[A-Za-z]*[ ]{3}ID: [0-9]*[ ]{3}VERSION: [0-9]*");
		

			System.out.println("Converstion Rate: "+ actSingRes + " Matched");
		} else {
			assertFalse(actSingRes.matches("^[-+]?\\d*\\.?\\d*$"));

			System.out.println("Conversion Rate: " + actSingRes + "Not Matched");
		
	}
        }
	    

//Verify Single Currency destination value
	public void single_cur_dest_value(String expDestvalue) throws Throwable {
		String actDesVal = elmDestValue.getText().toString();
		if (actDesVal.equalsIgnoreCase(expDestvalue)) {
			Assert.assertEquals(expDestvalue, actDesVal);
		} else {
			Assert.assertNotEquals(expDestvalue, actDesVal);
		}

	}

	// Verify Single Currency destination value
	public void single_cur_source_value(String expSourcevalue) throws Throwable {
		String actDesVal = elmSourceValue.getText().toString();
		if (actDesVal.equalsIgnoreCase(expSourcevalue)) {
			Assert.assertEquals(elmSourceValue, actDesVal);
			System.out.println("Results " + actDesVal + "" + expSourcevalue + " Matched");
		} else {
			Assert.assertNotEquals(elmSourceValue, actDesVal);
			System.out.println("Results " + actDesVal + "" + expSourcevalue + "Not Matched");
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
			System.out.println("Main heading title: " + acth1mainhead + "Found ");
		} else {
			Assert.assertNotEquals(h1mainhtitle, acth1mainhead);
			System.out.println("Main heading title   " + acth1mainhead + "Not Found");
		}

	}

	// Verify Amount Conversion amount
	public void verify_amount_convValue(String expConValue) throws Throwable {
		String actConvTitle = convTitle.getText().toString();
		// text.matches("^[a-zA-Z0-9]+$")
		if (actConvTitle.equalsIgnoreCase(expConValue)) {
			assertTrue("Match", actConvTitle.contains(expConValue));
			System.out.println("Amount Conversion " + actConvTitle + " Results ");
		} else {
			assertFalse("Not Match", actConvTitle.contains(expConValue));
			System.out.println("Amount Conversion: " + actConvTitle + "Title");
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
