package testmaze;





public class Testmaze {
    
    
    

    public static void main(String[] args) {
        Labirintas test = new Labirintas(4,6);
        test.rastiLangeli(0, 0).setAA(true);
        test.rastiLangeli(1, 0).setAA(true);
        test.rastiLangeli(1, 0).setAD(true);
        test.rastiLangeli(2, 0).setAA(true);
        test.rastiLangeli(2, 0).setAD(true);
        test.rastiLangeli(0, 1).setVD(true);
        test.rastiLangeli(0, 1).setAD(true);
        test.rastiLangeli(1, 1).setAD(true);
        test.rastiLangeli(2, 1).setVD(true);
        test.rastiLangeli(3, 1).setVD(true);
        test.rastiLangeli(0, 2).setAA(true);
        test.rastiLangeli(0, 2).setAD(true);
        test.rastiLangeli(1, 2).setAA(true);
        test.rastiLangeli(1, 2).setAD(true);
        test.rastiLangeli(2, 2).setVD(true);
        test.rastiLangeli(3, 2).setVD(true);
        test.rastiLangeli(3, 2).setAD(true);
        test.rastiLangeli(0, 3).setVD(true);
        test.rastiLangeli(1, 3).setVD(true);
        test.rastiLangeli(2, 3).setAA(true);
        test.rastiLangeli(3, 3).setVD(true);
        test.rastiLangeli(0, 4).setAD(true);
        test.rastiLangeli(1, 4).setVD(true);
        test.rastiLangeli(2, 4).setVD(true);
        test.rastiLangeli(2, 4).setAD(true);
        test.rastiLangeli(2, 4).setAA(true);
        test.rastiLangeli(3, 4).setAD(true);
        test.rastiLangeli(0, 5).setAA(true);
        test.rastiLangeli(1, 5).setAA(true);
        test.rastiLangeli(2, 5).setAA(true);
        test.printLabirintas();
        // puse labirinto, viskas veikia
        Taskas taskas = new Taskas(test.getMatmenys());
        taskas.AA();
        taskas.AD();
        taskas.AD();
        taskas.AD();
        taskas.printTaskas();
        test.paieska(test.getLangelisPagalID(3));
        
    }
}