# Plataforma de Gestión de Proyectos
Aplicación web de gestión de proyectos y tareas inspirada en Jira, enfocada en modelar lógica real de trabajo en equipo: estados, dependencias, roles y métricas.
Proyecto desarrollado como portfolio profesional fullstack.

## Objetivo
<ul> <li>Gestionar proyectos y tareas</li> <li>Visualizar el flujo de trabajo mediante tableros Kanban</li> <li>Definir dependencias entre tareas</li> <li>Medir el progreso del equipo</li> <li>Controlar accesos mediante roles</li> </ul>

## Tecnologías
### Backend
Spring Boot + Java
<ul> <li>API REST estructurada y escalable</li> <li>Arquitectura modular con capas (Controller, Service, Repository)</li> <li>Separación clara de responsabilidades</li> </ul>
Autenticación
<ul> <li>JWT (access + refresh tokens)</li> <li>Roles y permisos por proyecto</li> </ul>
Base de datos
<ul> <li>PostgreSQL</li> <li>Modelo relacional con relaciones complejas y transacciones</li> </ul>
ORM
<ul> <li>Spring Data JPA / Hibernate</li> <li>Migraciones con Flyway o Liquibase</li> </ul>
Otros
<ul> <li>Swagger/OpenAPI para documentación</li> <li>Docker para despliegue</li> </ul>

### Fronted
React
Angular
<ul> <li>SPA moderna y estructurada</li> <li>Componentes reutilizables</li> <li>Modules y Services para arquitectura limpia</li> </ul>
TypeScript
<ul> <li>Tipado estricto y mantenibilidad</li> </ul>
UI
<ul> <li>Angular Material para componentes base</li> <li>Estilos personalizados y responsive</li> </ul>
Estado
<ul> <li>Services / Signals para manejo de estado</li> <li>NGRX opcional para escalabilidad enterprise</li> </ul>
Kanban
<ul> <li>Drag & drop con Angular CDK</li> </ul>
Métricas
<ul> <li>Gráficos con Chart.js o Recharts</li> </ul>

## Funcionalidades principales
<ul> <li>Autenticación de usuarios con roles por proyecto</li> <li>Gestión de proyectos y miembros</li> <li>Boards Kanban configurables</li> <li>Tareas con estados, prioridades, fechas límite y asignación de responsables</li> <li>Dependencias entre tareas con bloqueo automático y validación de ciclos</li> <li>Métricas de progreso del equipo y tiempo en cada estado</li> <li>Documentación de API con Swagger</li> </ul>

## Arquitectura general
<ul> <li>Backend desacoplado con API REST</li> <li>Frontend como SPA independiente</li> <li>Separación de responsabilidades clara y escalable</li> <li>Validaciones y control de permisos gestionados en backend</li> </ul>

## Roadmap
<ul> <li>Autenticación y gestión de usuarios</li> <li>Proyectos y roles</li> <li>Boards y tareas</li> <li>Dependencias entre tareas</li> <li>Métricas y dashboards</li> <li>Tests unitarios y de integración</li> <li>Despliegue en producción con Docker</li> </ul>
