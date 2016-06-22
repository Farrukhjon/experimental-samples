Feature: Calculator

  Scenario: Exercise happy addition
    Given The positive numbers 3 and 2
    When I call add method
    Then It should return 5

  Scenario: Exercise happy subtraction
    Given The calculator
    When I call subtract method with 5 and 2
    Then It should return subtracted result 3

 #Scenario using bullets
  Scenario: Support factorial calculation
    * calculate factorial on 10 is called
    * expected factorial is 3628800

  # Exercise Data table

  Scenario: Exercise factorial calculation by 'Data Table'
    Given calculate factorial via data table:
    | 1| 1  |
    | 3| 6  |
    | 5| 120|