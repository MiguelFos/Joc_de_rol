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

    //Clase prova
    public static void provaClasse() {

        System.out.println("Vaig a crear un human");
        player A = new human("John Smith", 13, 8, 150);//En cas de tindre mes de 100 punts de vida, 
        System.out.println(A);                          //baixará a 100 d'eixida
        System.out.println("");
        System.out.println("Vaig a crear un alien");
        player B = new alien("Martian PK", 27, 2, 70);
        System.out.println(B);
        System.out.println("");
        System.out.println("Vaig a crear un warrior");
        player C = new warrior("Gerónimo", 9, 10, 100);
        System.out.println(C);
        System.out.println("");

        System.out.println("");

        //ATACS human contra alien
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("El personatge "+A.getName()+" lluita \ncontra el personatge "+B.getName());
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("");
        A.attack(B);
        B.attack(A);
        A.attack(B);
        B.attack(A);

        //REINICIAR Personatge
        System.out.println("////////////////////////////");
        A.reinicio();
        System.out.println("");
        B.reinicio();
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println("");

        //ATACS human contra warrior
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("El personatge "+A.getName()+" lluita \ncontra el personatge "+C.getName());
        System.out.println("+++++++++++++++++++++++++++++++++");
        A.attack(C);
        C.attack(A);
        A.attack(C);
        C.attack(A);
        
        
        //REINICIAR Personatge
        System.out.println("////////////////////////////");
        A.reinicio();
        System.out.println("");
        C.reinicio();
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println("");
        
        //ATACS human contra warrior
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("El personatge "+B.getName()+" lluita \ncontra el personatge "+C.getName());
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("");
        System.out.println("");
        B.attack(C);
        C.attack(B);
        B.attack(C);
        C.attack(B);
        
        //REINICIAR Personatge
        System.out.println("////////////////////////////");
        B.reinicio();
        System.out.println("");
        C.reinicio();
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println("");

    }
    
    //Metode d'atacs
    
    

}
