package cursos;

import java.sql.*;
import java.time.LocalDate;

public class InsertaUnaFilaImparte implements DataBaseTask {

    @Override
    public void run(Connection conn, String data)throws BBDDException, SQLException {
        String[] datos = data.split(",");
<<<<<<< HEAD
        try(PreparedStatement psI= conn.prepareStatement("INSERT INTO imparte(profesor_id , curso_id , n_modulo , aula_id , fecha) VALUES (?,?,?,?,?)")) {
=======
        try(PreparedStatement psI= conn.prepareStatement("INSERT INTO imparte(profesor_id , curso_id , n_modulo , aula_id , fecha) VALUES (?,?,?,?,?)")){

        psI.setInt(1,Integer.parseInt(datos[0].trim()));
        psI.setInt(2,Integer.parseInt(datos[1].trim()));
        psI.setInt(3,Integer.parseInt(datos[2].trim()));
        psI.setInt(4,Integer.parseInt(datos[3].trim()));
        String anio =datos[4].split("/")[2].trim();
        String mes =datos[4].split("/")[1].trim();
        String dia =datos[4].split("/")[0].trim();
        String fecha = anio+"-"+mes+"-"+dia;
        Date fecha2= Date.valueOf(fecha.trim());
        psI.setDate(5, fecha2);
        int res = psI.executeUpdate();
        }catch(Exception e) {
        	e.printStackTrace();
        }

>>>>>>> 7cda0af (prueba)

            psI.setInt(1, Integer.parseInt(datos[0].trim()));
            psI.setInt(2, Integer.parseInt(datos[1].trim()));
            psI.setInt(3, Integer.parseInt(datos[2].trim()));
            psI.setInt(4, Integer.parseInt(datos[3].trim()));
            String anio = datos[4].split("/")[2].trim();
            String mes = datos[4].split("/")[1].trim();
            String dia = datos[4].split("/")[0].trim();
            String fecha = anio + "-" + mes + "-" + dia;
            Date fecha2 = Date.valueOf(fecha.trim());
            psI.setDate(5, fecha2);
            int res = psI.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}