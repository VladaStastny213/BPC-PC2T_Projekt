package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Firma firma = new Firma();
        Scanner scanner = new Scanner(System.in);
        boolean bezi = true;

        System.out.println("--- Systém zaměstnanců ---");

        while (bezi) {
            System.out.println("\n1 - Přidat zaměstnance");
            System.out.println("2 - Vyhledat dle ID a spustit dovednost");
            System.out.println("0 - Konec");
            System.out.print("Vyberte možnost: ");
            
            int volba = scanner.nextInt();
            scanner.nextLine(); 

            switch (volba) {
                case 1:
                    System.out.print("Skupina (1 - Analytik, 2 - Specialista): ");
                    int skupina = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Jméno: ");
                    String jmeno = scanner.nextLine();
                    System.out.print("Příjmení: ");
                    String prijmeni = scanner.nextLine();
                    System.out.print("Rok narození: ");
                    int rok = scanner.nextInt();
                    
             
                    int id = firma.getZamestnanecCount() + 1; 
                    
                    if (skupina == 1) {
                        firma.pridejZamestnance(new DatovyAnalytik(id, jmeno, prijmeni, rok));
                    } else {
                        firma.pridejZamestnance(new BezpecnostniSpecialista(id, jmeno, prijmeni, rok));
                    }
                    System.out.println("Zaměstnanec přidán s ID: " + id);
                    break;
                case 2:
                    System.out.print("Zadejte ID: ");
                    int hledejId = scanner.nextInt();
                    Zamestnanec z = firma.najdiZamestnance(hledejId);
                    if (z != null) {
                        System.out.println("Nalezen: " + z.getJmeno() + " " + z.getPrijmeni());
                        z.provedDovednost(); // [cite: 14]
                    } else {
                        System.out.println("Nenalezen.");
                    }
                    break;
                case 0:
                    bezi = false;
                    break;
            }
        }
        scanner.close();
    }
}