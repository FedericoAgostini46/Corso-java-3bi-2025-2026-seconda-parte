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

    public boolean remove(Libro libro) {
     // cerco la posizione del libro da eliminare
     int index = indexOf(libro);

    // se non ho un libro, non posso eliminarlo
    if (libro == null) {
        return false;
    }

    // se il libro non esiste (cioè ha un indice negativo), 
    // non posso eliminarlo: il metodo termina restituendo false 
    if (index < 0) {
        return false;
    }

    // shift a sinistra per mantenere l'ordine
    for (int i = index; i < count - 1; i++) {
        // copio l'ultimo libro nella posizione del libro da eliminare
        collezione[i] = collezione[i + 1];
    }

    // per evitare probelmi di memory leak, imposto a null il valore dell'ultima posizione della collezione,
    // in cui stava l'elemento che ho spostato
    collezione[count - 1] = null;
    // diminuisco il numero di elementi da considerarescccccccccccccc
    count--;

    return true;

    }

    public boolean removeNoOrder(Libro libro) 
    {
    int index = indexOf(libro);

    // se il libro non esiste
    if (index < 0) {
        return false;
    }

    // sostituisco con l'ultimo elemento
    collezione[index] = collezione[count - 1];

    // pulizia ultima posizione
    collezione[count - 1] = null;
    count--;

    return true;
    
    }

    public boolean contains(Libro libro) {
    // riuso indexOf per evitare duplicazione di codice
    return indexOf(libro) >= 0;
}

public Libro getLibro(int index) {
    // controllo indice valido
    if (index < 0 || index >= count) {
        return null; // oppure potresti lanciare un'eccezione
    }

    return collezione[index];
}

// restituisce il primo libro che incontra che ha il maggior numero di pagine
public Libro libroPiuLungo() {
    if (count == 0) {
        return null;
    }

    Libro max = collezione[0];

    for (int i = 1; i < count; i++) {
        if (collezione[i].getNumeroPagine() > max.getNumeroPagine()) {
            max = collezione[i];
        }
    }

    return max;
}

// restituisce i libri che hanno il maggior numero di pagine
public Libro[] libriPiuLunghi() {
    if (count == 0) {
        return new Libro[0];
    }

    // trovo numero massimo di pagine
    int maxPagine = collezione[0].getNumeroPagine();

    for (int i = 1; i < count; i++) {
        if (collezione[i].getNumeroPagine() > maxPagine) {
            maxPagine = collezione[i].getNumeroPagine();
        }
    }

    // conto quanti libri hanno quel numero di pagine
    int quanti = 0;
    for (int i = 0; i < count; i++) {
        if (collezione[i].getNumeroPagine() == maxPagine) {
            quanti++;
        }
    }

    // creo array risultato
    Libro[] risultato = new Libro[quanti];
    int j = 0;

    for (int i = 0; i < count; i++) {
        if (collezione[i].getNumeroPagine() == maxPagine) {
            risultato[j++] = collezione[i];
        }
    }

    return risultato;
}

// unisce, senza duplicati, un'altra collezione
public CollezioneLibri unione(CollezioneLibri altraCollezione) {
    // nuova collezione con spazio sufficiente
    CollezioneLibri nuova = new CollezioneLibri(this.count + altraCollezione.count);

    try {
        // aggiungo tutti i libri della collezione corrente
        for (int i = 0; i < this.count; i++) {
            nuova.add(this.collezione[i]);
        }

        // aggiungo quelli dell'altra evitando duplicati (add già lo controlla)
        for (int i = 0; i < altraCollezione.count; i++) {
            Libro libro = altraCollezione.collezione[i];

            if (!nuova.contains(libro)) {
                nuova.add(libro);
            }
        }
    } catch (Exception e) {
        // in teoria non dovrebbe succedere, ma lo gestiamo
        e.printStackTrace();
    }

    return nuova;
    }
}
