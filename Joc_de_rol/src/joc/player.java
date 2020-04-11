/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;

/**
 *
 * @author damsp
 */
abstract public class player {

    private String name;
    private int attackPoints;
    private int defensePoints;
    private int life;
    private int reinicioLife;

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
        return name + " PA:" + attackPoints + " /  PD:" + defensePoints + " / PV:" + life;
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
}
