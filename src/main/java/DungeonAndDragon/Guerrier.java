package DungeonAndDragon;

public class Guerrier extends Personnage {

    private Arme armeGuerrier;
    private String bouclier;

    /**
     *
     * @param nom
     * @param image
     * @param vie
     * @param force
     * @param armeGuerrier
     */
    public Guerrier(String nom, String image, int vie, int force, Arme armeGuerrier) {
        super(nom, image, vie, force);
        this.armeGuerrier = armeGuerrier;
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
        return super.toString() + armeGuerrier.toString();
    }
}