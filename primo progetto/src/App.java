import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbFirstProject"; // nome del tuo database
        String user = "root"; // o altro utente MySQL
        String password = "laTuaPassword"; // metti la tua password

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione riuscita!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Errore di connessione: " + e.getMessage());
        }
    }
}
