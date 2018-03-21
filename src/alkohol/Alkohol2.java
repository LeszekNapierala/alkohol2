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
        
        double mocAlkoholu20 = 93.1; // tutaj podajemy moc alkoholu  co 0,1° od 80-100  np.93.7      
        double wagaNetto = 617782;  // tutaj podajemy wage alkoholu od 100 do 1000kg (co 10)   np. 620
                                    //double objetoscAlkoholu = 706,09;      
        int auxiliaryVariable = 0; // zmienna pomocnicza do obliczeń
        double temporary = wagaNetto;
        double[] wagaTemp = new double[6]; // tablica przchowująca wagę natto rozbitą na wartości, aby odczytać z z tablicy 100 do 1000kg	
        double wartoscTab = 0.0; // wartosc wyliczona z tablicy9b

        if (temporary >= 100000 && temporary < 1000000) {
            auxiliaryVariable = (int) temporary / 10000;
            wagaTemp[0] = 10 * auxiliaryVariable;
            TablicaAlkoholowa tab0 = new TablicaAlkoholowa(mocAlkoholu20, wagaTemp[0], nazwaPliku9b);
            wartoscTab += tab0.wartosc * 1000;
            temporary = temporary - wagaTemp[0] * 1000;
            System.out.println("0 :  objetoscAlkoholu " + "wagaTemp[0]" + wagaTemp[0] + "    "  + wartoscTab);
        }
        if (temporary >= 10000) {
            auxiliaryVariable = (int) temporary / 1000;
            wagaTemp[1] = 10 * auxiliaryVariable;
            TablicaAlkoholowa tab0 = new TablicaAlkoholowa(mocAlkoholu20, wagaTemp[1], nazwaPliku9b);
            wartoscTab += tab0.wartosc * 100;
            temporary = temporary - wagaTemp[1] * 100;
            System.out.println("1 :  objetoscAlkoholu " + "wagaTemp[1]" + wagaTemp[1] + "    " + wartoscTab);
        }
        if (temporary >= 1000) {
            auxiliaryVariable = (int) temporary / 100;
            wagaTemp[2] = 10 * auxiliaryVariable;
            TablicaAlkoholowa tab0 = new TablicaAlkoholowa(mocAlkoholu20, wagaTemp[2], nazwaPliku9b);
            wartoscTab += tab0.wartosc * 10;
            temporary = temporary - wagaTemp[2] * 10;
            System.out.println("2 :  objetoscAlkoholu " + "wagaTemp[2]" + wagaTemp[2] + "    " + wartoscTab);
        }
        if (temporary >= 100) {
            auxiliaryVariable = (int) temporary / 10;
            wagaTemp[3] = 10 * auxiliaryVariable;
            TablicaAlkoholowa tab0 = new TablicaAlkoholowa(mocAlkoholu20, wagaTemp[3], nazwaPliku9b);
            wartoscTab += tab0.wartosc * 1;
            temporary = temporary - wagaTemp[3] * 1;
            System.out.println("3 :  objetoscAlkoholu " + "wagaTemp[3]" + wagaTemp[3] + "    " + wartoscTab);
        }
        if (temporary >= 10) {
            auxiliaryVariable = (int) temporary / 1;
            wagaTemp[4] = 10 * auxiliaryVariable;
            TablicaAlkoholowa tab0 = new TablicaAlkoholowa(mocAlkoholu20, wagaTemp[4], nazwaPliku9b);
            wartoscTab += tab0.wartosc * 0.1;
            temporary = temporary - wagaTemp[4] * 0.1;
            System.out.println("4 :  objetoscAlkoholu " + "wagaTemp[4]" + wagaTemp[4] + "    " + wartoscTab);
        }
        if (temporary >= 1) {
            auxiliaryVariable = (int) temporary * 10;
            wagaTemp[5] = 10 * auxiliaryVariable;
            TablicaAlkoholowa tab0 = new TablicaAlkoholowa(mocAlkoholu20, wagaTemp[5], nazwaPliku9b);
            wartoscTab += tab0.wartosc * 0.01;
            System.out.println("5 :  objetoscAlkoholu " + "wagaTemp[5]" + wagaTemp[5] + "    " + wartoscTab);      
        }
        System.out.println("5 :  objetoscAlkoholu " + wartoscTab);
        
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });

    }

}
