# ConvertExchange
# Getting Started

# PageFactory:

Selenium PageFactory. The PageFactory Class in Selenium is an extension to the Page Object design pattern. It is used to initialize the elements of the Page Object or instantiate the Page Objects itself. The @FindBy annotation is used in Page Objects in Selenium tests to specify the object location strategy for a WebElement or a list of WebElements. Using the PageFactory, these WebElements are usually initialized when a Page Object is create

# Prerequisites
  -What things you need to install the software and how to install them java and maven needs to be install before running this maven project http://maven.apache.org/install.html https://www.java.com/en/
 -Install chrom and firefox in order to run the scripts 

# Command Line:
Download this project unzip and save into local folder where maven and java installed on window command line go to folder run mvn clean test

# Ecliplse:
Install spring-boot from eclipse market to run from spring-boot
Note:Make sure M2E Intalled in Eclipse,but this should come while installed eclipse Download project from this repository 1.open Eclipse create workspace 2.File->Open->Import->Existing Maven Project and click on next 3.successfully import 4.Right Click on Project->Run as->Maven Test

# Jenkins Steps Build:
# xvfb Plugin on jenkins in order to run as headless
1.Insta xvfb plugin from manage jenkins
2.set export Display=:99 on Execute Shell
3.On Build Environment set xvfb specification display name as 99
4.time out in 10 seconds
# Setup Project
1.Click on New job 2.Write Desc and choose maven project(note:if maven project is not availble, try install from manage jenkins -> Manage Plugins) 3.Go to build option enter root path with pom.xml 4.save and run build

# Reports
Reports can be generated on the folder "/report"


   
