package app;

import java.util.HashMap;
import java.util.Map;

public abstract class Zamestnanec {
    private int id;
    private String jmeno;
    private String prijmeni;
    private int rokNarozeni;
   
    protected Map<Integer, Integer> spolupracovnici;

    public Zamestnanec(int id, String jmeno, String prijmeni, int rokNarozeni) {
        this.id = id;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rokNarozeni = rokNarozeni;
        this.spolupracovnici = new HashMap<>();
    }

    public abstract void provedDovednost();

    public int getId() { return id; }
    public String getJmeno() { return jmeno; }
    public String getPrijmeni() { return prijmeni; }
    public int getRokNarozeni() { return rokNarozeni; }
    public Map<Integer, Integer> getSpolupracovnici() { return spolupracovnici; }
    
    public void pridejSpolupracovnika(int idKolegy, int uroven) {
        spolupracovnici.put(idKolegy, uroven);
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d | %s %s (%d) | Počet kolegů: %d", 
            id, jmeno, prijmeni, rokNarozeni, spolupracovnici.size());
    }
}