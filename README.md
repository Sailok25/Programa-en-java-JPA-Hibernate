# Proyecto Discográfica y Artistas (Hibernate)

Este proyecto utiliza Hibernate para gestionar una base de datos que contiene información sobre discográficas y artistas. El objetivo es demostrar cómo configurar Hibernate y trabajar con entidades relacionadas en una base de datos.

## Requisitos

- **Java**: Versión 8 o superior
- **Hibernate**: Versión 5.x
- **Base de datos**: MySQL (o la base de datos que prefiera, adaptando la configuración en el fichero `persistence.xml`)
- **Dependencias adicionales**: JPA, el conector de la base de datos correspondiente (por ejemplo, `mysql-connector-java` para MySQL)

## Configuración del proyecto

### Tablas
El esquema de la base de datos incluye las siguientes tablas:

1. **Discográficas (`discografica`)**:
   - `id`: Identificador único de la discográfica (Primary Key).
   - `nombre`: Nombre de la discográfica.
   - `direccion`: Dirección de la discográfica.

2. **Artistas (`artista`)**:
   - `id`: Identificador único del artista (Primary Key).
   - `nombre`: Nombre del artista.
   - `genero`: Género musical del artista.
   - `discografica_id`: Identificador de la discográfica asociada (Foreign Key).

### persistence.xml

El fichero `persistence.xml` configura los datos de conexión y las propiedades de Hibernate. Asegúrese de actualizarlo según sus necesidades.

```xml
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.1">
    <persistence-unit name="discograficaPU">
        <class>com.ejemplo.entidades.Discografica</class>
        <class>com.ejemplo.entidades.Artista</class>

        <properties>
            <!-- Configuración de conexión -->
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://127.0.0.1:3306/discograficaDB" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="password" />

            <!-- Configuración de Hibernate -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.format_sql" value="true" />
        </properties>
    </persistence-unit>
</persistence>
```

## Uso del proyecto

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/usuario/discografica-artistas-hibernate.git
   cd discografica-artistas-hibernate
   ```

2. **Configurar la base de datos**:
   Cree una base de datos llamada `hibernate_project` y configure/adapte los datos de conexión en el archivo `persistence.xml`.

3. **Ejecutar la aplicación**:
   Importe el proyecto en su IDE preferido (NetBeans, IntelliJ IDEA, Eclipse, etc.), compile y ejecute las clases principales.

## Estructura del proyecto

- `src/main/java/com/ejemplo/entidades`:
  Contiene las clases de entidad `Discografica` y `Artista`.
- `src/main/resources/META-INF/persistence.xml`:
  Archivo de configuración para Hibernate.
