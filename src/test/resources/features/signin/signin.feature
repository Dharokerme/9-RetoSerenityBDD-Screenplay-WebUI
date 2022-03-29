Feature:Ingresar al sistema
  Dado que existe un usuario
  Cuando ingresa al sistema
  Entonces deberia ver el mensaje de bienvenida

  Scenario: Loggin de usuario
    Given que el usuario se encuentra en la pagina de inicio
    When ingresa al sistema
    Then deberia ver el mensaje de bienvenida

  Scenario: Loggin erroneo de usuario
    Given que el usuario se encuentra en la pagina de inicio
    When ingreso al sistema incorrectamente
    Then deberia ver el mensaje de error
