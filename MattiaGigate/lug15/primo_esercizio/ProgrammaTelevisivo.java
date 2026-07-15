package primo_esercizio;

import java.time.LocalDateTime;
import java.time.Duration;

public class ProgrammaTelevisivo {
    private int numeroCanale;
    private LocalDateTime dataInizio;
    private Duration durata;
    
    private static final short NUM_CANALE_MIN = 1;
    private static final short NUM_CANALE_MAX = 100;


    public int getNumeroCanale() { return numeroCanale; }
    public LocalDateTime getDataInizio() { return dataInizio; }
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
        this.dataInizio = dataOraInizio;
    }
    // duraata
    public void setDurata(Duration durata) {
        if (durata == null || durata.isNegative() || durata.isZero())
            throw new IllegalArgumentException("Errore: La durata deve essere maggiore di 0 minuti.");
        this.durata = durata;
    }
}