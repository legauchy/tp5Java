//package testcouple;

public class Couple {
    
    private int a;
    private int b;
    
    /*
     * @pre_cond
     * @post_cond this.a == 0 && this.b == 0 
     */
    public Couple() {
    }
    
    /*
     * @pre_cond
     * @post_cond this.a == a && this.b == b 
     */
    public Couple(int a, int b) {
        this.a = a;
        this.b = b;
    }
    /*
     * @pre_cond couple != null
     * @post_cond this.a == couple.a && this.b == couple.b
     */
    public Couple(Couple couple) throws NullPointer {
        if(couple == null) {
            throw new NullPointer("couple", "Couple(Couple couple)");
        }
        this.a = couple.getA();
        this.b = couple.getB();
    }
    
    /*
     * @pre_cond
     * @post_cond return this.a 
     */
    public int getA() {
        return a;
    }
    
    /*
     * @pre_cond
     * @post_cond return this.b 
     */
    public int getB() {
        return b;
    }
    
    /*
     * @pre_cond
     * @post_cond this.a == a
     */
    public void setA(int a) {
        this.a = a;
    }
    
    /*
     * @pre_cond
     * @post_cond this.b == b
     */
    public void setB(int b) {
        this.b = b;
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond return true if this.a == couple.a && this.b == couple.b else false
     */ 
    public boolean eq(Couple couple) throws NullPointer {
        if(couple == null) {
        	throw new NullPointer("couple", "eq(Couple couple)");
        }
        return this.a == couple.a && this.b == couple.b;
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond return true if this.a < couple.a else if this.a == couple.a && this.b < couple.b else false
     */
    public boolean lt(Couple couple) throws NullPointer {
        if(couple == null) {
            throw new NullPointer("couple", "lt(Couple couple)");
        }
        if(this.a < couple.a) {
            return true;
        }else if( this.a == couple.a) {
            return this.b < couple.b;
        }
    
        return false;
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond return true if this.a < couple.a else if this.a == couple.a && this.b <= couple.b else false
     */
    public boolean leq(Couple couple) throws NullPointer {
        if(couple == null) {
        	throw new NullPointer("couple", "leq(Couple couple)");
        }
        if(this.a < couple.a) {
            return true;
        }else if( this.a == couple.a){
            return this.b <= couple.b;
        }
    
        return false;
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond return true if this.a != couple.a || this.b != couple.b else false
     */
    public boolean neq(Couple couple) throws NullPointer {
        if(couple == null) {
        	throw new NullPointer("couple", "neq(Couple couple)");
        }
        return this.a != couple.a || this.b != couple.b;
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond return true if this.a > couple.a else if this.a == couple.a && this.b > couple.b else false
     */
    public boolean gt(Couple couple) throws NullPointer {
        if(couple == null) {
        	throw new NullPointer("couple", "gt(Couple couple)");
        }
        if(this.a > couple.a) {
            return true;
        }else if( this.a == couple.a){
            return this.b > couple.b;
        }
    
        return false;
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond return true if this.a > couple.a else if this.a == couple.a && this.b >= couple.b else false
     */
    public boolean geq(Couple couple) throws NullPointer {
        if(couple == null) {
        	throw new NullPointer("couple", "geq(Couple couple)");
        }
        if(this.a > couple.a) {
            return true;
        }else if( this.a == couple.a){
            return this.b >= couple.b;
        }
    
        return false;
    }
    
    @Override
    public String toString() {
        return "Couple{" + "a=" + a + ", b=" + b + '}';
    }
}
