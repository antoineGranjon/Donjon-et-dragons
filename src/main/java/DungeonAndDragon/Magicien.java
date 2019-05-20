package DungeonAndDragon;

public class Magicien extends Personnage {

    public Sort sortMagicien;
    public String philtre;

    public Magicien(String nom, String image, int vie, int force, Sort sortMagicien) {
        super(nom, image, vie, force);
        //this.nameClass = "magicien";
        this.sortMagicien = sortMagicien;
    }
}