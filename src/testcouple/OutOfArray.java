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
public class OutOfArray extends Exception {
    
    public OutOfArray(int index, int length) {
        super("L'indice " + index + " est hors du tableau, le tableau est indexé de 0 à " + length);
    }
}
