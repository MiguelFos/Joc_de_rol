package joc;

import Excepcions.attackMortException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        attPInicial = this.attackPoints;
        dfPInicial = this.defensePoints;
        aIra = this.attPInicial + 3;//Ataque con ira
        dIra = this.dfPInicial - 3;//Defensa con ira
        if (dIra < 0) {
            dIra = 0;
            aIra=this.attPInicial+defensePoints;
        }

        reinicioLife = life;
    }

    public alien(String name, int attackPoints, int defensePoints) {
        super(name, attackPoints, defensePoints);
        
        System.out.println("CONSTRUCTOR -> he creat un alien");

        attPInicial = this.attackPoints;
        dfPInicial = this.defensePoints;
        aIra = this.attPInicial + 3;//Ataque con ira
        dIra = this.dfPInicial - 3;//Defensa con ira
        if (dIra < 0) {
            dIra = 0;
            aIra=this.attPInicial+defensePoints;
        }

        reinicioLife = life;
    }
    
    

    @Override
    public void attack(player y){

        this.modeEmbogir();

        
        try {
            super.attack(y);
        } catch (attackMortException ex) {
            System.err.println(ex.getMessage());
        }
       
        

    }

    //Métode Embogir
    public void modeEmbogir() {

        if (this.getLife() > 20) {

            System.out.println(this.name + " embogix");

            System.out.println("");
            this.attackPoints = this.aIra;
            this.defensePoints = this.dIra;

        }

    }

    public void reinicio() {

        this.life = reinicioLife;
        this.attackPoints = attPInicial;//La lluita pot acabar amb el estat del personatge alterat
        this.defensePoints = dfPInicial;//i necesitar reiniciar també atac i defensa 
        System.out.println("Personatge " + this.name + " \nreiniciat per a noves lluites");
        System.out.println(this);

    }

}
