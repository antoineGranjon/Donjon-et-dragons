package DungeonAndDragon;

public class Sort {

    private String nom;
    private int puissance;

    public Sort(String nom, int puissance){
        this.nom = nom;
        this.puissance = puissance;
    }

    public String toString(){
        return "mon sort est: " + nom + " et il à une puissance de: " + puissance;
    }
}