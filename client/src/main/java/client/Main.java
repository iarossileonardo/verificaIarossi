package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Client partito");
        Socket s0 = new Socket("localhost", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s0.getInputStream()));
        DataOutputStream out = new DataOutputStream(s0.getOutputStream());

        Scanner input = new Scanner(System.in);

        String messaggio;
        String nome;
        String esito;
        System.out.println("Connessione effettuata");

        do {
            System.out.println("Digita il tuo username");
            nome = input.nextLine();
            out.writeBytes(nome + "\n");
            esito = in.readLine();
        } while (!esito.equals("200"));

        do {
            System.out.println("Menu------------");
            System.out.println("1)Acquistare biglietti");
            System.out.println("2)Richiedere disponibilità");
            System.out.println("3)Uscire");
            String scelta = input.nextLine();
            switch (scelta) {
                case "1":
                    System.out.println("Quanti biglietti vuoi acquistare?");
                    messaggio = input.nextLine();
                    out.writeBytes(messaggio + "\n");
                    System.out.println("Che tipo? (gold, pit o parterre)");
                    messaggio = input.nextLine();
                    out.writeBytes(messaggio + "\n");
                    esito = in.readLine();
                    if (esito.equals("OK")) {
                        System.out.println("Operazione andata a buon fine");
                    } else {
                        System.out.println("Qualcosa è anadato storto :(");
                    }
                    break;
                case "2":
                    messaggio = "N";
                    out.writeBytes(messaggio + "\n");
                    String nBiglietti = in.readLine();
                    System.out.println("Sono disponibili " + nBiglietti);
                    break;
                case "3":
                    System.out.println("chiudo");
                    messaggio = "QUIT";
                    out.writeBytes(messaggio + "\n");
                    break;
            
                default:
                    System.out.println("Selezionare un'opzione tra quelle mostrate");
                    messaggio = "";
                    break;
            }
        } while (!messaggio.equals("QUIT"));
    }
}