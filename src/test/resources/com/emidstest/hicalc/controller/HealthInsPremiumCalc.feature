Feature: PremiumCalcController operations 

Scenario: Calculate premium for client 
	When I send post request to calculate premium for client details Michel 
	Then I should get premium details for Michel

