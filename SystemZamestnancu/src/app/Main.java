package app;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Firma firma = new Firma();
        firma.nactiZeSouboru("data.txt");
        Scanner scanner = new Scanner(System.in);
        boolean bezi = true;

        System.out.println(" system zamestnancu ");

        while (bezi) {
            System.out.println("\n1 - pridat zamestnance");
            System.out.println("2 - najit a spustit dovednost");
            System.out.println("3 - pridat spolupraci");
            System.out.println("4 - odstranit zamestnance");
            System.out.println("5 - vypis vseho");
            System.out.println("6 - analyza rizikovosti");
            System.out.println("0 - ukonceni programu");
            System.out.print("volba: ");
            
            int volba = scanner.nextInt();
            scanner.nextLine();

            switch (volba) {
                case 1:
                    System.out.print("1-Analytik, 2-Specialista: ");
                    int typ = scanner.nextInt(); scanner.nextLine();
                    System.out.print("jmeno: "); String j = scanner.nextLine();
                    System.out.print("prijmeni: "); String p = scanner.nextLine();
                    System.out.print("rok: "); int r = scanner.nextInt();
                    int id = firma.getZamestnanecCount() + 1;
                    if (typ == 1) firma.pridejZamestnance(new DatovyAnalytik(id, j, p, r));
                    else firma.pridejZamestnance(new BezpecnostniSpecialista(id, j, p, r));
                    System.out.println("pridano s ID " + id);
                    firma.ulozDoSouboru("data.txt");
                    break;

                case 2:
                    System.out.print("yadejte ID: ");
                    Zamestnanec z = firma.najdiZamestnance(scanner.nextInt());
                    if (z != null) {
                        System.out.println("nalezen: " + z.getJmeno() + " " + z.getPrijmeni());
                        z.provedDovednost();
                    } else System.out.println("nenalezen");
                    break;

                case 3:
                    System.out.print("ID prvniho-> "); int id1 = scanner.nextInt();
                    System.out.print("ID druheho-> "); int id2 = scanner.nextInt();
                    System.out.print("uroven (1-3): ");
                    int u = scanner.nextInt();
                    
                    if (firma.pridejVazbu(id1, id2, u)) {
                        System.out.println("vazba ulozena");
                        firma.ulozDoSouboru("data.txt");
                    } else {
                        System.out.println("error: ID neexistuji nebo jsou stejne");
                    }
                    break;

                case 4:
                    System.out.print("ID ke smazani: ");
                    if (firma.smazZamestnance(scanner.nextInt())) System.out.println("zamestnanec byl smazan");
                    else System.out.println("ID neexistuje");
                    firma.ulozDoSouboru("data.txt");
                    break;
               
                case 5:
                    System.out.println(" seznam vsech zamestnancu ");
                    for (Zamestnanec zam : firma.getZamestnanci()) {
                        System.out.println(zam.toString());
                    }
                    break;
                    
                case 6:
                    System.out.println(" analyza rizikovosti ");
                    for (Zamestnanec zam : firma.getZamestnanci()) {
                        System.out.println(zam.getJmeno() + " " + zam.getPrijmeni() + ": " + zam.getRizikoveSkore());
                    }
                    break;

                    
                case 0:
                    bezi = false;
                    System.out.println("program ukoncen");
                    break;
                    
                default:
                    System.out.println("neplatne volba");
            }
        }
        scanner.close();
    }
}
