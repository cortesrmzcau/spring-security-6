## Hello World! 👋

🤩 Práctica del [Curso: Spring security 6 Desde las bases hasta OAUTH2 y JWT](https://www.udemy.com/course/spring-security-6-desde-las-bases-hasta-oauth2-y-jwt/>)

![](https://github.com/cortesrmzcau/cortesrmzcau/blob/main/examples/spring-security-6/1.png?raw=true)

-------------

### ⚙ Tecnologías aplicadas

[![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white&labelColor=101010)]()
[![SpringBoot](https://img.shields.io/badge/SpringBoot-3DDC84?style=for-the-badge&logo=spring&logoColor=white&labelColor=101010)]()
[![Postgresql](https://img.shields.io/badge/Postgresql-007396?style=for-the-badge&logo=postgresql&logoColor=white&labelColor=101010)]()
[![Docker](https://img.shields.io/badge/Docker-1d63ed?style=for-the-badge&logo=docker&logoColor=white&labelColor=101010)]()

-------------
### 🚀 Resumen

### Sección 2

* UserDetailService se encarga de cargar cualquier usuario de una base de datos mediante el username.
    * Sirve para aplicaciones pequeñas.
* InMemoryUserDetailsManager sirve para cambiar la contraseña del usuario ADMIN y USER de la contraseña que viene por default.
    - Sirve para pruebas pequeñas cuando se este implementando seguridad.

### Sección 3

* Encrypt: Es una técnica de codificación en la que un mensaje se codifica mediante el uso de un algoritmo de cifrado de tal manera que el personal autorizado pueda acceder al mensaje o información. Los algoritmoas más comunes son el AES y ESA.
* Encode: Transformar los datos en una forma que sea legible por la mayoría de los sistemas o que pueda ser utilizada por cualquier proceso externo. No se puede usar para proteger datos. Los algoritmos más comunes son ASCII, BASE64 y UNICODE.
* Hashing: Los datos se convertiran en hash mediante alguna función hash, que puede ser cualquier número generado a partir de una cadena o texto. La función del hash siempre va dar el mismo resultado. Los datos una vez que se cifran, no son reversibles. Los algoritmos más comunes son MD5 y SHA256.

### Sección 4

* AuthenticationProvider: Procesa la solicitud de autenticación y retorna un objeto autenticado con credenciales.

### Sección 5

* CORS: Mecanismo que permite al servidor indicar que dominio, esquema o puerto con un origen distinto del suyo desde el navegador debería permitir la carga de recursos.
* CSRF: Tipo de vulneravilidad en un sitio web en el que comandos no autorizados son enviados por un usuario en el cual el sitio web confía.

### Sección 6

* Autenticacion: Valida lo que el usuario dice ser, debe autenticarse antes de recibir una autorización, necesita credenciales y si algo falla retorna un status 401.
* Autorizacion: Otorga acceso específico a un usuario, se realiza después de autenticarse, necesita roles o privilegios y si algo falla retorna un 403.
* Autorities / Roles: Son almacenados en el objeto GrenteAutority que solo tiene el método getAuthority() y este regresa el nombre del privilegio o role.
  * Authority: Permiso individual, ejemplo VIEW_ACCOUNT.
  * Role: Es un grupo de permisos, ejemplo ROLE_ADMIN.
* SimpleGrantesAuthority: Es la implementación por defecto de spring security que extiende de GreantedAuthority tenemos el método getAutorithy el cual se utiliza para construir el objeto Authenticacion.

Los privilegios(Authorities) pueden ser almacenados de la siguiente forma:
  hasAuthority: Regresa true si el usuario principal tiene el privilegio indicado.
  hasAnyAuthority: Regresa un true si el usuario prinipal tiene alguno de los privilegios indicados.
  access(): Asignas privilegios usando AND, OR y poder condicionar accesos.

### Sección 7

* En una app web de java, el contenedor servlet (servidor web) se encarga de traducir los mensajes http para que java los entienda. El servlet container transforma los mensajes http a Servlet request para poder ser recibidos como un objeto de java. De manera similar, Servlet response regresa como salida a servlet container desde el servlet, entonces todo lo que se escribe esta impulsado por servlet
* Los friltros dentro de las aplicaciones java se pueden usar para interceptar cada solicitud como respuesta para realizar un trabajo previo a nuestra lógica comercial. Spring security aplica la seguridad en función dentro de nuestras configuraciones web.

### Sección 7

* Se realiza la implementación y acceso a controllers de acuerdo con el JWT. 

-------------

### Encuéntrame

[![LinkedIn](https://img.shields.io/badge/LinkedIn-cesar_augusto_cortes_ramirez-0077B5?style=for-the-badge&logo=linkedin&logoColor=white&labelColor=101010)](https://www.linkedin.com/in/cortesrmzcau)

[![Platzi](https://img.shields.io/badge/Platzi-cesar_augusto_cortes_ramirez-0aeb8b?style=for-the-badge&logo=platzi&logoColor=white&labelColor=101010)](https://platzi.com/p/cortesrmzca)

[![LinkedIn](https://img.shields.io/badge/Udemy-cesar_augusto_cortes_ramirez-a435f0?style=for-the-badge&logo=Udemy&logoColor=white&labelColor=101010)](https://www.udemy.com/user/cesar-augusto-cortes-ramirez)

[![Behance](https://img.shields.io/badge/Behance-cesar_augusto_cortes_ramirez-0056ff?style=for-the-badge&logo=Behance&logoColor=white&labelColor=101010)](https://www.behance.net/cortesrmzca)