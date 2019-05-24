package event;

public enum Bonus {
    rois("Bénédiction des rois", 15, 15),
    vieroi("Bénédiction de vie",0,15),
    forceroi("Bénédiction de force",15,0),
    icetea("canette d'ice tea",20,20),
    eau("bouteill d'eau, c'est cool mais bon c'est pas ouf quoi",2,2),
    pourri("Potion périmée",1,1),
    petite("Petite potion",3,3),
    normal("Moyenne potion",6,6),
    grande("Grande potion",10,10),
    forcepetite("Petite potion de force",3,0),
    forcegrande("Grande potion de force",10,0),
    forcemoyenne("moyenne potion de force",6,0),
    viepetite("Petite potion de vie",0,3),
    viemoyenne("Moyenne potion de vie",0,6),
    viegrande("Grande potion de vie",0,10);

    private final String name;
    private final int puissance;
    private final int vie;

    Bonus(String name, int puissance, int vie) {
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

    public String getName() {
        return name;
    }

    public static Bonus random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Arme : " + name + " - Puissance : " + puissance;
    }
}