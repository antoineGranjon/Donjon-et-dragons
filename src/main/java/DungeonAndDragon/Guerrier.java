package DungeonAndDragon;

public class Guerrier {

    public String nom;
    public String image;
    public int vie;
    public int force;
    public Arme armeGuerrier;
    public String bouclier;

    public Guerrier(){

    }

    public Guerrier(String name){
        this.nom = name;
    }

    public Guerrier(String nom, String image, int vie, int force, Arme armeGuerrier){
        this.nom = nom;
        this.image = image;
        this.vie = vie;
        this.force = force;
        this.armeGuerrier = armeGuerrier;
    }

    public String toString(){
        return "Je suis un Guerrier, je m'apelle: " + nom + " mon image est: " + image + " j'ai " + vie + " points de vie et ma force est de: " + force + ", " + armeGuerrier;
    }
}