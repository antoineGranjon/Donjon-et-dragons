package DungeonAndDragon;

public class Guerrier extends Personnage {

    private Arme armeGuerrier;
    private String bouclier;

    public Guerrier(String nom, String image, int vie, int force, Arme armeGuerrier) {
        super(nom, image, vie, force);
        this.armeGuerrier = armeGuerrier;
    }
}