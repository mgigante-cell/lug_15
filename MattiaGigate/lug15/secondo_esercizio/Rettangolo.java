package secondo_esercizio;

public class Rettangolo {
    private double base;
    private double altezza;

    public Rettangolo() {
        base = 0.0;
        altezza = 0.0;
    }

    public Rettangolo(double base, double altezza){
        impostaDimensioni(base, altezza);
    }

    public void impostaDimensioni(double base, double altezza){
        if(base <= 0 || altezza <= 0)
            throw new IllegalArgumentException("Errore: non puoi inserire <= 0");
        this.base = base;
        this.altezza = altezza;
    }

    public double calcolaArea() { return base * altezza; }
    
    public void disegna(char simbolo) {
        for (int i = 0; i < altezza; i++) {
            for (int j = 0; j < base; j++)
                System.out.print(simbolo + " ");

            System.out.println();
        }
    }
}
