import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta = -1;

        while (scelta != 0) {
            System.out.println("\n--- MENU GESTIONE FALCONE ---");
            System.out.println("1. Test Connessione Database");
            System.out.println("2. Esegui un'altra funzione (es. Stampa studenti)");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            
            // Controllo input per evitare crash se l'utente inserisce lettere
            if (scanner.hasNextInt()) {
                scelta = scanner.nextInt();
            } else {
                scanner.next(); // consuma input non valido
                scelta = -1;
            }

            switch (scelta) {
                case 1:
                    testConnessione();
                    break;
                case 2:
                    System.out.println("Funzionalità non ancora implementata!");
                    break;
                case 0:
                    System.out.println("Uscita in corso...");
                    break;
                default:
                    System.out.println("Opzione non valida, riprova.");
            }
        }
        scanner.close();
    }

    private static void testConnessione() {
        System.out.println("Tentativo di connessione...");
        // Qui usiamo la classe DatabaseManager creata prima
        try (Connection conn = DatabaseManager.ottieniConnessione()) {
            System.out.println("✅ Connessione riuscita! Il database è pronto.");
        } catch (SQLException e) {
            System.err.println("❌ Errore di connessione: " + e.getMessage());
        }
    }
}