/**
 * Gestion des sorts
 */
package sorts;

public class Sort {

    private String nom;
    private int puissance;

    /**
     * Caractéristiques du sort
     * @param nom Nom du sort
     * @param puissance Puissance du sort
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

    /**
     * Description du sort
     * @return une description du sort
     */
    public String toString(){
        return "Sort: " + nom + " - Puissance: " + puissance;
    }
}