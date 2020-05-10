package inici;

import Excepcions.afegirEquipJugadorException;
import Excepcions.attackMortException;
import Excepcions.equipExistException;
import Excepcions.numeroJugadorsException;
import io.Leer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import joc.*;

/**
 *
 * @author Miguel_Fos
 */
public class Inici {

    public static ArrayList<player> jugadors = new ArrayList<>();
    public static ArrayList<team> equips = new ArrayList<>();
    public static ArrayList<item> armes = new ArrayList<>();

    public static void main(String[] args) {

        provaClasseV6();

    }

    //Clases prova
    public static void provaClasseV6() {

        jocDeRol();

    }

    //Metode joc de rol
    public static void jocDeRol() {
        
        //Jugadors,grups i armes per a fer probes. No cumplixen les regles que si es cumplixen al 
        //crear personatges al programa.
        //Les excepcions no m'apareixen al lloc quan faig un run project pero si quan prove fent un debug
        //marcant la excepció. 
        player jugador1 = new human("Miguel", 80, 40, 100);
        player jugador2 = new alien("Martian", 80, 40, 100);
        player jugador3 = new warrior("Arthur", 80, 40, 100);
        player jugador4 = new human("Charly", 80, 40, 100);
        jugadors.add(jugador1);
        jugadors.add(jugador2);
        jugadors.add(jugador3);
        jugadors.add(jugador4);
        team Guays = new team("Guays");
        equips.add(Guays);
        item espasa1 = new item("Espasa flamigera", 5, 1);
        armes.add(espasa1);
        item espasa2 = new item("Espasa gel", 4, 2);
        armes.add(espasa2);
        //Final de jugadors, grups i armes per a fer proves.
        
        System.out.println("////MENU DEL JOC\\\\\\\\");
        boolean joc = true;
        while (joc == true) {
            int menuJoc = Leer.leerEntero("Introdueix una opció:"
                    + "\n1-Configuració."
                    + "\n2-Jugar."
                    + "\n3-Eixir.");
            switch (menuJoc) {
                case 1:
                    configuracio();
                    break;
                case 2: {
                    try {
                        jugar();
                    } catch (numeroJugadorsException ex) {
                        System.out.println("");
                        System.out.println("No hi ha prou jugadors per a fer una batalla\nCrea mes personatges.");
                        System.out.println("");
                    }
                }
                break;

                case 3:
                    joc = false;
                    System.out.println("Eixim del joc.");
                    break;
                default:
                    System.out.println("");
                    System.err.println("Marca una opcio válida");
                    System.out.println("");
            }
        }
        joc = true;

    }

