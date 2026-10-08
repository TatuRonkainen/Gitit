import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Random r = new Random();

        // Pelaajan aloitussaldo
        int raha = 10;
        String panos;
        String input;

        System.out.println("Saldo " + raha);
        System.out.println("");
        System.out.println("Aseta panos");
        panos = in.nextLine();

        // Pelisilmukka yksi kierros per toisto
        do {
            int luku1;
            int luku2;
            int luku3;
            
            // Arvotaan numero 1-10
            luku1 = r.nextInt(10) + 1;
            luku2 = r.nextInt(10) + 1;
            luku3 = r.nextInt(10) + 1;

            System.out.println("**********");
            System.out.println(luku1);
            System.out.println("**********");
            System.out.println(luku2);
            System.out.println("**********");
            System.out.println(luku3);
            System.out.println("**********");

            // Vähennetään panos saldosta
            raha = raha - Integer.parseInt(panos);

            // Lasketaan monta seiskaa arvottiin
            int seiskoja = 0;

            if (luku1 == 7) {
                seiskoja++;
            }
            if (luku2 == 7) {
                seiskoja++;
            }
            if (luku3 == 7) {
                seiskoja++;
            }
            // Voitot: 1 Seiska *3, 2 Seiskaa *6, 3 Seiskaa *100
            if (seiskoja == 1) {
                raha = raha + (3 * Integer.parseInt(panos));
                System.out.println("Voitit " + (3 * Integer.parseInt(panos)) + " €");
            }
            if (seiskoja == 2) {
                raha = raha + (6 * Integer.parseInt(panos));
                System.out.println("Voitit " + (6 * Integer.parseInt(panos)) + " €");
            }
            if (seiskoja == 3) {
                raha = raha + (100 * Integer.parseInt(panos));
                System.out.println("JACKPOT voitit " + (100 * Integer.parseInt(panos)) + " €");

            }
            // Jos rahat loppuu peli loppuu
            if (raha <= 0) {
                System.out.println("Saldo loppu");
                break;
            }

            System.out.println("Haluatko pelata uudestaan? Kyllä -> Enter. Ei -> stop");
            System.out.println("Saldo " + raha + " €");
            input = in.nextLine();

            if (!input.equals("stop")) {
                
                // Kysytään uutta panosta, ja tarkastetaan ettei kenttä ole tyhjä tai suurempi kuin saldo.
                do {
                    System.out.println("Aseta panos");
                    panos = in.nextLine();
                    if (!panos.equals("") && Integer.parseInt(panos) > raha) {
                        System.out.println("Ei tarpeeksi saldoa");
                    }
                } while (panos.equals("") || Integer.parseInt(panos) > raha);

            }

        } while (raha > 0 && !input.equals("stop"));

    }
}