Feature: Aday öğrenciler sisteme kayıt olabilmelidir.

  Scenario Outline: US01_GuestUser

    Given "<username>" ile guest useri cagir
    Then body sunlari icermeli: "<name>", "<surname>", "<birthplace>", "<phone>", "<gender>", "<Date Of Birth>", "<ssn>","<username>","<password>"
    Examples:
      | username | name | surname | birthplace | phone        | gender | Date Of Birth | ssn         | password |
      | john129  | John | Doe     | Ankara     | 333-555-1234 | 0      | 2023-06-01    | 333-66-0987 | John.123 |