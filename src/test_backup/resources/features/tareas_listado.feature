Característica: Gestión unificada de errores de entrada
  Antecedentes:
    Dado que la lógica de factorial valida que "n" no sea negativo
    Y la interfaz captura las excepciones generadas por la lógica
    Y existen los mensajes configurados:
      | codigo | mensaje                              |
      | NEG    | "No se permiten números negativos"   |
      | VAC    | "Debe ingresar un valor"            |
      | INV    | "Ingrese solo números enteros"      |

  Escenario: Rechazar número negativo
    Cuando ingreso "-5" en el formulario de cálculo
    Entonces veo el mensaje "No se permiten números negativos"
    Y el mensaje se muestra en el componente de error visible en Azure y en local

  Escenario: Rechazar campo vacío
    Cuando dejo vacío el campo de entrada
    Entonces veo el mensaje "Debe ingresar un valor"
    Y el mensaje se registra en las pruebas automatizadas bajo "src/test/java"

  Escenario: Rechazar caracteres no numéricos
    Cuando ingreso "abc" en el formulario de cálculo
    Entonces veo el mensaje "Ingrese solo números enteros"
    Y la interfaz evita iniciar el cálculo del factorial
