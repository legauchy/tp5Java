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
public class Couple {
    
    private int a;
    private int b;
    
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
            throw new NullPointer("Le parametre couple du constructeur de Couple est nul!");
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
     * @post_cond this.getA() == a
     */
    public void setA(int a) {
        this.a = a;
    }
    
    /*
     * @pre_cond
     * @post_cond this.getB() == b
     */
    public void setB(int b) {
        this.b = b;
    }
    
    @Override
    public String toString() {
        return "Couple{" + "a=" + a + ", b=" + b + '}';
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond return true if this.a == couple.a && this.b == couple.b else false
     */
    public boolean eq(Couple couple) {
        if(couple == null) {
            throw new NullPointer("Le parametre couple de la methode eq de Couple est nul!");
        }
        return this.a == couple.a && this.b == couple.b;
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond return true if this.a < couple.a else if this.a == couple.a && this.b < couple.b else false
     */
    public boolean lt(Couple couple) throws NullPointer {
        if(couple == null) {
            throw new NullPointer("Le parametre couple de la methode lt de Couple est nul!");
        }
        if(this.a < couple.a) {
            return true;
        }else if( this.a == couple.a){
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
            throw new NullPointer("Le parametre couple de la methode leq de Couple est nul!");
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
            throw new NullPointer("Le parametre couple de la methode neq de Couple est nul!");
        }
        return this.a != couple.a || this.b != couple.b;
    }
    
    /*
     * @pre_cond couple != null
     * @post_cond return true if this.a > couple.a else if this.a == couple.a && this.b > couple.b else false
     */
    public boolean gt(Couple couple) throws NullPointer {
        if(couple == null) {
            throw new NullPointer("Le parametre couple de la methode gt de Couple est nul!");
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
            throw new NullPointer("Le parametre couple de la methode eq de Couple est nul!");
        }
        if(this.a > couple.a) {
            return true;
        }else if( this.a == couple.a){
            return this.b >= couple.b;
        }
    
        return false;
    }
}
