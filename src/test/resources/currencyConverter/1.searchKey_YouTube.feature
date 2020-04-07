@web
Feature:  As a Youtube user i will go and search my favorite singer
Scenario Outline: Validate search key on Firefox

Given I Go to "<url>" on "<Browser>"
Then I Verify Title of the Page "<pgtitle>"
Then I Wait for some Time
Then I Enter Amount to Convert "<amount>"
And I Select Source Currency Name "<sourCurrency>"
And I Press Enter at Source List
Then I Wait for some Time
And I Select Destination Currency Name "<destCurrency>"
And I Press Enter at Destination List
Then I Wait for some Time
Then I Close Browser

Examples:
|url|Browser|pgtitle|amount|sourCurrency|destCurrency|
|https://www.xe.com/currencyconverter|Chrome|XE Currency Converter - Live Rates|10|USD|EURO|



