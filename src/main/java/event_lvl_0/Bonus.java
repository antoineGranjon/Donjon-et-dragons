package event_lvl_0;

public enum Bonus {
    rois("une Bénédiction des rois", 15, 15),
    vieroi("une Bénédiction de vie",0,15),
    forceroi("une Bénédiction de force",15,0),
    rien("rien du tout, pas de chance ¯\\_(ツ)_/¯",0,0),
    pizzaravioles("WOW, une pizza aux ravioles",30,30),
    icetea("une canette d'ice tea",20,20),
    panini("un panini indien de chez big",10,2),
    eau("une bouteille d'eau, c'est cool mais bon c'est pas ouf quoi",2,2),
    pourri("une potion périmée",1,1),
    petite("une petite potion",3,3),
    normal("une moyenne potion",6,6),
    grande("une grande potion",10,10),
    forcepetite("une petite potion de force",3,0),
    forcegrande("une grande potion de force",10,0),
    forcemoyenne("une moyenne potion de force",6,0),
    viepetite("une petite potion de vie",0,3),
    viemoyenne("une moyenne potion de vie",0,6),
    viegrande("une grande potion de vie",0,10);

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