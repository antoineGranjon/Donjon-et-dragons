package DungeonAndDragon;

public class Guerrier extends Personnage {

    public Arme armeGuerrier;
    public String bouclier;

    public Guerrier(String nom, String image, int vie, int force, Arme armeGuerrier) {
        super(nom, image, vie, force);
        this.armeGuerrier = armeGuerrier;
    }
}