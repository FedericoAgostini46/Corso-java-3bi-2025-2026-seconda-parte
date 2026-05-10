package ricorsione;

public class MetodiRicorsivi {

    // 1. Determina se una stringa è palindroma
    public static boolean isPalindroma(String stringa) {
        
        if (stringa.length() <= 1) {
            return true;
        }

        if (stringa.charAt(0) != stringa.charAt(stringa.length() - 1)) {
            return false;
        }

        return isPalindroma(stringa.substring(1, stringa.length() - 1));
    }

    // 2. Calcola la somma delle cifre di un numero
    public static int sommaCifre(int n) {
        n = Math.abs(n); // gestisce numeri negativi

        // Caso base
        if (n < 10) {
            return n;
        }

        return (n % 10) + sommaCifre(n / 10);
    }

    // 3. Calcola la potenza in modo ricorsivo
    public static int potenza(int base, int esponente) {
        // Caso base
        if (esponente == 0) {
            return 1;
        }

        return base * potenza(base, esponente - 1);
    }

  
    public static void main(String[] args) {
        System.out.println(isPalindroma("anna"));      
        System.out.println(isPalindroma("ciao"));      

        System.out.println(sommaCifre(1234));          
        System.out.println(sommaCifre(987));           

        System.out.println(potenza(2, 3));            
        System.out.println(potenza(5, 4));            
    }
}