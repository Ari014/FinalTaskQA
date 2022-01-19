Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check that the word "рыба" correctly appears in the first paragraph
    Given User opens '<homePage>' page
    And User switches to Russian language
    Then User checks that the text of the first  element, which is the first paragraph, contains '<word>'

    Examples:
      | homePage                            | word |
      | https://www.lipsum.com/            | рыба    |



  Scenario Outline: Check that default setting result in text starting with Lorem ipsum
    Given User opens '<homePage>' page
    When User clicks Generate Lorem Ipsum button
    Then User checks that the first paragraph starts with '<text>'
    Examples:
      | homePage                            | text |
      | https://www.lipsum.com/            | Lorem ipsum dolor sit amet, consectetur adipiscing elit   |



  Scenario Outline: Check that Lorem Ipsum is generated with correct size of words
    Given User opens '<homePage>' page
    And User сlicks on Words button
    And User enters '<amount>' into the number field
    When User clicks Generate Lorem Ipsum button
    Then User checks that the result has '<amountOfWords>' words
    Examples:
      | homePage                            | amount | amountOfWords |
      | https://www.lipsum.com/            | 10      | 10            |
      | https://www.lipsum.com/            | -1      | 5             |
      | https://www.lipsum.com/            | 0       | 5             |
      | https://www.lipsum.com/            | 5       | 5             |
      | https://www.lipsum.com/            | 20      |  20           |


  Scenario Outline: Check that Lorem Ipsum is generated with correct size of bytes
    Given User opens '<homePage>' page
    And User сlicks on Bytes button
    And User enters '<amount>' into the number field
    When User clicks Generate Lorem Ipsum button
    Then User checks that the result has '<amount>' bytes
    Examples:
      | homePage                            | amount |
      | https://www.lipsum.com/            | 10      |
      | https://www.lipsum.com/            | 77     |
      | https://www.lipsum.com/            | 100       |
      | https://www.lipsum.com/            | 5       |
      | https://www.lipsum.com/            | 20      |


  Scenario Outline: Check the checkbox
    Given User opens '<homePage>' page
    And User uncheck Start with Lorem Ipsum checkbox
    When User clicks Generate Lorem Ipsum button
    Then User checks that result no longer starts with '<text>'
    Examples:
      | homePage                           |text |
      | https://www.lipsum.com/            |Lorem ipsum |




  Scenario Outline: Check that randomly generated text paragraphs contain the word "lorem" with probability of more than 40%
    Given User opens '<homePage>' page
    When User clicks Generate Lorem Ipsum button
    Then User checks that result from each paragraph and determine the number of paragraphs containing the '<word>'
    Examples:
      | homePage                           |word|
      | https://www.lipsum.com/            |lorem|


