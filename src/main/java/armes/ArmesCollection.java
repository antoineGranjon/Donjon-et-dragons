package armes;

public enum ArmesCollection {
    blaspheme("Blasphème", 15),
    shisui("Shisui", 20),
    nike("Une paire de nike", 8),
    epeeenbois("Une épée en bois", 5),
    lancepierre("Lance-pierre", 5),
    unesouris("Une souris", 5),
    pistoletaeau("Pistolet à eau", 5),
    barbapapa("Barbapapa", 1);


    private final String name;
    private final int puissance;

    ArmesCollection(String name, int puissance) {
        this.name = name;
        this.puissance = puissance;
    }

    public int getPuissance() {
        return puissance;
    }

    public String getName() {
        return name;
    }

    public static ArmesCollection random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Arme : " + name + " - Puissance : " + puissance;
    }
}