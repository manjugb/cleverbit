@web
Feature:  As User should be able to specify numeric amount, source and target currency, and obtain conversion amount
Scenario Outline: Validate the page title,amount,source and target conversion values on chrome

Given I Go to "<url>" on "<Browser>"
Then I Verify Title of the Page "<pgtitle>"
Then I Enter Amount to Convert "<amount>"
And I Select Source Currency "<souCurrency>"
And I Choose Destination Currency "<destCurrency>"
And I Click on CalcButton
Then I Verify h1 heading result "<expSingleValue>"
Then I Verify Amount Conversion Value "<amcnvalve>"

Examples:
|url|Browser|pgtitle|amount|souCurrency|destCurrency|expSingleValue|amcnvalve|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|usd|eur|10 USD to EUR = 9.17159 Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|USD|EUR|100 USD to EUR = 92.0082 Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|usd|eur|100 USD to EUR = 92.0082 Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|USD|eur|100 USD to EUR = 92.0082 Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|inr|eur|100 USD to EUR = 92.0082 Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|usd|eur|100 USD to EUR = 92.0082 Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|1.5|USD|eur|100 USD to EUR = 92.0082 Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|0.5|inr|eur|100 USD to EUR = 92.0082 Euros|test|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|-1|inr|eur|100 USD to EUR = 92.0082 Euros|test|



Scenario Outline: Closing Chrome
Then I Close Browser