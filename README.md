PERFULANDIA SPA

Proyecto de microservicios desarrollado para la asignatura Desarrollo FullStack I.

Perfulandia SPA es una empresa que necesita mejorar su sistema actual, ya que el crecimiento de sus sucursales y clientes hizo que el sistema monolítico comenzara a tener problemas de rendimiento y disponibilidad.

Para solucionar esto, se desarrollan microservicios separados, donde cada uno se encarga de una parte específica del sistema.


MICRO SERVICIOS DESARROLLADOS

En este proyecto se trabajaron los siguientes microservicios:

- tiendas-service
- inventario-catalogo-service
- soporte-resena-service


DESCRIPCION DE LOS SERVICIOS

tiendas-service

Se encarga de gestionar las tiendas o sucursales de Perfulandia.

Puerto:

8081

Ruta principal:

/api/v1/tiendas

Permite listar, buscar, registrar, actualizar, eliminar y cambiar el estado de una tienda.


inventario-catalogo-service

Se encarga de gestionar los productos del catálogo.

Puerto:

8082

Ruta principal:

/api/v1/productos

Permite listar, buscar, registrar, actualizar y eliminar productos. También permite filtrar productos por tienda, categoría y disponibilidad.

Este servicio se comunica con tiendas-service para validar que una tienda exista antes de asociarle un producto.


soporte-resena-service

Se encarga de gestionar las reseñas y calificaciones de productos.

Puerto:

8083

Ruta principal:

/api/v1/resenas

Permite listar, buscar, registrar, actualizar y eliminar reseñas. También permite filtrar reseñas por producto, por calificación y por estado activo.

Este servicio se comunica con inventario-catalogo-service para validar que un producto exista antes de registrar una reseña.


TECNOLOGIAS UTILIZADAS

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Validation
- JUnit
- Mockito
- Swagger / OpenAPI
- Git y GitHub


ARQUITECTURA

Los microservicios siguen una estructura por capas:

Controller -> Service -> Repository -> Model / DTO

Cada capa cumple una función dentro del proyecto:

- controller: recibe las solicitudes HTTP
- service: contiene la lógica del negocio
- repository: se comunica con la base de datos
- model: representa las tablas de la base de datos
- dto: se usa para enviar y recibir datos
- exception: maneja errores del sistema
- config: contiene configuraciones como Swagger o RestTemplate


BASES DE DATOS

Cada microservicio usa su propia base de datos en MySQL.

- perfulandia_tiendas_db
- perfulandia_inventario_catalogo_db
- perfulandia_soporte_resena_db

SWAGGER

Cada microservicio tiene documentación con Swagger.

- tiendas-service: http://localhost:8081/swagger-ui/index.html
- inventario-catalogo-service: http://localhost:8082/swagger-ui/index.html
- soporte-resena-service: http://localhost:8083/swagger-ui/index.html

En Swagger se pueden revisar los endpoints, parámetros, ejemplos de JSON y respuestas HTTP.


PRUEBAS UNITARIAS

El proyecto incluye pruebas unitarias para los servicios y controladores.

Para ejecutar las pruebas, se debe entrar a cada microservicio y usar:

.\mvnw.cmd test

Resultado esperado:

BUILD SUCCESS
Failures: 0
Errors: 0
Skipped: 0


EJECUCION LOCAL

Para ejecutar el proyecto se debe tener MySQL iniciado.

Luego, se levanta cada microservicio por separado con:

.\mvnw.cmd spring-boot:run

No se utiliza Docker en esta evaluación.


API GATEWAY

Las rutas esperadas para integrarse con Gateway son:

- /api/v1/tiendas
- /api/v1/productos
- /api/v1/resenas


ESTADO ACTUAL

El proyecto cuenta con:

- microservicios funcionales
- CRUD en los servicios principales
- conexión con MySQL
- validaciones
- comunicación entre microservicios
- manejo de errores
- pruebas unitarias
- documentación Swagger