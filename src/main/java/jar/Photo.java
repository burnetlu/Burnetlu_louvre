package jar;

import java.util.Date;

public class Photo {

    public String titre;

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean etat;
    public Date date;

    public Photo(String titre, boolean etat, Date date){
        this.titre = titre;
        this.etat = etat;
        this.date = date;

    }
}
