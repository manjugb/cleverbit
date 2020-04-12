@web
Feature:  As User should be able to specify numeric amount, source and target currency, and obtain conversion amount
Scenario Outline: Validate the page title,amount,source and target conversion values on chrome

Given I Go to "<url>" on "<Browser>"
Then I Verify Title of the Page "<pgtitle>"
Then I Enter Amount to Convert "<amount>"
And I Select Source Currency "<souCurrency>"
And I Choose Destination Currency "<destCurrency>"
And I Click on CalcButton
Then I Verify amount "<amount>" with "<souCurrency>" to "<destCurrency>" currency "<curName>"
Then I Checked Converstion Rate
Then I Verify Converstion Result Title "<convTitle>"

Examples:
|url|Browser|pgtitle|amount|souCurrency|destCurrency|curName|convTitle|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|1|INR|EUR|Euros|Indian Rupee to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|USD|EUR|Euros|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|USD|EUR|Euros|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|USD|EUR|Euros|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|USD|EUR|Euros|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|INR|EUR|Euros|Indian Rupee to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|USD|EUR|Euros|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|1.5|USD|EUR|Euros|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|0.5|INR|EUR|Euros|Indian Rupee to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|0.01|INR|EUR|Euros|Indian Rupee to Euro Conversion|

<<<<<<< HEAD
Scenario: Validate Currency Exchange Close on Chrome
Then I Close Browser
=======

Scenario: Validate Currency Exchange Close on Chrome
Then I Close Browser


Scenario: Closing Chrome
Then I Close Browser

>>>>>>> a75461e02321e827d6f2adeea2e12e06585684ca
