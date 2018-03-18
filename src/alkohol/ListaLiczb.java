/*
 * 
 */
package alkohol;
/**
 * @author Leszek
 */
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ListaLiczb {

	private List<String> liczby = new ArrayList<>();
	
	public ListaLiczb() {
		this.liczby = new ArrayList<>();		
	}
//  wczytanie całej linii tekstu podzielonego do listy nagłówka z przedrostkiem
	public void  wczytajNaglowek(String linia, String str) {
		StringTokenizer strTok = new StringTokenizer(linia,";");
		while (strTok.hasMoreTokens()) {
			liczby.add(str+strTok.nextToken());
		}
	}
	
	//  wczytanie całej linii tekstu podzielonego do listy 
	public void  wczytajLinie(String linia) {
		StringTokenizer strTok = new StringTokenizer(linia,";");
                liczby.clear();
		while (strTok.hasMoreTokens()) {
			liczby.add(strTok.nextToken());
		}
	}
	// odczyt wartości na podstawie indeksu
	public String wezLiczbe(int indeks) {
		return liczby.get(indeks);
	}
	// wyszukanie indeksu na podstawie wartości w liście nagłówka
	public int szukajIndeksu(double wartosc) {
		Integer indeks=null;
		for (int i=0; i<ileLiczb(); i++) {
			if (i>0 && wartosc==Double.parseDouble(wezLiczbe(i))) {
				indeks = i;
			}
		} 
		return indeks;
	}
	//szukanie wartości z tablicy na podstawie wartości 1-kolumny i indeksu
	public double szukajWartosci(double wartosc, int indeks) {
			double wynik = 0;
			if (wartosc==Double.parseDouble(wezLiczbe(0))) {
				wynik = Double.parseDouble(wezLiczbe(indeks));				
				return wynik;
			}
		return wynik;
	}
	
	// rozmiar listy
	public int ileLiczb() {
		return liczby.size();
	}
	
//	public void czyscLiczby() {
//		liczby.clear();
//	}
}