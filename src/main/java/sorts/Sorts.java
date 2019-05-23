package sorts;

public enum Sorts {
    bouledefeu("Boule de feu",100),
    sectumsempra("Sectum sempra",150),
    ridiculus("Ridiculus", 100),
    alohomora("Alohomora", 0);



    private final String name;
    private final int puissance;

    Sorts(String name, int puissance) {
        this.name = name;
        this.puissance = puissance;
    }

    public int getPuissance() {
        return puissance;
    }

    public String getName() {
        return name;
    }

    public static Sorts random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Sort : " + name + " - Puissance : " + puissance;
    }
}
