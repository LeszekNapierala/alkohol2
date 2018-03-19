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
public class TablicaAlkoholowa2 {

    ListaLiczb naglowek = new ListaLiczb();
    ListaLiczb dane = new ListaLiczb();
    // tutaj podajemy nagłówek kolumny tablicy  np.93.7 z tablica7c odczytanaMocAlkoholu
    double kolumna; // = 93.7;
    // tutaj podajemy nagłówek wiersza tablicy   np.17,5  z tablica7c odczytanaTemperatura
    double wiersz; // = 17.5;
    // np. wynik odczytu z tablicy7c
    double wartosc = 0.0; // wówczas powinno być moc wynosi 94,26 mocAlkoholu
    Integer indeks = null;  //indeks
    String nazwaPliku;
    // String nazwaPliku = "dane/tablice7c.csv";

    public TablicaAlkoholowa2(double kolumna, double wiersz, String nazwaPliku) {
        this.kolumna = kolumna;
        this.wiersz = wiersz;
        this.nazwaPliku = nazwaPliku;
        this.wartosc = odczytWartosci(kolumna, wiersz, nazwaPliku);

    }

    private double odczytWartosci(double kolumna, double wiersz, String nazwaPliku){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(nazwaPliku));
            String linia = null;
            int temporary = (int) wiersz; // liczba całkowita dla wiersza
            int auxiliaryVariable = 0; // zmienna pomocnicza do obliczeń
            int[] array = new int[6]; // tablica przchowująca wagę netto rozbitą na wartości, aby odczytać z z tablicy 100 do 1000kg
            double wagaTemp = 0.0;
            if (temporary >= 100000 && temporary < 1000000) {
                auxiliaryVariable = temporary / 10000;
                array[0] = 10 * auxiliaryVariable;
                try {
                    linia = br.readLine();
                    naglowek.wczytajLinie(linia);
                indeks = naglowek.szukajIndeksu(kolumna);
                // odczyt z poszczególnych wierszy
                while ((linia = br.readLine()) != null) {
                    dane.wczytajLinie(linia);
                    wagaTemp = dane.szukajWartosci(array[0], indeks);
                    wartosc += wagaTemp * 1000;
                    if (wagaTemp != 0) {
                        break;
                    }
                }
                } catch (IOException ex) {
                    Logger.getLogger(TablicaAlkoholowa2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            temporary = temporary - array[0] * 1000;
            if (temporary >= 10000) {
                auxiliaryVariable = temporary / 1000;
                array[1] = 10 * auxiliaryVariable;
                try {
                    linia = br.readLine();
                     naglowek.wczytajLinie(linia);
                indeks = naglowek.szukajIndeksu(kolumna);
                // odczyt z poszczególnych wierszy
                while ((linia = br.readLine()) != null) {
                    dane.wczytajLinie(linia);
                    wagaTemp = dane.szukajWartosci(array[1], indeks);
                    wartosc += wagaTemp * 100;
                    if (wagaTemp != 0) {
                        break;
                    }
                }
                } catch (IOException ex) {
                    Logger.getLogger(TablicaAlkoholowa2.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
            temporary = temporary - array[1] * 100;
            if (temporary >= 1000) {
                auxiliaryVariable = temporary / 100;
                array[2] = 10 * auxiliaryVariable;
                try {
                    linia = br.readLine();
                    naglowek.wczytajLinie(linia);
                indeks = naglowek.szukajIndeksu(kolumna);
                // odczyt z poszczególnych wierszy
                while ((linia = br.readLine()) != null) {
                    dane.wczytajLinie(linia);
                    wagaTemp = dane.szukajWartosci(array[2], indeks);
                    wartosc += wagaTemp * 10;
                    if (wagaTemp != 0) {
                        break;
                    }
                }
                } catch (IOException ex) {
                    Logger.getLogger(TablicaAlkoholowa2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            temporary = temporary - array[2] * 10;
            if (temporary >= 100) {
                auxiliaryVariable = temporary / 10;
                array[3] = 10 * auxiliaryVariable;
                try {
                    linia = br.readLine();
                    naglowek.wczytajLinie(linia);
                indeks = naglowek.szukajIndeksu(kolumna);
                // odczyt z poszczególnych wierszy
                while ((linia = br.readLine()) != null) {
                    dane.wczytajLinie(linia);
                    wagaTemp = dane.szukajWartosci(array[3], indeks);
                    wartosc += wagaTemp * 1;
                    if (wagaTemp != 0) {
                        break;
                    }
                }
                } catch (IOException ex) {
                    Logger.getLogger(TablicaAlkoholowa2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            temporary = temporary - array[3] * 1;
            if (temporary >= 10) {
                auxiliaryVariable = temporary / 1;
                array[4] = 10 * auxiliaryVariable;
                try {
                    linia = br.readLine();
                    naglowek.wczytajLinie(linia);
                indeks = naglowek.szukajIndeksu(kolumna);
                // odczyt z poszczególnych wierszy
                while ((linia = br.readLine()) != null) {
                    dane.wczytajLinie(linia);
                    wagaTemp = dane.szukajWartosci(array[4], indeks);
                    wartosc += wagaTemp * 0.1;
                    if (wagaTemp != 0) {
                        break;
                    }
                }
                } catch (IOException ex) {
                    Logger.getLogger(TablicaAlkoholowa2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            temporary = temporary - (int) (array[4] * 0.1); //to jest liczba całkowita
            if (temporary >= 1) {
                auxiliaryVariable = temporary * 10;
                array[5] = 10 * auxiliaryVariable;
                try {
                    linia = br.readLine();
                    naglowek.wczytajLinie(linia);
                indeks = naglowek.szukajIndeksu(kolumna);
                // odczyt z poszczególnych wierszy
                while ((linia = br.readLine()) != null) {
                    dane.wczytajLinie(linia);
                    wagaTemp = dane.szukajWartosci(array[5], indeks);
                    wartosc += wagaTemp * 0.01;
                    if (wagaTemp != 0) {
                        break;
                    }
                }
                } catch (IOException ex) {
                    Logger.getLogger(TablicaAlkoholowa2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 
        finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(TablicaAlkoholowa2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return wartosc;

    }
}
