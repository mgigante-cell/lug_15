package primo_esercizio;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.DateTimeException;
import java.util.Scanner;

public class Main {

    private static int menuCanale(Scanner scanner) {
        System.out.println("Inserisci il numero del canale (" + ProgrammaTelevisivo.NUM_CANALE_MIN + "-"
                + ProgrammaTelevisivo.NUM_CANALE_MAX + "):");
        while (true) {
            try {
                System.out.print("Canale: ");
                int canale = Integer.parseInt(scanner.nextLine());

                if (canale < ProgrammaTelevisivo.NUM_CANALE_MIN || canale > ProgrammaTelevisivo.NUM_CANALE_MAX) {
                    System.out.println("[ERRORE CANALE] Canale non valido! Inserire un numero tra "
                            + ProgrammaTelevisivo.NUM_CANALE_MIN + " e " + ProgrammaTelevisivo.NUM_CANALE_MAX + ".");
                    continue;
                }
                return canale;
            } catch (NumberFormatException e) {
                System.out.println("[ERRORE FORMATO] Inserisci solo numeri interi!");
            }
        }
    }

    private static LocalDate menuData(Scanner scanner) {
        System.out.println("\nInserisci la data di inizio registrazione");
        int anno = 0, mese = 0, giorno = 0;
        LocalDate oggi = LocalDate.now();

        while (true) {
            try {
                System.out.print("Anno [esempio: " + ProgrammaTelevisivo.ANNO_MIN + "]: ");
                anno = Integer.parseInt(scanner.nextLine());
                
                if (anno < ProgrammaTelevisivo.ANNO_MIN) {
                    System.out.println("[ERRORE ANNO] L'anno non può essere nel passato.");
                    continue;
                }
                if (anno > ProgrammaTelevisivo.ANNO_MAX) {
                    System.out.println("[ERRORE ANNO] L'anno non può superare il " + ProgrammaTelevisivo.ANNO_MAX + ".");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERRORE FORMATO] Inserisci solo numeri interi.");
            }
        }

        while (true) {
            try {
                System.out.print("Mese (" + ProgrammaTelevisivo.MESE_MIN + "-" + ProgrammaTelevisivo.MESE_MAX + "): ");
                mese = Integer.parseInt(scanner.nextLine());
                
                if (mese < ProgrammaTelevisivo.MESE_MIN || mese > ProgrammaTelevisivo.MESE_MAX) {
                    System.out.println("[ERRORE MESE] Il mese deve essere tra " + ProgrammaTelevisivo.MESE_MIN + " e " + ProgrammaTelevisivo.MESE_MAX + ".");
                    continue;
                }
                
                if (anno == oggi.getYear() && mese < oggi.getMonthValue()) {
                    System.out.println("[ERRORE MESE] Hai inserito l'anno corrente (" + anno + "). Il mese non può essere passato.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERRORE FORMATO] Inserisci solo numeri interi.");
            }
        }

        while (true) {
            try {
                System.out.print("Giorno (" + ProgrammaTelevisivo.GIORNO_MIN + "-" + ProgrammaTelevisivo.GIORNO_MAX + "): ");
                giorno = Integer.parseInt(scanner.nextLine());
                
                if (giorno < ProgrammaTelevisivo.GIORNO_MIN || giorno > ProgrammaTelevisivo.GIORNO_MAX) {
                    System.out.println("[ERRORE GIORNO] Il giorno deve essere tra " + ProgrammaTelevisivo.GIORNO_MIN + " e " + ProgrammaTelevisivo.GIORNO_MAX + ".");
                    continue;
                }
                
                LocalDate data = LocalDate.of(anno, mese, giorno);
                
                if (data.isBefore(oggi)) {
                    System.out.println("[ERRORE DATA] La data inserita è passata rispetto a oggi. Inserisci un giorno futuro/odierno.");
                    continue;
                }
                
                return data;
            } catch (NumberFormatException e) {
                System.out.println("[ERRORE FORMATO] Inserisci solo numeri interi.");
            } catch (DateTimeException e) {
                System.out.println("[ERRORE CALENDARIO] Giorno inesistente per il mese e l'anno scelti. Reinserisci il giorno.");
            }
        }
    }

    private static LocalTime menuOra(Scanner scanner, LocalDate dataScelta) {
        System.out.println("\nInserisci l'ora di inizio registrazione");
        int ora = 0, minuto = 0;
        LocalDate oggi = LocalDate.now();
        LocalTime adesso = LocalTime.now();

        while (true) {
            try {
                System.out.print("Ora (" + ProgrammaTelevisivo.ORA_MIN + "-" + ProgrammaTelevisivo.ORA_MAX + "): ");
                ora = Integer.parseInt(scanner.nextLine());

                if (ora < ProgrammaTelevisivo.ORA_MIN || ora > ProgrammaTelevisivo.ORA_MAX) {
                    System.out.println("[ERRORE ORA] L'ora deve essere compresa tra " + ProgrammaTelevisivo.ORA_MIN + " e " + ProgrammaTelevisivo.ORA_MAX + ".");
                    continue;
                }
                
                if (dataScelta.isEqual(oggi) && ora < adesso.getHour()) {
                    System.out.println("[ERRORE ORA] Hai selezionato la data di oggi. L'ora non può essere già passata.");
                    continue;
                }
                
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERRORE FORMATO] Inserisci solo numeri interi.");
            }
        }

        while (true) {
            try {
                System.out.print("Minuto (" + ProgrammaTelevisivo.MINUTO_MIN + "-" + ProgrammaTelevisivo.MINUTO_MAX + "): ");
                minuto = Integer.parseInt(scanner.nextLine());
                
                if (minuto < ProgrammaTelevisivo.MINUTO_MIN || minuto > ProgrammaTelevisivo.MINUTO_MAX) {
                    System.out.println("[ERRORE MINUTO] I minuti devono essere compresi tra " + ProgrammaTelevisivo.MINUTO_MIN + " e " + ProgrammaTelevisivo.MINUTO_MAX + ".");
                    continue;
                }

                if (dataScelta.isEqual(oggi) && ora == adesso.getHour() && minuto <= adesso.getMinute()) {
                    System.out.println("[ERRORE MINUTO] Orario già trascorso. Inserisci un minuto nel futuro.");
                    continue;
                }

                return LocalTime.of(ora, minuto);
            } catch (NumberFormatException e) {
                System.out.println("[ERRORE FORMATO] Inserisci solo numeri interi.");
            }
        }
    }

