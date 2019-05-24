package event;

public enum Boss {
    michel("Michel le sensei", 5, 300),
    marceline("Marceline",8,80),
    camille("Camille",12,100),
    toinou("Toinou la malice",42,420),
    ;

    private final String name;
    private final int puissance;
    private int vie;

    Boss(String name, int puissance, int vie) {
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

    public static Boss random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Arme : " + name + " - Puissance : " + puissance;
    }
}