    //Métode configuració
    public static void configuracio() {
        System.out.println("////MENU DE CONFIGURACIÓ\\\\\\\\");
        boolean menuConf = true;
        while (menuConf == true) {
            int conf = Leer.leerEntero("Introdueix una opció:"
                    + "\n1-Gestió de jugadors."
                    + "\n2-Gestió d'equips."
                    + "\n3-Gestió objectes."
                    + "\n4-Eixir.");
            switch (conf) {
                case 1:

                {
                    try {
                        gestioJugadors();
                    } catch (afegirEquipJugadorException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                    break;

                case 2: {
                    try {
                        gestioEquips();
                    } catch (afegirEquipJugadorException ex) {
                        System.out.println("");
                        System.out.println(ex.getMessage());
                        System.out.println("");
                    }
                }
                break;

                case 3:
                    gestioObjectes();
                    break;
                case 4:
                    menuConf = false;
                    System.out.println("Tornem al menu anterior.");
                    break;
                default:
                    System.out.println("");
                    System.err.println("Marca una opcio válida");
                    System.out.println("");
            }
        }
        menuConf = true;
    }

    //Métode gestió jugadors
    public static void gestioJugadors() throws afegirEquipJugadorException {
        System.out.println("////MENU DE GESTIÓ DE JUGADORS\\\\\\\\");
        boolean existeix = false;
        boolean existeix2 = false;
        boolean gj = true;
        while (gj == true) {
            int menuGJ = Leer.leerEntero("Introdueix una opció:"
                    + "\n1-Crear jugador."
                    + "\n2-Mostrar jugadors."
                    + "\n3-Esborrar jugadors."
                    + "\n4-Assignar jugador a equip."
                    + "\n5-Assignar objecte a jugador."
                    + "\n6-Eixir.");

            switch (menuGJ) {
                case 1:

                    elegixTipus();
                    break;
                case 2:
                    mostrarJugadors();
                    break;
                case 3:
                    System.out.println("Jugadors existents");
                    mostrarJugadors();
                    String borrJug = Leer.leerTexto("Quin jugador vols borrar? ");
                    existeix = comprobarExistenciaJugadors(borrJug);
                    if (existeix == true) {
                        borrarJugadors(borrJug);
                    } else {
                        System.out.println("El jugador no existeix");
                    }

                    break;
                case 4:
                    System.out.println("Jugadors existents");
                    mostrarJugadors();
                    String asigJE = Leer.leerTexto("Que jugador vols asignar? ");
                    existeix = comprobarExistenciaJugadors(asigJE);
                    System.out.println("Equips existents");
                    mostrarEquips();
                    String asigEJ = Leer.leerTexto("A quin equip el vols asignar?");
                    existeix2 = comprobarExistenciaEquips(asigEJ);
                    if (existeix==false || existeix2==false) {
                        throw new afegirEquipJugadorException("Algún dels parametres es equivocat");
                    }else{
                        asignarJugadorEquip(asigEJ, asigJE);
                    }
//                    if (existeix == true && existeix2 == true) {
//                        asignarJugadorEquip(asigEJ, asigJE);
//                    } else {
//                        System.out.println("");
//                        System.out.println("Dades incorrectes, no s'asignara jugador a equip.");
//                        System.out.println("");
//                    }

                    break;
                case 5:
                    System.out.println("Armes existents");
                    mostrarObjectes();
                    String nameArmaAs = Leer.leerTexto("Quina arma vols asignar?");
                    existeix2 = comprobarExistenciaArmes(nameArmaAs);
                    System.out.println("Jugadors disponibles");
                    mostrarJugadors();
                    String nameJugAr = Leer.leerTexto("A quin jugador li la vols asignar?");
                    existeix = comprobarExistenciaJugadors(nameJugAr);
                    if (existeix == true && existeix2 == true) {
                        asignarArmaJugador(nameArmaAs, nameJugAr);
                    } else {
                        System.out.println("");
                        System.out.println("Dades incorrectes, no asignarem arma a jugador");
                        System.out.println("");
                    }

                    break;
                case 6:
                    System.out.println("");
                    gj = false;
                    System.out.println("Tornem al menu anterior.");
                    break;
                default:
                    System.out.println("");
                    System.err.println("Marca una opcio válida");
                    System.out.println("");
            }

        }
        gj = true;
    }

    //Métode gestió equips
    public static void gestioEquips() throws afegirEquipJugadorException {
        System.out.println("////MENU DE GESTIÓ D'EQUIPS\\\\\\\\");
        boolean existeix = false;
        boolean existeix2 = false;
        boolean ge = true;
        while (ge == true) {
            int menuGE = Leer.leerEntero("Introdueix una opció:"
                    + "\n1-Crear equip."
                    + "\n2-Mostrar equips."
                    + "\n3-Esborrar equips."
                    + "\n4-Assignar equip a jugador."
                    + "\n5-Eixir.");

            switch (menuGE) {
                case 1: {
                    try {
                        creaEquip();
                    } catch (equipExistException ex) {
                        System.out.println("");
                        System.out.println(ex.getMessage());
                        System.out.println("");
                    }
                }
                break;

                case 2:
                    mostrarEquips();
                    break;
                case 3:
                    System.out.println("Equips existents:");
                    mostrarEquips();
                    String nameEquip = Leer.leerTexto("Quin equip vols borrar?");
                    existeix = comprobarExistenciaEquips(nameEquip);
                    if (existeix == true) {
                        borrarEquips(nameEquip);
                    } else {
                        System.out.println("No existeix ixe equip");
                    }

                    break;
                case 4:
                    System.out.println("Equips existents");
                    mostrarEquips();
                    String asigEJ = Leer.leerTexto("Quin equip vols asignar?");
                    existeix = comprobarExistenciaEquips(asigEJ);
                    System.out.println("Jugadors existents");
                    String asigJE = Leer.leerTexto("A que jugador el vols asignar? ");
                    existeix2 = comprobarExistenciaJugadors(asigJE);
                    if (existeix == false || existeix2 == false) {
                        throw new afegirEquipJugadorException("Algún dels dos no existeix");
                    } else {
                        asignarJugadorEquip(asigEJ, asigJE);
                    }

                    break;
                case 5:
                    System.out.println("");
                    ge = false;
                    System.out.println("Tornem al menu anterior.");
                    break;
                default:
                    System.out.println("");
                    System.err.println("Marca una opcio válida");
                    System.out.println("");
            }

        }
        ge = true;
    }

    //Métode gestió objectes
    public static void gestioObjectes() {
        System.out.println("////MENU DE GESTIÓ DE OBJECTES\\\\\\\\");
        boolean existent = false;
        boolean existent2 = false;
        boolean go = true;
        while (go == true) {
            int menuGO = Leer.leerEntero("Introdueix una opció:"
                    + "\n1-Crear objecte."
                    + "\n2-Mostrar objecte."
                    + "\n3-Esborrar objecte."
                    + "\n4-Assignar objecte a jugador."
                    + "\n5-Eixir.");

            switch (menuGO) {
                case 1:
                    creaObjecte();
                    break;
                case 2:
                    mostrarObjectes();
                    break;
                case 3:
                    System.out.println("Armes existents");
                    mostrarObjectes();
                    String nameArma = Leer.leerTexto("Com es diu l'arma que vols borrar?");
                    existent = comprobarExistenciaArmes(nameArma);
                    if (existent == true) {
                        borrarArmes(nameArma);
                    } else {
                        System.out.println("L'arma no existeix, no es pot borrar");
                    }

                    break;
                case 4:
                    System.out.println("Armes existents");
                    mostrarObjectes();
                    String nameArmaAs = Leer.leerTexto("Quina arma vols asignar?");
                    existent = comprobarExistenciaArmes(nameArmaAs);
                    System.out.println("Jugadors existents");
                    String nameJugAr = Leer.leerTexto("A quin jugador li la vols asignar?");
                    existent2 = comprobarExistenciaJugadors(nameJugAr);
                    if (existent == true && existent2 == true) {
                        asignarArmaJugador(nameArmaAs, nameJugAr);
                    } else {
                        System.out.println("Dades incorrecte, no es pot assignar objecte a jugador");
                    }

                    break;
                case 5:
                    System.out.println("");
                    go = false;
                    System.out.println("Tornem al menu anterior.");
                    break;
                default:
                    System.out.println("");
                    System.err.println("Marca una opcio válida");
                    System.out.println("");
            }

        }
        go = true;
    }

    //Metode jugar
    public static void jugar() throws numeroJugadorsException {
        int muertos = 1;
        String guanyador = "";

        if (jugadors.size() < 2) {
            throw new numeroJugadorsException("No hi ha prou jugadors");
        } else {
            while (jugadors.size() > muertos) {

                int posiciojug1, posiciojug2;

                do {
                    posiciojug1 = (int) Math.floor((Math.random() * jugadors.size()));
                } while (jugadors.get(posiciojug1).getLife() <= 0);

                do {
                    posiciojug2 = (int) Math.floor((Math.random() * jugadors.size()));
                } while (posiciojug1 == posiciojug2 || jugadors.get(posiciojug2).getLife() <= 0);

                try {
                    jugadors.get(posiciojug1).attack(jugadors.get(posiciojug2));
                } catch (attackMortException ex) {
                    System.err.println(ex.getMessage());
                }

                //System.out.println(posiciojug2);
                System.out.println("");
                muertos = 1;
                for (int i = 0; i < jugadors.size(); i++) {
                    if (jugadors.get(i).getLife() <= 0) {
                        muertos++;
                    }
                    if (jugadors.get(i).getLife() > 0) {
                        guanyador = jugadors.get(i).getName();
                    }
                }

            }
        }

        System.out.println("El guanyador es " + guanyador + ".");
        System.out.println("");
        for (int i = 0; i < jugadors.size(); i++) {
            jugadors.get(i).reinicio();
        }

    }

    //Métode crea tipus de jugador
    public static void elegixTipus() {
//        String nomp="";
//        int attack=0;
//        int defense=0;
//        int life=0;
        int tipus = Leer.leerEntero("Quin tipus de personatge vols crear?"
                + " \n1-Human \n2-Alien \n3-Warrior.");
        String nomp = "";
        int attack = 0;
        int life = 0;
        String lifeSN = "";

        nomp = Leer.leerTexto("Dona-li nom al teu personatge: ");
        boolean existeix = comprobarExistenciaJugadors(nomp);
        if (existeix == false) {
            switch (tipus) {
                case 1:

                    do {
                        attack = Leer.leerEntero("Quin atac tindrá? Valor de 1-100"
                                + "\n Has de tindre en conter que la defensa resultará de restarli a 100 l'atack.");
                    } while (attack < 1 || attack > 100);

                    lifeSN = Leer.leerTexto("Vols definir el valor dels punts de vida o vols tindre 100 per defecte?\n"
                            + "s- Si\nn- No");

                    if (lifeSN.equalsIgnoreCase("s")) {
                        life = Leer.leerEntero("Quina vida tindrá?");
                        creaHuman(nomp, attack, 100 - attack, life);
                    } else if (lifeSN.equalsIgnoreCase("n")) {
                        System.out.println("Life = 100");
                        creaHumanL100(nomp, attack, 100 - attack);
                    } else {
                        System.out.println("Opció introduida incorrecta. Es definirá de manera automática.");
                        creaHumanL100(nomp, attack, 100 - attack);
                    }

                    break;
                case 2:
                    //nomp = Leer.leerTexto("Dona-li nom al teu personatge: ");
                    do {
                        attack = Leer.leerEntero("Quin atac tindrá? Valor de 1-100"
                                + "\n Has de tindre en conter que la defensa resultará de restarli a 100 l'atack.");
                    } while (attack < 1 || attack > 100);

                    lifeSN = Leer.leerTexto("Vols definir el valor dels punts de vida o vols tindre 100 per defecte?\n"
                            + "s- Si\nn- No");

                    if (lifeSN.equalsIgnoreCase("s")) {
                        life = Leer.leerEntero("Quina vida tindrá?");
                        creaAlien(nomp, attack, 100 - attack, life);
                    } else if (lifeSN.equalsIgnoreCase("n")) {
                        System.out.println("Life = 100");
                        creaAlienL100(nomp, attack, 100 - attack);
                    } else {
                        System.out.println("Opció introduida incorrecta. Es definirá de manera automática.");
                        creaAlienL100(nomp, attack, 100 - attack);
                    }

                    break;
                case 3:
                    //nomp = Leer.leerTexto("Dona-li nom al teu personatge: ");
                    do {
                        attack = Leer.leerEntero("Quin atac tindrá? Valor de 1-100"
                                + "\n Has de tindre en conter que la defensa resultará de restarli a 100 l'atack.");
                    } while (attack < 1 || attack > 100);

                    lifeSN = Leer.leerTexto("Vols definir el valor dels punts de vida o vols tindre 100 per defecte?\n"
                            + "s- Si\nn- No");

                    if (lifeSN.equalsIgnoreCase("s")) {
                        life = Leer.leerEntero("Quina vida tindrá?");
                        creaWarrior(nomp, attack, 100 - attack, life);
                    } else if (lifeSN.equalsIgnoreCase("n")) {
                        System.out.println("Life = 100");
                        creaWarriorL100(nomp, attack, 100 - attack);
                    } else {
                        System.out.println("Opció introduida incorrecta. Es definirá de manera automática.");
                        creaWarriorL100(nomp, attack, 100 - attack);
                    }

                    break;
                default:
                    System.out.println("");
                    System.out.println("Opció equivocada, prova de nou.");
                    System.out.println("");
                    elegixTipus();
            }
        } else {
            System.out.println("");
            System.out.println("El jugador ja existeix!!!!\nTorna a probar...");
            System.out.println("");
        }
        //int defense=100-attack;

    }

    //Crear humá    
    public static void creaHuman(String name, int attack, int defense, int life) {
        System.out.println("");
        player p = new human(name, attack, defense, life);
        jugadors.add(p);

    }

    public static void creaHumanL100(String name, int attack, int defense) {
        System.out.println("");
        player p = new human(name, attack, defense);
        jugadors.add(p);

    }

    //Crear alien
    public static void creaAlien(String name, int attack, int defense, int life) {
        System.out.println("");
        player p = new alien(name, attack, defense, life);
        jugadors.add(p);

    }

    public static void creaAlienL100(String name, int attack, int defense) {
        System.out.println("");
        player p = new alien(name, attack, defense);
        jugadors.add(p);

    }

    //Crear warrior
    public static void creaWarrior(String name, int attack, int defense, int life) {
        System.out.println("");
        player p = new warrior(name, attack, defense, life);
        jugadors.add(p);

    }

    public static void creaWarriorL100(String name, int attack, int defense) {
        System.out.println("");
        player p = new warrior(name, attack, defense);
        jugadors.add(p);

    }

    //Comprobar existencia en array
    public static boolean comprobarExistenciaJugadors(String s) {
        boolean existeix = false;
        for (int i = 0; i < jugadors.size(); i++) {
            if (jugadors.get(i).getName().equalsIgnoreCase(s)) {
                existeix = true;
                break;
            }
        }
        return existeix;
    }

    public static boolean comprobarExistenciaEquips(String s) {
        boolean existeix = false;
        for (int i = 0; i < equips.size(); i++) {
            if (equips.get(i).getNameTeam().equalsIgnoreCase(s)) {
                existeix = true;
                break;
            }
        }
        return existeix;
    }

    public static boolean comprobarExistenciaArmes(String s) {
        boolean existeix = false;
        for (int i = 0; i < armes.size(); i++) {
            if (armes.get(i).getName().equalsIgnoreCase(s)) {
                existeix = true;
                break;
            }
        }
        return existeix;
    }

    //Crear equips
    public static void creaEquip() throws equipExistException {
        boolean existeix = false;
        System.out.println("");
        String nameEquip = Leer.leerTexto("Quin nom vols posar-li a l'equip?");
        System.out.println("");
        team t = new team(nameEquip);
        existeix = comprobarExistenciaEquips(nameEquip);
        if (existeix == true) {
            throw new equipExistException("L'equip existeix ja.");
        }
        equips.add(t);
    }

    //Crear objectes
    public static void creaObjecte() {
        boolean existeix = false;
        System.out.println("");
        String nameObjecte = Leer.leerTexto("Quin nom te l'objecte?");
        existeix = comprobarExistenciaArmes(nameObjecte);
        if (existeix == false) {
            int bonusAtac = Leer.leerEntero("Quin bonus d'atac s'aplicará a l'objecte?");
            int bonusDefensa = Leer.leerEntero("Quin bonus de defensa s'aplicará a l'objecte?");
            item arma = new item(nameObjecte, bonusAtac, bonusDefensa);
            armes.add(arma);
        } else {
            System.out.println("");
            System.out.println("No podem crear l'arma, ja existeix");
            System.out.println("");
        }

    }

    //Mostrar jugadors
    public static void mostrarJugadors() {

        if (jugadors.size() > 0) {
            for (int i = 0; i < jugadors.size(); i++) {
                System.out.println(jugadors.get(i));
                System.out.println("");
            }
        } else {
            System.out.println("");
            System.out.println("No hi ha jugadors que mostrar");
            System.out.println("");
        }

    }

    //Mostrar equips    
    public static void mostrarEquips() {
        if (equips.size() > 0) {
            for (int i = 0; i < equips.size(); i++) {
                System.out.println(equips.get(i));
                System.out.println("");
            }
        } else {
            System.out.println("");
            System.out.println("No hi ha equips que mostrar");
            System.out.println("");
        }

    }

    //Mostrar objectes
    public static void mostrarObjectes() {
        if (armes.size() > 0) {
            for (int i = 0; i < armes.size(); i++) {
                System.out.println(armes.get(i));
                System.out.println("");
            }
        } else {
            System.out.println("");
            System.out.println("No hi ha armes que mostrar");
            System.out.println("");
        }

    }

    public Iterator<player> iterator() {
        return jugadors.iterator();
    }

    public static void borrarJugadors(String s) {

        Iterator<player> it;
        player p = null;
        player r = null;
        it = jugadors.iterator();
        //p=jugadors.get(0);
        while (it.hasNext()) {

            p = it.next();
            if (p.getName().equalsIgnoreCase(s)) {
                it.remove();
                r = p;
                break;
            }

        }

        Iterator<team> it2;
        team t;

        it2 = equips.iterator();
        while (it2.hasNext()) {
            t = it2.next();
            if (t.getMembers().contains(r)) {
                r.eliminar(t);
            }
        }
    }

    public static void borrarEquips(String s) {

        Iterator<team> it;
        team t = null;
        team r = null;
        it = equips.iterator();
        //p=jugadors.get(0);
        while (it.hasNext()) {

            t = it.next();
            if (t.getNameTeam().equalsIgnoreCase(s)) {
                it.remove();
                r = t;
                break;
            }

        }

        Iterator<player> it2;
        player p;

        it2 = jugadors.iterator();
        while (it2.hasNext()) {
            p = it2.next();
            if (p.getTeams().contains(r)) {
                r.eliminar(p);
            }
        }
    }

    public static void borrarArmes(String s) {
        Iterator<item> it;
        item i = null;
        item r = null;
        it = armes.iterator();
        while (it.hasNext()) {

            i = it.next();
            if (i.getName().equalsIgnoreCase(s)) {
                it.remove();
                r = i;
                break;
            }

        }
        Iterator<player> it2;
        player p;
        it2 = jugadors.iterator();
        while (it2.hasNext()) {
            p = it2.next();
            if (p.getItems().contains(r)) {
                p.eliminarItem(r);
            }
        }
    }

    public static void asignarJugadorEquip(String e, String j) {

        Iterator<player> it;
        player p = null;
        player q = null;
        it = jugadors.iterator();
        while (it.hasNext()) {
            p = it.next();
            if (p.getName().equalsIgnoreCase(j)) {

                q = p;
            }
        }
        Iterator<team> it2;
        team t = null;
        team s = null;
        it2 = equips.iterator();
        while (it2.hasNext()) {
            t = it2.next();
            if (t.getNameTeam().equalsIgnoreCase(e)) {
                s = t;
            }
        }
        q.afegir(s);

    }

    public static void asignarArmaJugador(String a, String j) {
        Iterator<player> it;
        player p = null;
        player q = null;
        it = jugadors.iterator();
        while (it.hasNext()) {
            p = it.next();
            if (p.getName().equalsIgnoreCase(j)) {

                q = p;
            }
        }
        Iterator<item> it2;
        item t = null;
        item s = null;
        it2 = armes.iterator();
        while (it2.hasNext()) {
            t = it2.next();
            if (t.getName().equalsIgnoreCase(a)) {
                s = t;
            }
        }
        q.afegirItem(s);
    }

    //Métode consulta noms
    public static void consultaJugadors(String s) {
        Iterator<player> it;
        player p;
        it = jugadors.iterator();
        while (it.hasNext()) {
            p = it.next();
            if (p.getName().equals(s)) {
                System.out.println(p);
            }
        }

    }

    //Métode consulta noms per a asignar
//    public static void consultaJugadorsPerAsignar(String s, player jugador) {
//        Iterator<player> it;
//        player p;
//        it = jugadors.iterator();
//        while (it.hasNext()) {
//            p = it.next();
//            if (p.getName().equals(s)) {
//                jugador=p.clone();
//            }
//        }
//
//    }
    //Métode consulta equips per a asignar
//    public static void consultaEquipsPerAsignar(String s, team equip) {
//        Iterator<team> it;
//        team t;
//        it = equips.iterator();
//        while (it.hasNext()) {
//            t = it.next();
//            if (t.getNameTeam().equals(s)) {
//                equip=t.clone();
//            }
//        }
//
//    }
    //Métode consulta noms
    public static void consultaJugadorsEnTeam(team t, String s) {
        Iterator<player> it;
        player p;
        it = t.iterator();
        while (it.hasNext()) {
            p = it.next();
            if (p.getName().equals(s)) {
                System.out.println(p);
            }
        }

    }

}
