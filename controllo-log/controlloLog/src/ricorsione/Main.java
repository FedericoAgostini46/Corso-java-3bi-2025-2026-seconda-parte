package ricorsione;

public class Main {

    public static void main(String[] args) {
        int numero = 5;
        int fatt = fattoriale(numero);
    }

    // Ricorsione: trcnica di programmazione

    // Zurloso: un tipo un po' zurloso

    public static int x() {
        int y = 9;
        if(y<3) 
            return 1; // CASO BASE
        else
            return x();
    }

    // risoluzione iterativa
    public static int fattoriale(int n) {
        if(n==1 || n==0) {
            return 1;
        } else {
            return n*fattoriale(n-1);
        }
    }
}
