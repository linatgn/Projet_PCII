package projet.projet_piia.modele.plante;

import javafx.scene.image.Image;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Suivi implements Comparable<Suivi> {
    private Date date;

    private Image image;
    private String note;
    private TreeMap<String, Double> listeMesure;

    public Suivi(){
        listeMesure = new TreeMap<>();
    }

    // Setter

    public void setDate(Date date) {
        this.date = date;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public void setMesure(String mesure, double valeur) {
        listeMesure.put(mesure,valeur);
    }

    // Getter

    public Date getDate() {
        return date;
    }
    public Image getImage() {
        return image;
    }
    public String getNote() {
        return note;
    }
    public TreeMap<String, Double> getListeMesure() {
        return listeMesure;
    }



    @Override
    public int compareTo(Suivi suivi) {
        return date.compareTo(suivi.date);
    }
}
