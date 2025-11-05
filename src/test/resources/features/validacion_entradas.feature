# language: es
Característica: Validación de entradas inválidas
  El sistema debe manejar correctamente los valores no válidos.

  Escenario: Número negativo
    Dado que ingreso el número "-3"
    Cuando solicito calcular el factorial
    Entonces se muestra el mensaje de error "No se permiten números negativos"

  Escenario: Valor no numérico
    Dado que ingreso el valor "abc"
    Cuando solicito calcular el factorial
    Entonces se muestra el mensaje de error "Ingrese un número válido"

  Escenario: Campo vacío
    Dado que no ingreso ningún valor
    Cuando solicito calcular el factorial
    Entonces se muestra el mensaje de error "Debe ingresar un número"
