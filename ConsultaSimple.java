package cursos;

import java.sql.*;

import java.util.*;

public class ConsultaSimple extends ConsultaConResultado<Properties> {
    /**
     * Obtiene los profesores ordenados por apellido1
     *
     * @param conn La conexion ya abierta
     * @param data o bien ASC o bien DESC (debe ser case-insentive)
     * @throws BBDDException, cuando `data` sea distinto de ACS y DESC.
     * @throws SQLException,  cuando se produzca la misma al ejecutar
     *                        modificar la tabla.
     */
    @Override
    public void run(Connection conn, String data) throws BBDDException, SQLException {
        data = data.toUpperCase();
        super.resultado = new ArrayList<Properties>();
        if (!(data.equals("ASC") || data.equals("DESC"))) {
            throw new BBDDException(null, "ordenado");
        }
        if (data.equals("ASC")) {
            try (PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM profesor ORDER BY apellido1 ASC")) {
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    String apellido1 = rs1.getString("apellido1");
                    String apellido2 = rs1.getString("apellido2");
                    String nombre = rs1.getString("nombre");
                    Properties fila = new Properties(nombre, apellido1, apellido2);
                    resultado.add(fila);
                }
            } catch (SQLException e) {
                throw new SQLException(e);
            }
        }
        if (data.equals("DESC")) {
            try (PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM profesor ORDER BY apellido1 DESC")) {
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    String apellido1 = rs1.getString("apellido1");
                    String apellido2 = rs1.getString("apellido2");
                    String nombre = rs1.getString("nombre");
                    Properties fila = new Properties(nombre, apellido1, apellido2);
                    resultado.add(fila);
                }
            } catch (SQLException e) {
                throw new SQLException(e);
            }
        }
    }
}