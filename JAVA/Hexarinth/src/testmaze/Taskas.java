/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmaze;


public class Taskas {
    int x;
    int y;
    public Langelis [][] matmenys;
    
    public Taskas(Langelis [][] matm){
        this.matmenys=matm;
        this.x=0;
        this.y=0;
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
    public void VK(){
        if(matmenys[x][y].kryptis[0]==true && matmenys[x][y].gretimas[0]!=null){
        x=matmenys[x][y].gretimas[0].x;
        y=matmenys[x][y].gretimas[0].y;
        }
        else{
        System.out.println("Eiti negalima");
        }
    }
    public void VV(){
        if(matmenys[x][y].kryptis[1]==true && matmenys[x][y].gretimas[1]!=null){
        x=matmenys[x][y].gretimas[1].x;
        y=matmenys[x][y].gretimas[1].y;
        }
        else{
        System.out.println("Eiti negalima");
        }
    }
    public void VD(){
        if(matmenys[x][y].kryptis[2]==true && matmenys[x][y].gretimas[2]!=null){
        x=matmenys[x][y].gretimas[2].x;
        y=matmenys[x][y].gretimas[2].y;
        }
        else{
        System.out.println("Eiti negalima");
        }
    }
    public void AK(){
        if(matmenys[x][y].kryptis[5]==true && matmenys[x][y].gretimas[2]!=null){
        x=matmenys[x][y].gretimas[5].x;
        y=matmenys[x][y].gretimas[5].y;
        }
        else{
        System.out.println("Eiti negalima");
        }
    }
    public void AA(){
        if(matmenys[x][y].kryptis[4]==true && matmenys[x][y].gretimas[4]!=null){
        x=matmenys[x][y].gretimas[4].x;
        y=matmenys[x][y].gretimas[4].y;
        }
        else{
        System.out.println("Eiti negalima");
        }
    }
    public void AD(){
        if(matmenys[x][y].kryptis[3]==true && matmenys[x][y].gretimas[3]!=null){
        x=matmenys[x][y].gretimas[3].x;
        y=matmenys[x][y].gretimas[3].y;
        }
        else{
        System.out.println("Eiti negalima");
        }
    }
    public void printTaskas(){
    System.out.println("Lanegelio koordinates: "+x+" ,"+y);
    }
    
}
