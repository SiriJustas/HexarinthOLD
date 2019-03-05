/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmaze;


public class Langelis {
    public boolean [] kryptis  = new boolean[6];
    public Langelis []gretimas = new Langelis[6];
    int x;
    int y;
    public int id;
    static int ELEMENTO_NR = 0;
    
    public Langelis(int tx,int ty){
        id = ELEMENTO_NR;
        ELEMENTO_NR++;
        this.x=tx;
        this.y=ty;
        for(int i=0; i<6; i++){
            kryptis[i]=false;
            gretimas[i]=null;
        }
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Langelis[] getGretimas() {
        return gretimas;
    }
    public boolean[] getKryptis() {
        return kryptis;
    }
    public Langelis getGretimas1() {
        return gretimas[0];
    }
    public Langelis getGretimas2() {
        return gretimas[1];
    }
    public Langelis getGretimas3() {
        return gretimas[2];
    }
    public Langelis getGretimas4() {
        return gretimas[3];
    }
    public Langelis getGretimas5() {
        return gretimas[4];
    }
    public Langelis getGretimas6() {
        return gretimas[5];
    }

    public boolean getKryptis1() {
        return kryptis[0];
    }
    public boolean getKryptis2() {
        return kryptis[1];
    }
    public boolean getKryptis3() {
        return kryptis[2];
    }
    public boolean getKryptis4() {
        return kryptis[3];
    }
    public boolean getKryptis5() {
        return kryptis[4];
    }
    public boolean getKryptis6() {
        return kryptis[5];
    }
    public void setId(int id) {
        this.id = id;
    }
    public static void setELEMENTO_NR(int ELEMENTO_NR) {
        Langelis.ELEMENTO_NR = ELEMENTO_NR;
    }
    public int getId() {
        return id;
    }
    public static int getELEMENTO_NR() {
        return ELEMENTO_NR;
    }
    public void setVK(boolean kr){
        if(gretimas[0]!=null){
            this.kryptis[0]=kr;
            this.gretimas[0].kryptis[3]=kr;
        }
    }
    public void setVV(boolean kr){
        if(gretimas[1]!=null){
            this.kryptis[1]=kr;
            this.gretimas[1].kryptis[4]=kr;
        }
    }
    public void setVD(boolean kr){
        if(gretimas[2]!=null){
            this.kryptis[2]=kr;
            this.gretimas[2].kryptis[5]=kr;
        }
    }
    public void setAD(boolean kr){
        if(gretimas[3]!=null){
            this.kryptis[3]=kr;
            this.gretimas[3].kryptis[0]=kr;
        }
    }
    public void setAA(boolean kr){
        if(gretimas[4]!=null){
            this.kryptis[4]=kr;
            this.gretimas[4].kryptis[1]=kr;
        }
    }
    public void setAK(boolean kr){
        if(gretimas[5]!=null){
            this.kryptis[5]=kr;
            this.gretimas[5].kryptis[2]=kr;
        }
    }
    public void printLangelis(){
        System.out.println("  "+kryptis[0]+"  "+kryptis[1]+"  "+kryptis[2]+"  "+kryptis[3]+"  "+kryptis[4]+"  "+kryptis[5]+"  ");
    }
}
