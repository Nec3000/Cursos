package cursos;

import java.util.ArrayList;

public class MainS3 {

    // Comprobar
    public static void test() {
        // Crea el gestor de conexiones
        BBDDManager cm = new BBDDManager("alumno","bbdd-upm");
        ConsultaSimple consulta = new ConsultaSimple();
        // Crear las tareas
        DataBaseTask[] tasks = {
            consulta
        };
        String[] data = {
            "ASC"
        };

        // Llamar a run:
        StringWriter result = cm.run(tasks, data, true);
        ArrayList<Properties> res = consulta.get();
        for(Properties p : res) {
            result.add(p.toString());
        }
        System.out.println(result);
        
    }

    public static void main(String[] args) {
        test();
    }
}


