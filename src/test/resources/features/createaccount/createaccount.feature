Feature:Crear un usuario
  Dado un cliente nuevo
  Cuando ingresa los datos de registro
  Entonces puede crear una cuenta

  Scenario: Registro correcto de usuario
  Given el usuario se encuentra en la pagina de inicio
  When ingreso sus datos de registro correctamente
  Then deberia ver el mensaje de bienvenida

  Scenario: Registro incorrecto de usuario ya existente
  Given el usuario se encuentra en la pagina de inicio
  When ingresa un correo ya existente
  Then deberia ver un mensaje de error
