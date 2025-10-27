# language: es

Característica: Cálculo del factorial  
Para conocer el factorial de un número entero positivo  
Como usuario de la aplicación  
Quiero ingresar un número entero positivo  
Para obtener el resultado de su factorial

Escenario: Cálculo exitoso del factorial  
Dado que ingreso el número entero positivo "5"  
Cuando se calcula el factorial mediante una función recursiva  
Entonces se muestra en pantalla el mensaje "La factorial de 5 es 120"

Escenario: Cálculo del factorial de cero  
Dado que ingreso el número "0"  
Cuando se calcula el factorial mediante una función recursiva  
Entonces se muestra en pantalla el mensaje "La factorial de 0 es 1"

Escenario: Número negativo no permitido  
Dado que ingreso el número "-3"  
Entonces se muestra un mensaje de error indicando que solo se aceptan enteros positivos

Escenario: Número fuera del rango permitido  
Dado que ingreso un número mayor al máximo permitido por tipo long  
Entonces se muestra un mensaje de error indicando que el número excede el rango permitido

