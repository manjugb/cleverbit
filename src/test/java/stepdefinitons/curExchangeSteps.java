package stepdefinitons;

import org.junit.Assert;

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
	@And("I Select Source Currency Name \"([^\"]*)\"$")
	public void enter_source(String souCurrName) throws Throwable{
		new curExchange(wd).enter_key_dest(souCurrName);
	}
	
	@And("^I Press Enter at Source List$")
	public void press_enter_source() throws Throwable{
		new curExchange(wd).press_enter_source();
	}
	//select currenncy to 
	@And("I Select Destination Currency Name \"([^\"]*)\"$")
	public void enter_dest(String destCurrName) throws Throwable{
		new curExchange(wd).enter_key_source(destCurrName);
	}
	
	@And("^I Press Enter at Destination List$")
	public void press_enter_dest() throws Throwable{
		new curExchange(wd).press_enter_dest();
	}
	//click on calc button
	@Then("^I Click on Calc Button$")
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
