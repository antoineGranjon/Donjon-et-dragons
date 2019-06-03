package event;

public enum Boss_lvl_0 {
    michel("Michel le sensei", 5, 300),
    marceline("Markeline",5,80),
    camille("Camille",6,100);

    private final String name;
    private final int puissance;
    private int vie;

    Boss_lvl_0(String name, int puissance, int vie) {
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

    public static Boss_lvl_0 random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Arme : " + name + " - Puissance : " + puissance;
    }
}