import java.util.ArrayList;
import java.util.Scanner;

public class Banka {
    private ArrayList<Klient> klienti;
    private Scanner console = new Scanner(System.in);

    public Banka() {
        this.klienti = new ArrayList<>();
    }

    public boolean SHTOKLIENT(Klient klientiRi) {
        if (KerkoKlientID(klientiRi.getId()) >= 0) {
            System.out.println("Klienti ekziston tashme nuk mund ta regjistroni serisht!");
            return false;
        } else if (klientiRi.getVitiLindjes() > 2004) {
            System.out.println("Klienti nuk mund te regjistrohet.Viti Lindjes Nuk Eshte i regullt");
            return false;
        }
        klienti.add(klientiRi);
        return true;

    }



    public boolean DEPOZITO(Klient klient, double depozita) {
        if (GJEJKLIENTIN(klient) < 0) {
            System.out.println("Gabim: Klienti nuk u gjet");
            return false;
        }
        int pozicioni = GJEJKLIENTIN(klient);
        double balanca = this.klienti.get(pozicioni).getGjendja();
        double balancaRe = balanca + depozita;
        this.klienti.get(pozicioni).setGjendja(balancaRe);
        return true;

    }

    public boolean TERHIQ(Klient klient, double terheqja) {
        if (GJEJKLIENTIN(klient) < 0) {
            System.out.println("Klienti nuk u gjet.");
            return false;
        }
        int pozicioni = GJEJKLIENTIN(klient);
        if (terheqja < 0) {
            System.out.println("Sasia terheqjes nuk mund te kryhet. Sasia nuk mund te jete negative");
            return false;
        }
        double gjendja = klienti.get(pozicioni).getGjendja();
        double gjendjare = gjendja - terheqja;
        if (GJEJKLIENTIN(klient) >= 0) {
            if (gjendjare >= 0) {
                klienti.get(pozicioni).setGjendja(gjendjare);
                System.out.println("Klienti" + klienti.get(pozicioni).getEmri() + " " +
                        klienti.get(pozicioni).getMbiemri() + "terhoqi " +
                        terheqja + " " + klienti.get(pozicioni).getMonedha());
                System.out.print("Gjendja e mbetur: " + klienti.get(pozicioni).getGjendja());
            }
        } else
            System.out.println("Depozitmi nuk mund te kryhet. ID nuk ekziston");
        return false;

    }


    public void ListoKlientet() {
        for (int i = 0; i < klienti.size(); i++) {
            System.out.println((1 + i) + ". " + klienti.get(i).getEmri() + " " + klienti.get(i).getMbiemri()
                    + " ID: " + klienti.get(i).getId() + " Balanca: " + klienti.get(i).getGjendja() + " "
                    + klienti.get(i).getMonedha() + " Interesi: " + klienti.get(i).getInteresi());
        }
    }

    public boolean TRANSFERO(String ID1, String ID2, Klient klienti1, Klient klienti2, double transferta) {
        if (GJEJKLIENTIN(klienti1) < 0) {
            System.out.println("Klienti nuk u gjet.");
            return false;
        }
        if (GJEJKLIENTIN(klienti2) < 0) {
            System.out.println("Klienti nuk u gjet.");
            return false;
        }
        double balanca1 = KerkoID(ID1).getGjendja();
        double balanca2 = KerkoID(ID2).getGjendja();
        if (balanca1 < transferta && (balanca1 - transferta) < 0) {
            System.out.println("Error: Ju nuk keni balance te mjaftueshme per te kryer trasnferten");
            return false;
        } else {
            KerkoID(ID1).setGjendja(balanca1 - transferta);
            KerkoID(ID2).setGjendja(balanca2 + transferta);
            System.out.println("Transferta u krye me sukses");
            return true;
        }


    }


    public boolean NDRYSHOINTERES(Klient klient, double new_interest) {
        if (GJEJKLIENTIN(klient) < 0) {
            System.out.println("Klienti nuk u gjet");
            return false;
        }
        int pozicioni = GJEJKLIENTIN(klient);
        klienti.get(pozicioni).setInteresi(new_interest);
        return true;

    }

    public void FSHIJKLIENT(Klient klient) {
        if (GJEJKLIENTIN(klient) < 0) {
            System.out.println("Klienti nuk u gjet");
            return;
        }
        int pozicioni = GJEJKLIENTIN(klient);
        System.out.println("Jeni te sigurt qe deshironi te fshini klientin(Y/N):");
        PrintoKlientin(klient);
        String action = console.nextLine();
        if (action.charAt(0) == 'Y') {
            klienti.remove(pozicioni);
            System.out.println("Klienti u fshi me sukses");
        } else if (action.charAt(0) == 'N') {
            //Goes out of the method
        }


    }


    // Takes the id of the client and returns the index of the klient on the arraylist
    private int KerkoKlientID(String ID) {
        for (int i = 0; i < this.klienti.size(); i++) {
            if (klienti.get(i).getId().equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void PrintoKlientin(Klient klient) {
        if (GJEJKLIENTIN(klient) < 0) {
            System.out.println("Klienti Nuk Ekziston");
            return;
        }
        int pozicioni = GJEJKLIENTIN(klient);
        System.out.println(klienti.get(pozicioni).getId()
                + ":: Klenti me emer " + klienti.get(pozicioni).getEmri() + " Interesi: " +
                klienti.get(pozicioni).getInteresi());

    }

    public void PERFITOINTERES(Klient klient) {
        if (GJEJKLIENTIN(klient) < 0) {
            System.out.println("Klienti nuk u gjet");
        }
        int pozicioni = GJEJKLIENTIN(klient);
        double balanca = klienti.get(pozicioni).getGjendja();
        double interesi = klienti.get(pozicioni).getInteresi();
        double interesiperfituar = (interesi / 100) * balanca;
        System.out.printf("Interesi i perfituar %.2f ", interesiperfituar);
        klienti.get(pozicioni).setGjendja(balanca + interesiperfituar);
        System.out.println("Balanca e re eshte: " + klienti.get(pozicioni).getGjendja() + " " +
                klienti.get(pozicioni).getMonedha());
    }


    //Takes a string id of a client and returns it from the array list
    public Klient KerkoID(String ID) {
        int pozicioni = KerkoKlientID(ID);
        if (pozicioni >= 0) {
            return this.klienti.get(pozicioni);
        } else return null;
    }

    //Takes a klient object and returns its index
    private int GJEJKLIENTIN(Klient klienti) {
        return this.klienti.indexOf(klienti);
    }

    public String KonvertoIDNeEmer(String ID) {
        return KerkoID(ID).getEmri();

    }

}
