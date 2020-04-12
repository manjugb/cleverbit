@web
Feature:  As User should be able to specify numeric amount, source and target currency, and obtain conversion amount and Type Search Currency as Upper Case letters
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
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|1|INR|EUR|EUR|Indian Rupee to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|USD|EUR|EUR|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|USD|MYR|MYR|US Dollar to Malaysian Ringgit Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|GBP|INR|INR|British Pound to Indian Rupee Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|GBP|INR|INR|British Pound to Indian Rupee Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|1000|GBP|INR|INR|British Pound to Indian Rupee Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|USD|EUR|EUR|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|USD|EUR|EUR|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|INR|EUR|EUR|Indian Rupee to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10000|USD|EUR|EUR|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|1.5|USD|EUR|EUR|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|0.5|INR|EUR|EUR|Indian Rupee to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|0.01|INR|EUR|EUR|Indian Rupee to Euro Conversion|

Scenario: Validate Currency Exchange Close on Chrome
Then I Close Browser