Feature: User uses the Swag Labs website
  @RegressionPack
  Scenario Outline: User logins to purchase products and checkouts
    Given User enters username "<username>" and password "<password>" and logs in for Test Case "<testCaseNo>"
    When User adds products to cart
    And User checks outs selected items
    And User enters first name "<firstName>" last name "<lastName>" and zip code "<zipCode>"
    Then User checks Product Price Totals and completes checkout
    Then User Logs Out


    Examples:
      | username          | password      | firstName | lastName  | zipCode | testCaseNo |
      | standard_user     | secret_sauce  | John      |  Doe      | 2001    | 1          |


  @CancelPayment
  Scenario Outline: User logins to purchase products and cancels checkout
    Given User enters username "<username>" and password "<password>" and logs in for Test Case "<testCaseNo>"
    When User adds products to cart
    And User checks outs selected items
    And User enters first name "<firstName>" last name "<lastName>" and zip code "<zipCode>"
    Then User checks Product Price Totals and cancels checkout
    Then User Logs Out


    Examples:
      | username          | password      | firstName | lastName  | zipCode | testCaseNo |
      | standard_user     | secret_sauce  | Jon       |  Doe      | 2001    | 1 |


  @LockedOutUser @NegativeTests
  Scenario Outline: Locked User logins in
    Given Locked user enters username "<username>" and password "<password>" and logs in for Test Case "<testCaseNo>"

    Examples:
      | username        | password     | testCaseNo |
      | locked_out_user | secret_sauce | 1 |

  @IncorrectUserLoginDetails @NegativeTests
  Scenario Outline: User logins in with incorrect Details
    Given Locked user enters username "<username>" and password "<password>" and logs in for Test Case "<testCaseNo>"

    Examples:
      | username        | password     | testCaseNo |
      | locked_out_user | ghfhthff | 1 |


  @IncorrectUserInfo @NegativeTests
  Scenario Outline: User logins to purchase products and checkouts
    Given User enters username "<username>" and password "<password>" and logs in for Test Case "<testCaseNo>"
    When User adds products to cart
    And User checks outs selected items
    And User enters first name "<firstName>" last name "<lastName>" and zip code "<zipCode>"
    Then User checks Product Price Totals and completes checkout
    Then User Logs Out


    Examples:
      | username          | password      | firstName | lastName  | zipCode | testCaseNo |
      | standard_user     | secret_sauce  |  12587    |   57748   | five    | 1          |



  @SortByFilter
  Scenario Outline: Filter by available options
    Given User enters username "<username>" and password "<password>" and logs in for Test Case "<testCaseNo>"
    When User selects to filter 1 by descending order by name "<filterText1>"
    And User selects to filter 2 by ascending order by name "<filterText2>"
    And User selects to filter 3 by ascending order by price "<filterText3>"
    Then User selects to filter 4 by descending order by price "<filterText4>"

    Examples:
      | username        | password     |  filterText1  |    filterText2  |filterText3  |  filterText4  | testCaseNo |
      | standard_user | secret_sauce |  Name (Z to A)  |  Name (A to Z)  |  Price (low to high)  |  Price (high to low)  | 1 |

  @FailureScenarios
  Scenario Outline: User logins to purchase products and checkouts
    Given User enters username "<username>" and password "<password>" and logs in for Test Case "<testCaseNo>"
    When User adds products to cart
    And User checks outs selected items
    And User enters first name "<firstName>" last name "<lastName>" and zip code "<zipCode>"
    Then User checks Product Price Totals and completes checkout
    Then User Logs Out


    Examples:
      | username          | password      | firstName | lastName  | zipCode | testCaseNo |
      | problem_user      | secret_sauce  | Joe       |  Don      | 2001    | 2          |
      | error_user        | secret_sauce  | Jane      |  Doe      | 2001    | 3          |
      | visual_user       | secret_sauce  | Mary      |  Smith    | 2001    | 4          |
