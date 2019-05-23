/**
 * Classe Magicien (hérite de personnage)
 */

package personnages;

import sorts.Philtres;
import sorts.Sort;
import sorts.Sorts;

public class Magicien extends Personnage {

    private Sort sortMagicien;
    private Philtres philtre;

    /**
     * @param nom
     * @param image
     * @param vie
     * @param force
     */
    public Magicien(String nom, String image, int vie, int force) {
        super(nom, image, vie, force);
        Sorts random = Sorts.random();
        this.sortMagicien = new Sort(random.getName(), random.getPuissance());
        this.philtre = philtre.random();
    }

    public Magicien(String nom, String image, int vie, int force,Sort sortMagicien) {
        super(nom, image, vie, force);
        Sorts random = Sorts.random();
        this.sortMagicien = sortMagicien;
        this.philtre = philtre.random();
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
        return super.toString() + sortMagicien.toString() + philtre.toString();
    }
}