package armes;

public enum Armes {
    triforce("Triforce",300),
    blaspheme("Blasphème",250),
    grandgriffe("Grand griffe", 100),
    shisui("Shisui", 175),
    lancepierre("Lance-pierre", 2),
    excalibur("Excalibur",290),
    unesouris("Une souris",5),
    pistoletaeau("Pistolet à eau",1),
    barbapapa("Barbapapa",0);



    private final String name;
    private final int puissance;

    Armes(String name, int puissance) {
        this.name = name;
        this.puissance = puissance;
    }

    public int getPuissance() {
        return puissance;
    }

    public String getName() {
        return name;
    }

    public static Armes random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Arme : " + name + " - Puissance : " + puissance;
    }
}