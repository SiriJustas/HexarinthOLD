/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmaze;

/**
 *
 * @author Exciting
 */
public class Labirintas {
    
    public Langelis [][] matmenys;
    int ilgis;
    int plotis;
    public int [][] sarysiuMatrica;
    int kelias=0;
    int iteracija=1;
    int [] p;
    int [] s;
    int [] d;
    int k;
    
    

    public Labirintas(int ilg, int pl){
        ilgis=ilg;
        plotis=pl;
        matmenys = new Langelis[ilgis][plotis];
        for(int i=0; i<matmenys.length; i++){
            for(int j=0; j<matmenys[i].length; j++){
                matmenys[i][j] = new Langelis(i,j);
            }
        }
        for(int i=0; i<matmenys.length; i++){
            for(int j=0; j<matmenys[i].length; j++){
                if(j>0 && i!=0 || j%2!=0 && i==0){
                    if(j%2==0){
                    matmenys[i][j].gretimas[0]=matmenys[i-1][j-1]; //taip
                    }
                    else{
                    matmenys[i][j].gretimas[0]=matmenys[i][j-1]; //taip
                    }
                }
                if(i>0){
                    matmenys[i][j].gretimas[1]=matmenys[i-1][j]; //taip
                }
                if(j<plotis-1){
                    if(i==0){
                        if(j%2!=0){
                        matmenys[i][j].gretimas[2]=matmenys[i][j+1]; //taip
                        }
                        else{}
                    }
                    else{
                        if(j%2==0){
                            matmenys[i][j].gretimas[2]=matmenys[i-1][j+1]; //taip
                        }
                        else{
                            matmenys[i][j].gretimas[2]=matmenys[i][j+1]; //taip
                        }
                    }
                }
                if(i<ilgis-1 && j<plotis-1 || j%2==0 && j<plotis-1){
                    if(j%2==0){
                    matmenys[i][j].gretimas[3]=matmenys[i][j+1]; //taip///
                    }
                    else{
                    matmenys[i][j].gretimas[3]=matmenys[i+1][j+1]; //taip
                    }
                }
                if(i<ilgis-1){
                    matmenys[i][j].gretimas[4]=matmenys[i+1][j]; //taip
                }
                if(j!=0 && i<ilgis-1 || j%2==0 && i==ilgis-1 && j>0 ){
                    if(j%2!=0){
                    matmenys[i][j].gretimas[5]=matmenys[i+1][j-1];
                    }
                    else{
                        matmenys[i][j].gretimas[5]=matmenys[i][j-1];
                    }
                }
            }
        }
        
    }
    
    public void printLabirintas(){
        for(int i=0; i<matmenys.length; i++){
                for(int j=0; j<matmenys[i].length; j++){
                    matmenys[i][j].printLangelis();
                }
            }
    }
    
    public Langelis rastiLangeli(int ilg, int pl){
        return matmenys[ilg][pl];
    }

