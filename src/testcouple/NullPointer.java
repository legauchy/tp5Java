//package testcouple;

public class NullPointer extends Exception {
    
	public NullPointer(String parametre, String methode) {
        super("Le paramètre "  + parametre + " de la méthode " + methode + " est nul!");
    }
}
