package DungeonAndDragon;

public class Magicien extends Personnage {

    private Sort sortMagicien;
    private String philtre;

    public Magicien(String nom, String image, int vie, int force, Sort sortMagicien) {
        super(nom, image, vie, force);
        //this.nameClass = "magicien";
        this.sortMagicien = sortMagicien;
    }
}