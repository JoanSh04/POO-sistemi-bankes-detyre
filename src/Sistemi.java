import java.util.Scanner;

public class Sistemi {
    private static Scanner console = new Scanner(System.in);
    private static Banka banka = new Banka();


    public static void main(String[] args) {
        boolean quit = false;
        printoInstruksionet();
        while (!quit) {
            System.out.println("Cfare veprimi deshironi te beni(0 - per te listuar listen)");
            int aksioni = console.nextInt();
            console.nextLine();
            switch (aksioni) {
                case 0:
                    printoInstruksionet();
                    break;
                case 1:
                    ShtoKlient();
                    break;
                case 2:
                    ShtoLlogari();
                    break;
                case 3:
                    banka.ListoKlientet();
                    break;
                case 4:
                    depozito();
                    break;
                case 5:
                    terhiq();
                    break;
                case 6:
                    transfer();
                    break;
                case 7:
                    ndryshointeres();
                    break;
                case 8:
                    perfitoInteres();
                    break;
                case 9:
                    fshijKlient();
                    break;
            }

        }
    }


    public static void printoInstruksionet() {
        System.out.println("0- Listo listen e instruksioneve\n" +
                "1- Shto Klient Te Ri\n" +
                "2- Shto Llogari Te Re\n" +
                "3- Listo Klientet\n" +
                "4- Depozito\n" +
                "5- Terhiq\n" +
                "6- Transfero\n" +
                "7- Ndrysho Interes\n" +
                "8- Perfito Interes\n" +
                "9- Fshij Klientin\n");
    }

    public static void ShtoKlient() {
        System.out.println("Vendos ID: ");
        String id = console.nextLine();
        System.out.println("Vendos Emrin: ");
        String emri = console.nextLine();
        System.out.println("Vendos Mbiemrin: ");
        String mbiemri = console.nextLine();
        System.out.println("Vendos vitin e lindjes: ");
        int vitiLindjes = console.nextInt();
        console.nextLine();1
        System.out.println("Vendos monedhen(ALL,EUR,USD,GBP): ");
        String monedha = console.nextLine();
        double interesi = 7.5;
        if (monedha.equalsIgnoreCase("EUR")) {
            interesi = 4.3;
            monedha = "EUR";
        } else if (monedha.equalsIgnoreCase("USD")) {
            interesi = 5.6;
            monedha = "USD";
        } else if (monedha.equalsIgnoreCase("GBP")) {
            interesi = 3.8;
            monedha = "GBP";
        } else monedha = "ALL";
        Klient klientiIRi = new Klient(id, emri, mbiemri, vitiLindjes, monedha, 0, interesi);
        banka.SHTOKLIENT(klientiIRi);

    }

    public static void ShtoLlogari(){
        System.out.println("Vendosni ID e klientit:");




    }


    public static void depozito() {
        System.out.println("Vendosni ID e klientit:");
        String ID = console.nextLine();
        System.out.println("Vendosni vleren te cilen deshironi te depozitoni");
        double depozita = console.nextDouble();
        if (banka.DEPOZITO(banka.KerkoID(ID), depozita)) {
            System.out.println("Sukses!");
        }
    }

    public static void terhiq() {
        System.out.println("Vendosni ID e klientit:");
        String ID = console.nextLine();
        System.out.println("Vendosni vleren te cilen deshironi te terhiqni");
        double terheqja = console.nextDouble();
        Klient klienti = banka.KerkoID(ID);
        if (banka.TERHIQ(klienti, terheqja)) {
            System.out.println("Sukses!");
        }
    }

    public static void transfer() {
        System.out.println("Vendosni vleren te cilen doni te transferoni: ");
        double transferta = console.nextDouble();
        console.nextLine();
        System.out.println("Vendosni ID e klientit nga te cilen do behet transferta: ");
        String derguesiID = console.nextLine();
        System.out.println("Vendosni ID e klientit ku do dergohet transferta: ");
        String marresiID = console.nextLine();
        Klient klienti1 = banka.KerkoID(derguesiID);
        Klient klienti2 = banka.KerkoID(marresiID);
        if (banka.TRANSFERO(derguesiID, marresiID, klienti1, klienti2, transferta)) {
            System.out.println(banka.KonvertoIDNeEmer(derguesiID) + " transferoi me sukses vleren =" +
                    transferta + " tek => " + banka.KonvertoIDNeEmer(marresiID));
        } else System.out.println("Transferta Deshtoi");
    }


    public static void ndryshointeres() {
        System.out.println("Vendosni ID e klientit i te cilit do behet ndryshimi: ");
        String ID = console.nextLine();
        Klient klient = banka.KerkoID(ID);
        banka.PrintoKlientin(klient);
        System.out.println("Vendosni interesin e ri");
        double interesiRi = console.nextDouble();
        banka.NDRYSHOINTERES(klient, interesiRi);
        System.out.println("Sukses!");
    }


    public static void fshijKlient() {
        System.out.println("Vendosni ID e klientit te cilin deshironi te fshini");
        String ID = console.nextLine();
        Klient klient = banka.KerkoID(ID);
        banka.FSHIJKLIENT(klient);


    }

    public static void perfitoInteres() {
        System.out.println("Vendosni ID e klientit: ");
        String ID = console.nextLine();
        Klient klient = banka.KerkoID(ID);
        banka.PERFITOINTERES(klient);


    }


}
