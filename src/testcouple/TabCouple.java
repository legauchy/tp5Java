/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcouple;

/*
 *
 * @author Goum
 */
public class TabCouple {
    
    private static final int DEFAULT = 10;
    private final int size;
    
    private Couple[] tab;
    
    /*
     * Taille du tableau 
     */
    private int length;
    
    /*
     * Nombre d'éléments contenus dans le tableau.
     */
    private int nbElement;
    
    /*
     * @pre_cond
     * @post_cond this.size == TabCouple.DEFAULT; && this.tab != null && this.length = this.size && this.nbElement == 0
     */
    public TabCouple() {
        this.size = TabCouple.DEFAULT;
        this.tab = new Couple[this.size];
        this.length = this.size;
        this.nbElement = 0;
    }
    
    /* 
     * @pre_cond size > 0
     * @post_cond this.size == size && this.tab != null && this.length = this.size && this.nbElement == 0
     */
    public TabCouple(int size) {
        this.size = size;
        this.tab = new Couple[this.size];
        this.length = this.size;
        this.nbElement = 0;
    }
    
    /*
     * @pre_cond
     * @post_cond return this.size
     */
    public int getSize() {
        return size;
    }
    
    /*
     * @pre_cond
     * @post_cond return this.tab
     */
    public Couple[] getTab() {
        return tab;
    }

    /*
     * @pre_cond
     * @post_cond return this.length
     */
    public int getLength() {
        return length;
    }

    /*
     * @pre_cond
     * @post_cond return this.nbElement
     */
    public int getNbElement() {
        return nbElement;
    }

    /*
     * @pre_cond
     * @post_cond
     */
    public void setTab(Couple[] tab) {
        this.tab = tab;
    }
    
    /*
     * @pre_cond this.nbElement != 0
     * @post_cond return this.tab[this.nbElement-1]
     */
    public Couple get() throws IndexOutOfBoundsException{
        if(this.nbElement == 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.tab[this.nbElement-1];
    }
    
    /*
     * @pre_cond this.nbElement-1 >= i && i >= 0
     * @post_cond return this.tab[i]
     */
    public Couple get(int i) throws IndexOutOfBoundsException{
        if(nbElement-1 < i || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.tab[i];
    }
    
    /*
     * @pre_cond this.nbElement-1 >= i && i >= 0
     * @post_cond this.tab[i] = couple
     */
    public void set(int i, Couple couple) {
        if(nbElement-1 < i || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.tab[i] = couple;
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond this.tab[nbElement-1] == couple
     */
    public void add(Couple couple) {
        if(this.nbElement == this.length) {
            this.grow();
        }
        this.tab[this.nbElement] = couple;
        ++this.nbElement;
    }
    
    /*
     * @pre_cond this.nbElement > 0
     * @post_cond this.tab.lenght <= _this.tab.lenght && this.nbElement == _this.nbElement-- &&
     *              this.tab[this.nbElement] == null
     */
    public void remove() {
        if(this.nbElement == 0) {
            throw new IndexOutOfBoundsException();
        }
        --this.nbElement;
        this.set(this.nbElement, null);
        if(this.nbElement < this.length/2.0 ) {
            this.shrink();
        }
    }
    
    /*
     * @pre_cond 
     * @post_cond this.tab.length == _this.tab.lenght + this.size &&
     *             find i in [0.._tab.nbElement] : tab[i] == _tab[i]
     */
    private void grow() {
        this.grow(this.size);
    }
    
    /*
     * @pre_cond g > 0
     * @post_cond this.tab.length == _this.tab.lenght + g &&
     *              this.length == _this.lenght + g &&
     *              find i in [0.._tab.nbElement] : tab[i] == _tab[i]
     */
    private void grow(int g) {
        Couple[] new_tab = new Couple[this.length + g];
        for(int i = 0; i < this.nbElement ; i++) {
            new_tab[i] = this.get(i);
        }
        this.tab = new_tab;
        this.length += g;
    }
    
    /*
     * @pre_cond 
     * @post_cond if this.nbElement + size < this.thab.length so _this.tab.lenght > this.tab.length
     */
    private void shrink() {
        Couple[] new_tab = new Couple[this.nbElement + this.size];
        for(int i = 0; i < this.nbElement ; i++) {
            new_tab[i] = this.get(i);
        }
        this.tab = new_tab;
        this.length = this.tab.length;
    }
    
    /*
     * @pre_cond
     * @post_cond
     */
    public String toString() {
        String s = "";
        s += "Tableau de taille : " + this.length + ", contient " + this.nbElement + " éléments\n";
        for (Couple couple : this.tab) {
            s += "(" + couple + ") \n";
        }
        return s;
    }
    
    /*
     * @pre_cond
     * @post_cond
     */
    public void heapsort() {
        for(int i = 1 ; i < this.nbElement ; i++) {
            this.monter(i);
        }
        int i = this.nbElement-1;
        while(i > 0) {
            this.echanger(0,i);
            i--;
            this.descendre(i);  
        }
    }
    
    /*
     * @pre_cond
     * @post_cond
     */
    public void echanger(int i, int j) {
        Couple temp = this.get(i);
        this.set(i, this.get(j));
        this.set(j, temp);
    }
    
    /*
     * @pre_cond
     * @post_cond
     */
    public void monter(int j) {
        while(this.get(j).gt(this.get(j/2))) {
            this.echanger(j, j/2);
            j = j/2;
        }
    }
    
    /*
     * @pre_cond
     * @post_cond
     */
    public void descendre(int j) {
        int i = 0;
        while(i*2 < j && (this.get(i).lt(this.get(i*2)) || this.get(i).lt(this.get(i*2+1)))) {
            if (this.get(i*2).gt(this.get(i*2+1))) {
                this.echanger(i, i*2);
                i = i*2;
            } else {
                this.echanger(i, i*2+1);
                i = i*2+1;
            }
        }
    }
}
