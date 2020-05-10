package joc;

import Excepcions.attackMortException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Miguel
 */
abstract public class player implements Iterable, Cloneable {

    protected String name;
    protected int attackPoints;
    protected int defensePoints;
    protected int life;
    private int reinicioLife;
    private ArrayList<team> teams;
    private int posicio = 0;
    private ArrayList<item> items;

    public player() {
    }

    public player(String name, int attackPoints, int defensePoints) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = 100;

        this.teams = new ArrayList<>();

        reinicioLife = 100;

        this.items = new ArrayList<>();

    }

    public player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;

        this.teams = new ArrayList<>();

        reinicioLife = life;

        this.items = new ArrayList<>();

    }

    public ArrayList<team> getTeams() {
        return teams;
    }

    public String getName() {
        return name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public int getLife() {
        return life;
    }

    @Override
    public String toString() {
        String litem = "";
        if (items.size() > 0) {
            litem = "\t-";
            for (item i : items) {
                litem = litem + i + "\n\t-";
            }
            litem = litem.substring(0, litem.length() - 1);
        }

        //litem=litem.substring(litem.length()-1, litem.length());
        return name + " PA:" + attackPoints + " /  PD:" + defensePoints + " / PV:" + life
                + " (pertany a " + teams.size() + " equips)\n" + litem;
    }

    public void attack(player y) throws attackMortException{
        System.out.println("-----------------------------------------------------------");
        System.out.println("");
        System.out.println("//      ABANS DE L'ATAC:");
        System.out.println(this);
        System.out.println(y);

        System.out.println("//      ATAC:");
        
        //comprobarVida(y);
        y.hit(this.aplicarBonusAttack());
//        if (y.life > 0) {
//            if (this.life > 0) {
//        //comprobarVida(this);
//        this.hit(y.aplicarBonusAttack());
////
//            }
//        }

        if (y.life<=0) {
            throw new attackMortException("No torna el colp per que está mort.");
        }else{
         this.hit(y.aplicarBonusAttack());   
        }

        System.out.println("");
        System.out.println("//      DESPRES DE L'ATAC:");
        System.out.println(this);
        System.out.println(y);
        System.out.println("");
        System.out.println("-----------------------------------------------------------");
        System.out.println("");

    }

//    public void comprobarVida(player p) throws attackMort {
//        if (p.life <= 0) {
//            throw new attackMort("El jugador no pot atacar per q esta mort");
//        } else {
//
//            if (this.life <= 0) {
//                throw new attackMort("El jugador no pot atacar per q esta mort");
//
//            }
//        }
//
//    }

    public int aplicarBonusAttack() {
        int BA = 0;//Bonus attack sense attackpoints
        int BAAA = 0;//Bonus attack amb attackpoints
        for (int i = 0; i < this.items.size(); i++) {
            BA = BA + this.items.get(i).attackBonus;
        }
        BAAA = this.attackPoints + BA;
        return BAAA;
    }

    public int aplicarBonusDefense() {
        int BD = 0;//Bonus defense sense defensepoints
        int BDAA = 0;//Bonus defense amb defensepoints
        for (int i = 0; i < items.size(); i++) {
            BD = BD + this.items.get(i).defenseBonus;
        }
        BDAA = this.defensePoints + BD;
        return BDAA;
    }

    protected void hit(int attackpoints) {

        int bonusD = this.aplicarBonusDefense();//defensePoints + el bonus de defensa
        if (bonusD < 0) {
            bonusD = 0;
        }

        if (this.life <= 0) {
            System.out.println("No hi ha atac per que no hi ha punts de vida");
        } else {
            System.out.println(this.name + " és colpejat amb " + attackpoints + " punts i es defén amb " + bonusD + ". Vides: " + this.life + " - "
                    + ((attackpoints - bonusD) < 0 ? 0 : (attackpoints - bonusD)) + " = " + (this.life - ((attackpoints - bonusD) < 0 ? 0 : (attackpoints - bonusD))));
            if ((this.life - (attackpoints - bonusD)) > 0) {
            } else {
                System.out.println("El jugador " + this.name + " ha muerto.");
            }
            this.life = this.life - ((attackpoints - bonusD) < 0 ? 0 : (attackpoints - bonusD));
            if (this.life < 0) {
                this.life = 0;
            }

        }
    }

    //Métode per a reiniciar jugadors per a noves lluites
    public void reinicio() {
        System.out.println("");
        this.life = reinicioLife;
        System.out.println("Personatge " + this.getName() + " \nreiniciat per a noves lluites");
        System.out.println(this);
    }

    public void afegir(team t) {

        if (teams.contains(t)) {
            return;
        }

        this.teams.add(t);
        t.afegir(this);
    }

    public void eliminar(team t) {

        if (teams.contains(t)) {
            teams.remove(t);
            t.eliminar(this);
        }

    }

    public void afegirItem(item I) {
        if (I.propietari == false) {
            this.items.add(I);
            I.propietari = true;
        } else {
            System.out.println("");
            System.out.println("No es pot asignar " + I.name + " a " + this.name + ", ja te propietari");
            System.out.println("");
        }

    }

    public ArrayList<item> getItems() {
        return items;
    }

    public void eliminarItem(item I) {
        if (items.contains(I)) {
            this.items.remove(I);

        }

    }

    @Override
    public Iterator<team> iterator() {
        return new IteratorDEquips();
    }

    protected class IteratorDEquips implements Iterator<team> {

        private int posicio = 0;

        @Override
        public boolean hasNext() {
            return posicio < teams.size();
        }

        @Override
        public team next() {
            return teams.get(posicio++);
        }

//        @Override
//        public void remove() {
//            int eliminar = posicio - 1;
//            if (eliminar < 0) {
//                return;
//            }
//            if (eliminar < teams.size()) {
//                teams.remove(posicio-1);
//            }
//        }
//        @Override
//        public void remove() {
//            Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
//        }
        public void consulta() {

            int consulta = posicio - 1;
            if (consulta < 0) {
                return;
            }
            if (consulta < teams.size()) {
                teams.get(posicio - 1);
            }

            System.out.println(posicio - 1);
        }

//        public int calculaEquipos() {
//            int calcula = 0;
//            int contador = 0;
//            while (calcula < teams.size()) {
//                contador++;
//            }
//            return contador;
//        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + this.attackPoints;
        hash = 53 * hash + this.defensePoints;
        hash = 53 * hash + this.life;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final player other = (player) obj;
        if (this.attackPoints != other.attackPoints) {
            return false;
        }
        if (this.defensePoints != other.defensePoints) {
            return false;
        }
        if (this.life != other.life) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public player clone() {
        player nou = null;

        try {
            nou = (player) super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Error de clonació");
        }

        return nou;
    }

}
