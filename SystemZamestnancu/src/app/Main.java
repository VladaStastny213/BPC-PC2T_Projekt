package app;

public class Main {
    public static void main(String[] args) {
        Firma firma = new Firma();

        firma.pridejZamestnance(new DatovyAnalytik(1, "Jan", "Novak", 1990));
        firma.pridejZamestnance(new BezpecnostniSpecialista(2, "Petr", "Svoboda", 1985));

        Zamestnanec nalezeny = firma.najdiZamestnance(1);
        if (nalezeny != null) {
            System.out.println("Nalezen: " + nalezeny.getJmeno() + " " + nalezeny.getPrijmeni());
            nalezeny.provedDovednost();
        }
    }
}