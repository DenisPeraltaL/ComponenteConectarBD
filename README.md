# ComponenteConectarBD
*Componente para conectar un proyecto a una base de datos en MySQL*
Equipo 14
Rodriguez Alavés Alejandro
Peralta López Denis

## Instalación del Componente en NetBeans
1. Descarga del Proyecto:

Para comenzar, descarga el proyecto comprimido en formato ZIP desde el repositorio.

![1](https://github.com/user-attachments/assets/ce2f136d-6875-40d0-a028-323b7cdee6f2)

2. Importación del Proyecto en NetBeans:

Abre NetBeans y dirígete a la pestaña *File* en la barra de menú.
Selecciona *Import Project* y luego haz clic en *From ZIP....*

![Captura de pantalla 2024-11-02 233822](https://github.com/user-attachments/assets/eaf226c6-6ac3-4629-bb97-0b63cd512b5a)

Aparecerá una ventana emergente. En el campo *ZIP File*, haz clic en *Browse* y localiza el archivo ZIP que descargaste.

![Captura de pantalla 2024-11-02 234114](https://github.com/user-attachments/assets/abd5e113-25b2-4610-b144-8b62ec45411a)

Finalmente haz clic en import.

3. Limpieza y Construcción del Proyecto:

Después de importar el proyecto, haz clic derecho sobre el nombre del proyecto en el panel de proyectos y selecciona *Clean and Build*.

![Captura de pantalla 2024-11-02 234714](https://github.com/user-attachments/assets/6239fd60-7f87-4c5c-816b-5e7d1208e21c)
![Captura de pantalla 2024-11-03 000042](https://github.com/user-attachments/assets/abed46bc-0f08-4a9d-a541-bd85eaec519b)

Este paso generará un archivo .JAR. Para verificar su ubicación, consulta el apartado Output en la parte inferior de la ventana de NetBeans. Toma nota de la ruta donde se ha guardado el archivo.

4. Adición del Componente a la Palette:

En NetBeans, ve a la pestaña *Tools* y selecciona *Palette*. Luego, elige *Swing/AWT Components*.

![Captura de pantalla 2024-11-03 000224](https://github.com/user-attachments/assets/120275fb-32a9-446e-a377-efa1e4daf931)

Se abrirá una nueva ventana. Haz clic en *Add from JAR...* para buscar el archivo .JAR que generaste en el paso anterior.

![Captura de pantalla 2024-11-03 000316](https://github.com/user-attachments/assets/73cbca3f-15b1-41a1-93d3-38f255f0f13a)

Una vez que localices el archivo .JAR, haz clic en *Next*.

![Captura de pantalla 2024-11-03 000455](https://github.com/user-attachments/assets/fad1bf9b-fb56-4269-8b02-72dc55af6a8f)
![Captura de pantalla 2024-11-03 003021](https://github.com/user-attachments/assets/806b3449-2452-4e6b-a09b-9f140e083cb6)

Selecciona el componente *Conectar* y de nuevo haz clic en *Next*

5. Configuración en la Palette:

A continuación, se te pedirá que elijas la categoría en la que deseas que aparezca el nuevo componente en la Palette.
Selecciona la opción adecuada y luego haz clic en Finish.

![Captura de pantalla 2024-11-03 000716](https://github.com/user-attachments/assets/24e6a6b6-1d67-47da-88f1-33a25627da36)

Si todos los pasos se realizaron correctamente, el componente debería ser visible en la sección de Palette al crear un nuevo JForm.

![Captura de pantalla 2024-11-03 001423](https://github.com/user-attachments/assets/8101d0a8-3ec5-44b0-b234-adf0295a1b02)

------------


## Explicación del codigo del componente:
El componente `Conectar` fue diseñado para facilitar la conexión a una base de datos MySQL. 

#### Estructura de la Clase

**Importaciones:**

`java.sql.Connection`: Proporciona la interfaz para establecer una conexión con la base de datos.

`java.sql.DriverManager`: Maneja el registro de controladores y la creación de conexiones a la base de datos.

`java.sql.SQLException`: Maneja las excepciones que pueden ocurrir durante las operaciones de acceso a la base de datos.


**Atributos**

`private Connection connection;`: Este atributo almacena la conexión a la base de datos.

`private String ur;`: Almacena la URL de la base de datos a la que se conectará.

`private String user;`: Contiene el nombre de usuario para autenticar la conexión.

`private String password;`: Almacena la contraseña del usuario.


**Métodos**

Métodos de Configuración:

- Método `setUrl(String url)`: Establece la URL de la base de datos.

- Método `setUser(String user)`: Define el nombre de usuario para la conexión.

- Método `setPassword(String password)`: Asigna la contraseña del usuario.


- Método `conectar()`:

Este método se encarga de establecer la conexión a la base de datos. 

```java
    public void conectar() {
        if (url == null || user == null || password == null) {
            throw new IllegalStateException("La URL, usuario o contraseña no han sido configurados.");
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion exitosa a MySQL");
        } catch (SQLException e) {
            System.err.println("Error de conexion: " + e.getMessage());
        }
    }
```

Si la URL, el usuario y la contraseña es null, lanza una excepción IllegalStateException.
Se utiliza DriverManager.getConnection(url, user, password) para establecer la conexión y notifica si la conexión fue exitosa o si ocurrió un error mediante un try-catch.


- Método `cerrarConexion()`:

Este método cierra la conexión a la base de datos si está abierta.

```java
    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar conexion: " + e.getMessage());
        }
    }
```

Se utiliza un bloque try-catch para manejar cualquier error que pueda ocurrir al intentar cerrar la conexión. Si la operación es exitosa, muestra un mensaje confirmando que la conexión ha sido cerrada; si ocurre un error, muestra un mensaje detallando el problema.
Si la conexión ya está cerrada, no realiza ninguna acción.

- Método `getConnection()`:

Devuelve la conexión activa, permitiendo que otras partes del programa interactúen con la base de datos a través de esta conexión.

```java
    public Connection getConnection() {
        return connection;
    }
```

------------

## Uso del Componente en un JForm en NeatBeans

Para usar el componente, crea un nuevo formulario (JForm) y busca el componente en la Palette.
Arrastra el componente desde la Palette hacia tu panel de diseño para integrarlo en tu interfaz.
En la parte de *Other components* podremos ver que se ha agregado nuestro componente.

![Captura de pantalla 2024-11-03 012036](https://github.com/user-attachments/assets/215b26db-04a1-44ee-b915-ba7bccfc1d75)

## Prueba de la base de datos

![Captura de pantalla 2024-11-03 012650](https://github.com/user-attachments/assets/dd1567f9-c98a-41a0-b256-18a47359f683)

## VIDEO

https://github.com/user-attachments/assets/71ab22e4-64ce-439d-bccf-81fa62dd9438





