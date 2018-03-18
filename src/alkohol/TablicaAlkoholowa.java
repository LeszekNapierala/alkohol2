/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkohol;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leszek
 */
public class TablicaAlkoholowa {

    ListaLiczb naglowek = new ListaLiczb();
    ListaLiczb dane = new ListaLiczb();
    // tutaj podajemy nagłówek kolumny tablicy  np.93.7 z tablica7c odczytanaMocAlkoholu
    double kolumna; // = 93.7;
    // tutaj podajemy nagłówek wiersza tablicy   np.17,5  z tablica7c odczytanaTemperatura
    double wiersz; // = 17.5;
    // np. wynik odczytu z tablicy7c
    double wartosc = 0; // wówczas powinno być moc wynosi 94,26 mocAlkoholu
    Integer indeks = null;  //indeks
    String nazwaPliku;
    // String nazwaPliku = "dane/tablice7c.csv";

    public TablicaAlkoholowa(double kolumna, double wiersz, String nazwaPliku) {
        this.kolumna = kolumna;
        this.wiersz = wiersz;
        this.nazwaPliku = nazwaPliku;
        this.indeks = indeks;
        this.wartosc = odczytWartosci(kolumna, wiersz, nazwaPliku);
    }

    public double odczytWartosci(double kolumna, double wiersz, String nazwaPliku) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nazwaPliku));
            String linia = null;

            try {
                linia = br.readLine();
                naglowek.wczytajLinie(linia);
                indeks = naglowek.szukajIndeksu(kolumna);
                // odczyt z poszczególnych wierszy
                while ((linia = br.readLine()) != null) {
                    dane.wczytajLinie(linia);
                    wartosc = dane.szukajWartosci(wiersz, indeks);
                    if (wartosc != 0) {
                        break;
                    }

                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return wartosc;
        
    }
}
