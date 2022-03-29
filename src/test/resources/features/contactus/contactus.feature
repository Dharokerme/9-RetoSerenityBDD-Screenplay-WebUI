Feature:Contactarse con el administrador
  Dado que un usuario quiere contactarse con el administrador
  Cuando envia un mensaje al administrador
  Entonces se debe mostrar un mensaje de exito

  Scenario: Envio correcto del mensaje
    Given que un usuario quiere contactarse con el administrador
    When envia un mensaje al administrador
    Then se debe mostrar un mensaje de exito

  Scenario: Ingreso erroneo de usuario
  Given que un usuario quiere contactarse con el administrador
  When envia un mensaje erroneo al administrador
  Then se debe mostrar un mensaje de error

