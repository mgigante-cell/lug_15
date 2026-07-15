package primo_esercizio;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

public class ProgrammaTelevisivo {
    private int numeroCanale;
    private LocalDateTime dataInizio;
    private Duration durata;

    public static final byte NUM_CANALE_MIN = 1;
    public static final byte NUM_CANALE_MAX = 100;
    private static final byte GAP_ANNO_MAX_MIN = 50;
    public static final short ANNO_MIN = (short) LocalDate.now().getYear();
    public static final short ANNO_MAX = (short) (ANNO_MIN + GAP_ANNO_MAX_MIN);
    public static final byte MESE_MIN = 1;
    public static final byte MESE_MAX = 12;
    public static final byte GIORNO_MIN = 1;
    public static final byte GIORNO_MAX = 31;
    public static final byte MINUTO_MIN = 0;
    public static final byte MINUTO_MAX = 59;
    public static final byte ORA_MIN = 0;
    public static final byte ORA_MAX = 23;

    public int getNumeroCanale() { return numeroCanale; }
    public LocalDateTime getDataOraInizio() { return dataInizio; }
    public LocalDate getDataInizio() { return dataInizio.toLocalDate(); }
    public LocalTime getOraInizio() { return dataInizio.toLocalTime(); }
    public Duration getDurata() { return durata; }

    // canale
    public void setNumeroCanale(int numeroCanale) {
        if (numeroCanale < NUM_CANALE_MIN || numeroCanale > NUM_CANALE_MAX)
            throw new IllegalArgumentException("Errore: Canale non valido! Inserire un numero tra "
                    + NUM_CANALE_MIN + " e " + NUM_CANALE_MAX + ".");
        this.numeroCanale = numeroCanale;
    }

    // data inizio
    public void setDataOraInizio(LocalDateTime dataOraInizio) {
        if (dataOraInizio == null || dataOraInizio.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Errore: La data di inizio non può essere nel passato o nulla");
        if (dataOraInizio.getYear() > ANNO_MAX)
            throw new IllegalArgumentException("Errore: L'anno non può essere maggiore di " + ANNO_MAX);
        this.dataInizio = dataOraInizio;
    }

    // duraata
    public void setDurata(Duration durata) {
        if (durata == null || durata.isNegative() || durata.isZero())
            throw new IllegalArgumentException("Errore: La durata deve essere maggiore di 0 minuti.");
        this.durata = durata;
    }
}