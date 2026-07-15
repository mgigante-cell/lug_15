package secondo_esercizio;

public class Test {
    public static void main(String[] args) {
        Rettangolo r1 = new Rettangolo();
        Rettangolo r2 = new Rettangolo(12, 3);

        System.out.println("RETTANGOLO 1");
        r1.impostaDimensioni(8, 4);

        System.out.println("Area calcolata: " + r1.calcolaArea());
        System.out.println("Rappresentazione grafica:");
        r1.disegna('@');

        System.out.println("RETTANGOLO 2");
        System.out.println("Area calcolata: " + r2.calcolaArea());
        System.out.println("Rappresentazione grafica:");
        r2.disegna('#');

    }
}
