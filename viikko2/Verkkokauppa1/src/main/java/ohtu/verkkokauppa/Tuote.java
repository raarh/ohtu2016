
package ohtu.verkkokauppa;

public class Tuote implements ITuote {
    private int id;
    private String nimi;
    private int hinta;

    public Tuote(int id, String nimi, int hinta) {
        this.id = id;
        this.nimi = nimi;
        this.hinta = hinta;
    }

    @Override
    public boolean equals(Object o) {
        ITuote t = (ITuote)o;
        
        return id==t.getId();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getHinta() {
        return hinta;
    }

    @Override
    public String toString() {
        return nimi;
    }            
    
}
