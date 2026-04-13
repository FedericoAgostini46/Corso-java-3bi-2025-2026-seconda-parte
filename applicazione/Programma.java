package applicazione;

import biblioteca.CollezioneLibri;
import biblioteca.Genere;
import biblioteca.Libro;

public class Programma {

    public static void main(String[] args) {
        
        int x = 9;

        System.out.println(x);
        x++;
        System.out.println(x);
        
        System.out.println("***********************");

        int y = 9;
        System.out.println(y);
        ++y;
        System.out.println(y);

        System.out.println("***********************");

        int z = 9;
        System.out.println(z);
        System.out.println(z++);
        System.out.println(z);

        System.out.println("***********************");
        int t = 9;
        System.out.println(t);
        System.out.println(++t);
        System.out.println(t);

        try {
            CollezioneLibri collezione = new CollezioneLibri(28);

            Libro l1 = new Libro("123","3Bi","Agostini",500,true,Genere.ALTRO);
            Libro l2 = new Libro("123","3Bi","Agostini",500,true,Genere.ALTRO);
            
            if ( l1.equals(l2) ) {
                System.out.println("UGUALI");
            }
            else
            {
                System.out.println("NON UGUALI");
            }

            Libro[] col1 = {l1,l2};
            
            CollezioneLibri biblioteca = new CollezioneLibri(col1);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
  
