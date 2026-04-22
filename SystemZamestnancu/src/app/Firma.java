package app;

import java.util.ArrayList;
import java.util.List;

public class Firma {
    private List<Zamestnanec> zamestnanci;

    public Firma() {
        this.zamestnanci = new ArrayList<>();
    }
    
    public boolean pridejVazbu(int id1, int id2, int uroven) {
        Zamestnanec z1 = najdiZamestnance(id1);
        Zamestnanec z2 = najdiZamestnance(id2);
        
        if (z1 != null && z2 != null && id1 != id2) {
            z1.pridejSpolupracovnika(id2, uroven);
            z2.pridejSpolupracovnika(id1, uroven);
            return true;
        }
        return false;
    }
    
    public int getZamestnanecCount() {
        return zamestnanci.size();
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