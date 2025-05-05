package hito;

import java.sql.*;

public class Cine {
    public static void mostrarPeliculas() {
        // Obtenemos la conexión a la base de datos
        Conexion conexionBD = new Conexion();
        Connection conexion = conexionBD.conectar();

        // Si la conexión es nula, no se puede continuar
        if (conexion == null) {
            return;
        }

        try {
            // Sentencia SQL para obtener las películas
            String query = "SELECT p.id_pelicula, p.titulo, p.director, p.duracion, g.nombre as genero "
                         + "FROM pelicula p "
                         + "JOIN genero g ON p.id_genero = g.id_genero";

            // Crear el Statement y ejecutar la consulta
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Mostramos los resultados
            while (rs.next()) {
                int idPelicula = rs.getInt("id_pelicula");
                String titulo = rs.getString("titulo");
                String director = rs.getString("director");
                int duracion = rs.getInt("duracion");
                String genero = rs.getString("genero");

                // Mostramos la información de cada película
                System.out.println("ID: " + idPelicula + ", Título: " + titulo + ", Director: " + director + ", Duración: " + duracion + " minutos, Género: " + genero);
            }
        } catch (SQLException e) {
            // Mostramos un mensaje de error
            System.out.println("Error al obtener las películas: " + e.getMessage());
        } finally {
            // Cerramos la conexión
            try {
            	conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
