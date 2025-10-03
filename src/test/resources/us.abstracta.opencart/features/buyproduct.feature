Feature: Buy products
  This feature is designed to automate and validate the product purchasing process on the https://opencart.abstracta.us/ platform.

  Scenario Outline: Buy product
    Given the user opens the browser
      | <browser> |
    When the user selects the product to purchase
    And the user completes the checkout
      | <userType> |
    Then they should verify that the message "Your order has been placed!" is displayed
    Examples:
      | browser | userType       |
      | chrome  | Guest Checkout |


