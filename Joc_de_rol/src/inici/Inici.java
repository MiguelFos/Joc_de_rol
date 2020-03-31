package inici;

import io.Leer;
import joc.*;

/**
 *
 * @author Miguel_Fos
 */
public class Inici {

    public static void main(String[] args) {
        provaClasse();
        
       
        
    }
    
    

    public static void provaClasse() {
        System.out.println("Vaig a crear un human");
        player A = new human("John Smith", 13, 8, 39);
        System.out.println(A);
        System.out.println("");
        System.out.println("Vaig a crear un alien");
        player B = new alien("Martian PK", 27, 2, 32);
        System.out.println(B);
        System.out.println("");
        System.out.println("Vaig a crear un warrior");
        player C = new warrior("Gerónimo", 9, 4, 100);
        System.out.println(C);
        System.out.println("");
        
        
        
        
        
        
        A.attack(B);
        B.attack(A);
        A.attack(B);
        
            
            
        
        
        
        

      
                
    }
    
    
    
    
    

}
