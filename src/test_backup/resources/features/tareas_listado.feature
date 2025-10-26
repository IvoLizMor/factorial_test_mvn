# language: es
Característica: Listado y filtro de tareas
  Antecedentes:
    Dado que estoy autenticado como "alice"
    Y existen las tareas:
      | titulo             | estado     |
      | Preparar informe   | pendiente  |
      | Enviar correo      | completada |

  Escenario: Listar solo mis tareas
    Cuando consulto mis tareas
    Entonces veo 2 tarea(s)

  Escenario: Filtrar por estado "pendiente"
    Cuando filtro mis tareas por "pendiente"
    Entonces veo 1 tarea(s)
