/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcouple;

/**
 *
 * @author Goum
 */
public class EmptyTab extends Exception {
    
    public EmptyTab(String string) {
        super("Le tableau " + string + " est vide!");
    }
}
