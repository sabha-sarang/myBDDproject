Feature: Login functionality for nopcommerce Website

Scenario: Successful Login with valid credentials
Given User launch Chrome Browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And user enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Log Out link
Then Page Title should be "Your store. Login"
And close browser
