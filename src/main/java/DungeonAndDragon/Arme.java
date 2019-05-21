package DungeonAndDragon;

public class Arme {

    private String nom;
    private int puissance;

    public Arme(String nom, int puissance){
        this.nom = nom;
        this.puissance = puissance;
    }

    public String toString(){
        return "mon arme est: " + nom + " et elle à une puissance de: " + puissance;
    }
}