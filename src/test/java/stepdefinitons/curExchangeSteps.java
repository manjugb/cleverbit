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
	@And("^I Select Source Currency \"([^\"]*)\"$")
	public void select_source(String souCurrName) throws Throwable{
		WebElement elmInput = wd.findElement(By.cssSelector("#converterForm > form > div:nth-child(2) > div > div > div.css-1hwfws3.converterform-dropdown__value-container.converterform-dropdown__value-container--has-value > div.CurrencyInputWrapper-Djuqw.fmFlNB"));
		Actions action = new Actions(wd);
        action.moveToElement(elmInput).perform(); 
		WebDriverWait wait = new WebDriverWait(wd, 30);
        wait.until(ExpectedConditions.elementToBeClickable(elmInput));
        
        elmInput.click();
        enterText_source(souCurrName);
        
        //select_span(souCurrName);
        click_span_source(souCurrName);
      
		/* //WebElement elem = wd.findElement(By.xpath("//span[@class='dropdown-currencyCode']//span[text(),'"+souCurrName+"']")).click();
		 new WebDriverWait(wd,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(), \"" + souCurrName + "\")]"))).click();
		*/ 
		     
	}
	
	public void enterText_source(String sourText) throws Throwable{
	
        WebElement elminputText = wd.findElement(By.xpath("//*[@id=\"converterForm\"]/form/div[2]/div/div/div[1]/div[2]"));
        Actions action = new Actions(wd);
        action.moveToElement(elminputText).perform(); 
		WebDriverWait wait = new WebDriverWait(wd, 30);
        wait.until(ExpectedConditions.elementToBeClickable(elminputText));
        elminputText.click();
         Thread.sleep(300);
        action.sendKeys(sourText);
        /*String script = "arguments[0].setAttribute('div',  ' + sourText + ');"
        		((JavascriptExecutor) wd).executeScript(script, elminputText);
        */
        
        
        //elminputText.sendKeys(sourText);
			
	}
	
	
	public void select_span_source(String optionText) throws Throwable{
		WebElement drop_down_Menu =  wd.findElement(By.xpath("//*[@id=\"converterForm\"]/form/div[2]/div/div/div[1]/div[2]"));

		// Verify selection menu is now visible

		if(drop_down_Menu.isDisplayed()) {

		List<WebElement> menuItems = drop_down_Menu.findElements(By.tagName("span"));

		for(WebElement menuItem : menuItems) 
		{ 
			if(menuItem.getText().trim().toLowerCase().equalsIgnoreCase(optionText.trim().toLowerCase())) {
		}
			Actions action = new Actions(wd);
            action.moveToElement(menuItem).perform(); 
    		WebDriverWait wait = new WebDriverWait(wd, 30);
            wait.until(ExpectedConditions.elementToBeClickable(menuItem));
            menuItem.click();
            action.sendKeys(menuItem.getText()).click();
            break;
		

		}
		}
	}


 public void click_span_dest(String strCurrency) throws Throwable{
	
	 WebElement drop_down_Menu =  wd.findElement(By.xpath("//*[@id=\"converterForm\"]/form/div[2]/div/div/div[1]/div[2]"));

		// Verify selection menu is now visible

		if(drop_down_Menu.isDisplayed()) {

		List<WebElement> currencies = drop_down_Menu.findElements(By.tagName("span"));
	    for(WebElement currency: currencies)
	    {  
	        if(currency.getText().equals(strCurrency) || currency.getText().trim().toLowerCase().equalsIgnoreCase(strCurrency.trim().toLowerCase())){
	        	Actions action = new Actions(wd);
	            action.moveToElement(currency).perform(); 
	    		WebDriverWait wait = new WebDriverWait(wd, 30);
	            wait.until(ExpectedConditions.elementToBeClickable(currency));
	            action.sendKeys(strCurrency).click();
	            break;
	        }
	    }
		}
 }

 
 
//Select the currencny from 
	@And("^I Choose Destination Currency \"([^\"]*)\"$")
	public void select_dest(String souCurrName) throws Throwable{
		
		WebElement elmInput = wd.findElement(By.cssSelector("#converterForm > form > div:nth-child(4) > div > div > div.css-1hwfws3.converterform-dropdown__value-container.converterform-dropdown__value-container--has-value > div.CurrencyInputWrapper-Djuqw.fmFlNB\n"));
		Actions action = new Actions(wd);
       action.moveToElement(elmInput).perform(); 
		WebDriverWait wait = new WebDriverWait(wd, 30);
       wait.until(ExpectedConditions.elementToBeClickable(elmInput));
       
       elmInput.click();
       enterText_dest(souCurrName);
       
       //select_span(souCurrName);
       click_span_dest(souCurrName);
     
		/* //WebElement elem = wd.findElement(By.xpath("//span[@class='dropdown-currencyCode']//span[text(),'"+souCurrName+"']")).click();
		 new WebDriverWait(wd,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(), \"" + souCurrName + "\")]"))).click();
		*/ 
		     
	}
	
	public void enterText_dest(String sourText) throws Throwable{
		
       WebElement elminputText = wd.findElement(By.xpath("//*[@id=\"converterForm\"]/form/div[3]/div/div/div[1]/div[2]"));
       Actions action = new Actions(wd);
       action.moveToElement(elminputText).perform(); 
		WebDriverWait wait = new WebDriverWait(wd, 30);
       wait.until(ExpectedConditions.elementToBeClickable(elminputText));
       elminputText.click();
        Thread.sleep(300);
       action.sendKeys(sourText);
       /*String script = "arguments[0].setAttribute('div',  ' + sourText + ');"
       		((JavascriptExecutor) wd).executeScript(script, elminputText);
       */
       
       
       //elminputText.sendKeys(sourText);
			
	}
	
	public void click_span_source(String strCurrency) throws Throwable{
		
		 WebElement drop_down_Menu =  wd.findElement(By.xpath("//*[@id=\"converterForm\"]/form/div[3]/div/div/div[1]/div[2]"));

			// Verify selection menu is now visible

			if(drop_down_Menu.isDisplayed()) {

			List<WebElement> currencies = drop_down_Menu.findElements(By.tagName("span"));
		    for(WebElement currency: currencies)
		    {  
		        if(currency.getText().equals(strCurrency) || currency.getText().trim().toLowerCase().equalsIgnoreCase(strCurrency.trim().toLowerCase())){
		        	Actions action = new Actions(wd);
		            action.moveToElement(currency).perform(); 
		    		WebDriverWait wait = new WebDriverWait(wd, 30);
		            wait.until(ExpectedConditions.elementToBeClickable(currency));
		            action.sendKeys(strCurrency).click();
		            break;
		        }
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

		  wd.findElement(By.xpath("//span[contains(text()='"+seldesName+"']")).click();
	  
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
