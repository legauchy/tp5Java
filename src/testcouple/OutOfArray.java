//package testcouple;

public class OutOfArray extends Exception {
    
    public OutOfArray(int index, int length) {
        super("L'indice " + index + " est hors du tableau, le tableau est indexé de 0 à " + length);
    }
}
