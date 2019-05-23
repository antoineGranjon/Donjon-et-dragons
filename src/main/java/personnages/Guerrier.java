/**
 * Classe Guerrier (hérite de personnage)
 */

package personnages;

import armes.Arme;
import armes.Armes;
import armes.Boucliers;

public class Guerrier extends Personnage {

    private Arme armeGuerrier;
    private Boucliers bouclier;

    /**
     * @param nom Le nom du personnage
     * @param image L'image du personnage
     * @param vie La vie du personnage
     * @param force La force du personnage
     */
    public Guerrier(String nom, String image, int vie, int force) {
        super(nom, image, vie, force);
        Armes random = Armes.random();
        this.armeGuerrier = new Arme(random.getName(),random.getPuissance());
        this.bouclier = bouclier.random();
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
        return super.toString() + armeGuerrier.toString() + bouclier.toString();
    }
}