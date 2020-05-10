/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joc;

import java.util.Iterator;

/**
 *
 * @author damsp
 */
public class item{
    protected String name;
    protected int attackBonus;
    protected int defenseBonus;
    protected boolean propietari;

    public item(String name, int attackBonus, int defenseBonus) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.propietari = false;
    }

    @Override
    public String toString() {
        
        return name+" BA:"+attackBonus+" / BD:"+defenseBonus;
    }

    public String getName() {
        return name;
    }

    
    
    
    
}
