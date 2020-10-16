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
        -  Cifrado 
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
   
   

   


# Requerimientos Faltantes

 - Base de Datos
    - Data de Muestra
            
- Api
   - Logs de Sesión
   - Autenticación
       - 403 personalizado

       
- Normas
   - El API NO debe de ejecutar DELETE ni borrar registro de la base de datos, debe de marcarlos como
“desactivados”

    - El API debe de tener control de error y devolver los mensajes pertinentes en caso de peticiones
incorrecta/malformadas. NO debe de generar errores 500 sino devolver un mensaje de error 

- Entregable
   - Código fuente completo
   - 1 ejemplo de cada petición 
   - Pasos necesarios a la compilación/implementación
    
- Otros puntos faltantes
   - Comentarios en código
   - Formato


# Bugs para arreglar
   - Get en categorias no muestra id


# Notas

 - Manejo de desactivación?
 - No valida todos los duplicados


 # Referencias
   - https://www.javaguides.net/2018/09/spring-boot-spring-mvc-role-based-spring-security-jpa-thymeleaf-mysql-tutorial.html
   - https://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html
   - https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial
   - https://www.youtube.com/watch?v=QXFgzomuDOg&t=626s
   - https://www.youtube.com/watch?v=TNt3GHuayXs&ab_channel=JavaBrains
   - https://www.youtube.com/watch?v=PHB917iikjk 
   - https://www.youtube.com/watch?v=X80nJ5T7YpE&t=1s
   - https://stackoverflow.com/questions/44404085/hasauthority-method-for-only-post-and-put-httpmethods
   
   
# Autor

Luis Villarreal