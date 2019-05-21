package DungeonAndDragon;

public class Sort {

    private String nom;
    private int puissance;

    /**
     *
     * @param nom
     * @param puissance
     */
    public Sort(String nom, int puissance){
        this.nom = nom;
        this.puissance = puissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public String toString(){
        return "Sort: " + nom + " | Puissance: " + puissance;
    }
}