Feature: Signup


  @signup @access-form
  Scenario Outline: Access Form
    Given that I am on the signup screen
    When I send the "<name>" and email
    Then I am directed to the registration form
    Examples:
      | name | email |
      | fulano | fulanosilva@uorak.com |

  @signup @create-user
  Scenario Outline: Create user
    Given I am on the signup screen "fulano" and email
    When I send the following details: "<firstName>", "<lasttName>", "<password>", "<dateOfBirth>", "<address>", "<country>", "<state>", "<city>", "<zipCode>", "<mobileNumber>"
    Then I should see success message
    Examples:
      |firstName |lasttName |password |dateOfBirth |address |country |state |city |zipCode |mobileNumber|
      | Fulano | da Silva | 12S3nh@ | 3 August 1990 | Rua dos Bobos | United States | NY | New York | 431861761 | 5581654163264 |