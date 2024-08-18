# Examen de Gestión de Personas y Habilidades

Este proyecto es una aplicación de consola en Java diseñada para gestionar un sistema de personas y habilidades utilizando arquitectura hexagonal, vertical slicing, principios de programación orientada a objetos (POO), SOLID y JDBC. El objetivo es proporcionar una solución robusta y escalable para la administración de personas y sus habilidades mediante operaciones CRUD básicas.

## Descripción del Proyecto

La aplicación permite gestionar personas y habilidades, ofreciendo funcionalidades para crear, actualizar, buscar y eliminar tanto personas como habilidades. La arquitectura hexagonal garantiza una separación clara entre la lógica de negocio y las interfaces externas, mientras que JDBC se utiliza para la persistencia de datos.

## Características

- **Crear Persona**: Permite ingresar los detalles de una nueva persona y almacenarlos en la base de datos.
- **Buscar Persona por Skill**: Busca personas basándose en un ID de habilidad.
- **Actualizar Persona**: Actualiza la información de una persona existente.
- **Eliminar Persona**: Elimina una persona de la base de datos por su ID.
- **Asignar Skill a Persona**: Asigna una habilidad a una persona con validación de fecha y existencia de habilidad.
- **Crear Skill**: Permite crear nuevas habilidades en el sistema.

## Arquitectura

El proyecto sigue una arquitectura hexagonal, separando la lógica de negocio de la interacción con la base de datos y la interfaz de usuario. La arquitectura vertical slicing permite una organización clara y modular del código, facilitando la expansión y el mantenimiento.

### Componentes Principales

- **PersonConsoleAdapter**: Adaptador de consola que gestiona la entrada del usuario para operaciones relacionadas con personas.
- **Person_SkillsConsoleAdapter**: Adaptador de consola que gestiona la entrada del usuario para asignar habilidades a personas y crear habilidades.
- **PersonService**: Servicio de aplicación que contiene la lógica de negocio relacionada con la gestión de personas.
- **Person_skillsService**: Servicio de aplicación que maneja la asignación de habilidades a personas.
- **SkillService**: Servicio de aplicación para la gestión de habilidades.
- **Person**: Entidad que representa a una persona en el sistema.
- **Persons_skills**: Entidad que representa la relación entre personas y habilidades.
- **Skill**: Entidad que representa una habilidad en el sistema.

## Requisitos

- Java 17 o superior
- JDBC
- MySQL u otra base de datos compatible

## Uso

- **Crear Persona**: Selecciona la opción para crear una persona y sigue las instrucciones en la consola.
- **Buscar Persona por Skill**: Ingresa el ID de la habilidad para encontrar personas asociadas a esa habilidad.
- **Actualizar Persona**: Ingresa el ID de la persona que deseas actualizar y proporciona los nuevos datos.
- **Eliminar Persona**: Ingresa el ID de la persona que deseas eliminar.
- **Asignar Skill a Persona**: Ingresa el ID de la persona y la habilidad, junto con la fecha de asignación en formato `dd-MM-yyyy`. Se realiza una validación para asegurar la correcta asignación.
- **Crear Skill**: Ingresa los detalles de la nueva habilidad para agregarla al sistema.

## Validación de Errores

- **Fecha Inválida**: Se valida que la fecha de asignación esté en el formato `dd-MM-yyyy`. Si el formato es incorrecto, se muestra un mensaje de error.
- **Persona No Encontrada**: Se valida que la persona exista en el sistema antes de realizar operaciones.
- **Skill No Encontrada**: Se valida que la habilidad exista en el sistema antes de asignarla.
