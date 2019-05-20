package DungeonAndDragon;

public class Magicien {

    public String nom;
    public String image;
    public int vie;
    public int force;
    public Sort sortMagicien;
    public String philtre;

    public Magicien(){

    }

    public Magicien(String name){

    }

    public Magicien(String nom, String image, int vie, int force, Sort sort){
        this.nom = nom;
        this.image = image;
        this.vie = vie;
        this.force = force;
        this.sortMagicien = sort;
    }

    public String toString(){
        return "Je suis un Magicien, je m'apelle: " + nom + " mon image est: " + image + " j'ai " + vie + " points de vie et ma force est de: " + force + ", " + sortMagicien;
    }
}