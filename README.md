
# API Docentes, Convocatoria 1

Este repositorio contiene una API Rest en SpringBoot para la materia de APOO, donde se registran las operaciones de:
-
- Crear Docente
- Obtener todos los docentes creados
- Actualizar Docente
- Eliminar Docente



## Estructura del Repositorio
| Carpeta/Archivo | Descripción |
|---|---|
| `controller/` | Controladores REST |
| `service/` | Lógica de negocio |
| `repository/` | Acceso a datos (JPA) |
| `model/` | Entidades |
| `exception/` | Manejo de excepciones personalizadas |
| `resources/application.properties` | Configuración de la aplicación y base de datos |
| `pom.xml` | Dependencias y configuración de Maven |
| `README.md` | Documentación del proyecto |

## Modelo: Docente

| Atributo         | Tipo   | Descripción                  |
|-------------------|--------|-------------------------------|
| id                | Long   | Identificador único (autogenerado) |
| numeroDocumento   | String | Número del documento de identidad |
| tipoDocumento     | String | Tipo de documento (CC, CE, TI, etc.) |
| nombre            | String | Nombre del docente            |
| apellido          | String | Apellido del docente          |
| email             | String | Correo electrónico            |
| especialidad      | String | Área de especialidad          |

## Reglas de API

- No se puede crear un docente con el mismo `tipoDocumento` y `numeroDocumento` que uno ya existente.
- Al actualizar o eliminar un docente, se valida previamente que exista por su `id`. Si no existe, se devuelve un error 404.

## Endpoints

| Método | Endpoint                  | Descripción                  |
|--------|----------------------------|--------------------------------|
| POST   | /api/v1/docentes          | Crear un nuevo docente        |
| GET    | /api/v1/docentes          | Obtener todos los docentes    |
| GET    | /api/v1/docentes/{id}     | Obtener un docente por ID     |
| PUT    | /api/v1/docentes/{id}     | Actualizar un docente por ID  |
| DELETE | /api/v1/docentes/{id}     | Eliminar un docente por ID    |

## Manejo de excepciones

El proyecto implementa un manejador global de excepciones (`GlobalExceptionHandler`) que captura:

- `DocenteNoEncontradoException`: cuando se busca, actualiza o elimina un docente con un ID inexistente (HTTP 404).
- `DocenteDuplicadoException`: cuando se intenta crear un docente con tipo y número de documento ya registrados (HTTP 409).
- Excepciones generales no controladas (HTTP 500).

Todas las respuestas de error siguen este formato:

```json
{
  "timestamp": "2026-06-20T17:00:00",
  "status": 404,
  "error": "Not Found",
  "mensaje": "Docente no encontrado con ID: 5"
}
```

## Cómo ejecutar el proyecto

1. Clonar el repositorio:
```bash
git clone https://github.com/Jstigerheart/docentes-api
cd docentes-api
```

2. Ejecutar la aplicación:
```bash
./mvnw spring-boot:run
```

3. La aplicación quedará disponible en:
- http://localhost:8082

## Documentación Swagger

Una vez la aplicación esté corriendo, la documentación interactiva está disponible en:
- http://localhost:8082/swagger-ui/index.html

## Consola H2

Para ver los datos almacenados mientras la app está corriendo:
- http://localhost:8082/h2-console

- JDBC URL: `jdbc:h2:mem:docentesdb`
- Usuario: `sa`
- Contraseña: (vacío)

## Autor

- [@Jstigerheart](https://github.com/Jstigerheart)
