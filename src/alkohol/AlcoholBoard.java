package alkohol;

import java.io.*;
/**
 * @author Leszek
 */
public class AlcoholBoard {

    ListNumber heading = new ListNumber();
    ListNumber data = new ListNumber();
    // tutaj podajemy nagłówek kolumny tablicy  np.93.7 z tablica7c odczytanaMocAlkoholu
    double column; // = 93.7;
    // tutaj podajemy nagłówek wiersza tablicy   np.17,5  z tablica7c odczytanaTemperatura
    double line; // = 17.5;
    // np. wynik odczytu z tablicy7c
    double vaule = 0; // wówczas powinno być moc wynosi 94,26 mocAlkoholu
    Integer index = null;  //indeks
    String fileName;   // String nazwaPliku = "dane/tablice7c.csv";

    public AlcoholBoard(double column, double line, String fileName) {
        this.column = column;
        this.line = line;
        this.fileName = fileName;
        this.vaule = readingValues(column, line, fileName);
    }
        
    private double readingValues(double column, double line, String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String ruler = null;

            try {
                ruler = br.readLine();
                heading.loadLines(ruler);
                index = heading.searchIndex(column);
                // odczyt z poszczególnych wierszy
                while ((ruler = br.readLine()) != null) {
                    data.loadLines(ruler);
                    vaule = data.searchValue(line, index);
                    if (vaule != 0) {
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
        return vaule;       
    }
}
