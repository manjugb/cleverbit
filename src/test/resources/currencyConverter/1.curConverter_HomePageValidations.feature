@web
Feature:  As User should be able to specify numeric amount, source and target currency, and obtain conversion amount
Scenario Outline: Validate the page title,amount,source and target conversion values

Given I Go to "<url>" on "<Browser>"
Then I Verify Title of the Page "<pgtitle>"
Then I Wait for some Time
Then I Enter Amount to Convert "<amount>"
Then I Wait for some Time
And I Select Source Currency Code "<sourCurrency>"
And I Click at Destination Lists
And I Select Destination Currency Name "<destCurrency>"
And I Click at Destination Lists
Then I Wait for some Time
And I Click on CalcButton
Then I Verify h1 heading result "<expSingleValue>"

Examples:
|url|Browser|pgtitle|amount|sourCurrency|destCurrency|expSingleValue|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|INR|Euro|10 USD to EUR = 9.17159 Euros|




Scenario Outline: Validate the page title,amount,source and target conversion values on Chrome
Then I Close Browser