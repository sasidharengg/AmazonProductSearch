# AmazonProductSearch
This code is to search for a particular product and to apply desired filters

Hi! Here you’ll find detailed description of whole program and it’s execution
Contents:
1.	Tools and Environment used
2.	Guidelines to add the project to IDE
3.	Running the program
4.	Script description
Let’s go through one by one.

Environment and Tools used:
•	Windows 10 + Intellij IDEA + Selenium + Java + Maven + TestNG + Data-Driven Framework

Guidelines to add the project:
•	Unzip the CorbereumSasidharTestSasidhar.zip and save to local folder
•	Open any IDE, preferably Intellij IDEA
•	Import the project to IDE
•	Let the IDE download all the dependencies
•	Check all import statements to make sure that all dependencies are installed before running.

How to Run the program:
•	Navigate to src>test>resources>TestRuns>AmazonTestRun.xml
•	Open AmazonTestRun.xml
•	Right Click on the xml file and click on Run (default values: Chrome browser and 5th product)
•	Should you be running in desired browser, Enter firefox, ie, chrome values as per requirement

Script Description:
Skeleton of Framework
•	src/test/java
•	baseSetup (packgage)
  •	 BaseClass (class) 
•	funtionalTests (packgage)
  •	SearchAndRetrieveProduct (class)
•	pageObjects (packgage)
  •	SearchInHomePageObjects (class)
  •	FilterObjects (class)
  •	RetreveProductObjects (class)
•	Utilities (packgage)
  •	LoadPropertiesFile (class)
  •	WriteToExcel (class)
•	src/test/resources
   •	TestData (Folder)
•	OutputDataFile.xlsx
•	TestData.properties
•	Drivers (Folder)
•	Chromedriver.exe
•	Geckodriver.exe
•	InternetExplorer.exe
•	TestRuns (Folder)
•	AmazonTestRun.xml 
•	pom.xml

@BeforeTest 
BaseClass contains driver initialization and Window maximize and URL navigation steps. Driver initialization is implemented in switch() statement which is faster than nested-if. Depending on parameter passed through xml file, respective browser is initiated.
URL is retrieved from properties file.
@Test
SearchAndRetrieveProduct class contains test methods for each and every stage i.e. Searching of the product, Selecting the filters and Writing the desired product into excel file
For each page, I’ve created each class for Object repositories
Loading the user desired value from properties file and finding locators dynamically to retrieve the product is my code concept.
@AfterTest
In this, I’ve just closed the browser.

In the whole program, I’ve nowhere hard corded the program, from URL to selection of desired filters and desired product. To Apply any change in filter or desired product (nth product) you need to change in properties file. This also can be done in numerous ways like excel, xml…



