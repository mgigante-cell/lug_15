package primo_esercizio;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProgrammaTelevisivo programma = new ProgrammaTelevisivo();

        try {
            // Lettura del Canale
            System.out.print("Inserisci il numero del canale (" + 1 + "-" + 100 + "): ");
            int canale = scanner.nextInt();
            if(scanner.hasNextLine()) scanner.nextLine();
            programma.setNumeroCanale(canale);

            // Lettura della data e ora di inizio
            System.out.println("\nInserisci la data e l'ora di inizio registrazione");
            System.out.print("Anno [esempio: 2026 (in poi) ]: ");
            int anno = scanner.nextInt();
            if(scanner.hasNextLine()) scanner.nextLine();
            System.out.print("Mese (1-12): ");
            int mese = scanner.nextInt();
            if(scanner.hasNextLine()) scanner.nextLine();
            System.out.print("Giorno (1-31): ");
            int giorno = scanner.nextInt();
            if(scanner.hasNextLine()) scanner.nextLine();
            System.out.print("Ora (0-23): ");
            int ora = scanner.nextInt();
            if(scanner.hasNextLine()) scanner.nextLine();
            System.out.print("Minuto (0-59): ");
            int minuto = scanner.nextInt();
            if(scanner.hasNextLine()) scanner.nextLine();

            LocalDateTime inizio = LocalDateTime.of(anno, mese, giorno, ora, minuto);
            programma.setDataOraInizio(inizio);
            
            System.out.print("\nInserisci la durata della registrazione (in minuti): ");
            long minutiDurata = scanner.nextLong();
            if(scanner.hasNextLine()) scanner.nextLine();
            programma.setDurata(Duration.ofMinutes(minutiDurata));

            System.out.println("\nREGISTRAZIONE PROGRAMMATA CON SUCCESSO!");
            System.out.println("Canale: " + programma.getNumeroCanale());
            System.out.println("Inizio: " + programma.getDataInizio());
            System.out.println("Durata: " + programma.getDurata().toMinutes() + " minuti");

        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERRORE DI CONFIGURAZIONE] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n[ERRORE] Inserimento non valido. Assicurati di inserire solo numeri.");
        } finally {
            scanner.close();
        }
    }
}