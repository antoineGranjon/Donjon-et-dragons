package sorts;

public enum Philtres {
    felicis("Felix felicis"),
    puissance("Philtre de puissance"),
    vie("Philtre de vie"),
    infini("Potion de soin"),
    amnesie("Philtre d'amnésie"),
    eclatax("Philtre ECLATAX");

    private String name = "";

    Philtres(String name) {
        this.name = name;
    }

    public static Philtres random() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String toString() {
        return " | Philtre : " + name ;
    }
}