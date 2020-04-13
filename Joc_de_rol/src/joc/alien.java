
package joc;

/**
 *
 * @author Miguel
 */
public class alien extends player {

    private int aIra;//Ataque con ira
    private int dIra;//Defensa con ira
    private int attPInicial;
    private int dfPInicial;
    private int reinicioLife;

    public alien(String name, int attackPoints, int defensePoints, int life) {

        super(name, attackPoints, defensePoints, life);

        System.out.println("CONSTRUCTOR -> he creat un alien");

        attPInicial = this.getAttackPoints();
        dfPInicial = this.getDefensePoints();
        aIra = this.attPInicial + 3;//Ataque con ira
        dIra = this.dfPInicial - 3;//Defensa con ira
        if (dIra < 0) {
            dIra = 0;
        }

        reinicioLife = life;

    }

    @Override
    public void attack(player y) {

        this.modoIra();

        System.out.println("//      ABANS DE L'ATAC:");
        System.out.println(this);
        System.out.println(y);

        System.out.println("//      ATAC:");

        y.hit(this.getAttackPoints());

        if (y.getLife() > 0) {
            this.hit(y.getAttackPoints());
        }

        System.out.println("//      DESPRES DE L'ATAC:");
        System.out.println(this);
        System.out.println(y);
        System.out.println("");

    }

    //Métode ira
    public void modoIra() {

        if (this.getLife() >= 20) {
            
                System.out.println(this.getName() + " está en modo ira");
               
            
            System.out.println("");
            this.setAttackPoints(this.aIra);
            this.setDefensePoints(this.dIra);
            

        } else {
            System.out.println(this.getName() + " no está en modo ira");
            this.setAttackPoints(this.attPInicial);
            this.setDefensePoints(this.dfPInicial);

        }

    }

    public void reinicio() {

        this.setLife(reinicioLife);
        this.setAttackPoints(attPInicial);//La lluita pot acabar amb el estat del personatge alterat
        this.setDefensePoints(dfPInicial);//i necesitar reiniciar també atac i defensa 
        System.out.println("Personatge " + this.getName() + " \nreiniciat per a noves lluites");
        System.out.println(this);
        

    }

}
