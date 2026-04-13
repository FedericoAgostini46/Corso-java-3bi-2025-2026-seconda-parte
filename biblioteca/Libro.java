package biblioteca;

/**
 * Gestisce un Libro.
 *
 * @author luca.boschi
 * @version 1.0
 */
public class Libro {

    // attributi
    private final String ISBN;    // utilizzato per identificare in modo univoco un libro
    private String titolo;
    private String autore;
    private int numeroPagine;
    private boolean disponibile;
    private Genere genere;

    // costruttori
    public Libro(String ISBN, String titolo, String autore, int numeroPagine, boolean disponibile, Genere genere) throws Exception {        
        try {
            this.ISBN = ISBN;
            setAutore(autore);
            setDisponibile(disponibile);
            setGenere(genere);
            setNumeroPagine(numeroPagine);
            setTitolo(titolo);
        } 
        catch (Exception e) {
            throw new Exception("Errore nella costruzione del Libro. "+e.getMessage());
        }
 
    }

    // setter e getter
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setAutore(String autore) throws Exception {
        if (autore == null || autore.isBlank()) {
            throw new Exception("Autore non corretto.");
        }
        this.autore = autore;
    }

    public int getNumeroPagine() {
        return numeroPagine;

    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;

    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    // to string
    @Override
    public String toString() {
        return "Libro{ISBN="+this.ISBN + ", titolo=" + titolo + ", autore=" + autore + ", numeroPagine=" + numeroPagine + ", disponibile=" + disponibile + ", genere=" + genere + '}';
    }

    // altri metodi
    
    public void prestaLibro() throws Exception{
        if (!disponibile) {
            throw new Exception("Libro già in prestito");
        }
        this.disponibile = false;
    }
    
    
    public void prestaLibro2(){
        if (disponibile) {
            this.disponibile = false;
        }        
    }
    
    public void restituisciLibro(){
        this.disponibile = true;
    }
           
    
    @Override
    public boolean equals(Object obj) {
        
        // se gli indirizzi dell'oggetto corrente e del parametro obj sono uguali
        // vuol dire che puntano allo stesso oggetto (libro)
        if (this == obj) {
            return true;
        }

        // se l'oggetto che vuoi confrontare con this è nullo,
        // sicuramente sarà diverso da this
        if (obj == null) {
            return false;
        }

        // se il parametro obj appartiene ad una classe
        // diversa da quella dell'oggetto corrente this (di tipo Libro), 
        // sicuramente, i due oggetti saranno diversi
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        
        // se arrivo qui, this e obj contengono riferimenti ad oggetti di tipo Libro
        // faccio diventare l'oggetto referenziato tramite obj di tipo Libro
        Libro altroLibro = (Libro)obj;

        /*if (this.getISBN().equals(altroLibro.getISBN())) {
            return true;
        }
        else
        {
            return false;
        }*/

        return this.getISBN().equals(altroLibro.getISBN());
    }

}
