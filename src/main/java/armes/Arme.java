/**
 * Gestion des armes
 */

package armes;

public class Arme {

    private String nom;
    private int puissance;

    /**
     * Caractéristiques de l'armes
     * @param nom Nom de l'armes
     * @param puissance Puissance de l'armes
     */
    public Arme(String nom, int puissance) {
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
     * Description de l'armes
     * @return une description de l'armes
     */
    public String toString() {
        return "Arme: " + nom + " - Puissance: " + puissance;
    }

}