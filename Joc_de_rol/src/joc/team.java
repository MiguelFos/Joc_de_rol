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

    private ArrayList<player> players = new ArrayList<>();

    public team(String name) {
        this.nameTeam = name;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public ArrayList<player> getMemberes() {
        return players;
    }

    public void add(player y) {

        this.players.add(y);

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

        @Override
        public void remove() {

            int eliminar = posicio - 1;
            if (eliminar < 0) {
                return;
            }
            if (eliminar < players.size()) {
                players.remove(posicio - 1);
            }

        }

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

        return "********\n*\n" + "Equip \"" + this.nameTeam
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
