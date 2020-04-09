package runner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import pages.DriverHandler;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/currencyConverter/"},
        //format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = {"stepdefinitons"},
        //~ will skip the features with that specific tag
        tags = {"@web"},
        //monochrome = true,
        format={"pretty"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:report/report.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests{

    @BeforeClass
    public static void initExtentReport() {
        //you can configure the path here, for that leave in the options the following
        //  plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
       // ExtentProperties extentProperties = ExtentProperties.INSTANCE;
       // extentProperties.setReportPath("report/report.html");
    }

    //writes in the report
    @AfterClass
    public static void writeExtentReport() {
        try {
            //Reporter.loadXMLConfig(new File(ConfigFileReader.getInstance().getReportConfigPath()));
            //C:/Users/jorge/Desktop/Work/Code/Mine/Java_Selenium_cucumber_testNG/config/extent-config.xml
            //Reporter.loadXMLConfig();
            //Reporter.loadXMLConfig(ConfigFileReader.getInstance().getReportConfigPath());
        	Reporter.loadXMLConfig("./extent-Config.xml");
            Reporter.setSystemInfo("user", System.getProperty("user.name"));
            Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
            Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
            Reporter.setSystemInfo("Selenium", "3.141.59");
            Reporter.setSystemInfo("Maven", "3.7.0");
            Reporter.setSystemInfo("Java Version", "11");
            Reporter.setTestRunnerOutput("Sample test runner output message");
        }catch(Exception e){
            System.out.println("Hay un errooooor: " + e);
        }


    }

    //Added  TestNG annotation to allow closing the browser at the end
    @AfterSuite
    public static void tearDown(){
        DriverHandler.GetInstanceDriverHandler();
    }
}

//Strict : it will try to find the pending steps or missing steps, and fail if not find
//features :need to provide path of feature
//format : will contain the reporting features
//tag : for tagged hookes for scenarios
//monochrome : enhance the readbility
//glue : provide your stepdefinition class path
//dryrun : will check if u have pending or missing steps, but will not fail scripts
