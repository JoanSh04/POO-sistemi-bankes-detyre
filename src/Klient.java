import java.util.ArrayList;

public class Klient {
    private String id;
    private String Emri;
    private String mbiemri;
    private int vitiLindjes;
    private String monedha;
    private double gjendja;
    private double interesi;
    public ArrayList<NenLlogari> llogari = new ArrayList<>();



    public Klient(String id, String emri, String mbiemri, int vitiLindjes,
                  String monedha, double gjendja, double interesi) {
        this.id = id;
        Emri = emri;
        this.mbiemri = mbiemri;
        this.monedha = monedha;
        this.gjendja = gjendja;
        this.interesi = interesi;
    }

    public Klient(String id, String emri, String mbiemri, String monedha, double gjendja, double interesi) {
        this.id = id;
        Emri = emri;
        this.mbiemri = mbiemri;
        this.monedha = monedha;
        this.gjendja = gjendja;
        this.interesi = interesi;
    }

    public ArrayList<NenLlogari> getLlogari() {
        return llogari;
    }

    public void setLlogari(ArrayList<NenLlogari> llogari) {
        this.llogari = llogari;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmri() {
        return Emri;
    }

    public void setEmri(String emri) {
        Emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public int getVitiLindjes() {
        return vitiLindjes;
    }

    public void setVitiLindjes(int vitiLindjes) {
        this.vitiLindjes = vitiLindjes;
    }

    public String getMonedha() {
        return monedha;
    }

    public void setMonedha(String monedha) {
        this.monedha = monedha;
    }

    public double getGjendja() {
        return gjendja;
    }

    public void setGjendja(double gjendja) {
        this.gjendja = gjendja;
    }

    public double getInteresi() {
        return interesi;
    }

    public void setInteresi(double interesi) {
        this.interesi = interesi;
    }


    public static Klient klient(String id, String emri, String mbiemri, int vitiLindjes,
                                String monedha, double gjendja, int interesi) {
        return new Klient(id, emri, mbiemri, vitiLindjes, monedha, gjendja, interesi);
    }
}
