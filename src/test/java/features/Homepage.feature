Feature: Homepage.Feature

  @runner
  Scenario: Validate general user is able to view products wihtout logging in
    Given User navigates to the Online products page
    When User clicks on Formal Shoes drop down
    Then User should be able to view the Products
#
#  @runner
#  Scenario: Validate general user is able to view products wihtout logging in
#    Given User navigates to the Online products page
#    When User clicks on Formal Shoes drop down
#    Then User should be able to view the Products
#
#  @runner
#  Scenario: Validate general user is able to view products wihtout logging in
#    Given User navigates to the Online products page
#    When User clicks on Formal Shoes drop down
#    Then User should be able to view the Products