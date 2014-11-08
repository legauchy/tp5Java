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
public class TestCouple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TabCouple tab = new TabCouple(5);
        int a;
        int b;

        // Ajout de 8 couples dans le tableau
        System.out.println("Ajout de 8 couples dans le tableau :");
        for (int i=0; i<8; i++) {
                a = (int)(20*Math.random()) - 10;
                b = (int)(20*Math.random()) - 10;
                tab.add(new Couple(a, b));
        }
        System.out.println(tab.toString());


        // Ajout de 10 couples dans le tableau
        System.out.println("Ajout de 10 couples dans le tableau :");
        for (int i=0; i<10; i++) {
                a = (int)(20*Math.random()) - 10;
                b = (int)(20*Math.random()) - 10;
                tab.add(new Couple(a, b));
        }
        System.out.println(tab.toString());


        // Suppression de 10 éléments
        System.out.println("Suppression de 10 éléments :");
        while (tab.getNbElement()> 8) {
                tab.remove();
        }
        System.out.println(tab.toString());


        // Tri par tas
        System.out.println("Tri par tas :");
        tab.heapsort();
        System.out.println(tab.toString());
    }
    
}
