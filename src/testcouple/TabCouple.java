//package testcouple;

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
     * @pre_cond this.size > 0
     * @post_cond this.size == size && this.tab != null && this.length = this.size && this.nbElement == 0
     */
    public TabCouple(int size) throws NonPositiveSize {
    	if (size <= 0) {
    		throw new NonPositiveSize("size", "TabCouple(int size)");
    	}
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
     * @pre_cond this.tab != null
     * @post_cond this.tab = tab 
     */
    public void setTab(Couple[] tab) throws NullPointer {
    	if (tab == null) {
    		throw new NullPointer("tab", "setTab(Couple[] tab)");
    	}
        this.tab = tab;
    }
    
    /*
     * @pre_cond this.nbElement != 0
     * @post_cond return this.tab[this.nbElement-1]
     */
    public Couple get() throws EmptyTab {
        if(this.nbElement == 0) {
            throw new EmptyTab("tab");
        }
        return this.tab[this.nbElement-1];
    }
    
    /*
     * @pre_cond i >= 0 && i <= this.nbElement-1
     * @post_cond return this.tab[i]
     */
    public Couple get(int i) throws OutOfArray {
        if (i < 0 || i > nbElement-1) {
            throw new OutOfArray(i, nbElement);
        }
        return this.tab[i];
    }
    
    /*
     * @pre_cond i >= 0 && i <= this.nbElement-1
     * @post_cond this.tab[i] = couple
     */
    public void set(int i, Couple couple) throws OutOfArray {
    	if (i < 0 || i > nbElement-1) {
            throw new OutOfArray(i, nbElement);
        }
        this.tab[i] = couple;
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond this.tab[nbElement-1] == couple
     */
    public void add(Couple couple) throws NullPointer {
    	if (couple == null) {
    		throw new NullPointer("couple", "add(Couple couple)");
    	}
        if (this.nbElement == this.length) {
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
    public void remove() throws EmptyTab {
        if(this.nbElement == 0) {
            throw new EmptyTab("tab");
        }
        // Theoriquement, exception jamais catchee
        try {
			this.set(this.nbElement-1, null);
		} catch (OutOfArray e) {
			e.printStackTrace();
		}
        --this.nbElement;
        if (this.nbElement < this.length/2.0) {
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
     * @pre_cond size > 0
     * @post_cond this.tab.length == _this.tab.lenght + size &&
     *              this.length == _this.lenght + size &&
     *              find i in [0.._tab.nbElement] : tab[i] == _tab[i]
     */
    private void grow(int size) {
        Couple[] new_tab = new Couple[this.length + size];
        for(int i = 0; i < this.nbElement ; i++) {
        	// Theoriquement exception jamais catchee
            try {
				new_tab[i] = this.get(i);
			} catch (OutOfArray e) {
				e.printStackTrace();
			}
        }
        this.tab = new_tab;
        this.length += size;
    }
    
    /*
     * @pre_cond 
     * @post_cond _this.tab.lenght >= this.tab.length
     */
    private void shrink() {
        Couple[] new_tab = new Couple[this.nbElement + this.size];
        for(int i = 0; i < this.nbElement; i++) {
        	// Theoriquement, exception jamais catchee
            try {
				new_tab[i] = this.get(i);
			} catch (OutOfArray e) {
				e.printStackTrace();
			}
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
     * @pre_cond this.nbElement > 0
     * @post_cond find i in [0..this.nbElement] : find j in [i..this.nbElement] : this.tab[i] <= this.tab[j]
     */
    public void heapsort() throws NullPointer, OutOfArray, EmptyTab {
    	if (this.nbElement == 0) {
    		throw new EmptyTab("tab");
    	}
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
     * @pre_cond i >= 0 && i <= this.nbElement-1 && j >= 0 && j <= this.nbElement-1
     * @post_cond _this.tab[i] = this.tab[j] && _this.tab[j] == this.tab[i]
     */
    private void echanger(int i, int j) throws OutOfArray {
        Couple tmp;
        tmp = this.get(i);
        this.set(i, this.get(j));
        this.set(j, tmp);
    }
    
    /*
     * @pre_cond j >= 0 && j <= this.nbElement-1
     * @post_cond tab[j] <= tab[j/2] && tab[j] > tab[2*j] && tab[j] > tab[2*j + 1]
     */
    private void monter(int j) throws NullPointer, OutOfArray {
        while (this.get(j).gt(this.get(j/2))) {
            this.echanger(j, j/2);
            j = j/2;
        }
    }
    
    /*
     * @pre_cond j >= 0 && j <= this.nbElement-1
     * @post_cond 
     */
    private void descendre(int j) throws NullPointer, OutOfArray {
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
