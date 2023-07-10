@smoke @regression
Feature: Testing Login Functionality for OpenMrs

#  Scenario: Positive Login Functionality(Happy Path)
#    Given User provides the username and password with 'Inpatient Ward'
#    Then User validates the 'Home' and 'https://demo.openmrs.org/openmrs/referenceapplication/home.page'

  Scenario Outline: Negative Login Functionality
    Given User provides '<username>' and '<password>' with '<location>'
    Then User validates the 'Invalid username/password. Please try again.'
    Examples:
      | username  | password  | location          |
      | admin     | asdasd    | Inpatient Ward   |
      | retrte    | Admin123  | Isolation Ward    |
      | adsf      | sfffd     | Laboratory        |
      |           |           | Outpatient Clinic |
      | ^&*(*&$$# | ^&*(*&$$# | Pharmacy          |
      | ADMIN     | ADMIN123  | Registration Desk |


