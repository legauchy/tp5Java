//package testcouple;

public class NonPositiveSize extends Exception {
    
    public NonPositiveSize(String parametre, String methode) {
        super("Le paramètre "  + parametre + " de la méthode " + methode + " doit être positif!");
    }
}
