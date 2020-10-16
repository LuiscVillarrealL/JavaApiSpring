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
        -  Usuarios
        -  Categorias
        -  Productos
        -  Cifrado
        -  Extras
            - permisos_usuario
            - categorias_productos
            
- Api
   - Autenticación
       - Tiempo de Sesión: 10 min
       - Usuario/clave
       
- Normas
   - Api cumple con las convenciones REST de verbo (get/post/put)
   
   

   


# Requerimientos Faltantes

 - Base de Datos
    - Data de Muestra
            
- Api
   - Logs de Sesión
   - Autenticación
       -  Peticiones al api sin autenticación deben de devolver un error 403 (forbidden)
       
- Normas
   - El API NO debe de ejecutar DELETE ni borrar registro de la base de datos, debe de marcarlos como
“desactivados”
    - El API debe de tener control de error y devolver los mensajes pertinentes en caso de peticiones
incorrecta/malformadas. NO debe de generar errores 500 sino devolver un mensaje de error

- Entregable
   - Código fuente completo
   - 1 ejemplo de cada petición 
   - Pasos necesarios a la compilación/implementación
    
- Otros
   - Comentarios en código
   - Formato
   