package cursos;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class InsertaImparteDesdeCSV implements DataBaseTask {

    @Override
    public void run(Connection conn, String data) throws BBDDException, SQLException {
    	try(FileInputStream f = new FileInputStream(data);
            Scanner sc = new Scanner(f)){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String []datos = linea.split(",");
                try(PreparedStatement ps = conn.prepareStatement("INSERT INTO imparte(profesor_id,curso_id,n_modulo,aula_id,fecha) VALUES(?,?,?,?,?)")) {
                    ps.setInt(1, Integer.parseInt(datos[0].trim()));
                    ps.setInt(2, Integer.parseInt(datos[1].trim()));
                    ps.setInt(3, Integer.parseInt(datos[2].trim()));
                    ps.setInt(4, Integer.parseInt(datos[3].trim()));
                    Date date = Date.valueOf(datos[4].trim());
                    ps.setDate(5, date);
                    int res = ps.executeUpdate();
                    if(res!=1){
                        throw new SQLException("Error al ejecutar la query");
                    }
                }catch(SQLException e){
                    throw new SQLException("Error al ejecutar la query");//esto es para que no se haga una bbddexception, ya que so es sql lo pilla este antes
                }

                catch (Exception e) {
                    throw new BBDDException(e,"Insertando");
                }
            }
        } catch ( Exception e) {
            throw new BBDDException(e,"Insertando");
        }

    }
}
