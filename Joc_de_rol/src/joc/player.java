package joc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Miguel
 */
abstract public class player implements Iterable, Cloneable {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;
    private int reinicioLife;
    private ArrayList<team> teams = new ArrayList<>();
    private int posicio = 0;

    public player() {
    }

    public player(String name, int attackPoints, int defensePoints, int life) {
        this.name = name;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.life = life;

        reinicioLife = life;

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
        posicio = 0;
        int contador = 0;
        while (posicio < this.teams.size()) {
            contador++;
            posicio++;
        }

        return name + " PA:" + attackPoints + " /  PD:" + defensePoints + " / PV:" + life + " (pertany a " + contador + " equips)";
    }

    public void attack(player y) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("");
        System.out.println("//      ABANS DE L'ATAC:");
        System.out.println(this);
        System.out.println(y);

        System.out.println("//      ATAC:");

        y.hit(attackPoints);

        if (y.life > 0) {
            this.hit(y.attackPoints);
        }

        System.out.println("//      DESPRES DE L'ATAC:");
        System.out.println(this);
        System.out.println(y);
        System.out.println("");
        System.out.println("-----------------------------------------------------------");
        System.out.println("");

    }

    protected void hit(int attackPoints) {

        if (this.life <= 0) {
            System.out.println("No hi ha atac per que no hi ha punts de vida");
        } else {
            System.out.println(this.name + " és colpejat amb " + attackPoints + " punts i es defén amb " + this.defensePoints + ". Vides: " + this.life + " - "
                    + +(attackPoints - this.defensePoints) + " = " + (this.life - (attackPoints - this.defensePoints)));
            //System.out.println("puntos de vida: " + (this.life-(attackPoints-this.defensePoints)));
            if ((this.life - (attackPoints - this.defensePoints)) > 0) {
            } else {
                System.out.println("El jugador " + this.name + " ha muerto.");
            }
            this.life = this.life - (attackPoints - this.defensePoints);
            if (this.life < 0) {
                this.life = 0;
            }

        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public void setLife(int life) {
        this.life = life;
    }

    //Métode per a reiniciar jugadors per a noves lluites
    public void reinicio() {
        this.setLife(reinicioLife);
        System.out.println("Personatge " + this.getName() + " \nreiniciat per a noves lluites");
        System.out.println(this);
    }

    public void add(team t) {
        this.teams.add(t);
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

        @Override
        public void remove() {
            int eliminar = posicio - 1;
            if (eliminar < 0) {
                return;
            }
            if (eliminar < teams.size()) {
                teams.remove(posicio - 1);
            }
        }

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

        public int calculaEquipos() {
            int calcula = 0;
            int contador = 0;
            while (calcula < teams.size()) {
                contador++;
            }
            return contador;
        }

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
