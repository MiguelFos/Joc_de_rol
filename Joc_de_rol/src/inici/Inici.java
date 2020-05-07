package inici;

import io.Leer;
import java.util.Iterator;
import joc.*;

/**
 *
 * @author Miguel_Fos
 */
public class Inici {

    public static void main(String[] args) {
        provaClasseV5();

    }

    //Clases prova
    
    public static void provaClasseV5() {

        //Crear players
        System.out.println("Vaig a crear un human");
        player A = new human("John Smith", 13, 8, 150);//En cas de tindre mes de 100 punts de vida, 
        System.out.println(A);                          //baixará a 100 d'eixida
        System.out.println("");
        System.out.println("Vaig a crear un alien");
        player B = new alien("Martian PK", 27, 2, 102);
        System.out.println(B);
        System.out.println("");
        System.out.println("Vaig a crear un warrior");
        player C = new warrior("Gerónimo", 9, 10, 125);
        System.out.println(C);
        System.out.println("");

        System.out.println("");

        //Crear teams
        team guais = new team("Els guais");
        Iterator<player> it;
        player play;
        Iterator<team> it2;
        team te;
        team noTanGuais = new team("Els no tan guais");
        
        //Afegir jugadors a equips
        guais.afegir(A);
        noTanGuais.afegir(A);
        guais.afegir(B);
        noTanGuais.afegir(B);
        noTanGuais.afegir(C);
        System.out.println("");
        
        //Crear Items
        item sunglasses=new item("Sunglasses", -1, -1);
        item falseNails=new item("False Nails", 5, 2);
        item demonBlade=new item("Espasa demoníaca", 12, -5);
        item dalekLight=new item("Llum Dalek", 5, 0);
        item sonicScrewdriver=new item("Tornavís sonic", 3, 0);
        item muramasaBlade=new item("Espasa de Muramasa", 6, -2);
        item woodenArmor=new item("Armadura de fusta", 0, 5);
        item soulArmor=new item("Armadura d'animes", 2, 6);
        
        System.out.println("////Items creats\\\\\\\\");
        System.out.println("");
        System.out.println(sunglasses);
        System.out.println(falseNails);
        System.out.println(demonBlade);
        System.out.println(dalekLight);
        System.out.println(sonicScrewdriver);
        System.out.println(muramasaBlade);
        System.out.println(woodenArmor);
        System.out.println(soulArmor);
        
        //Afegir items a jugadors
        A.afegirItem(soulArmor);
        A.afegirItem(sunglasses);
        A.afegirItem(falseNails);
        B.afegirItem(demonBlade);
        B.afegirItem(woodenArmor);
        B.afegirItem(muramasaBlade);
        C.afegirItem(dalekLight);
        C.afegirItem(sonicScrewdriver);
        C.afegirItem(soulArmor);
        

        System.out.println("");

//        System.out.println("////Equips amb els seus jugadors\\\\\\\\");
//        System.out.println("");
//        System.out.println(guais);
//        System.out.println("");
//        System.out.println(noTanGuais);
//        System.out.println("");
//        System.out.println("////Jugadors amb els seus equips\\\\\\\\");
//        System.out.println("");
//        System.out.println(A);
//        System.out.println(B);
//        System.out.println(C);

        System.out.println("");

        

        System.out.println("");
        System.out.println("/\\/\\/\\/\\ETAPA D'ATACS/\\/\\/\\/\\");
        System.out.println("");
        //ATACS human contra alien
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("El personatge " + A.getName() + " lluita \ncontra el personatge " + B.getName());
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
        System.out.println("El personatge " + A.getName() + " lluita \ncontra el personatge " + C.getName());
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
        System.out.println("El personatge " + B.getName() + " lluita \ncontra el personatge " + C.getName());
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
    
    
    public static void provaClasse() {

        //Crear players
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

//        //Crear teams
        team guais = new team("Els guais");
        Iterator<player> it;
        player play;
        Iterator<team> it2;
        team te;
        team noTanGuais = new team("Els no tan guais");

        guais.afegir(A);//guais.afegir(A);//agregaPlayerTeam(A, guais);
        noTanGuais.afegir(A);//agregaPlayerTeam(A, noTanGuais);
        guais.afegir(B);//agregaPlayerTeam(B, guais);
        noTanGuais.afegir(B);//agregaPlayerTeam(B, noTanGuais);
        noTanGuais.afegir(C);//agregaPlayerTeam(C, noTanGuais);

        System.out.println("");

        System.out.println("////Equips amb els seus jugadors\\\\\\\\");
        System.out.println("");
        System.out.println(guais);
        System.out.println("");
        System.out.println(noTanGuais);
        System.out.println("");
        System.out.println("////Jugadors amb els seus equips\\\\\\\\");
        System.out.println("");
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);

        System.out.println("");

        System.out.println("////Borrar jugadors\\\\\\\\");
        System.out.println("");
        System.out.println("Borrarem John Smith de guais");
        A.eliminar(guais);
        System.out.println("");
        System.out.println("Borrarem Martian PK de no tan guais");
        B.eliminar(noTanGuais);
        System.out.println(guais);

        //Consultas
        System.out.println("////Consultes\\\\\\\\");
        System.out.println("");
        System.out.println("Dades de John Smith en el grup no tan guais");
        consultandoNombres(noTanGuais, "John Smith");
        System.out.println("");
        System.out.println("Dades de Gerónimo a no tan guais");
        consultandoNombres(noTanGuais, "Gerónimo");

        //Clonacions i equals
        System.out.println("////Clonacion de guai\\\\\\\\");
        System.out.println("");
        team guaisClonat = guais.clone();
        System.out.println("");
        System.out.println("guais i el seu clon");
        System.out.println(guais);
        System.out.println(guaisClonat);
        System.out.println("");
        System.out.println("////equals de teams\\\\\\\\");
        System.out.println("");
        System.out.println("Son iguals guais i guais clonat?");
        System.out.println(guais.equals(guaisClonat));
        System.out.println("Son iguals guais i no tan guais?");
        System.out.println(guais.equals(noTanGuais));

        System.out.println("");
        System.out.println("////Clonacion de John Smith\\\\\\\\");
        System.out.println("");
        player AClonat = A.clone();
        System.out.println("");
        System.out.println("John Smith i el seu clon");
        System.out.println(A);
        System.out.println(AClonat);
        System.out.println("");
        System.out.println("////equals de players\\\\\\\\");
        System.out.println("");
        System.out.println("John Smith i el seu clon son iguals?");
        System.out.println(A.equals(AClonat));
        System.out.println("Son iguals John Smith i Gerónimo?");
        System.out.println(A.equals(C));
        System.out.println("");
        System.out.println("////equals de team i player\\\\\\\\");
        System.out.println("");
        System.out.println("Son iguals john Smith i guais?");
        System.out.println(A.equals(guais));

        System.out.println("");
        System.out.println("/\\/\\/\\/\\ETAPA D'ATACS/\\/\\/\\/\\");
        System.out.println("");
        //ATACS human contra alien
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("El personatge " + A.getName() + " lluita \ncontra el personatge " + B.getName());
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
        System.out.println("El personatge " + A.getName() + " lluita \ncontra el personatge " + C.getName());
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
        System.out.println("El personatge " + B.getName() + " lluita \ncontra el personatge " + C.getName());
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

    //Métode consulta noms
    public static void consultandoNombres(team t, String s) {
        Iterator<player> it;
        player play;
        it = t.iterator();
        while (it.hasNext()) {
            play = it.next();
            if (play.getName().equals(s)) {
                System.out.println(play);
            }
        }

    }

}
