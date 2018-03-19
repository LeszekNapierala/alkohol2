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
        double odczytanaMocAlkoholu7c = 93.7;
        // tutaj podajemy odczytana temperature alkoholu od -10 do +30 (co 0,5°)   np.22,5
        double odczytanaTemperatura7c = 22.5;

        String nazwaPliku7c = "dane/tablice7c.csv";
        // mocAlkoholu  wynosi 93,12

        TablicaAlkoholowa tablica7c = new TablicaAlkoholowa(odczytanaMocAlkoholu7c, odczytanaTemperatura7c, nazwaPliku7c);

        System.out.println("tablica7c :  odczytanaMocAlkoholu " + tablica7c.kolumna);
        System.out.println("tablica7c :  odczytanaTemperatura " + tablica7c.wiersz);
        System.out.println("tablica7c :  mocAlkoholu " + tablica7c.wartosc);
        System.out.println("----------------------");

        String nazwaPliku8d = "dane/tablice8d.csv";
        // tutaj podajemy odczytaną moc alkoholu co 1° z alkoholomierza od 80-100  np.93
        int odczytanaMocAlkoholu8d = 93;
        // tutaj podajemy odczytana temperature alkoholu od -10 do +30 (co 0,5°)   np.17,5
        double odczytanaTemperatura8d = -10;
        //poprawka wynosi 3.03(-0,07) = 2,96

        TablicaAlkoholowa tablica8d = new TablicaAlkoholowa(odczytanaMocAlkoholu8d, odczytanaTemperatura8d, nazwaPliku8d);

        System.out.println("tablica8d :  odczytanaMocAlkoholu " + tablica8d.kolumna);
        System.out.println("tablica8d :  odczytanaTemperatura " + tablica8d.wiersz);
        System.out.println("tablica8d :  poprawka " + tablica8d.wartosc + " poprawka końcowa -0,07 = " + (tablica8d.wartosc - 0.07));
        tablica8d.wartosc -= 0.07;
        System.out.println("tablica8d :  poprawka " + tablica8d.wartosc);
        System.out.println("----------------------");

        String nazwaPliku9b = "dane/tablice9b.csv";
        // tutaj podajemy moc alkoholu  co 0,1° od 80-100  np.93.7
        double odczytanaMocAlkoholu9b = 93.1;
        // tutaj podajemy wage alkoholu od 100 do 1000kg (co 10)   np. 620
        double odczytanaWaga9b = 620;
        //double objetoscAlkoholu = 706,09;
        TablicaAlkoholowa tablica9b = new TablicaAlkoholowa(odczytanaMocAlkoholu9b, odczytanaWaga9b, nazwaPliku9b);
        
        System.out.println("tablica9b :  odczytanaMocAlkoholu " + tablica9b.kolumna);
        System.out.println("tablica9b :  odczytanaWaga " + tablica9b.wiersz);
        System.out.println("tablica9b :  objetoscAlkoholu " + tablica9b.wartosc);
        System.out.println("----------------------");
        
        double odczytanaWaga9bx = 61778;
        //double objetoscAlkoholu = 70609;
        TablicaAlkoholowa2 tablica9bx = new TablicaAlkoholowa2(odczytanaMocAlkoholu9b, odczytanaWaga9bx, nazwaPliku9b);
        
        System.out.println("tablica9bx :  odczytanaMocAlkoholu " + tablica9bx.kolumna);
        System.out.println("tablica9bx :  odczytanaWaga " + tablica9bx.wiersz);
        System.out.println("tablica9bx :  objetoscAlkoholu " + tablica9bx.wartosc);
        System.out.println("----------------------");
        
        
    }

}
