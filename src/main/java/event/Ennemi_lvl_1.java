package event;

public enum Ennemi_lvl_1 {
    encounter_1("NAME1", 5, 15),
    encounter_2("NAME2", 6, 18),
    encounter_3("NAME3", 7, 20),
    encounter_4("NAME4", 8, 22),
    encounter_5("NAME5", 9, 24),
    encounter_6("NAME6", 10, 26),
    encounter_7("NAME7", 11, 28),
    encounter_8("NAME8", 12, 30);

    private final String name;
    private final int puissance;
    private int vie;

    Ennemi_lvl_1(String name, int puissance, int vie) {
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

    public static Ennemi_lvl_1 random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Arme : " + name + " - Puissance : " + puissance;
    }
}