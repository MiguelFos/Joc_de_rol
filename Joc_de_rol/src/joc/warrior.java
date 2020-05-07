package joc;

/**
 *
 * @author Miguel
 */
public class warrior extends player {

    private int dfInicial;
    private int atInicial;
    private int difAD;

    public warrior(String name, int attackPoints, int defensePoints, int life) {

        super(name, attackPoints, defensePoints, life);

        dfInicial = defensePoints;
        atInicial = attackPoints;

        System.out.println("CONSTRUCTOR -> he creat un warrior");
    }

    @Override
    protected void hit(int attackPoints) {
        difAD = attackPoints - this.defensePoints;
        if (difAD <= 5) {
            System.out.println("¡¡¡¡El colp es reduix a 0!!!!");
            attackPoints = 0;
            //this.defensePoints = 0;
        }
        super.hit(attackPoints);
        attackPoints = atInicial;
        defensePoints = dfInicial;
    }

}