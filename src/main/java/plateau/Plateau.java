package plateau;

import java.util.Hashtable;

public class Plateau {

    private Hashtable plateau;

    public Plateau(){
        this.plateau = new Hashtable();
        for (int i = 0; i < 10; i++){
            plateau.put(i,event());
            System.out.println(plateau.get(i).toString());
        }
        event();
    }

    public static String event(){
        String[] tab = new String[2];
        tab[0] = "bonus";
        tab[1] = "malus";
        String test = tab[(int) (Math.random() * tab.length)];
        return test;
    }
}
