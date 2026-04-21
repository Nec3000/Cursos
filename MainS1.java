package Cursos;

import java.sql.SQLException;

public class MainS1 {

    // Comprobar
    public static void test() throws SQLException, BBDDException {
        // Crea el gestor de conexiones
        BBDDManager cm = new BBDDManager("alumno","bbdd-upm");

        // Crear las tareas
        DataBaseTask[] tasks = {
            new CreateTable()
        };
        String[] data = { "" };

        // Llamar a run:
        StringWriter result = cm.run(tasks, data, true);
        System.out.println(result);
    }

    public static void main(String[] args) throws SQLException, BBDDException {
        test();
    }
}


