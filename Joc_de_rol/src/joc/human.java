
package joc;

/**
 *
 * @author Miguel
 */
public class human extends player {
    //private int maxLife=100;
    private int reinicioLife;
    public human(String name, int attackPoints, int defensePoints, int life) {
        
        //super(name, attackPoints, defensePoints, life=(life>100)?100:life);
        super(name, attackPoints, defensePoints, life>100?100:life);

            //Condició per a que la vida de l'huma no siga superior a 100
        if (this.life>100) {
            this.life=100;        
        }
        reinicioLife=life;
        System.out.println("CONSTRUCTOR -> he creat un human");

    }
    
    @Override//Encara que hereta el métode si no sobreescribim, la vida, en cas de ser introduida a mes 100
    public void reinicio(){//no es reniciara a 100, si no al valor major a 100 que li donem
        this.life=reinicioLife;
        System.out.println("Personatge "+this.name+" \nreiniciat per a noves lluites");
        System.out.println(this);
    }

}
