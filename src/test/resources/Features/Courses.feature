Feature: This file contains all test cases for corses tab

            Scenario: To verify when user click on Courses tab
	Given chrome browser is opened
	And url is launched
	And wait Karo Courses visible honay tak
	When user click on courses tab
	And wait Karo options visible honay tak
	Then Courses options should display
  And Browser band kar do
	
	
Scenario: To verify user click on Recent placement tab option
	Given chrome browser is opened
  And url is launched
	When user click on Recent placement tab
	And wait Karo Courses options visible honay tak
	Then GetText
	And wait Karo Courses options visible honay tak 
  And Browser band kar do



