Feature: Cart

Background:
  Given that I am logged  in home screen

  @cart @add-product-success
  Scenario Outline: Add product to card
    When I add a "<brand>" and "<product>" to cart
    Then I see the success message
    Examples:
      | brand | product |
      | Polo | Premium Polo T-Shirts |

  @cart @verify-product
  Scenario Outline: Check if the product is in the cart
    When I have already added the "<brand>" "<product>" to the cart
    Then I see the chosen "<product>" in the cart
    Examples:
      | brand | product |
      | Polo | Blue Top |