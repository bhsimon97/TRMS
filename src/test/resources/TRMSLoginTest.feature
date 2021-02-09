Feature: Logging In

	Background:
		Given The Guest is on the Login Page
		
	Scenario Outline: The Guest tries to Login
		When The user types in "<username>" in the Username form
		And The user types in "<password>" in the Password form
		And The user clicks the Login button
		Then The user should be at reimbursement.html
		
		Examples:
		|	username	| password				|
		|	bsimon		| password				|
		|	hhlin		| password				|
		|	gordongee	| password				|