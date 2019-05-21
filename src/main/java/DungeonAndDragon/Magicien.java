package DungeonAndDragon;

public class Magicien extends Personnage {

    private Sort sortMagicien;
    private String philtre;

    /**
     *
     * @param nom
     * @param image
     * @param vie
     * @param force
     * @param sortMagicien
     */
    public Magicien(String nom, String image, int vie, int force, Sort sortMagicien) {
        super(nom, image, vie, force);
        //this.nameClass = "magicien";
        this.sortMagicien = sortMagicien;
    }

    @Override
    public int getForce() {
        return super.getForce();
    }

    @Override
    public int getVie() {
        return super.getVie();
    }

    @Override
    public String toString() {
        return super.toString() + sortMagicien.toString();
    }
}