# language: es
Característica: Autenticación de usuario
  Para acceder a mis recursos necesito poder iniciar sesión.

  Escenario: Inicio de sesión exitoso
    Dado un usuario registrado "alice" con contraseña "s3cr3t"
    Cuando intento iniciar sesión con usuario "alice" y contraseña "s3cr3t"
    Entonces el acceso es concedido
    Y el estado de sesión es "autenticado"

  Escenario: Inicio de sesión rechazado por clave incorrecta
    Dado un usuario registrado "bob" con contraseña "123456"
    Cuando intento iniciar sesión con usuario "bob" y contraseña "xxxx"
    Entonces el acceso es denegado con mensaje "Credenciales inválidas"
