package applicazione;

import biblioteca.CollezioneLibri;
import biblioteca.Genere;
import biblioteca.Libro;

public class Programma {

    public static void main(String[] args) {
        try {
            CollezioneLibri collezione = new CollezioneLibri(28);

            Libro l1 = new Libro("3Bi","Agostini",500,true,Genere.ALTRO);
            Libro l2 = new Libro("4Bi","Rossi",50,true,Genere.ALTRO);
            Libro[] col1 = {l1,l2};
            
            CollezioneLibri biblioteca = new CollezioneLibri(col1);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

