@web
Feature:  As User should be able to specify numeric amount, source and target currency, and obtain conversion amount and Type Search Currency as Upper Case letters
Scenario Outline: Validate the page title,amount,source and target conversion values with type currency name as uppercase on chrome

Given I Go to "<url>" on "<Browser>"
Then I Verify Title of the Page "<pgtitle>"
Then I Enter Amount to Convert "<amount>"
And I Select Source Currency "<souCurrency>"
And I Choose Destination Currency "<destCurrency>"
And I Click On Swap to Change Currencies
And I Click on CalcButton
Then I Verify amount "<amount>" with "<souCur>" to "<destCur>" currency "<curName>"
Then I Checked Converstion Rate
Then I Checked Converstion Rate Source "<souCur>"
Then I Checked Converstion Rate Dest "<destCur>"
Then I Verify Converstion Result Title "<convTitle>"

Examples:
|url|Browser|pgtitle|amount|souCurrency|destCurrency|souCur|destCur|curName|convTitle|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10,000|EURO|INR|INR|EUR|EUR|Euro to Indian Rupee Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|EURO|USD|USD|EUR|EUR|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|MYR|USD|USD|MYR|MYR| Malaysian Ringgit toUS Dollar Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|GBP|INR|INR|GBP|GBP|British Pound to Indian Rupee Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|1,000|GBP|INR|INR|GBP|GBP|British Pound to Indian Rupee Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|INR|GBP|GBP|INR|INR|Indian Rupee to British Pound Conversion|



Scenario Outline: Validate the page title,amount,source and target conversion values with type currency name as case sensitive on chrome

Given I Go to "<url>" on "<Browser>"
Then I Verify Title of the Page "<pgtitle>"
Then I Enter Amount to Convert "<amount>"
And I Select Source Currency "<souCurrency>"
And I Choose Destination Currency "<destCurrency>"
And I Click On Swap to Change Currencies
And I Click on CalcButton
Then I Verify amount "<amount>" with "<souCur>" to "<destCur>" currency "<curName>"
Then I Checked Converstion Rate
Then I Verify Converstion Result Title "<convTitle>"

Examples:
|url|Browser|pgtitle|amount|souCurrency|destCurrency|souCur|destCur|curName|convTitle|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10,000|inr|EUR|INR|EUR|EUR|Indian Rupee to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|USD|eur|USD|EUR|EUR|US Dollar to Euro Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|usd|myr|USD|MYR|MYR|US Dollar to Malaysian Ringgit Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|gbp|inr|GBP|INR|INR|British Pound to Indian Rupee Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|1,000|gbp|myr|GBP|MYR|MYR|British Pound to Indian Rupee Conversion|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|100|gbp|INR|GBP|INR|INR|British Pound to Indian Rupee Conversion|

Scenario: Validate Currency Exchange Close on Chrome
Then I Close Browser




