package inici;

import io.Leer;
import joc.*;

/**
 *
 * @author Miguel_Fos
 */
public class Inici {

    public static void main(String[] args) {
        provaClasse();
    }

    public static void provaClasse() {

        player playerHuman = new human();
        System.out.println("");
        player playerWarrior = new warrior();
        System.out.println("");
        player playerAlien = new alien();
        System.out.println("");

    }
    

}
