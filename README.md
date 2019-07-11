# Author : Virendra

1) ConfigFileReader contains all the basic method
2) WebDriverManager: If we want execute on different browser this class have required stuffs
	-- for now i have created only for chrome browser 
3) DiscoveryHomePageObjects : Contains all the objects and methods releated Homepage and Myvideos page
4) DiscoveryHomePage: Step defination are defined
5) TestRunner : This is triggering point for your test

#Procedure to run 
1) Open Eclispe
2) Import project as maven
3) Go to src/test/java/testsuite -> #TestRunner and Run as JUnit test
4) Extent Report is created under target -> #report.html
