/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacePanel;

/**
 *
 * @author Sirijus
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import testmaze.*;
public class LabirintasPanel extends javax.swing.JPanel {

    Labirintas lab = null;
    Taskas taskas = null;
    int gr=15;
    int eile=1;
    int x1 = 35, x2 = 55;
    int y1 = 5, y2 = 5;
    int temp = 1; //kelintas 
    int taskox=0;
    int taskoy=0;
    int matmuox=10;
    int matmuoy=10;
    int ilgiausioid=0;
    int endx1=0;
    int endx2=0;
    int endy1=0;
    int endy2=0;
    int endtemp=0;
    int endmetodas=0;
    
    boolean pabaiga = false;
    boolean taskoCheck=false;
    Color liniju_spalva = Color.DARK_GRAY;
    public LabirintasPanel() {

    }
    
    public void setLabirintas(Labirintas temp){
        this.lab = temp;
        this.x1 = 35;
        this.x2 = 55;
        this.y1 = 5;
        this.y2 = 5;
        this.temp=1;
        this.taskas=null;
        
    }

    public void setIlgiausioid(int ilgiausioid) {
        this.ilgiausioid = ilgiausioid;
    }
    
    
    
    public void setTaskas(Taskas t){
        this.taskas = t;
    }

    public int getMatmuox() {
        return matmuox;
    }

    public void setMatmuox(int matmuox) {
        this.matmuox = matmuox;
    }

    public int getMatmuoy() {
        return matmuoy;
    }

    public void setMatmuoy(int matmuoy) {
        this.matmuoy = matmuoy;
    }

    
    
    @Override
    public void paintComponent(Graphics g){
        System.out.println("Generuoja");
         System.out.println("XXXXXXXXXXXXXXXXXXX "+matmuox+"YYYYYYYYYYYYYYYYYYYYYYYYYY "+matmuoy);
        liniju_spalva = Color.BLACK;
        g.setColor(liniju_spalva);
        y1=5;
        y2=5;
        taskox=0;
        taskoy=0;
        temp=1;
        super.paintComponent(g);
            if(lab==null)
            {
                g.drawString("Press NEW to generate new labyrinth", 300, 200);
            }
            else
            {
                //g.drawString("Sukurtas labirintas", 300, 200);
                
                
                taskoCheck=false;
                y1=5;
                y2=5;
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(5));
                taskoy=0;
                taskox=0;
                
                for(Langelis[] e : lab.getMatmenys()){
                    taskox=0;
                //System.out.println("tasko y"+taskas.getY());
                //System.out.println("slenkantis y"+taskoy);
                    if(taskas.getY() == taskoy){
                        taskoCheck=true;
                    }
                    for(Langelis e2 : e){
                        
                        //System.out.println("tasko x"+taskas.getX());
                        //System.out.println("slenkantis x"+taskox);
                        if(e2.getId()==0){
                            liniju_spalva=Color.RED;
                            g.setColor(liniju_spalva);
                            if(taskas.getX()==taskox&&taskoCheck==true){
                            g.drawOval(x1+5, y1+10, 10, 10);
                            g.fillOval(x1+5, y1+10, 10, 10);
                            taskoCheck=false;
                            }
                        }
                        else if(e2.getId()==ilgiausioid){
                            endx1=x1;
                            endx2=x2;
                            endy1=y1;
                            endy2=y2;
                            endtemp = temp;
                        }

                        else{
                            liniju_spalva=Color.BLACK;
                            g.setColor(liniju_spalva);
                        }

                        if(matmuoy%2==0){
                            if(temp%2!=0){
                                if(taskas.getX()==taskox&&taskoCheck==true){
                                    g.drawOval(x1+5, y1+10, 10, 10);
                                    g.fillOval(x1+5, y1+10, 10, 10);
                                    taskoCheck=false;
                                }
                                if(e2.getId()==ilgiausioid){
                                    endmetodas=1;
                                }
                                if(e2.getKryptis1()==false)
                                    g.drawLine(x1-10,y1+15,x1,y2);
                                if(e2.getKryptis2()==false)
                                    g.drawLine(x1,y1,x2,y2);
                                if(e2.getKryptis3()==false)
                                    g.drawLine(x2,y2,x2+10,y2+15);

                                if(e2.getKryptis4()==false)
                                    g.drawLine(x2+10,y2+15,x2,y2+30);
                                if(e2.getKryptis5()==false)
                                    g.drawLine(x2,y2+30,x1,y2+30);
                                if(e2.getKryptis6()==false)
                                    g.drawLine(x1-10,y1+15,x1,y2+30);
                                //System.out.println("NERLYGINIS x1 :"+x1+"  x2: "+x2+"   y1: "+y1+"  y2: "+y2 );
                                x1+=30;
                                x2+=30;
                            }
                            else{
                                if(taskas.getX()==taskox&&taskoCheck==true){
                                    g.drawOval(x1+5, y1+25, 10, 10);
                                    g.fillOval(x1+5, y1+25, 10, 10);
                                taskoCheck=false;
                                System.out.println("slenkantis x"+taskox + "tasko x"+taskas.getX() +"slenkantis y"+taskoy+"tasko y"+taskas.getY() );
                                }
                                if(e2.getId()==ilgiausioid){
                                    endmetodas=2;
                                }
                                if(e2.getKryptis1()==false)    
                                    g.drawLine(x1-10,y1+30,x1,y2+15);
                                if(e2.getKryptis2()==false)
                                    g.drawLine(x1,y1+15,x2,y2+15);
                                if(e2.getKryptis3()==false)
                                    g.drawLine(x2,y2+15,x2+10,y2+30);

                                if(e2.getKryptis4()==false)
                                    g.drawLine(x2+10,y2+30,x2,y2+45);
                                if(e2.getKryptis5()==false)
                                    g.drawLine(x2,y2+45,x1,y2+45);
                                if(e2.getKryptis6()==false)
                                    g.drawLine(x1-10,y1+30,x1,y2+45);
                                
                                //System.out.println("LYGINIS x1 :"+x1+"  x2: "+x2+"   y1: "+y1+"  y2: "+y2 );
                                x1+=30;
                                x2+=30;
                            }
                        }
                         if(matmuoy%2!=0){
                             if(taskoy%2==0){
                                 if(temp%2!=0){
                                    if(taskas.getX()==taskox&&taskoCheck==true){
                                        g.drawOval(x1+5, y1+10, 10, 10);
                                        g.fillOval(x1+5, y1+10, 10, 10);
                                        taskoCheck=false;
                                    }
                                    if(e2.getId()==ilgiausioid){
                                    endmetodas=3;
                                     }
                                    if(e2.getKryptis1()==false)
                                        g.drawLine(x1-10,y1+15,x1,y2);
                                    if(e2.getKryptis2()==false)
                                        g.drawLine(x1,y1,x2,y2);
                                    if(e2.getKryptis3()==false)
                                        g.drawLine(x2,y2,x2+10,y2+15);

                                    if(e2.getKryptis4()==false)
                                        g.drawLine(x2+10,y2+15,x2,y2+30);
                                    if(e2.getKryptis5()==false)
                                        g.drawLine(x2,y2+30,x1,y2+30);
                                    if(e2.getKryptis6()==false)
                                        g.drawLine(x1-10,y1+15,x1,y2+30);

                                    //System.out.println("NERLYGINIS x1 :"+x1+"  x2: "+x2+"   y1: "+y1+"  y2: "+y2 );
                                    x1+=30;
                                    x2+=30;
                                    }
                                    else{
                                        if(taskas.getX()==taskox&&taskoCheck==true){
                                            g.drawOval(x1+5, y1+25, 10, 10);
                                            g.fillOval(x1+5, y1+25, 10, 10);
                                            taskoCheck=false;
                                        System.out.println("slenkantis x"+taskox + "tasko x"+taskas.getX() +"slenkantis y"+taskoy+"tasko y"+taskas.getY() );
                                        }
                                        if(e2.getId()==ilgiausioid){
                                            endmetodas=4;
                                        }
                                        if(e2.getKryptis1()==false)    
                                            g.drawLine(x1-10,y1+30,x1,y2+15);
                                        if(e2.getKryptis2()==false)
                                            g.drawLine(x1,y1+15,x2,y2+15);
                                        if(e2.getKryptis3()==false)
                                            g.drawLine(x2,y2+15,x2+10,y2+30);

                                        if(e2.getKryptis4()==false)
                                            g.drawLine(x2+10,y2+30,x2,y2+45);
                                        if(e2.getKryptis5()==false)
                                            g.drawLine(x2,y2+45,x1,y2+45);
                                        if(e2.getKryptis6()==false)
                                            g.drawLine(x1-10,y1+30,x1,y2+45);

                                        //System.out.println("LYGINIS x1 :"+x1+"  x2: "+x2+"   y1: "+y1+"  y2: "+y2 );
                                        x1+=30;
                                        x2+=30;
                                    }
                            }
                             if(taskoy%2!=0){
                                 if(temp%2==0){
                                    if(taskas.getX()==taskox&&taskoCheck==true){
                                        g.drawOval(x1+5, y1+10, 10, 10);
                                        g.fillOval(x1+5, y1+10, 10, 10);
                                        taskoCheck=false;
                                    }
                                    if(e2.getId()==ilgiausioid){
                                            endmetodas=5;
                                        }
                                    if(e2.getKryptis1()==false)
                                        g.drawLine(x1-10,y1+15,x1,y2);
                                    if(e2.getKryptis2()==false)
                                        g.drawLine(x1,y1,x2,y2);
                                    if(e2.getKryptis3()==false)
                                        g.drawLine(x2,y2,x2+10,y2+15);

                                    if(e2.getKryptis4()==false)
                                        g.drawLine(x2+10,y2+15,x2,y2+30);
                                    if(e2.getKryptis5()==false)
                                        g.drawLine(x2,y2+30,x1,y2+30);
                                    if(e2.getKryptis6()==false)
                                        g.drawLine(x1-10,y1+15,x1,y2+30);

                                    //System.out.println("NERLYGINIS x1 :"+x1+"  x2: "+x2+"   y1: "+y1+"  y2: "+y2 );
                                    x1+=30;
                                    x2+=30;
                                    }
                                    else{
                                        if(taskas.getX()==taskox&&taskoCheck==true){
                                            g.drawOval(x1+5, y1+25, 10, 10);
                                            g.fillOval(x1+5, y1+25, 10, 10);
                                            taskoCheck=false;
                                        System.out.println("slenkantis x"+taskox + "tasko x"+taskas.getX() +"slenkantis y"+taskoy+"tasko y"+taskas.getY() );
                                        }
                                        if(e2.getId()==ilgiausioid){
                                            endmetodas=6;
                                        }
                                        if(e2.getKryptis1()==false)    
                                            g.drawLine(x1-10,y1+30,x1,y2+15);
                                        if(e2.getKryptis2()==false)
                                            g.drawLine(x1,y1+15,x2,y2+15);
                                        if(e2.getKryptis3()==false)
                                            g.drawLine(x2,y2+15,x2+10,y2+30);

                                        if(e2.getKryptis4()==false)
                                            g.drawLine(x2+10,y2+30,x2,y2+45);
                                        if(e2.getKryptis5()==false)
                                            g.drawLine(x2,y2+45,x1,y2+45);
                                        if(e2.getKryptis6()==false)
                                            g.drawLine(x1-10,y1+30,x1,y2+45);

                                        //System.out.println("LYGINIS x1 :"+x1+"  x2: "+x2+"   y1: "+y1+"  y2: "+y2 );
                                        x1+=30;
                                        x2+=30;
                                }
                             }
                         }

                        temp++;
                        taskox++;
                    }
                    x1=35; x2=55; 
                    y1 +=30;
                    y2 +=30;
                    taskoy++;
                }
                liniju_spalva=Color.BLUE;
                g.setColor(liniju_spalva);
                Langelis pabaiga = lab.getLangelisPagalID(ilgiausioid);
                switch(endmetodas){
                    case 1:
                        if(pabaiga.getKryptis1()==false)
                        g.drawLine(endx1-10,endy1+15,endx1,endy2);
                        if(pabaiga.getKryptis2()==false)
                        g.drawLine(endx1,endy1,endx2,endy2);
                        if(pabaiga.getKryptis3()==false)
                        g.drawLine(endx2,endy2,endx2+10,endy2+15);
                        if(pabaiga.getKryptis4()==false)
                        g.drawLine(endx2+10,endy2+15,endx2,endy2+30);
                        if(pabaiga.getKryptis5()==false)
                        g.drawLine(endx2,endy2+30,endx1,endy2+30);
                        if(pabaiga.getKryptis6()==false)
                        g.drawLine(endx1-10,endy1+15,endx1,endy2+30);
                        break;
                    case 2:
                        if(pabaiga.getKryptis1()==false)    
                        g.drawLine(endx1-10,endy1+30,endx1,endy2+15);
                        if(pabaiga.getKryptis2()==false)
                        g.drawLine(endx1,endy1+15,endx2,endy2+15);
                        if(pabaiga.getKryptis3()==false)
                        g.drawLine(endx2,endy2+15,endx2+10,endy2+30);
                        if(pabaiga.getKryptis4()==false)
                        g.drawLine(endx2+10,endy2+30,endx2,endy2+45);
                        if(pabaiga.getKryptis5()==false)
                        g.drawLine(endx2,endy2+45,endx1,endy2+45);
                        if(pabaiga.getKryptis6()==false)
                        g.drawLine(endx1-10,endy1+30,endx1,endy2+45);
                        break;
                    case 3:
                        if(pabaiga.getKryptis1()==false)
                        g.drawLine(endx1-10,endy1+15,endx1,endy2);
                        if(pabaiga.getKryptis2()==false)
                        g.drawLine(endx1,endy1,endx2,endy2);
                        if(pabaiga.getKryptis3()==false)
                        g.drawLine(endx2,endy2,endx2+10,endy2+15);
                        if(pabaiga.getKryptis4()==false)
                        g.drawLine(endx2+10,endy2+15,endx2,endy2+30);
                        if(pabaiga.getKryptis5()==false)
                        g.drawLine(endx2,endy2+30,endx1,endy2+30);
                        if(pabaiga.getKryptis6()==false)
                        g.drawLine(endx1-10,endy1+15,endx1,endy2+30);
                        break;
                    case 4:
                        if(pabaiga.getKryptis1()==false)    
                        g.drawLine(endx1-10,endy1+30,endx1,endy2+15);
                        if(pabaiga.getKryptis2()==false)
                        g.drawLine(endx1,endy1+15,endx2,endy2+15);
                        if(pabaiga.getKryptis3()==false)
                        g.drawLine(endx2,endy2+15,endx2+10,endy2+30);
                        if(pabaiga.getKryptis4()==false)
                        g.drawLine(endx2+10,endy2+30,endx2,endy2+45);
                        if(pabaiga.getKryptis5()==false)
                        g.drawLine(endx2,endy2+45,endx1,endy2+45);
                        if(pabaiga.getKryptis6()==false)
                        g.drawLine(endx1-10,endy1+30,endx1,endy2+45);
                        break;
                    case 5:
                        if(pabaiga.getKryptis1()==false)
                        g.drawLine(endx1-10,endy1+15,endx1,endy2);
                        if(pabaiga.getKryptis2()==false)
                        g.drawLine(endx1,endy1,endx2,endy2);
                        if(pabaiga.getKryptis3()==false)
                        g.drawLine(endx2,endy2,endx2+10,endy2+15);
                        if(pabaiga.getKryptis4()==false)
                        g.drawLine(endx2+10,endy2+15,endx2,endy2+30);
                        if(pabaiga.getKryptis5()==false)
                        g.drawLine(endx2,endy2+30,endx1,endy2+30);
                        if(pabaiga.getKryptis6()==false)
                        g.drawLine(endx1-10,endy1+15,endx1,endy2+30);
                        break;
                    case 6:
                        if(pabaiga.getKryptis1()==false)    
                        g.drawLine(endx1-10,endy1+30,endx1,endy2+15);
                        if(pabaiga.getKryptis2()==false)
                        g.drawLine(endx1,endy1+15,endx2,endy2+15);
                        if(pabaiga.getKryptis3()==false)
                        g.drawLine(endx2,endy2+15,endx2+10,endy2+30);
                        if(pabaiga.getKryptis4()==false)
                        g.drawLine(endx2+10,endy2+30,endx2,endy2+45);
                        if(pabaiga.getKryptis5()==false)
                        g.drawLine(endx2,endy2+45,endx1,endy2+45);
                        if(pabaiga.getKryptis6()==false)
                        g.drawLine(endx1-10,endy1+30,endx1,endy2+45);
                        break;
                    default: 
                        break;
                }
            }
            
            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(java.awt.Color.white);
        setName("output"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
