package app;

public class BezpecnostniSpecialista extends Zamestnanec {

    public BezpecnostniSpecialista(int id, String jmeno, String prijmeni, int rokNarozeni) {
        super(id, jmeno, prijmeni, rokNarozeni);
    }

    @Override
    public void provedDovednost() {
        System.out.println("Výpočet rizikového skóre (bude dopracováno).");
    }
}