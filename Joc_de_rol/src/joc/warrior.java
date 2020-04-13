
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
        
        dfInicial=defensePoints;
        atInicial=attackPoints;

        System.out.println("CONSTRUCTOR -> he creat un warrior");
    }

    @Override
    protected void hit(int attackPoints) {
        difAD=attackPoints-this.getDefensePoints();
        //Atac si viu o no atac si mort
        if (this.getLife() <= 0) {
            System.out.println("No hi ha atac per que no hi ha punts de vida");
        } else {//Colp
            //Condició d'agilitat
            if (difAD<=5) {
                System.out.println("¡¡¡¡El colp es reduix a 0!!!!");
                attackPoints=0;
                this.setDefensePoints(0);
            }
            System.out.println(this.getName() + " és colpejat amb " + attackPoints + " punts i es defén amb " + this.getDefensePoints() + ". Vides: " + this.getLife() + " - "
                    + +(attackPoints - this.getDefensePoints()) + " = " + (this.getLife() - (attackPoints - this.getDefensePoints())));
            
            //Viu o mort desrpres de colp
            if ((this.getLife() - (attackPoints - this.getDefensePoints())) > 0) {
            } else {
                System.out.println("El jugador " + this.getName() + " ha muerto.");
            }
            this.setLife(this.getLife() - (attackPoints - this.getDefensePoints()));
            
            //Condició de 0 si la vida es inferior a 0
            if (this.getLife() < 0) {
                this.setLife(0);
            }

        }
        attackPoints=atInicial;
        setDefensePoints(dfInicial);
    }
    
    //Condicio d'agilitat
    public void agilitatWarrior(int y){
        if ((y-this.getDefensePoints())<=5) {
                System.out.println("L'atac pasa a ser 0.");
                y=0;                
            }
    }
            

}
