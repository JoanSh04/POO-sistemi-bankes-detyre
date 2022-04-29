public class NenLlogari extends Klient{

    private String IDLlogari;

    public NenLlogari(String id, String emri, String mbiemri, String monedha,
                      double gjendja, double interesi, String IDLlogari) {
        super(id, emri, mbiemri, monedha, gjendja, interesi);
        this.IDLlogari = IDLlogari;
    }

    public String getIDLlogari() {
        return IDLlogari;
    }

    public void setIDLlogari(String IDLlogari) {
        this.IDLlogari = IDLlogari;
    }

    public static NenLlogari llogari(String id, String emri, String mbiemri, String monedha,
                                     double gjendja, double interesi, String IDLlogari){
        return new NenLlogari(id, emri, mbiemri, monedha, gjendja, interesi, IDLlogari);
    }
}
