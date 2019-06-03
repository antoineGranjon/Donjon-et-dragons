package event;

public enum Ennemi_lvl_0 {
    ungarsbourre("un gars bourré", 2, 15),
    unetruite("une truite",1,5),
    legarsdchezbig("le gars de chez big",5,10),
    benginx("Benginx, l'homme serveur",4,25),
    damien("Damien (il pousse à la salle)",5,15),
    arthar("arthar (il à des boules de neige)",6,12),
    lafilledufond("la fille du fond",6,20),
    unindus("un indus",0,1),
    jp("jp (il à une guitare)",5,18),
    max("maxime (attention aux dab)",6,18),
    georges("le gars de chez Georges",8,8);

    private final String name;
    private final int puissance;
    private int vie;

    Ennemi_lvl_0(String name, int puissance, int vie) {
        this.name = name;
        this.puissance = puissance;
        this.vie = vie;
    }

    public int getPuissance() {
        return puissance;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie){
        this.vie = vie;
    }

    public String getName() {
        return name;
    }

    public static Ennemi_lvl_0 random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Arme : " + name + " - Puissance : " + puissance;
    }
}