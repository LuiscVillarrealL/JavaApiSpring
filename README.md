# Java Api



# Dependencias y Herramientas
 - Java: 11
 - Spring Boot: 2.0.4
 - Hibernate 5.4.21
 - Dependencias: Web, JPA, MSSQL, Security
 - Java IDE (Eclipse,  IntelliJ, netbeans, etc)
 - SQL Server 2019
 
# Requerimientos Completos

 - Base de Datos
    - Script de Base de datos
        -  Tabla Usuarios
        -  Tabla Categorias
        -  Tabla Productos
	-  Data de Muestra (se creó data de muestra con https://www.mockaroo.com/ y se cifraron las contraseñas con python antes de ingresar. No se ingresaron fechas)
        -  Cifrado (Cifra/decifra los pass desde post/get)
        -  Extras
            - Tabla permisos_usuario
            - Tabla categorias_productos
            
- Api
   - Autenticación
       - Tiempo de Sesión: 10 min
       - Usuario/clave 
       - 403 default


- Control de Sesión
	- Los usuarios autenticados esta divididos en dos grupos
		- Usuarios
			- Pueden consultar todos los servicios (get), excepto el registro de usuarios
			- Pueden Modificar (post/put) todos los registros, excepto el registro de usuario
		-  Administradores
			- Pueden consultar todos los servicios (get)
			- Pueden modificar todos los registros (post/put)
			


       
- Normas
   - Api cumple con las convenciones REST de verbo (get/post/put)
   - Desactiva por PUT en funcionamiento (PUT de usuario bugged)
   
   - Entregable
   	- 1 ejemplo de cada petición (respuestas) 
        - Pasos necesarios a la compilación/implementación


   


# Requerimientos Faltantes

    
            
- Api
   - Logs de Sesión
   - Autenticación
       - 403 personalizado

       
- Normas

   - NO debe de generar errores 500 sino devolver un mensaje de error. (faltan las de los productos)


- Entregable
   - Código fuente completo
   - 1 ejemplo de cada petición (respuestas) 
   - Mejorar pasos de manual (agregar imagenes, troubleshooting,.. )

    

- Otros puntos faltantes
   - Mejorar comentarios en código
   - Mejorar formato



# Bugs para arreglar
   - Get en categorias no muestra id
   - Arreglar PUTs 


# Notas
 - No valida todos los duplicados

# Como instalar

 - Bajar el proyecto
	- Por zip:
	   - Bajar zip y descomprimir
	   
	- Por  git bash:
	
```sh
$ git clone https://github.com/LuiscVillarrealL/JavaApiSpring.git
```

   - Abrir un Java IDE (Eclipse,  IntelliJ, netbeans, etc) e importar como proyecto maven
   - Abrir sql server management studio, conectarse y correr los queries. Correr primero los queries de base de datos.
   - En el ide, abrir el archivo: src/main/resources/application.properties
   - Cambiar los datos de la base de datos si es necesario
   
```sh
spring.datasource.url=jdbc:sqlserver://localhost;databaseName=PruebaTecnica
spring.datasource.username=sa
spring.datasource.password=admin123!
```

 -Hacer click derecho en com.pruebatecnica.app/AppApplication.java y elegir run as > spring boot app
 

 






 # Referencias
   - https://www.javaguides.net/2018/09/spring-boot-spring-mvc-role-based-spring-security-jpa-thymeleaf-mysql-tutorial.html
   - https://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html
   - https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial
   - https://www.youtube.com/watch?v=QXFgzomuDOg&t=626s
   - https://www.youtube.com/watch?v=TNt3GHuayXs&ab_channel=JavaBrains
   - https://www.youtube.com/watch?v=PHB917iikjk 
   - https://www.youtube.com/watch?v=X80nJ5T7YpE&t=1s
   - https://stackoverflow.com/questions/44404085/hasauthority-method-for-only-post-and-put-httpmethods
   - https://www.youtube.com/watch?v=YW5AqKI9w-0
   - https://www.mockaroo.com/
   
   
# Autor

Luis Villarreal
