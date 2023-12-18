# Manual de Usuario - Entrega 3 Taller de Bases de Datos

Bienvenido/a al manual de usuario para la aplicación de la entrega 3 del laboratorio de Taller de Bases de Datos.

## Requisitos de Instalación

### 1. Base de Datos (MongoDB):

- MongoDB (versión 4.4+)
- MongoDB Compass

### 2. Backend (API RESTful en Spring):

- JDK (Versión 17)
- IntelliJ IDEA (para backend)
- Postman



## Instrucciones de Configuración

### 2.1 Configuración de la Base de Datos:

1. Abre MongoDB Compass y conecta con tu servidor de MongoDB.
2. Crea una nueva base de datos con el nombre: TBD.

Luego, con los siguientes scripts ubicados en la carpeta 'LAB3', haz lo siguiente:

3. Abrir el archivo 'dbload.txt', copiar el contenido para cada colección (están señalados ahí mismo).
4. En MongoDB Compass, crear las colecciones 'tarea' y 'voluntario'.
5. Dirigirse a cada colección y elegir la opción 'add data' - 'insert document' y pegar el contenido respectivo.


### 2.2 Ejecutar el Backend:

1. Ejecuta el backend a través de IntelliJ para habilitar el servidor. Para esto, debes dirigirte a lab2-TBD/lab1/src/main/java/com/tbd/lab1 - abrir el archivo Lab1Application.java, instalas el JDK adecuado y aprietas la opción "Build". A continuación, usas la opción de "Run" (shift + F10) y listo. El backend ahora está ejecutándose.

2. En caso de querer evaluar cada cosa, es posible utilizar postman ahora, mientras el backend está ejecutándose, por medio de las siguientes rutas:

--localhost:8081/api/tareas
--localhost:8081/api/voluntarios

Ya cada ruta podría variar dependiendo de lo que se desee realizar, por lo que se recomienda revisar las rutas asignadas en los controllers de cada colección.
