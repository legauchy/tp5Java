//package testcouple;

/**
 *
 * @author Goum
 */
public class TestCouple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TabCouple tab = null;
        try {
                tab = new TabCouple(5);
        } catch (NonPositiveSize e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        int a;
        int b;

        // Ajout de 8 couples dans le tableau
        System.out.println("Ajout de 8 couples dans le tableau :");
        for (int i=0; i<8; i++) {
            a = (int)(20*Math.random()) - 10;
            b = (int)(20*Math.random()) - 10;
            try {
                    tab.add(new Couple(a, b));
            } catch (NullPointer e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
        System.out.println(tab.toString());


        // Ajout de 10 couples dans le tableau
        System.out.println("Ajout de 10 couples dans le tableau :");
        for (int i=0; i<10; i++) {
            a = (int)(20*Math.random()) - 10;
            b = (int)(20*Math.random()) - 10;
            try {
                tab.add(new Couple(a, b));
            } catch (NullPointer e) {
                    // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(tab.toString());


        // Suppression de 10 éléments
        System.out.println("Suppression de 10 éléments :");
        while (tab.getNbElement()> 8) {
            try {
                tab.remove();
            } catch (EmptyTab e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(tab.toString());


        // Tri par tas
        System.out.println("Tri par tas :");
        try {
            tab.heapsort();
        } catch (NullPointer | OutOfArray | EmptyTab e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(tab.toString());
    }
    
}
