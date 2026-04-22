package cursos;

import java.sql.*;

public class BBDDManager {
    private String user;
    private String password;
    private String host;
    String db = "cursos_db";

    public BBDDManager(String user, String password) {
        this.user = user;
        this.password = password;
        host = "localhost:3306";
    }

    public String url() {
        return "jdbc:mysql://" + host + "/" + db;
    }

    public StringWriter run(DataBaseTask[] tasks, String[] dataArray, boolean autoCommit) {
        StringWriter result = new StringWriter();
        try (Connection conn = DriverManager.getConnection(url(), user, password)) {
            conn.setAutoCommit(autoCommit);
            for (int i = 0; i < tasks.length; i++) {
                try {
                    tasks[i].run(conn, dataArray[i]);
                } catch (SQLException e) {
                    if (!autoCommit) conn.rollback();
                    result.add("SQL:" + e.getMessage() + ";");
                } catch (BBDDException e) {
                    if (!autoCommit) conn.commit();
                    result.add("Task:" + e.when() + ";" + e.getMessage() + ";");
                }
            }
        } catch (SQLException e) {
            result.add("Connection:" + e.getMessage() + ";");
        } catch (Exception e) {
            result.add("Otro:" + e.getMessage() + ";");
        }
        result.add("fin");
        return result;
    }
}
