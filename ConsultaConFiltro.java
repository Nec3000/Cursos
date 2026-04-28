package cursos;

import java.sql.*;
import java.util.*;

import cursos.Properties;

public class ConsultaConFiltro extends ConsultaConResultado<Properties> {
    /**
     * Obtiene los profesores que imparten un modulo cuyo titulo
     * contiene la cadena dada.
     *
     * @throws BBDDException, cuando data este vacia. Se debe fijar
     *         when a "filtro vacio"
     * @throws SQLException, cuando se produzca la misma al ejecutar
     *         modificar la tabla.
     */
    @Override
    public void run(Connection conn, String data) throws BBDDException, SQLException {
    	if(data.isEmpty()) {
    		throw new BBDDException(null,"filtro vacío");
    	}
        try(PreparedStatement psI= conn.prepareStatement("SELECT * FROM profesor WHERE profesor.id=(SELECT profesor_id FROM imparte WHERE n_modulo=(SELECT n_modulo FROM modulo WHERE titulo =?)) ORDER BY apellido1 ASC")){
        	psI.setString(1,data);
        	ResultSet rs1 = psI.executeQuery();
            while(rs1.next()) {
                String apellido1 = rs1.getString("apellido1");
                String apellido2 = rs1.getString("apellido2");
                String nombre = rs1.getString("nombre");
                String datos = "curso_id"+"-"+data;
                Properties fila = new Properties(nombre, apellido1, apellido2,datos);
                resultado.add(fila);
            }
        }catch(Exception e) {
        	
        }
    }
}