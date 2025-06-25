package AplicationProperties;

# Configuración del DataSource
spring.datasource.url=jdbc:h2:mem:examendb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuración de JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
# create-drop: crea el schema al iniciar y lo borra al terminar. Ideal para pruebas y exámenes.
spring.jpa.hibernate.ddl-auto=create-drop
# Muestra el SQL generado en la consola (muy útil para depurar)
spring.jpa.show-sql=true

# Habilitar la consola web de H2
spring.h2.console.enabled=true
# La ruta para acceder a la consola H2 (ej: http://localhost:8080/h2-console)
spring.h2.console.path=/h2-console
