package biblioteca;

public class CollezioneLibri {
    private Libro[] collezione;
    private int count;

    public CollezioneLibri(int dimensione)
    {
        collezione = new Libro[dimensione];     // COMPOSIZIONE
        count = 0;
    }

    
    public CollezioneLibri()
    {
        this(1000);
    }

    public CollezioneLibri(Libro[] collezione)
    {
        this.collezione = new Libro[collezione.length * 2];

        for (int i = 0; i < collezione.length; i++) {
            this.collezione[i] = collezione[i];
        }
    }


    public void add(Libro libro) throws Exception
    {
        /*collezione[count] = libro;
        count++;*/

        // se non un libro, non posso inserirlo
        if (libro == null) {
            throw new Exception("Il libro non può essere null");
        }

        // se la collezione è piena, non posso aggiungere il libro
        if (count == collezione.length) {
            throw new Exception("Collezione piena");
        }

        // se il libro esiste, non lo inserisco
        if (indexOf(libro)>=0) {
            throw new Exception("Il libro esiste già nella collezione");
        }

        collezione[count++] = libro;
    }


    public int indexOf(Libro libro)
    {
        if (libro == null) {
            return -1;
        }

        for (int i = 0; i < count; i++) {
            if (collezione[i].getISBN().equals(libro.getISBN())) {
                return i;
            }
        }
        
        return -1;
    }
}
