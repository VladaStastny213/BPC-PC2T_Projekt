package app;

import java.util.ArrayList;
import java.util.List;

public class Firma {
    private List<Zamestnanec> zamestnanci;

    public Firma() {
        this.zamestnanci = new ArrayList<>();
    }

    public void pridejZamestnance(Zamestnanec z) {
        zamestnanci.add(z);
    }

    public boolean smazZamestnance(int id) {
        for (Zamestnanec z : zamestnanci) {
            z.getSpolupracovnici().remove(id);
        }
        return zamestnanci.removeIf(z -> z.getId() == id);
    }

    public Zamestnanec najdiZamestnance(int id) {
        for (Zamestnanec z : zamestnanci) {
            if (z.getId() == id) {
                return z;
            }
        }
        return null;
    }
    
    public List<Zamestnanec> getZamestnanci() {
        return zamestnanci;
    }
}