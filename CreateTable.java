package Cursos;

import java.sql.*;

public class CreateTable implements DataBaseTask {
	public CreateTable() {}
    @Override
    public void run(Connection conn, String data) throws SQLException {
    	String sql = "CREATE TABLE imparte("+
    				 "Fecha DATE, "+
    				 "n_modulo INT NOT NULL,"+
                     "curso_id INT NOT NULL,"+
    				 "id_aula INT,"+
    				 "id_profesor INT," +
    				 "PRIMARY KEY(curso_id,n_modulo,id_aula,id_profesor),"+
    				 "FOREIGN KEY(curso_id, n_modulo) REFERENCES modulo(curso_id, n_modulo) ON DELETE CASCADE ON  UPDATE CASCADE,"+
    				 "FOREIGN KEY(id_aula) REFERENCES aula(id) ON DELETE CASCADE ON  UPDATE CASCADE,"+
    				 "FOREIGN KEY(id_profesor) REFERENCES profesor(id) ON DELETE CASCADE ON  UPDATE CASCADE)";

            Statement st = conn.createStatement();
            int rows = st.executeUpdate(sql);
            System.out.println("Filas afectadas: " + rows);
            st.close();
    }
}
