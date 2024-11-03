package ConexionB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Denis Peralta
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  Conectar{

    private Connection connection;
    private String url;
    private String user;
    private String password;

    public Conectar() {
       
    }

  
    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // conectar a la base de datos
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

    // cerrar la conexión
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

    // para obtener la conexión y ejecuta una consulta SQL que cuenta los registro
    public Connection getConnection() {
        return connection;
    }
}
