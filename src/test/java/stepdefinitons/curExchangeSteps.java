package stepdefinitons;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.DriverHandler;
import pages.curExchange;



public class curExchangeSteps extends DriverHandler{
	protected com.aventstack.extentreports.ExtentTest logger;
	static ExtentTest test;
	static ExtentReports report;
	public pages.DriverHandler dh = new  pages.DriverHandler();
	
	
	
	@Given("^I Go to \"([^\"]*)\" on \"([^\"]*)\"$")
	//Given("^I Go to \"([^\"]*)\" on \"([^\"]*)\"$", (String url,String browser) -> {
       public void open_browser(String url,String browser) throws Throwable{
		if(wd==null && browser.equalsIgnoreCase("Firefox")) {
		dh.chooseDriver(url, browser);
		dh.getDriver().getTitle();
		System.out.println(wd.hashCode());
	
		}else if(wd==null && browser.equalsIgnoreCase("Chrome")) {
			dh.chooseDriver(url, browser);
			dh.getDriver().getTitle();
			System.out.println(wd.hashCode());
		}else if(wd==null && browser.equalsIgnoreCase("Headless")) {
			dh.chooseDriver(url, browser);
			dh.getDriver().getTitle();
			System.out.println(wd.hashCode());}			
	 }
	//Enter the amount to convert
	@And("^I Enter Amount to Convert \"([^\"]*)\"$")
	public void enter_key(String key) throws Throwable{
	//	test.log(Status.PASS, "User Enter the keyword to search");
		new curExchange(wd).enter_key(key);
		
	}
	//Select the currencny from 
	@And("I Select Source Currency Code \"([^\"]*)\"$")
	public void enter_source(String souCurrName) throws Throwable{
		/*/html[1]/body[1]/div[1]/div[2]/div[2]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]
		/html[1]/body[1]/div[1]/div[2]/div[2]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]
		*/
		//div.GradientStyled-cppXvn.dGZPbD.gradient:nth-child(2) div.CenterpieceContainer-dSIInE.jBdjhw main.Main-qeYMh.hqxsYs:nth-child(3) div.sc-AxheI.fniENO div.ConverterContainer-cnPALV.CustomConverterContainer-dQlrWq.jvifoo div.Wrapper-jDUUyL.jwmWMe div.RowContainer-jiJByP.eOAMnW div.converterform-wrapper.converterForm form.Form-qfhCc.sc-AxmLO.gCBjtB div.converterform-field-wrap:nth-child(4) div.css-1pcexqc-container.converterform-dropdown div.css-ty0g2a-control.converterform-dropdown__control:nth-child(1) div.css-1hwfws3.converterform-dropdown__value-container.converterform-dropdown__value-container--has-value > div.CurrencyInputWrapper-Djuqw.fmFlNB
		
		WebElement elmInput = wd.findElement(By.cssSelector("#converterForm > form > div:nth-child(2) > div > div > div.css-1hwfws3.converterform-dropdown__value-container.converterform-dropdown__value-container--has-value > div.CurrencyInputWrapper-Djuqw.fmFlNB"));
		Actions action = new Actions(wd);
        action.moveToElement(elmInput).perform(); 
		WebDriverWait wait = new WebDriverWait(wd, 30);
        wait.until(ExpectedConditions.elementToBeClickable(elmInput));
        
        elmInput.click();
       
      //*[@id="converterForm"]/form/div[2]/div/div/div[1]/div[2]
        WebElement elm1 = wd.findElement(By.xpath("//*[@id=\"converterForm\"]/form/div[2]/div/div/div[1]/div[2]"));
			String tag = elm1.getTagName();
			String tex = elm1.getText();
			System.out.println(""+tag+" : "+tex+" ");
		 //WebElement elem = wd.findElement(By.xpath("//span[@class='dropdown-currencyCode']//span[text(),'"+souCurrName+"']")).click();
		 new WebDriverWait(wd,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(), \"" + souCurrName + "\")]"))).click();
		 //Select dropdown = new Select(ele);
		 //dropdown.selectByValue(souCurrName); 
		 
		 //WebElement elmnt=wd.findElement(By.xpath(".//*[@id='MainLayout']/div/div[2]/div/div/div[3]/div/div[2]/div/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[3]/div/div[2]/div/div/div[1]/div/div/div/div/div/div[4]/span/span"));

		 //elmnt.click(); 
		 
		     
	}


 public void select_currency(String strCurrency) throws Throwable{
	
	//div[contains(text(),’share’)]
	//span[@class='dropdown-currencyName']//span[contains(text(),'US Dollar')]
	//*[@id="converterForm"]/form/div[2]/div/div/div[1]/div[1]/div/span[2]/span
	    List<WebElement> currencies = wd.findElements(By.tagName("span"));
	    //List<WebElement> print4 = wd.findElements(By.xpath("//span[contains(@class, '" +in_strChapterName+ "')]"));
	    //List<WebElement> options = elmInput.findElements(By.tagName("//span[text()='"+strCurrency+"']"));
	    //System.out.println(spans);
	    for(WebElement currency: currencies)
	    {
	        if(currency.getText().equals(strCurrency)){
	        	Actions action = new Actions(wd);
	            action.moveToElement(currency).perform(); 
	    		WebDriverWait wait = new WebDriverWait(wd, 30);
	            wait.until(ExpectedConditions.elementToBeClickable(currency));
	            currency.click();
	            break;
	        }
	    }
 }
		
		
		
	
	
	@And("^I Click at Source Lists$")
	public void press_enter_source() throws Throwable{
		
		Actions action = new Actions(wd);
        action.moveToElement(new curExchange(wd).elmSelsourcecur).perform(); 
        WebDriverWait wait = new WebDriverWait(wd, 30);
        wait.until(ExpectedConditions.elementToBeClickable(new curExchange(wd).elmSelsourcecur));
        new curExchange(wd).elmSelsourcecur.click();
        
	}
	//select currenncy to 
	@And("I Select Destination Currency Name \"([^\"]*)\"$")
	public void enter_dest(String seldesName) throws Throwable{

		  wd.findElement(By.xpath("//span[@class='dropdown-currencyName']//span[contains(text()='"+seldesName+"']")).click();
	  
	}
	
	
	

	@And("^I Click at Destination Lists$")
	public void press_enter_dest() throws Throwable{
		new curExchange(wd).press_enter_dest();Actions action = new Actions(wd);
        action.moveToElement(new curExchange(wd).elmDestCur).perform(); 
        WebDriverWait wait = new WebDriverWait(wd, 30);
        wait.until(ExpectedConditions.elementToBeClickable(new curExchange(wd).elmDestCur));
        new curExchange(wd).elmDestCur.click();
	}
	//click on calc button
	@Then("^I Click on CalcButton$")
	public void clk_Search() throws Throwable{
		
		new curExchange(wd).clk_calcbut();
	}
	//Verify Single value currency
	@Then("^I Verify h1 heading result \"([^\"]*)\"$")
	public void h1_heading_result(String expSingleValue) throws Throwable{
		new curExchange(wd).single_results(expSingleValue);
	}
	
	//Verify single_cur_dest_value
	@Then("^I Verify Amount Conversion Value \"([^\"]*)\"$")
	public void amt_conv_value(String expAmtValue) throws Throwable{
		new curExchange(wd).verify_amount_convValue(expAmtValue);
	}
	
	@Then("^I Click On Swap to Change Currencies")
	public void click_swap() throws Throwable{
		new curExchange(wd).clk_swap();
	}
	
    
	@Then("^I Verify Title of the Page \"([^\"]*)\"$")
	public void verifytext(String expText) throws Throwable{

		 String actTitle = wd.getTitle();
       if(actTitle.equalsIgnoreCase(expText)) {
		
		Assert.assertEquals("Title Matched", actTitle, expText);
		}
		else {
			Assert.assertNotEquals("Title Not Matched", actTitle, expText);
		}
	}
	
	@Then("^I Close Browser$")
	public void close_br() throws Throwable{
		dh.destroyDriver();
	
	}
	@Then("^I Wait for some Time$")
	public void waitfor() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
