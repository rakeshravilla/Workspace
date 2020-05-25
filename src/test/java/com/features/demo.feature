Feature: Registration of demo site

Scenario Outline: Filling details using demo site
Given User launch the browser and navigate to demo site
Then User will enter all the required fields
|rarak|hero|Andhra|kbksdbk@gmail.com|9876447890|
And click on "<gender>" and "radiobuttons"
And click on "<hobbies>" and "hobbies"
And select languange in the list
And also select "<Skills>" from dropdown of "skills" field
And also select "<country>" from dropdown of "country" field
And Enter the "<SelectCountry>" by "clicking" the column and "Enter"
And also select "<year>" from dropdown of "Year" field
And also select "<month>" from dropdown of "Month" field
And also select "<day>" from dropdown of "Day" field
And Enter the password and confirm password
|Qwerty@123|Qwerty@123|
Then click on the "Submit" button
Then take a screen shot and validate the scenario

Examples:
|gender|hobbies|Skills|country|SelectCountry|year|month|day|
|male|Movies|Analytics|Afghanistan|Australia|1997|April|21|