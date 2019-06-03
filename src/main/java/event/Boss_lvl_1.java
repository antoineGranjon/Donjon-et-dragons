package event;

public enum Boss_lvl_1   {
    boss_1("Boss 1", 5, 300),
    boss_2("Boss 2", 5, 300),
    boss_3("Boss 3", 5, 300),
    boss_4("Boss 4", 5, 300);

    private final String name;
    private final int puissance;
    private int vie;

    Boss_lvl_1(String name, int puissance, int vie) {
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

    public static Boss_lvl_1 random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Arme : " + name + " - Puissance : " + puissance;
    }
}