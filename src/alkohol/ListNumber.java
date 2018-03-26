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

public class ListNumber {

	private List<String> number = new ArrayList<>();
	
	public ListNumber() {
		this.number = new ArrayList<>();		
	}
//  wczytanie całej linii tekstu podzielonego do listy nagłówka z przedrostkiem
	public void  loadHeader(String line, String str) {
		StringTokenizer strTok = new StringTokenizer(line, ";");
		while (strTok.hasMoreTokens()) {
			number.add(str+strTok.nextToken());
		}
	}
	
	//  wczytanie całej linii tekstu podzielonego do listy 
	public void  loadLines(String line) {
		StringTokenizer strTok = new StringTokenizer(line,";");
                number.clear();
		while (strTok.hasMoreTokens()) {
			number.add(strTok.nextToken());
		}
	}
	// odczyt wartości na podstawie indeksu
	public String takeNumber(int index) {
		return number.get(index);
	}
	// wyszukanie indeksu na podstawie wartości w liście nagłówka
	public int searchIndex(double value) {
		Integer index=null;
		for (int i=0; i<howNumbers(); i++) {
			if (i>0 && value==Double.parseDouble(takeNumber(i))) {
				index = i;
			}
		} 
		return index;
	}
	//szukanie wartości z tablicy na podstawie wartości 1-kolumny i indeksu
	public double searchValue(double value, int index) {
			double score = 0;
			if (value==Double.parseDouble(takeNumber(0))) {
				score = Double.parseDouble(takeNumber(index));				
				return score;
			}
		return score;
	}
	
	// rozmiar listy
	public int howNumbers() {
		return number.size();
	}
}