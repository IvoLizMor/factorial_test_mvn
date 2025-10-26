# language: es
Característica: Alta de tareas
  Escenario: Crear tarea válida
    Dado que estoy autenticado como "alice"
    Cuando creo una tarea con título "Preparar informe"
    Entonces la tarea existe en mi lista
    Y su estado es "pendiente"

  Escenario: Impedir crear tarea sin título
    Dado que estoy autenticado como "alice"
    Cuando intento crear una tarea con título ""
    Entonces se muestra un error "Título requerido"
