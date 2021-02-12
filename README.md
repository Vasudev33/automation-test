# automation-test
Web and API automation test projects

1. Web Application Test:         
    - Selected test 1 with BlazeDemo app        
    - src/main/java/utils package contains class with some utility methods        
    - src/main/java/pages package contains all the page classes with POM (Page Object Model)        
    - src/test/java/scripts/web/VerifyBooking.java - contains a test method to cover one positive scenario of flight booking
    
2. API Application Test:        
    - src/test/java/scripts/api/APITests.java - contains test methods - TestValidStatusCode , TestResponseForInvalidURI and TestMandatoryFieldsInResponse

TestNG suite file path: ./test-suites/testng.xml


TestNG report path with all test cases passed: ./test-output/emailable-report.html
