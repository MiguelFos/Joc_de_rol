package joc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author Miguel
 */
public class team implements Iterable, Cloneable {

    private String nameTeam;

    private ArrayList<player> players;
    
    public team() {
        
    }

    public team(String name) {
        this.nameTeam = name;
        this.players = new ArrayList<>();
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public ArrayList<player> getMembers() {
        return players;
    }

    public void afegir(player y) {

        if (players.contains(y)) {
            return;
        }

        players.add(y);
        y.afegir(this);

    }

    public void eliminar(player y) {

        if (players.contains(y)) {
            players.remove(y);
            y.eliminar(this);
        }

    }

    protected class IteradorDplayers implements Iterator<player> {

        private int posicio = 0;

        @Override
        public boolean hasNext() {
            return posicio < players.size();
        }

        @Override
        public player next() {
            return players.get(posicio++);
        }

//        @Override
//        
//        public void remove() {
//
//            int eliminar = posicio - 1;
//            
//            if (eliminar < 0) {
//                return;
//            }
//            if (eliminar < players.size()) {
//                players.remove(posicio-1);
//            }
//
//        }

        public void consulta() {

            int consulta = posicio - 1;
            if (consulta < 0) {
                return;
            }
            if (consulta < players.size()) {
                players.get(posicio - 1);
            }

            System.out.println(posicio - 1);
        }

//        @Override
//        public void remove() {
//            Iterator.super.remove(); //To change body of generated methods, choose Tools | Templates.
//        }

    }

    @Override
    public Iterator<player> iterator() {
        return new IteradorDplayers();
    }

    @Override
    public String toString() {

        String equipo = "";

        for (player jugadores : players) {
            equipo = equipo + jugadores + "\n";
        };

        return "********\n*\n" + "Equip \"" + nameTeam
                + "\":\n*\n" + equipo + "*\n********";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final team other = (team) obj;
        if (!Objects.equals(this.nameTeam, other.nameTeam)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public team clone() {
        team nou = null;
        try {
            nou = (team) super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Error de clonació");
        }
        return nou;
    }

}
