package DungeonAndDragon;


public abstract class Personnage {

    private String nom;
    private String image;
    private int vie;
    private int force;

    public Personnage() {

    }

    public Personnage(String name) {
        this.nom = name;
    }

    /**
     *
     * @param nom
     * @param image
     * @param vie
     * @param force
     */
    public Personnage(String nom, String image, int vie, int force) {

        this.nom = nom;
        this.image = image;
        this.vie = vie;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getVie() {
        return vie;
    }

    public int getForce() {
        return force;
    }

    public String toString() {
        return "Classe : " + this.getClass().getSimpleName() + " | Nom: " + nom + " | Image: " + image + "| Points de vie : " + vie + "| Force: " + force + " | ";
    }
}
