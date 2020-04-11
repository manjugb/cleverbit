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
Then I Verify Amount Conversion Value "<amcnvalve>"

Examples:
|url|Browser|pgtitle|amount|souCurrency|destCurrency|curName|amcnvalve|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|1|inr|eur|Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|usd|eur|Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|USD|EUR|Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|usd|eur|Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|USD|eur|Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|inr|eur|Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|usd|eur|Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|1.5|USD|eur|Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|0.5|inr|eur|Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|-1|inr|eur|Euros|test|

<<<<<<< HEAD
Scenario: Validate Currency Exchange Close on Chrome
Then I Close Browser
=======


Scenario: Closing Chrome
Then I Close Browser
>>>>>>> a5b6668b5ddfec4259eb9e634c1cb692bf8d5599