    private static Duration menuDurata(Scanner scanner) {
        System.out.println("\nInserisci la durata della registrazione");
        while (true) {
            try {
                System.out.print("Durata (minuti): ");
                int durata = Integer.parseInt(scanner.nextLine());

                if (durata <= 0) {
                    System.out.println("[ERRORE DURATA] La durata deve essere maggiore di 0 minuti.");
                    continue;
                }
                return Duration.ofMinutes(durata);
            } catch (NumberFormatException e) {
                System.out.println("[ERRORE FORMATO] Inserisci solo numeri interi.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProgrammaTelevisivo programma = new ProgrammaTelevisivo();

        System.out.println("CONFIGURAZIONE REGISTRAZIONE");

        programma.setNumeroCanale(menuCanale(scanner));

        LocalDate dataInizio = menuData(scanner);
        LocalTime oraInizio = menuOra(scanner, dataInizio); 
        
        LocalDateTime inizio = LocalDateTime.of(dataInizio, oraInizio);

        try {
            programma.setDataOraInizio(inizio);
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERRORE TEMPORALE CRITICO] " + e.getMessage());
            return;
        }

        programma.setDurata(menuDurata(scanner));

        System.out.println("\nREGISTRAZIONE PROGRAMMATA CON SUCCESSO");
        System.out.println("Canale: " + programma.getNumeroCanale());
        System.out.println("Inizio: " + programma.getDataInizio() + " alle ore " + programma.getOraInizio());
        System.out.print("Durata: " + programma.getDurata().toMinutes() + " minuti");
        
        if (programma.getDurata().toMinutes() >= 60) {
            System.out.println(" - ("
                    + programma.getDurata().toHours() + " ore e "
                    + (programma.getDurata().toMinutes() % 60) + " minuti)");
        }

        scanner.close();
    }
}