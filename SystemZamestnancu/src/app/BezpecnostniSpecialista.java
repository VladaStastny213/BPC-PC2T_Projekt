package app;

public class BezpecnostniSpecialista extends Zamestnanec {

    public BezpecnostniSpecialista(int id, String jmeno, String prijmeni, int rokNarozeni) {
        super(id, jmeno, prijmeni, rokNarozeni);
    }

    
    @Override
    public void provedDovednost() {
        String status = (getRizikoveSkore() > 2.5) ? "KRITICKE" : "STABILNI";
        System.out.println(" stav zamestnance je " + status + ".");
    }
}