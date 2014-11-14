//package testcouple;

public class NonGeq extends Exception {
    
     public NonGeq(String parametreA, String parametreB, String methode) {
         super("Le paramètre "  + parametreA + " de la méthode " + methode + " doit etre plus grand ou égal au paramétre " + parametreB + "de la méthode "+ methode);
     }
}
