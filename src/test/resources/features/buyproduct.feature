Feature: Buy products
  This feature is designed to automate and validate the product purchasing process on the https://opencart.abstracta.us/ platform.

  @BuyProduct
  Scenario Outline: Buy product
    Given the user opens the browser
      | <id> | <archive> | <sheet> |
    When the user selects the product to purchase
    And the user completes the checkout
      | <userType> |
    Then they should verify that the message "Your order has been placed!" is displayed
    Examples:
      | id | archive              | sheet | userType       |
      | 1  | DataBuyProducts.xlsx | Data  | Guest Checkout |

  @CartEmpty
  Scenario Outline: Shooping Cart Empty
    Given the user opens the browser
      | <id> | <archive> | <sheet> |
    When the user selects the shopping cart without adding any products
    Then the user should verify that the correct message is displayed
      | <id> | <archive> | <sheet> |
    Examples:
      | id | archive              | sheet |
      | 2  | DataBuyProducts.xlsx | Data  |


