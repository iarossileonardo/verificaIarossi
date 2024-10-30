package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class GestioneServizio extends Thread{
    Socket s0;
    ArrayList<String> nomi = new ArrayList<String>();
    Biglietti biglietti;

    public GestioneServizio(Socket s0, ArrayList<String> nomi, Biglietti biglietti) {
        this.s0 = s0;
        this.nomi = nomi;
        this.biglietti = biglietti;
    }

    @Override
    public void run(){

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s0.getInputStream()));
            DataOutputStream out = new DataOutputStream(s0.getOutputStream());
            String nome;
            boolean flag = false;
    
            do {
                flag = true;
                nome = in.readLine();
                if(nomi.contains(nome)){
                    flag = false;
                    out.writeBytes("400\n");
                }
            } while (!flag);
            nomi.add(nome);
            out.writeBytes("200\n");

            String nMess;

            do {
                nMess = in.readLine();

                if (nMess.equals("N")) {
                    System.out.println("invio quantità biglietti");
                    out.writeBytes("Gold: " + Integer.toString(biglietti.getGold().size()) + " pit: " + biglietti.getPit().size() + " parterre: " + biglietti.getParterre().size() + "\n");
                }
                else if(nMess.equals("QUIT")) {
                    //nomi.remove(nome);
                    nMess = "QUIT";
                    break;
                } else {
                    if(Integer.parseInt(nMess) > biglietti.getGold().size()){
                        System.out.println("Non possibile");
                        out.writeBytes("KO\n");
                    } else {
                        for (int i = 0; i < Integer.parseInt(nMess); i++) {
                            biglietti.getGold().remove(i);
                        }
                        out.writeBytes("OK\n");
                    }
                }
            } while (!nMess.equals("QUIT"));
            System.out.println("Ciao client");
            
        } catch (Exception e) {}


    }

}
