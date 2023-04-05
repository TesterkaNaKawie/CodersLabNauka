@hotel
Feature: Hotel account creation
#zad2 HotelSteps
  @create
  Scenario: User can create an account
    Given I'm on hotel main page
    When I sign in
    And I enter email that is not already taken on authentication page
    And I enter name "John" surname "Doe" and password "superpass"
    Then I can see success message with test "Your account has been created."
    And I close hotel browser

#zad3
  @createmore
  Scenario Outline: User can create an account
    Given I'm on hotel main page
    When I sign in
    And I enter email that is not already taken on authentication page
    And I enter name "<name>" surname "<surname>" and password "<password>"
    Then I can see success message with test "Your account has been created."
    And I close hotel browser
    Examples:
      | name   | surname  | password |
      | Jan    | Kowalski | 123abc   |
      | Alicja | Lopag    | qaz123   |