    public Langelis[][] getMatmenys() {
        return matmenys;
    }
    
    
    public Langelis getLangelisPagalID(int idd){
        
        for(Langelis e[]:matmenys){
            for(Langelis ee: e){
                if(ee.id==idd){
                    return ee;
                }
            }
        }
        
        return null;
        
    }
    
    
    public int paieska(Langelis nuo){ //djikstra
        int ilgiausias=0;
        int ilgiausioid=0;
        int tempint;
        boolean check=true;
        //System.out.println("Sudaroma sarysiu matrica, gali uztrukti...");
        //System.out.println("....Sudaroma....");
       
        sarysiuMatrica = new int[ilgis*plotis][ilgis*plotis];
        Langelis temp;
        for(int i=0; i<sarysiuMatrica.length; i++){ // turi sutapti su langelio ID
            //System.out.println("");
            for(int j=0; j<sarysiuMatrica[i].length; j++){ // to langelio sarysiai su kitais langeliais
                temp=getLangelisPagalID(i);
                if(i==j){
                sarysiuMatrica[i][j]=0;
                }
                else{
                sarysiuMatrica[i][j]=5000;
                }
                for(int h=0; h<6; h++){
                    if(temp.gretimas[h]!=null){
                        if(temp.gretimas[h].id==j ){
                            if(temp.kryptis[h]==true){
                            sarysiuMatrica[i][j]=1;
                            }
                        }
                    }
                }
                //System.out.print(sarysiuMatrica[i][j]+"  ");
            } 
        }
       // System.out.println();
        //System.out.println("....Sudaryta");
        
        p = new int[ilgis*plotis];
        s = new int[ilgis*plotis];
        d = new int[ilgis*plotis];
        
        for (int i = 0; i < ilgis*plotis; i++) {
			s[i] = nuo.id;
                        p[i] = nuo.id;
		}
        for (int i = 0; i < ilgis*plotis; i++) {
			d[i]=sarysiuMatrica[nuo.id][i];
                        //System.out.print(d[i]+"  ");
		}
        System.out.println();
        //checked ->viskas ok
        while(iteracija<ilgis*plotis){
            k=isrinktiMaziausia(nuo.id,ilgis*plotis);
            for(int i=0; i<ilgis*plotis; i++){
                if(i!= nuo.id && i!=k){
                    tempint=d[k]+sarysiuMatrica[k][i];
                    //System.out.println("tempint "+tempint);
                    if(d[i]>tempint){
                        d[i]=tempint;
                        p[i]=k;
                    }
                }
        }
            
        iteracija++;
        }
        
        
        int virsune = 0;
	int index;
	//System.out.println(" Nuo langelio ID: " +nuo.id + " su koordinatemis: X: "+nuo.x+"  Y: "+nuo.y);
        //System.out.println("Visi trumpiausi keliai iki kitų langelių yra:");
	for (int i = 0; i < ilgis*plotis; i++) {
		if (i != nuo.id) {
                        kelias=0;
			//System.out.print("Iki virsunes: " + i + " : ");
			rekursija(nuo.id, ilgis*plotis, i);
                        if(ilgiausias<kelias){
                        ilgiausias=kelias;
                        ilgiausioid=i;
                        }
			//System.out.println();
			//System.out.println(" Kelio ilgis: " + kelias);
			//System.out.println();
			kelias = 0;
		}
	}
        /*for (int i = 0; i < ilgis*plotis; i++) {
                        System.out.print(d[i]+"  ");
		}
        System.out.println("");
        for (int i = 0; i < ilgis*plotis; i++) {
                        System.out.print(p[i]+"  ");
		}
        System.out.println("");
        for (int i = 0; i < ilgis*plotis; i++) {
                        System.out.print(s[i]+"  ");
		}
        masyvų patikrinimai
        */
        return ilgiausioid;
    }
    
    public int isrinktiMaziausia(int nuo, int matmenys){
        int k=0;
        int tempmaks = 900000000;
        boolean check=true;
        //System.out.println("Iteracija: "+iteracija);
            for(int i=0; i<ilgis*plotis; i++){
                if (d[i] < tempmaks && d[i] != 0) {
                    if(iteracija>1){
                        for(int j=0; j<iteracija; j++){
                            if(i==s[j]){
                                check=false;
                                //System.out.println("111111111111111111111");
                            }
                        }
                        if (check == true) {
                            k = i;
                            tempmaks = d[i];
                            //System.out.println("22222222222222222222");
                        }
                    check = true;
                    }
                    else { 
                        k = i;
                        tempmaks = d[i];
                        //System.out.println("3333333333333333333333");
                    }
                }
            }
        s[iteracija]=k;
        
        System.out.println("K yra: "+k);
    return k;
    }
    
    public void rekursija(int nuoo, int matmenys, int index){
        //System.out.print(" <- "+p[index]);
	kelias ++; // vietoje += d[index], kadangi kelias visad didėja po vienetą
	index = p[index];
	if (index != nuoo) {
		rekursija(nuoo, matmenys, index);
	}
    }
}


//System.out.print("Pridedamo kelio vertė: " +d[index]);