# language: es
Característica: Cálculo de factorial válido
  Como usuario de la aplicación
  Quiero ingresar un número entero positivo
  Para obtener el resultado de su factorial

  Antecedentes:
    Dado que la aplicación está en funcionamiento

  Escenario: Calcular el factorial de un número entero positivo
    Dado que ingreso el número 5
    Cuando solicito calcular su factorial
    Entonces veo en pantalla "El factorial de 5 es 120"

  Escenario: Ingreso de número no válido
    Dado que ingreso el número -3
    Cuando solicito calcular su factorial
    Entonces veo un mensaje de error que indica "Ingrese un número entero positivo"

  Escenario: Cálculo mediante función recursiva
    Dado que ingreso el número 4
    Cuando se calcula el factorial internamente
    Entonces la función utilizada debe ser recursiva
    Y el resultado mostrado debe ser "El factorial de 4 es 24"
