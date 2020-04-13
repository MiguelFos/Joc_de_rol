
package joc;

/**
 *
 * @author Miguel
 */
public class human extends player {
    private int maxLife=100;
    private int reinicioLife;
    public human(String name, int attackPoints, int defensePoints, int life) {
        
        //super(name, attackPoints, defensePoints, life=(life>100)?100:life);
        super(name, attackPoints, defensePoints, life);

            //Condició per a que la vida de l'huma no siga superior a 100
        if (getLife()>this.maxLife) {
            this.setLife(this.maxLife);
        reinicioLife=getLife();
        }
        System.out.println("CONSTRUCTOR -> he creat un human");

    }
    
    @Override//Encara que hereta el métode si no sobreescribim, la vida, en cas de ser introduida a mes 100
    public void reinicio(){//no es reniciara a 100, si no al valor major a 100 que li donem
        this.setLife(reinicioLife);
        System.out.println("Personatge "+this.getName()+" \nreiniciat per a noves lluites");
        System.out.println(this);
    }

}
