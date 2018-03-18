/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkohol;

/**
 *
 * @author Leszek
 */
public class Alkohol2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // tutaj podajemy odczytaną moc alkoholu  co 0,1° z alkoholomierza od 70-101,9  np.93.7
        double odczytanaMocAlkoholu = 93.7;
        // tutaj podajemy odczytana temperature alkoholu od -10 do +30 (co 0,5°)   np.17,5
        double odczytanaTemperatura = 17.5;

        String nazwaPliku = "dane/tablice7c.csv";
        // mocAlkoholu  wynosi 94,26

        TablicaAlkoholowa tablica7c = new TablicaAlkoholowa(odczytanaMocAlkoholu, odczytanaTemperatura, nazwaPliku);

        System.out.println("tablica7c :  odczytanaMocAlkoholu " + tablica7c.kolumna);
        System.out.println("tablica7c :  odczytanaTemperatura " + tablica7c.wiersz);
        System.out.println("tablica7c :  mocAlkoholu " + tablica7c.wartosc);
        System.out.println("----------------------");
        
        String nazwaPliku2 = "dane/tablice8d.csv";
        // tutaj podajemy odczytaną moc alkoholu co 1° z alkoholomierza od 80-100  np.93
        int odczytanaMocAlkoholu2 = 93;
        // tutaj podajemy odczytana temperature alkoholu od -10 do +30 (co 0,5°)   np.17,5
        double odczytanaTemperatura2 = -10;
        //poprawka wynosi 3.03(-0,07) = 2,96 l 
        
        TablicaAlkoholowa tablica8d = new TablicaAlkoholowa(odczytanaMocAlkoholu2, odczytanaTemperatura2, nazwaPliku2);
        System.out.println("tablica8d :  odczytanaMocAlkoholu " + tablica8d.kolumna);
        System.out.println("tablica8d :  odczytanaTemperatura " + tablica8d.wiersz);
        System.out.println("tablica8d :  poprawka " + tablica8d.wartosc);
        System.out.println("----------------------");
        
    }

}
