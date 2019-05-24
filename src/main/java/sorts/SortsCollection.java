package sorts;

public enum SortsCollection {
    spell1("Spell 1",5),
    spell2("Spell 2",10),
    spell3("Spell 3", 15),
    spell4("Spell 4", 20);

    private final String name;
    private final int puissance;

    SortsCollection(String name, int puissance) {
        this.name = name;
        this.puissance = puissance;
    }

    public int getPuissance() {
        return puissance;
    }

    public String getName() {
        return name;
    }

    public static SortsCollection random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Sort : " + name + " - Puissance : " + puissance;
    }
}
