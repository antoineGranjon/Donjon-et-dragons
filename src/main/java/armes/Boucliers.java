package armes;

public enum Boucliers {
    commun("Bouclier CLAQUÉ AU SOL"),
    normal("Bouclier en bois"),
    rare("Bouclier dorée"),
    epique("Bouclier BADASS"),
    legendaire("Bouclier Hylien"),
    ancien("Bouclier ancien mais tu vois il as vécu il est solide sur ses appuis"),
    primordial("Bouclier primoridal"),
    maudit("Cursed shield"),
    mousse("Bouclier en mousse, il est un peu mou mais tranquil ça passe"),
    padbol("Pas de bouclier dommage mon pote tu feras peut-être mieux la prochaine fois je sais pas on verras bien aller bonne journée le NULOS");

    private String name = "";

    Boucliers(String name) {
        this.name = name;
    }

    public static Boucliers random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | " + name;
    }
}